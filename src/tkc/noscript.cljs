(ns tkc.noscript
  (:require [clojure.string :as string]
            [clojure.walk :as walk]
            [hiccups.runtime :as hiccupsrt]
            [tkc.cards.library :as library]
            [tkc.pattern :as pattern])
  (:require-macros [hiccups.core :as hiccups]))

(defn hoist-fragments
  ;; hiccups doesn't know about :<>
  [markup]
  (walk/postwalk (fn [thing]
                   (cond->> thing
                     (vector? thing)
                     (into [] (mapcat (fn [child]
                                        (if (and (vector? child)
                                                 (= :<> (first child)))
                                          (rest child)
                                          [child]))))))
                 markup))

(defn combine-classes
  ;; hiccups can't handle [:tag.class {:class "more classes"}]
  [markup]
  (walk/postwalk (fn [thing]
                   (if-let [class (and (vector? thing)
                                       (-> thing first keyword?)
                                       (-> thing second map?)
                                       (-> thing second (get :class)))]
                     (into [(-> thing first name
                                (str \. (->> (string/split class #" +")
                                             (string/join ".")))
                                (keyword))
                            (-> thing second (dissoc :class))]
                           (drop 2 thing))
                     thing))
                 markup))

(defn table-of-contents
  [all-decks]
  (->> (for [[id deck] all-decks
             :let [ranks (->> deck
                              (map pattern/pattern->rank)
                              (set))
                   sublinks? (and (contains? ranks :common)
                                  (contains? ranks :heroic))
                   deck-name (name id)]]
         [:li
          [:a.text-capitalize {:href (str \# deck-name)} deck-name]
          (when sublinks?
            [:span.small.ml-1
             "("
             [:a.text-capitalize {:href (str \# deck-name "-c")} "Common"]
             ", "
             [:a.text-capitalize {:href (str \# deck-name "-h")} "Heroic"]
             ")"])])
       (into [:ul])))

(defn deck-listing
  [id cards]
  (let [deck-name (name id)
        seen-common? (atom false)
        seen-heroic? (atom false)]
    [:<>
     [:h3.text-capitalize {:id deck-name} deck-name
      [:a.text-muted.ml-2
       {:href "#"}
       [:svg.feather
        [:use {:href "/img/feather-sprite.svg#arrow-up"}]]]]
     (->> cards
          (map (fn [card]
                 [:div.col-md-6
                  (cond
                    (and (not @seen-common?)
                         (= :common (pattern/pattern->rank card)))
                    (do (reset! seen-common? true)
                        {:id (str deck-name "-c")})

                    (and (not @seen-heroic?)
                         (= :heroic (pattern/pattern->rank card)))
                    (do (reset! seen-heroic? true)
                        {:id (str deck-name "-h")})

                    :else {})
                  (pattern/pattern card)]))
          (partition-all 2)
          (map (partial into [:div.row])))]))

(hiccups/defhtml cheatsheet
  []
  (let [decks (->> (dissoc library/all-decks :common)
                   (sort-by (fn [[k v]]
                              (cond
                                (= k :flares) [2 k]
                                (= k :legends) [1 k]
                                :else [0 k]))))]
    (-> [:html
         [:head
          {:lang "en"}
          [:meta {:charset "UTF-8"}]
          [:meta {:name "viewport"
                  :content "width=device-width, initial-scale=1"}]
          [:title "Tash-Kalar Cheatsheet"]
          [:link {:rel "stylesheet"
                  :type "text/css"
                  :href "/css/bootstrap.min.css"}]
          [:link {:rel "stylesheet"
                  :type "text/css"
                  :href "/css/main.css"}]]
         [:body
          [:div.container
           [:h2 "Tash-Kalar Card Reference"]
           (table-of-contents decks)
           (->> decks
                (map (partial apply deck-listing))
                (interpose [:hr])
                (into [:<>]))]]]
        (hoist-fragments)
        (combine-classes))))

(defn main!
  [& args]
  (println "<!DOCTYPE html>")
  (-> (cheatsheet)
      (println)))
