(ns gameboard.ui
  (:require
   [datascript.core :as d]
   [gameboard.state :as state]))

(defn team-score [db team-id]
  (let [score ((d/entity db team-id) ::state/score)]
    [:div.team-score
     [:div.team-score-label "score"]
     [:div.team-score-value score]]))

(defn team-panel [db team-id]
  (let [team (d/entity db team-id)]
    [:div.team-panel
     [:div.team-name (team ::state/name)]
     (team-score db team-id)]))

(defn team-panels [db]
  (let [team-ids (map first (d/q '[:find ?id
                                   :where [?id ::state/type ::state/team]]
                                 db))]
    [:div.team-panels
     (map #(team-panel db %) team-ids)]))