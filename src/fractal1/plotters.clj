(ns fractal1.plotters
  (:require [fractal1.ascii :as ascii]
            [fractal1.julia :as julia]
            [fractal1.mandelbrot :as mandelbrot]))

(defn mandelbrot-plotter [limit]
  (fn [x y]
    (ascii/char-for-val (mandelbrot/convergence [x y] :limit limit) 0 limit (ascii/standard-chars))))

(defn julia-plotter [[c-re c-im] limit]
  (let [converger (julia/julia-converger [c-re c-im] :limit limit)]
  (fn [x y]
    (ascii/char-for-val (converger [x y]) 0 limit (ascii/standard-chars)))))

