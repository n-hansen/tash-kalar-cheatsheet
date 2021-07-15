(ns tkc.cards.etherweave
  (:require [tkc.pattern :as pattern :refer-macros [defpattern]]))

(defn warp-caption
  ([warp-effect]
   [:div.d-flex.flex-row
    [:div.mx-1 "🌀"]
    [:p.text-info warp-effect]])
  ([warp-effect on-play]
   [:<>
    (warp-caption warp-effect)
    [:p on-play]]))

(defpattern :etherweave/doppelganger
  "Doppelganger" :common [2 2]
  "If you have a pending being, copy its warp effect."
  c t
  c _)

(defpattern :etherweave/paradox-worm
  "Paradox Worm" :common [4 2]
  (warp-caption
   "Upgrade 1 enemy common piece. You may then discard your pending being."
   "You may swap one of your non-legendary pieces with an enemy piece of the same rank.")
  _ _ c t
  c c _ _)

(defpattern :etherweave/lesser-shadow-twin
  "Lesser Shadow Twin" :common [3 2]
  (warp-caption
   "Upgrade 1 of your common pieces."
   "If Greater Shadow Twin is in your discard pile, choose one of your pieces and destroy up to 2 common pieces adjacent to it.")
  t _ _
  c c c)

(defpattern :etherweave/translocationist
  "Translocationist" :common [3 3]
  (warp-caption
   "Gain an action."
   "You may swap up to 2 of your heroic pieces with your common pieces.")
  _ _ c
  c t _
  c c _)

(defpattern :etherweave/antimatter-spirit
  "Antimatter Spirit" :common [3 3]
  (warp-caption
   "Place a common piece of your color on an empty colorless square. It does a combat move. Place a common piece of another color on the same empty square. It does a combat move in the opposite direction. This is a linked effect.")
  _ _ c
  _ t _
  c _ _)

(defpattern :etherweave/merchant-of-time
  "Merchant of Time" :heroic [4 3]
  (warp-caption
   "Take a piece from a colorless square and put it on this card. This card cannot be copied. If pending, it cannot be discarded or returned to hand."
   "If there is a piece on this card, do a standard leap with that piece to any colorless square on the board.")
  _ _ t _
  _ c _ c
  c _ c _)

(defpattern :etherweave/gate-of-oblivion
  "Gate of Oblivion" :heroic [5 3]
  (warp-caption
   "For the rest of this turn, when you destroy a piece count it as though you also destroyed an additional piece of the same color and rank."
   "Destroy any piece on the centrally marked square. On another marked square, you may destroy a non-legendary piece.")
  _ m m m _
  m c t c m
  m c m2 c m)

(defpattern :etherweave/time-traveler
  "Time Traveler" :heroic [3 3]
  "Time Traveler's summoning square can be any colorless empty square. You may destroy an adjacent common piece. If you do, put the top card of your discard pile on top of your deck."
  c _ _
  _ c _
  _ _ c)

(defpattern :etherweave/greater-shadow-twin
  "Greater Shadow Twin" :heroic [4 1]
  (warp-caption
   "Upgrade 1 of your common pieces."
   "If Lesser Shadow Twin is in your discard pile, you may destroy one heroic piece adjacent to at least two of your pieces.")
  t c c c)

(defpattern :etherweave/warpmaster
  "Warpmaster" :heroic [3 4]
  "You may either return your pending being to your hand or do a standard move with the Warpmaster."
  _ c _
  _ _ _
  c _ t
  _ c _)

(defpattern :etherweave/dark-sphere
  "Dark Sphere" :heroic [2 2]
  "Choose up to 3 non-legendary pieces, at most 2 of one color. With each, do a combat move. Each move must end at distance 2 from the Dark Sphere."
  c [t c]
  c c)

(defpattern :etherweave/void-summoner
  "Void Summoner" :heroic [3 3]
  (warp-caption
   "Do a standard move with one of your non-legendary pieces"
   "For your next summoning this turn, you may count up to two empty squares as common pieces of your color.")
  _ t c
  _ c _
  c _ c)

(defpattern :etherweave/eternal-emperor
  "Eternal Emperor" :heroic [2 3]
  (warp-caption
   "Either place a common piece of your color on an empty square, or move 1 of your pieces—combat move if common, standard move if upgraded."
   "If you have not played Eternal Emperor's warp effect this turn, you may perform it now as a normal effect.")
  c _
  c t
  c c)

(defpattern :etherweave/reality-patch
  "Reality Patch" :heroic [3 3]
  "In each enemy color, you may destory 1 heroic piece. You may discard your pending being. You may discard one card of any type from your hand."
  _ c _
  c t c
  _ c _)

(defpattern :etherweave/polarity-queen
  "Polarity Queen" :heroic [3 4]
  (warp-caption
   "Place a common piece of your color on an empty square adjacent to an enemy piece."
   "Choose 2 of your non-legendary pieces other than the Queen. Do 1 combat move with each of them in opposite directions. This is a linked effect.")
  _ t _
  c _ c
  _ c _
  _ c _)

(defpattern :etherweave/singularity
  "Singularity" :heroic [3 3]
  "Choose an empty colorless square. All common pieces adjacent to that square must do a combat move onto it in the order of your choosing."
  c _ c
  _ t _
  c _ c)

(defpattern :etherweave/ziggurat-sentinel
  "Ziggurat Sentinel" :heroic [3 4]
  (warp-caption
   "Do 1 combat move or 2 standard moves with one of your non-legendary pieces."
   "You may either copy a warp effect on a card in your discard pile, or do up to 3 combat moves with Ziggurat Sentinel in the marked direction.")
  _ _ t
  _ _ c
  _ c c
  c c _)

(defpattern :etherweave/iris-of-eternity
  "Iris of Eternity" :heroic [3 5]
  "You may either destroy an adjacent legendary piece or upgrade the Iris. If the Iris becomes legendary, count it as a legend summoned this turn and discard all your legendary cards."
  m m m
  m t m
  [m c] m [m c]
  c _ c
  _ c _)

(def deck
  (pattern/deck :etherweave 18))
