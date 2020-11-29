(ns tkc.main
  (:require [clojure.edn :as edn]
            [reagent.core :as r]
            [reagent.dom :as dom]
            [tkc.pattern :as pattern]
            [tkc.cards.everfrost :as everfrost]
            [tkc.cards.highland :as highland]
            [tkc.cards.legends :as legends]
            [tkc.cards.northern :as northern]
            [tkc.cards.sylvan :as sylvan]))

(def decks (r/atom (or (some-> js/window
                               .-location
                               .-href
                               js/URL.
                               .-search
                               js/URLSearchParams.
                               (.get "d")
                               js/atob
                               edn/read-string)
                       [{:deck-id :legends :hidden #{}}])))

(defn deck
  [ix]
  (let [{:keys [deck-id hidden]} (get @decks ix)
        {hidden-cards true shown-cards false} (->> (case deck-id
                                                     :sylvan sylvan/deck
                                                     :northern northern/deck
                                                     :highland highland/deck
                                                     :everfrost everfrost/deck
                                                     :legends legends/deck)
                                                   (group-by (comp boolean hidden)))]
    [:div.d-flex.flex-column
     [:h3.text-capitalize (name deck-id) " " (when (not-empty hidden)
                                               [:svg.feather
                                                {:on-click #(swap! decks assoc-in [ix :hidden] #{})
                                                 :alt "Refresh all cards"
                                                 :role "button"}
                                                [:use {:stroke "silver"
                                                       :href "/img/feather-sprite.svg#refresh-cw"}]])]
     (for [c shown-cards]
       [:div
        {:key c
         :on-click #(swap! decks update-in [ix :hidden] conj c)}
        [pattern/pattern c]])
     [:hr.w-100]
     (for [c hidden-cards]
       [:div.hidden-card
        {:key c
         :on-click #(swap! decks update-in [ix :hidden] disj c)}
        [pattern/pattern c]])]))

(defn persistence-link
  []
  (let [b64st (-> @decks pr-str js/btoa)]
    [:a
     {:href (str "?d=" b64st)}
     [:svg.feather
      [:use {:href "/img/feather-sprite.svg#link"}]]]))

(defn root []
  [:div
   [:div.border-bottom.mb-3.d-flex.flex-row.align-items-center
    [:h2.m-2 "Tash-Kalar Cheatsheet"]
    [:div.dropdown.ml-2
     [:button.btn.btn-sm.btn-light.border.dropdown-toggle
      {:type "button"
       :id "addDeckDropdown"
       :data-toggle "dropdown"
       :aria-haspopup true
       :aria-expanded false}
      "Add Deck"]
     [:div.dropdown-menu
      {:aria-labelledby "addDeckDropdown"}
      (for [d [:northern :highland :sylvan :everfrost]]
        [:a.dropdown-item.text-capitalize
         {:key d
          :on-click #(swap! decks conj {:deck-id d :hidden #{}})}
         (name d)])]]
    [:div.ml-auto.mr-3 [persistence-link]]]
   [:div.container
    [:div.row
     (for [ix (range (count @decks))]
       [:div.col
        {:key ix}
        [deck ix]])]]])

;; Entry Points

(defn mount-root []
  (dom/render [root] (.getElementById js/document "app")))

(defn main! []
  (mount-root))

(defn reload! []
  (mount-root))
