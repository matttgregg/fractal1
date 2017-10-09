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
        0
        (if (> cnt LIMIT)
          cnt
          (recur (.add (.multiply z z) c) (inc  cnt)))))
    )
  )


(defn mf
  "returns an indicator of being in or out of the set"
  [x y xres yres]
  (let [start-real -2
        end-real 1
        end-i 1
        start-i -1
        r (+ start-real (* x (/ 1.0 xres) (- end-real start-real)) )
        i (+ start-i (* y (/ 1.0 yres) (- end-i start-i)) )]
    (in-m-set r i)
    )
  )


(defn grey-scale
  [n]
  (let [chars "123456789"]
    (nth chars (int (* (count chars)
                           (/ n LIMIT))))))

(grey-scale 20)

(defn -main
  "I don't do a whole lot ... yet.."
  [& args]

  (let [xres 100
        yres 40]
    (doseq [y (range yres)]
      (println  (clojure.string/join ( (map #(grey-scale (mf % y xres yres)) (range xres))))))))
