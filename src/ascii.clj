(ns fractal1.ascii
  (:require [clojure.string :as str]))

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
    
