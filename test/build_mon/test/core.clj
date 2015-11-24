(ns build-mon.test.core
  (:require [clojure.test :refer :all]
            [build-mon.core :as c]))

(def succeeded-build {:result "succeeded"})
(def in-progress-build {:result nil :status "inProgress"})
(def failed-build {:result "failed"})

(deftest determine-background-colour
  (is (= (c/determine-background-colour succeeded-build :anything) "green"))
  (is (= (c/determine-background-colour failed-build :anything) "red"))
  (is (= (c/determine-background-colour in-progress-build succeeded-build) "yellow"))
  (is (= (c/determine-background-colour in-progress-build failed-build) "orange")))

(deftest determine-text
  (is (= (c/determine-text succeeded-build) "succeeded"))
  (is (= (c/determine-text failed-build) "failed"))
  (is (= (c/determine-text in-progress-build) "inProgress")))