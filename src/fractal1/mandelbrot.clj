(ns fractal1.mandelbrot)

(defn- c-abs [[x y]]
  (Math/sqrt (+ (* x x) (* y y))))

;; For each pt z -> z^2 + c
;;             z-re + i z-im -> (z-re^2 - z-im^2 + c-re) + i(2 z-re z-im + c-im)
(defn convergence [[c-re c-im] & { :keys [limit] :or {limit 500}}]
  (loop [[z-re z-im] [0 0] ct 0]
    (if (or
         (> (c-abs [z-re z-im]) 2)
         (> ct limit)) ct
        (recur
         [(+ (- (* z-re z-re) (* z-im z-im)) c-re)
          (+ (* 2 z-re z-im) c-im)]
         (+ ct 1)))))

