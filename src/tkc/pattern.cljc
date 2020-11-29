(ns tkc.pattern
  (:require [clojure.string :as string]
            #?(:cljs [goog.string.format :refer [format]])))

(defonce +pattern-registry+ (atom {}))

(defn- kwify
  [thing]
  (cond
    (symbol? thing) (keyword (name thing))
    (coll? thing) (mapv kwify thing)
    :else thing))

(defmacro defpattern
  [id name rank [width height] description & grid]
  (assert (= (count grid) (* width height))
          (str "Grid has the wrong number of elements: expected "
               (* width height)
               " and got "
               (count grid)))
  `(swap! +pattern-registry+ assoc ~id {:name ~name
                                        :rank ~rank
                                        :width ~width
                                        :height ~height
                                        :description ~description
                                        :grid ~(kwify grid)}))

(defn deck
  ([ns] (deck ns nil))
  ([ns cnt]
   (let [syms (->> @+pattern-registry+
                   (filter #(= (name ns) (namespace (first %))))
                   (sort-by (fn [[id {:keys [rank name]}]]
                              [(case rank
                                 :common 0
                                 :heroic 1
                                 :legendary 2
                                 :flare 3)
                               name]))
                   (mapv first))]
     (when cnt
       (assert (= cnt (count syms))
               (str "Expected " ns " %s to have " cnt " entries, but only found " (count syms))))
     syms)))

(defn pattern*
  [{:keys [name rank width height description grid]}]
  [:div.card.my-1
   [:h5.card-header name (case rank
                           :common [:span.badge.badge-secondary.ml-2 "Common"]
                           :heroic [:span.badge.badge-primary.ml-2 "Heroic"]
                           :legendary [:span.badge.badge-warning.ml-2 "Legendary"]
                           :flare [:span.badge.badge-info.ml-2 "Flare"])]
   (if-some [grid (not-empty grid)]
     [:div.card-body.d-flex.flex-row
      [:div.mr-2
       [:table.table.table-bordered.mt-1.gameboard
        (->> grid
             (map (fn [cell]
                    [:td
                     (let [cell-data (if (keyword? cell)
                                       #{cell}
                                       (set cell))
                           use-piece (fn [kw id]
                                       (when (contains? cell-data kw)
                                         [:use {:href (str "/img/pieces.svg#" id)}]))]
                       [:div.cell
                        [:svg {:width 20 :height 20}
                         (use-piece :m "mark")
                         (use-piece :m2 "mark2")
                         (use-piece :c "commonPiece")
                         (use-piece :h "heroicPiece")
                         (use-piece :n "arrN")
                         (use-piece :ne "arrNE")
                         (use-piece :e "arrE")
                         (use-piece :se "arrSE")
                         (use-piece :s "arrS")
                         (use-piece :sw "arrSW")
                         (use-piece :w "arrW")
                         (use-piece :nw "arrNW")
                         (use-piece :t "target")]])]))
             (partition width)
             (map (partial into [:tr]))
             (into [:tbody]))]]
      (if (string? description)
        [:p.card-text.ml-2 description]
        [:div.ml-2 description])]
     ;; really only relevant for flares.
     description)])

(defn pattern
  [id]
  (if-some [p (get @+pattern-registry+ id)]
    (pattern* p)
    [:div.alert.alert-danger
     "No definition for pattern " [:code (pr-str id)]]))
