(ns tkc.noscript
  (:require [hiccups.runtime :as hiccupsrt]
            [tkc.cards.library :as library]
            [tkc.pattern :as pattern])
  (:require-macros [hiccups.core :as hiccups]))

(hiccups/defhtml cheatsheet
  []
  [:html
   [:head
    {:lang "en"}
    [:meta {:charset="UTF-8"}]
    [:meta {:name "viewport"
            :content "width=device-width, initial-scale=1"}]
    [:title "Tash-Kalar Cheatsheet"]
    [:link {:rel "stylesheet"
            :type "text/css"
            :href "/css/bootstrap.min.css"}]
    [:link {:rel "stylesheet"
            :type "text/css"
            :href "/css/main.css"}]]
   [:body
    (->> (get library/all-decks :northern)
         (map pattern/pattern)
         (into [:div.container]))]])

(defn main!
  [& args]
  (println "<!DOCTYPE html>")
  (-> (cheatsheet)
      (println)))
