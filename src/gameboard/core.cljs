(ns gameboard.core
  (:require
   [reagent.dom :as d]
   [gameboard.state :as state]
   [gameboard.ui :as ui]))

(defn home-page []
  (let [db @state/db-atom]
    [:div (ui/team-panels db)]))

(defn mount-root []
  (d/render [home-page] (.getElementById js/document "app")))

(defn ^:export init! []
  (mount-root))
