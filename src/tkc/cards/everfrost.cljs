(ns tkc.cards.everfrost
  (:require [tkc.pattern :as pattern :refer-macros [defpattern]]))

(defn frost-caption
  ([frost-effect]
   [:div.d-flex.flex-row
    [:div.mx-1 "❄"]
    [:p.text-info.mb-0 frost-effect]])
  ([on-play frost-effect]
   [:<>
    [:p on-play]
    (frost-caption frost-effect)]))

(defpattern :everfrost/snow-fox
  "Snow Fox" :common [3 2]
  "The Show Fox may do up to 2 standard moves."
  t c _
  _ _ c)

(defpattern :everfrost/royal-reindeer
  "Royal Reindeer" :common [3 3]
  "The Royal Reindeer may do a combat leap to a distance of exactly 2. If neither the summoning nor the leap destorys a pieces, upgrade the Royal Reindeer."
  _ t _
  c c _
  _ _ c)

(defpattern :everfrost/crystal-mirror
  "Crystal Mirror" :common [5 3]
  "You may choose 1 heroic or 2 common pieces on the yellow-marked squares: For each, place one of your pieces with the same rank on the mirror-image square, if it is empty."
  m m c m2 m2
  m m t m2 m2
  m m c m2 m2)

(defpattern :everfrost/crystal-grower
  "Crystal Grower" :common [2 2]
  (frost-caption "Upgrade 1 common piece of each enemy color."
                 "Upgrade a common piece of your color.")
  _ t
  c c)

(defpattern :everfrost/ice-princess
  "Ice Princess" :common [3 3]
  (frost-caption "You may do 1 combat move with one of your common pieces other than the Ice Princess."
                 "Do 1 standard move with one of your common pieces.")
  _ t _
  _ c _
  c _ c)

(defpattern :everfrost/ice-queen
  "Ice Queen" :heroic [3 3]
  (frost-caption "You may do 1 combat move with one of your heroic pieces other than the Ice Queen."
                 "Do 1 standard move with one of your heroic pieces.")
  _ [t c] _
  _ c _
  c _ c)

(defpattern :everfrost/frostweave-summoner
  "Frostweave Summoner" :heroic [2 4]
  (frost-caption "Use just before summoning a being. For the pattern of that being, you may use one enemy piece as though it were yours.")
  c _
  _ t
  _ c
  _ c)

(defpattern :everfrost/winter-whisperer
  "Winter Whisperer" :heroic [4 2]
  (frost-caption "You may destroy one of your common pieces. You may discard 1 flare. If you do both, gain an action.")
  _ t _ _
  c c c c)

(defpattern :everfrost/frozen-chest
  "Frozen Chest" :heroic [3 1]
  "You may take one frozen effect from your discard pile and put it directly into play. (The limit of 1 frozen effect in play still applies.)"
  c [c t] c)

(defpattern :everfrost/everfrost-sentinel
  "Everfrost Sentinel" :heroic [2 4]
  "If summoning the Everfrost Sentinel destroyed an enemy piece, you may downgrade the Everfrost Sentinel. If you do, each other player or team has 1 less action on their next turn."
  t _
  c _
  c c
  _ c)

(defpattern :everfrost/glacier-giant
  "Glacier Giant" :heroic [3 3]
  "The Glacier Giant may do any number of combat moves in one of the indicated directions. If it moves, it may continue 1 more square to destroy a legendary piece, but this also destroys the Glacier Giant."
  _ t _
  sw c se
  c c c)

(defpattern :everfrost/polar-bear
  "Polar Bear" :heroic [4 2]
  "The Polar Bear may do a combat move. If that move destroys a piece, it may do a standard move. If that destroys a piece, it may do a move onto an empty square."
  t c c _
  _ c _ c)

(defpattern :everfrost/war-sled
  "War Sled" :heroic [4 3]
  "The War Sled may do up to 3 combat moves, the first in one of the indicated directions and each subsequent move in a direction that differs by no more than 45 degrees from the previous move."
  _ _ _ ne
  c _ t e
  c c c se)

(defpattern :everfrost/snow-monster
  "Snow Monster" :heroic [5 5]
  "Destroy each common enemy piece that is within distance 2 of the Snow monster and adjacent to at least one of your pieces."
  m m m m m
  m m m m m
  m m [t c] c m
  m c m m c
  m m m m m)

(defpattern :everfrost/frost-imp
  "Frost Imp" :heroic [3 3]
  "You may choose an adjacent common piece and a direction: That piece does as many standard moves as it can in that direction."
  c t _
  _ c _
  _ _ c)

(defpattern :everfrost/ice-wyvern
  "Ice Wyvern" :heroic [3 3]
  (frost-caption "The Ice Wyvern may do a combat leap to anywhere on the board. If the leap destroys a piece, destroy the Ice Wyvern."
                 "Place a common piece of your color on an empty square adjacent to one of your heroic pieces.")
  t c _
  c _ _
  _ c c)

(defpattern :everfrost/deathbringer
  "Deathbringer" :heroic [4 4]
  "You may destroy an adjacent piece; if heroic, it must be adjacent to at least one other piece of yours; if legendary, 3 other pieces of yours. Count it as two destroyed pieces. Remove it from the game."
  _ m m m
  _ c t m
  _ m m m
  c c c _)

(defpattern :everfrost/frostweave-illusionist
  "Frostweave Illusionist" :heroic [3 3]
  (frost-caption "Convert the Frostweave Illusionist to a common piece of an enemy color."
                 "Convert any common enemy piece to your common piece.")
  c t c
  _ _ _
  _ c _)

(def deck
  (pattern/deck :everfrost 18))
