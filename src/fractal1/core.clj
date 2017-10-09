(ns fractal1.core
;;  (:require [])
  (:import [org.apache.commons.math3.complex Complex])
  (:gen-class))

(def LIMIT 1000)

(defn in-m-set
  [r i]
  (let [c (Complex. r i)]
    (loop [z (Complex. 0 0 )
           cnt 0]
      (if (> (.abs z) 2)
        1
        (if (> cnt LIMIT)
          0
          (recur (.add (.multiply z z) c) (inc  cnt)))))
    )
  )


(defn mf
  "returns int in range 0 255"
  [x y xres yres]
  (let [start-real -2
        end-real 1
        end-i 1
        start-i -1
        r (+ start-real (* x (/ 1.0 xres) (- end-real start-real)) )
        i (+ start-i (* x (/ 1.0 yres) (- end-i start-i)) )]
    (in-m-set r i)
    )
  )


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println  (mf 100 0  100 100))
  (println  (mf 50 50  100 100)))
