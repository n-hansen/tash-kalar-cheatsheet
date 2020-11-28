(ns tkc.main
  (:require [reagent.core :as r]
            [reagent.dom :as dom]
            [tkc.pattern :as pattern]
            [tkc.cards.northern :as northern]))

(defn root []
  [:div.container
   (for [c northern/deck ]
     [:div {:key c}
      [pattern/pattern c]])])

;; Entry Points

(defn mount-root []
  (dom/render [root] (.getElementById js/document "app")))

(defn main! []
  (mount-root))

(defn reload! []
  (mount-root))
