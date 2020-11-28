(ns tkc.main
  (:require [reagent.core :as r]
            [reagent.dom :as dom]
            [tkc.pattern :as pattern]
            [tkc.cards.legends :as legends]
            [tkc.cards.northern :as northern]
            [tkc.cards.sylvan :as sylvan]))

(defn root []
  [:div.container
   [:div.row
    [:div.col
     (for [c northern/deck ]
       [:div {:key c}
        [pattern/pattern c]])]
    [:div.col
     (for [c sylvan/deck]
       [:div {:key c}
        [pattern/pattern c]])]
    [:div.col
     (for [c legends/deck]
       [:div {:key c}
        [pattern/pattern c]])]]])

;; Entry Points

(defn mount-root []
  (dom/render [root] (.getElementById js/document "app")))

(defn main! []
  (mount-root))

(defn reload! []
  (mount-root))
