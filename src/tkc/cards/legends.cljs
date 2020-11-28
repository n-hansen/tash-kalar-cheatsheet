(ns tkc.cards.legends
  (:require [tkc.pattern :as pattern :refer-macros [defpattern]]))

(defpattern :legends/fire-dragon
  "Fire Dragon" :legendary [3 5]
  "Choose one of the indicated directions: Destroy all non-legendary pieces up to distance 2 in that direction and in both directions at 45 degrees to it."
  h _ h
  _ c _
  _ h _
  w t e
  sw s se)

(defpattern :legends/hell-bull
  "Hell Bull" :legendary [3 3]
  "Choose any direction: The Hell Bull may do any number of combat moves in that direction. If it destroys a legendary piece, it stops."
  c _ c
  h [c t] h
  _ c _)

(defpattern :legends/angel-of-death
  "Angel of Death" :legendary [5 3]
  "You may choose any 1 piece other than the Angel of Death: Upgrade it and then do a combat leap on its square with the Angel of Death."
  _ c _ c _
  c _ [h t] _ c
  _ _ c _ _)

(defpattern :legends/the-eldest-tree
  "The Eldest Tree" :legendary [5 3]
  "On up to 3 adjacent squares: if it has an enemy non-legendary piece, destroy it; if it has your common piece, upgrade it; if it is empty, place 1 common piece of your color there."
  _ m m h _
  c m t m c
  _ h m m _)

(defpattern :legends/bone-catapult
  "Bone Catapult" :legendary [3 3]
  "You may choose any 1 piece in any of the indicated directions: Destroy it and all common pieces adjacent to it."
  c n ne
  w t e
  h h h)

(defpattern :legends/fire-elemental
  "Fire Elemental" :legendary [5 5]
  "Destroy either all non-legendary enemy piece on all adjacent squares or all common enemy pieces up to distance 2."
  m m m m m
  m m2 m2 m2 m
  m m2 t m2 m
  m h m2 c m
  h m c m c)

(defpattern :legends/leviathan
  "Leviathan" :legendary [5 3]
  "Choose one: Either downgrade a connected group of up to 3 upgraded pieces or destroy a connected group of up to 4 common pieces. (A group may have multiple colors.)"
  _ _ _ _ t
  _ _ h h _
  h c _ _ _)

(defpattern :legends/two-headed-dragon
  "Two-Headed Dragon" :legendary [4 4]
  "You may upgrade 1 of the pieces used to summon the Two-Headed Dragon. If you do, you may destroy 1 heroic piece adjacent to the upgraded piece."
  t _ [m h] _
  _ [m h] _ _
  [m h] _ [m c] _
  _ _ _ [m c])

(defpattern :legends/earth-elemental
  "Earth Elemental" :legendary [4 3]
  "Destroy a non-legendary piece on or adjacent to a red square. Then upgrade a common piece on or adjacent to a green square. Then the Earth Elemental may do 1 combat move to an adjacent red or green square."
  _ t c _
  _ c c _
  h _ _ h)

(defpattern :legends/time-elemental
  "Time Elemental" :legendary [3 4]
  "After this turn, take an extra turn (even if the end of the game has been triggered)."
  _ t _
  h _ h
  _ h _
  c _ c)

(defpattern :legends/storm-elemental
  "Storm Elemental" :legendary [3 3]
  "You may place 1 piece of your color on an empty square up to distance 3. With it, do up to 1 (if legendary), 3 (if heroic), or 5 (if common) combat moves in one direction. Then destroy it."
  h _ _
  h _ h
  _ [c t] _)

(defpattern :legends/titan
  "Titan" :legendary [3 5]
  "Destroy all orthogonally adjacent pieces and all non-legendary diagonally adjacent pieces. They do not count as pieces destroyed by you."
  m m2 m
  m2 t m2
  m [m2 h] m
  _ h _
  c c c)

(def deck
  (pattern/deck :legends 12))
