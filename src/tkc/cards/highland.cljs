(ns tkc.cards.highland
  (:require [tkc.pattern :as pattern :refer-macros [defpattern]]))

(defpattern :highland/wild-eagle
  "Wild Eagle" :common [3 2]
  "The Wild Eagle may do a combat leap to any square on the board."
  _ t _
  c _ c)

(defpattern :highland/clan-axeman
  "Clan Axeman" :common [3 3]
  "You may destroy 1 non-legendary piece on an orthogonally adjacent square."
  _ m c
  m t m
  c m _)

(defpattern :highland/clan-healer
  "Clan Healer" :common [3 2]
  "You may place up to 2 common pieces of your color. Each must be placed on an empty square adjacent to a green square."
  _ _ c
  c t c)

(defpattern :highland/dire-wolf
  "Dire Wolf" :common [3 3]
  "The Dire Wolf may do up to 2 combat moves."
  _ _ t
  _ c c
  c _ _)

(defpattern :highland/ritual-keeper
  "Ritual Keeper" :common [2 2]
  "If the Ritual Keeper was summoned on a green square, upgrade 1 of your common pieces; if on a red square, you may do 1 combat move with 1 of your pieces."
  _ c
  c t)

(defpattern :highland/eagle-lord
  "Eagle Lord" :heroic [5 2]
  "The Eagle Lord may do a combat leap to any square on the board."
  c _ t _ c
  _ c _ c _)

(defpattern :highland/wolf-rider
  "Wolf Rider" :heroic [3 3]
  "The Wolf Rider may do up to 2 combat moves."
  t _ _
  c c c
  c _ _)

(defpattern :highland/blood-shaman
  "Blood Shaman" :heroic [3 3]
  "Destroy 1 non-legendary piece. If it was on a red square, destroy all common pieces adjacent to the red square."
  _ _ c
  _ t c
  c c _)

(defpattern :highland/war-drummer
  "War Drummer" :heroic [2 2]
  "Do either 1 combat move or up to 2 standard moves, using your pieces other than the War Drummer."
  [c t] c
  c c)

(defpattern :highland/hill-giant
  "Hill Giant" :heroic [3 4]
  "Destory all non-legendary pieces on orthogonally adjacent squares."
  _ m _
  m t m
  _ [c m] _
  c c c)

(defpattern :highland/warlord
  "Warlord" :heroic [5 3]
  "Do up to 3 combat moves, using your pieces. If you do all 3, at least one has to be with the Warlord."
  _ _ t _ _
  _ c c c _
  c _ _ _ c)

(defpattern :highland/war-summoner
  "War Summoner" :heroic [3 3]
  "Gain an action. For the pattern of the next being you summon this turn, you may use one enemy piece as though it were yours."
  c t c
  _ c _
  _ c _)

(defpattern :highland/ritual-master
  "Ritual Master" :heroic [3 3]
  "If the Ritual Master was summoned on a green square, gain 2 actions; if on a red square, you may destroy 1 heroic and/or 1 common piece anywhere on the board."
  c _ _
  _ t _
  c _ c)

(defpattern :highland/legend-slayer
  "Legend Slayer" :heroic [4 4]
  "You may destroy 1 legendary or up to 2 non-legendary pieces on diagonally adjacent squares."
  m _ m _
  _ t _ _
  m c [c m] _
  _ c _ c)

(defpattern :highland/mountain-troll
  "Mountain Troll" :heroic [3 4]
  "Destory all common enemy pieces on adjacent squares. If you destory at least 2 this way, gain an action."
  m m m
  m t m
  c c m
  _ c c)

(defpattern :highland/hungry-bear
  "Hungry Bear" :heroic [2 2]
  "The Hungry Bear may do up to 2 standard moves. If it moves onto an empty square, it stops moving."
  t c
  c c)

(defpattern :highland/werewolf
  "Werewolf" :heroic [4 3]
  "If the Werewolf was summoned on a non-central red or green square, it may do up to 3 combat moves. Otherwise it may do 1 standard move."
  _ c _ _
  c _ _ t
  _ c _ _)

(defpattern :highland/clan-guardian
  "Clan Guardian" :heroic [4 1]
  "You may upgrade 1 common piece used to summon the Clan Guardian."
  [m c] [m c] t [m c])

(def deck
  (pattern/deck :highland 18))
