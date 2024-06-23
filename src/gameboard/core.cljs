(ns gameboard.core
  (:require
   [reagent.core :as r]
   [reagent.dom :as d]
   [gameboard.state :as state]
   [gameboard.ui :as ui]))

(def db-atom (r/atom state/default-db))

(defn home-page []
  (let [db @db-atom]
    [:div (ui/team-panels db)]))

(defn mount-root []
  (d/render [home-page] (.getElementById js/document "app")))

(defn ^:export init! []
  (mount-root))
