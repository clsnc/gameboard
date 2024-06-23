(ns gameboard.utils)

(defn input-event->value [e]
  (.-value (.-target e)))