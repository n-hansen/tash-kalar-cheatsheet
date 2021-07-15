(ns tkc.cards.nethervoid
  (:require [tkc.pattern :as pattern :refer-macros [defpattern]]))

(defpattern :nethervoid/shadow-imp
  "Shadow Imp" :common [3 2]
  "The Shadow Imp may do 1 combat move. If it does and if it is not the Gateway, then the Gateway may do 1 combat move in the same direction."
  c _ _
  _ t c)

(defpattern :nethervoid/flame-imp
  "Flame Imp" :common [3 2]
  "You may destroy a common piece adjacent to the Gateway."
  c _ t
  _ c _)

(defpattern :nethervoid/gate-keeper
  "Gate Keeper" :common [3 2]
  "You may upgrade any one piece of your common pieces or place a common piece of your color on an empty square. In either case, that piece becomes the Gateway."
  _ c _
  c t c)

(defpattern :nethervoid/demon-of-gluttony
  "Demon of Gluttony" :common [3 2]
  "The Demon of Gluttony may do a combat move. If this destroys a piece, upgrade the Demon of Gluttony and it may do another combat move. If this destroys another piece, the Demon of Gluttony becomes the Gateway."
  _ t _
  c c c)

(defpattern :nethervoid/demon-of-pride
  "Demon of Pride" :common [2 3]
  "Upgrade the Demon of Pride. It becomes the Gateway. It may do 1 combat move."
  t _
  c _
  c c)

(defpattern :nethervoid/acolyte-of-destruction
  "Acolyte of Destruction" :heroic [3 4]
  "Destroy a common piece. If the Gateway is on a red square, you may also destroy a heroic piece adjacent to the destroyed piece's square."
  _ t _
  c _ c
  _ _ _
  _ c _)

(defpattern :nethervoid/acolyte-of-growth
  "Acolyte of Growth" :heroic [3 2]
  "Place a common piece of your color on an empty square. If the Gateway is on a green square, place a heroic piece of your color on an empty square adjacent to that new common piece."
  c _ c
  c t c)

(defpattern :nethervoid/power-seeker
  "Power Seeker" :heroic [5 2]
  "If the Power Seeker is the Gateway, it may do 1 standard move. Otherwise, it may do any number of combat moves toward the Gateway."
  t c _ c _
  _ _ c _ c)

(defpattern :nethervoid/hell-hound
  "Hell Hound" :heroic [5 3]
  "You may destroy an adjacent piece. If you destroy no legendary piece and if your deck is not out of cards, put this card on the bottom of your deck."
  _ _ m m m
  _ c [m c] t m
  c _ m [m c] m)

(defpattern :nethervoid/vortexmaster
  "Vortexmaster" :heroic [3 4]
  "You may do 1 combat move with the Gateway. Whether you do or not, you may then do 1 combat move with one of your pieces adjacent to the Gateway."
  _ c _
  c _ c
  _ c _
  _ t _)

(defpattern :nethervoid/gate-master
  "Gate Master" :heroic [4 2]
  "Upgrade the Gateway. Then choose 1 of your non-legendary pieces to become the Gateway. If upgrading created a legendary piece, then Gate Master's summoning counts as summoning a legend on Gate Master's square."
  _ c c _
  c t c c)

(defpattern :nethervoid/hell-rider
  "Hell Rider" :heroic [3 2]
  "If the Hell Rider is the Gateway, it may do 1 combat move. Otherwise, it may do up to 3 combat moves."
  [t c] c c
  c _ _)

(defpattern :nethervoid/demon-of-wrath
  "Demon of Wrath" :heroic [3 3]
  "Destroy all enemy common pieces adjacent to the Gateway. If there are none, the Gateway may do a standard move first."
  _ t c
  c _ c
  _ c _)

(defpattern :nethervoid/demon-of-greed
  "Demon of Greed" :heroic [3 3]
  "Destroy one of your common and one of your heroic non-Gateway pieces. For each destroyed piece, gain an action."
  c c _
  _ t _
  c _ c)

(defpattern :nethervoid/demon-of-lust
  "Demon of Lust" :heroic [3 3]
  "Choose up to 2 pieces (not necessarily yours). With each, do 1 combat move towards the Gateway. These moves must not destroy the Gateway."
  t _ _
  c c _
  _ c c)

(defpattern :nethervoid/demon-of-sloth
  "Demon of Sloth" :heroic [2 2]
  "Spend an action doing nothing. If you cannot, destroy the Gateway instead."
  _ t
  c _)

(defpattern :nethervoid/demon-of-envy
  "Demon of Envy" :heroic [3 2]
  "Place a common piece of your color on an empty square adjacent to the Gateway. Then repeat this until there is no such empty square or until no opponent has more pieces than you do."
  c _ _
  _ [t c] c)

(defpattern :nethervoid/possessed-summoner
  "Possessed Summoner" :heroic [3 3]
  "Place a common enemy piece on an empty square adjacent to a piece of the same color. For your next summoning this turn, use pieces of that color instead of your own. You may discard your flare to gain an action."
  _ t c
  c c _
  _ c _)

(def deck
  (pattern/deck :nethervoid 18))
