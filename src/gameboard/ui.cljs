(ns gameboard.ui
  (:require
   [datascript.core :as d]
   [gameboard.state :as state]
   [gameboard.utils :as u]))

(defn team-name [db team-id]
  (let [team (d/entity db team-id)]
    [:input.team-name
     {:type :text
      :onChange #(state/set-team-name! team-id (u/input-event->value %))
      :value (team ::state/name)}]))

(defn team-score [db team-id]
  (let [score ((d/entity db team-id) ::state/score-text)]
    [:div.team-score
     [:div.team-score-label "score"]
     [:input.team-score-value
      {:type :number
       :onChange #(state/set-team-score-text! team-id (u/input-event->value %))
       :value score}]]))

(defn team-panel [db team-id]
  [:div.team-panel
   (team-name db team-id)
   (team-score db team-id)])

(defn team-panels [db]
  (let [team-ids (map first (d/q '[:find ?id
                                   :where [?id ::state/type ::state/team]]
                                 db))]
    [:div.team-panels
     (map #(with-meta (team-panel db %) {:key %}) team-ids)]))