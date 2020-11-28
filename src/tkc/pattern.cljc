(ns tkc.pattern
  (:require [clojure.string :as string]
            [goog.string.format :refer [format]]))

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
          (format "Grid has the wrong number of elements: expected %s and got %s"
                  (* width height) (count grid)))
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
                        :upgraded 1
                        :legendary 2)
                      name]))
          (mapv first))]
     (when cnt
       (assert (= cnt (count syms))
               (format "Expected %s to have %s entries, but only found %s"
                       ns cnt (count syms))))
     syms)))

(defn- use-piece
  [id]
  )

(defn pattern*
  [{:keys [name rank width height description grid]}]
  [:div.card.my-1
   [:h5.card-header name " " (case rank
                               :common [:span.badge.badge-secondary "Common"]
                               :upgraded [:span.badge.badge-primary "Upgraded"]
                               :legendary [:span.badge.badge-warning "Legendary"])]
   [:div.d-flex.flex-row.p-3
    [:div
     [:table.table.table-bordered.mt-1.gameboard
      (->> grid
           (map (fn [cell]
                  [:td
                   (let [cell-data (if (keyword? cell)
                                     #{cell}
                                     (set cell))
                         use-piece (fn [kw id]
                                     (when (contains? cell-data kw)
                                       [:use {:href (str "img/pieces.svg#" id)}]))]
                     [:div.cell
                      [:svg {:width 20 :height 20}
                       (use-piece :m "mark")
                       (use-piece :c "commonPiece")
                       (use-piece :u "upgradedPiece")
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
    [:p.card-text.ml-2 description]]])

(defn pattern
  [id]
  (if-some [p (get @+pattern-registry+ id)]
    (pattern* p)
    [:div.alert.alert-danger
     "No definition for pattern " [:code (pr-str id)]]))
