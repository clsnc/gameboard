(ns gameboard.state
  (:require [datascript.core :as d]
            [reagent.core :as reagent]))

(def schema {::name {:db/cardinality :db.cardinality/one}
             ::score-text {:db/cardinality :db.cardinality/one}})
(def default-db (d/db-with (d/empty-db schema)
                           [{:db/id -1
                             ::type ::team
                             ::name "team1"
                             ::score-text "35"}
                            {:db/id -2
                             ::type ::team
                             ::name "team2"
                             ::score-text "55"}]))
(def db-atom (reagent/atom default-db))

(defn- set-attribute! [id attr val]
  (swap! db-atom d/db-with [{:db/id id
                             attr val}]))

(defn set-team-name! [team-id new-name]
  (set-attribute! team-id ::name new-name))

(defn set-team-score-text! [team-id new-score]
  (set-attribute! team-id ::score-text new-score))