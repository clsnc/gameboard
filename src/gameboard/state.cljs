(ns gameboard.state
  (:require [datascript.core :as d]))

(def schema {})
(def default-db (d/db-with (d/empty-db schema)
                           [{:db/id -1
                             ::type ::team
                             ::name "team1"
                             ::score 35}
                            {:db/id -2
                             ::type ::team
                             ::name "team2"
                             ::score 55}]))