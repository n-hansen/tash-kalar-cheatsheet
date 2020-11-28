(ns tkc.cards.sylvan
  (:require [tkc.pattern :as pattern :refer-macros [defpattern]]))

(defpattern :sylvan/sapling
  "Sapling" :common [1 3]
  "Upgrade the Sapling after summoning it."
  t c c)

(defpattern :sylvan/kiskin-farseeders
  "Kiskin Farseeders" :common [3 2]
  "You may place 1 common piece of your color on an empty square adjacent to one of your pieces"
  _ t c
  c _ _)

(defpattern :sylvan/charging-buck
  "Charging Buck" :common [2 3]
  "The Charging Buck may do up to 2 combat leaps, each of distance exactly 2."
  _ t
  c c
  c _)

(defpattern :sylvan/forest-wardens
  "Forest Wardens" :common [4 1]
  "Destroy 1 common piece of an opponent with more common pieces than you. Destroy 1 heroic piece of an opponent with more upgraded pieces than you."
  c _ t c)

(defpattern :sylvan/naiad
  "Naiad" :common [3 2]
  "You may choose up to 2 of your pieces adjacent to the Naiad and do 1 standard move with each."
  _ _ t
  c c c)

(defpattern :sylvan/kiskin-spirit
  "Kiskin Spirit" :upgraded [3 2]
  "You may choose a card from your discard pile and put it on top of your deck. If you do, or if your discard pile was empty, draw 1 extra card from your deck at the end of this turn."
  c _ t
  c _ c)

(defpattern :sylvan/dryad
  "Dryad" :upgraded [3 3]
  "On one of the adjacent squares, you may convert 1 non-legendary enemy piece to your common piece."
  c m m
  m [c t] m
  m c m)

(defpattern :sylvan/centaur-spearman
  "Centaur Spearman" :upgraded [3 3]
  "The Centaur Spearman may do 1 combat move. If he does, destroy the next piece in the same direction, unless it is legendary."
  t _ _
  c c c
  _ _ c)

(defpattern :sylvan/centaur-chieftain
  "Centaur Chieftain" :upgraded [4 4]
  "The Centaur Chieftain may do 1 combat move. If he does, you may do up to 3 combat moves in the same direction, using other pieces of yours."
  c _ _ _
  _ c t _
  _ _ c _
  _ _ _ c)

(defpattern :sylvan/unicorn
  "Unicorn" :upgraded [3 3]
  "Choose one: Either the Unicorn may do 1 combat move, or you gain 1 action."
  _ c t
  c c _
  c _ _)

(defpattern :sylvan/sylvan-queen
  "Sylvan Queen" :upgraded [4 5]
  "You may convert 1 non-legendary enemy piece on a diagonally adjacent square to your piece of the same rank."
  m _ m _
  _ t _ _
  m c m c
  _ _ c _
  _ _ c _)

(defpattern :sylvan/sylvan-princess
  "Sylvan Princess" :upgraded [3 5]
  "You may convert 1 common enemy piece on a diagonally adjacent square to your common piece."
  m _ m
  _ t _
  m c m
  _ _ c
  _ c _)

(defpattern :sylvan/woodland-druid
  "Woodland Druid" :upgraded [3 3]
  "Upgrade 1 common piece of each color."
  c _ c
  _ t _
  _ c _)

(defpattern :sylvan/forest-ancient
  "Forest Ancient" :upgraded [3 3]
  "Place 2 enemy common pieces on the empty square up to distance 2. Then destroy 2 common pieces of the same color or colors up to distance 3."
  _ c _
  c t c
  c _ _)

(defpattern :sylvan/forest-mystic
  "Forest Mystic" :upgraded [3 3]
  "At the end of this turn, draw 1 extra card from your deck and 1 extra card from the legend deck."
  _ c _
  c t _
  _ _ c)

(defpattern :sylvan/kiskin-leafsplitter
  "Kiskin Leafsplitter" :upgraded [3 3]
  "Up to 2 times, you may choose a diagonal direction and destroy the first piece in that direction."
  nw c ne
  c t c
  sw c se)

(defpattern :sylvan/kiskin-boughrunner
  "Kiskin Boughrunner" :upgraded [3 3]
  "The Kiskin Boughrunner may do up to 3 combat moves. Each move must end on a square adjacent to one of your pieces."
  _ t _
  c c c
  _ c _)

(defpattern :sylvan/tree-shepherd
  "Tree Shepherd" :upgraded [3 2]
  "Choose 1 of your pieces: if it is common, upgrade it; if it is heroic, it may do 1 combat move; if it is legendary, it may do 1 standard move."
  c t c
  _ c c)

(def deck
  (pattern/deck :sylvan 18))
