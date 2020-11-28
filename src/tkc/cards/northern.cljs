(ns tkc.cards.northern
  (:require [tkc.pattern :as pattern :refer-macros [defpattern]]))

(defpattern :northern/swordmaster
  "Swordmaster" :common [3 3]
  "You may destroy one common enemy piece on a diagonally adjacent square. If you do, upgrade the Swordmaster."
  m c m
  _ t _
  m c m)

(defpattern :northern/messenger
  "Messenger" :common [3 3]
  "You may choose 1 of your non-legendary pieces and a direction: That piece may do any number of standard moves in that direction."
  t _ _
  _ c _
  _ _ c)

(defpattern :northern/herald
  "Herald" :common [3 3]
  "Do up to 2 moves, using your pieces. These moves can only be onto empty squares."
  t _ _
  _ c c
  _ c _)

(defpattern :northern/bomb
  "Bomb" :common [3 4]
  "If summoning the Bomb is your last action this turn, nothing happens; otherwise, destroy the Bomb and all common pieces adjacent to it."
  m m m
  m [m t] m
  m m [m c]
  _ _ c)

(defpattern :northern/chronicler
  "Chronicler" :common [3 2]
  "Upgrade 1 of your common pieces other than the Chronicler. Then that piece may do a standard move."
  _ c _
  c t c)

(defpattern :northern/assassin
  "Assassin" :heroic [4 4]
  "Destroy any piece on the marked square. If the square was empty, the Assassin may move onto it."
  _ _ c _
  _ c _ _
  c _ m _
  _ _ _ t)

(defpattern :northern/time-mage
  "Time Mage" :heroic [3 3]
  "Gain an action. If there is an enemy pieceo n the marked square, destroy it."
  _ c t
  c m c
  _ c _)

(defpattern :northern/summoner
  "Summoner" :heroic [5 4]
  "You may place up to 2 common pieces of your color on empty marked squares."
  m _ m _ m
  _ m m m _
  m m t m m
  _ c c c _)

(defpattern :northern/hypnotist
  "Hypnotist" :heroic [3 3]
  "You may choose up to 3 common or up to 2 heroic pieces in one enemy color: Do 1 combat move with each."
  _ _ c
  c t c
  c _ _)

(defpattern :northern/cannon
  "Cannon" :heroic [4 3]
  "You may chose 1 of the indicated directions: Destroy all common pieces in that direction."
  _ nw n ne
  _ c [c t] e
  c sw s se)

(defpattern :northern/champion
  "Champion" :heroic [3 4]
  "You may destroy 1 adjacent enemy piece. If that piece was legendary, you also destroy the Champion and gain an action."
  m m m
  c t m
  c c m
  _ c _)

(defpattern :northern/infantry-captain
  "Infantry Captain" :heroic [5 2]
  "Do up to 2 combat moves, using your pieces other than the Infantry Captain."
  _ _ t _ _
  c c _ c c)

(defpattern :northern/cavalry-captain
  "Cavalry Captain" :heroic [3 3]
  "You may choose 1 of your pieces other than the Cavalry Captain: You may do up to 1 combat move and up to 2 standard moves with it (in any order)."
  _ t _
  c _ c
  c _ c)

(defpattern :northern/gryphon-rider
  "Gryphon Rider" :heroic [4 3]
  "The Gryphon Rider may do a combat leap. If she does, you may then downgrade her and place 1 common piece of your color on an empty adjacent square."
  _ c t _
  c _ c _
  _ _ _ c)

(defpattern :northern/knight
  "Knight" :heroic [3 3]
  "The Knight may do up to 3 combat moves. You cannot destroy common pieces with these moves."
  _ t _
  c c c
  c _ _)

(defpattern :northern/high-priestess
  "High Priestess" :heroic [3 3]
  "The High Priestess may do 1 standard move. Whether she moves or not, you may then upgrade 1 common piece adjacent to her."
  _ [t c] _
  _ _ _
  c _ c)

(defpattern :northern/master-of-intrigue
  "Master of Intrigue" :heroic [3 3]
  "Do up to 3 moves: standard moves with the Master of Intrigue and/or combat moves using non-legendary pieces that were used to summon him."
  [m c] _ [m c]
  _ t _
  [m c] _ [m c])

(defpattern :northern/gun-tower
  "Gun Tower" :heroic [3 3]
  "You may choose 1 of the indicated directions: Destroy the first 2 pieces in that direction. A legendary piece cannot be destroyed and stops the shot."
  w t e
  _ c c
  _ c c)

(def deck
  (pattern/deck :northern 18))
