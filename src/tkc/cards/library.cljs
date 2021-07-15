(ns tkc.cards.library
  (:require [tkc.cards.etherweave :as etherweave]
            [tkc.cards.everfrost :as everfrost]
            [tkc.cards.highland :as highland]
            [tkc.cards.flares :as flares]
            [tkc.cards.legends :as legends]
            [tkc.cards.nethervoid :as netherweave]
            [tkc.cards.northern :as northern]
            [tkc.cards.sylvan :as sylvan]))

(def faction-decks
  {:sylvan sylvan/deck
   :northern northern/deck
   :highland highland/deck
   :everfrost everfrost/deck
   :nethervoid netherweave/deck
   :etherweave etherweave/deck})

(def all-decks
  (into faction-decks
        {:legends legends/deck
         :flares flares/deck
         :common (concat legends/deck
                         flares/deck)}))
