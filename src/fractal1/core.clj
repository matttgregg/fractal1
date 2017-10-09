(ns fractal1.core
  (:require  [clojure.string :as str])
  (:import [org.apache.commons.math3.complex Complex])
  (:gen-class))

(def LIMIT 20)

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
  (let [chars " 2345678#"]
    (nth chars (int (* (- (count chars) 1)
                           (/ n LIMIT))))))

(grey-scale 20)



(defn get-points [from to res]
  (let [delta (/ (- to from) res)]
    (map (fn [i] (+ from (* i delta))) (range (+ res 1)))))

(defn char-for-val [val min max chars]
  (let [index (int (Math/floor (* (count chars) (/ (- val min) (- max min)))))]
    (cond
      (< index 0) (nth chars 0)
      (> index (- (count chars) 1)) (nth chars (- (count chars) 1))
      :else (nth chars index))))

(defn draw-point [x y f] (f x y))

(defn standard-chars
  ([n] (take n (standard-chars)))
  ([] [\@ \% \# \x \+ \= \: \- \. \space]))

(defn plot-coord [x y]  (str "(" x "," y ")"))
(defn plot-sqr [x y] (char-for-val (float (+ (* x x) (* y y))) 0 7 (standard-chars)))

(defn draw-row [y-val x-values f]
  (apply str (map (fn [x] (draw-point x y-val f)) x-values)))

(defn ascii-lines [[x-from x-to x-res] [y-from y-to y-res] f]
  (let [x-points (get-points x-from x-to x-res)
        y-points (get-points y-from y-to y-res)]
    (map (fn [y] (draw-row y x-points f)) y-points)))

(defn ascii-draw [[x-from x-to x-res] [y-from y-to y-res] f]
  (println (str/join "\n" (ascii-lines [x-from x-to x-res] [y-from y-to y-res] f))))

(defn -main
  "I don't do a whole lot ... yet.."
  [& args]


  (let [xres 100
        yres 40]
    (doseq [y (range yres)]
      (println  (clojure.string/join  (map #(char-for-val (mf % y xres yres) 0 LIMIT (standard-chars)) (range xres))))))


  (let [xres 100
        yres 40]
    (doseq [y (range yres)]
      (println  (clojure.string/join  (map #(grey-scale (mf % y xres yres)) (range xres))))))

  )
