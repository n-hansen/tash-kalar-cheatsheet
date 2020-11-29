(ns tkc.cards.flares
  (:require [tkc.pattern :as pattern :refer-macros [defpattern]]))

(defn flare-caption
  [heroic-delta heroic-action piece-delta piece-action]
  [:ul.list-group.list-group-flush
   [:li.list-group-item
    [:div.d-flex.flex-row.align-items-center
     [:h5.mr-1.mb-0 heroic-delta]
     [:h5.mr-3.mb-0
      [:svg.feather
       [:use {:href "/img/feather-sprite.svg#x-circle"}]]]
     [:p.mb-0 heroic-action]]]
   [:li.list-group-item
    [:div.d-flex.flex-row.align-items-center
     [:h5.mr-1.mb-0 piece-delta]
     [:h5.mr-3.mb-0
      [:svg.feather
       [:use {:href "/img/feather-sprite.svg#circle"}]]]
     [:p.mb-0 piece-action]]]])

(defpattern :flares/f36
  "3 / 6" :flare [0 0]
  (flare-caption 3 "Place 1 common piece of your color on any empty square."
                 6 "Place 1 heroic piece of your color on any empty square."))

(defpattern :flares/f44
  "4 / 4" :flare [0 0]
  (flare-caption 4 "Place 1 common piece of your color on any empty square."
                 4 "Place 1 common piece of your color on any empty square."))

(defpattern :flares/f35
  "3 / 5" :flare [0 0]
  (flare-caption 3 "You may do up to 3 standard moves, using your common pieces."
                 5 "Gain an action."))

(defpattern :flares/f45
  "4 / 5" :flare [0 0]
  (flare-caption 4 "Place 1 common piece of your color on any empty square."
                 5 "Place 1 common piece of your color on any empty square, or convert 1 common enemy piece to your color."))

(defpattern :flares/f36b
  "3 / 6" :flare [0 0]
  (flare-caption 3 "Do 1 standard move with one of your common pieces, or upgrade 1 of your common pieces."
                 6 "Place 2 common pieces of your color on empty squares."))

(defpattern :flares/f44b
  "4 / 4" :flare [0 0]
  (flare-caption 4 "Place 1 common piece of your color on any empty square, or upgrade 1 of your common pieces."
                 4 "You may do 1 combat leap with 1 of your common pieces."))

(defpattern :flares/f46
  "4 / 6" :flare [0 0]
  (flare-caption 4 "Place 1 common piece of your color on any empty square."
                 6 "Upgrade 1 of your common pieces. Gain an action."))

(defpattern :flares/f45b
  "4 / 5" :flare [0 0]
  (flare-caption 4 "Gain an action."
                 5 "Place 1 common piece of your color on any empty square."))

(defpattern :flares/f54
  "5 / 4" :flare [0 0]
  (flare-caption 5 "Place 1 heroic piece of your color on any empty square."
                 4 "You may do 1 standard move and 1 combat move (in either order), using your common pieces."))

(defpattern :flares/f55
  "5 / 5" :flare [0 0]
  (flare-caption 5 "Place 2 common pieces of your color on empty squares."
                 5 "Place 1 common piece of your color on any empty square."))

(defpattern :flares/f34
  "3 / 4" :flare [0 0]
  (flare-caption 3 "Place 1 common piece of your color on any empty square."
                 4 "You may do 1 combat move or 2 standard moves, using your non-legendary pieces."))

(defpattern :flares/f25
  "2 / 5" :flare [0 0]
  (flare-caption 2 "You may do 1 standard leap with 1 of your common pieces."
                 5 "Gain an action."))

(def deck
  (pattern/deck :flares 12))
