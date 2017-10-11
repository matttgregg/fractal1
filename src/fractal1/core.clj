(ns fractal1.core
  (require [clojure.string :as str]
           [fractal1.ascii :as ascii]
           [fractal1.plotters :as p]))

(defn plot-mandelbrot [args]
  (let
      [x-res (Float/parseFloat (nth args 1))
       y-res (Float/parseFloat (nth args 2))
       limit (Float/parseFloat (nth args 3))]
  (println x-res y-res limit)
  (ascii/ascii-draw [-2.0 0.6 x-res] [-1.0 1.0 y-res] (p/mandelbrot-plotter limit))))

(defn plot-julia [args]
  (let
      [x-res (Float/parseFloat (nth args 1))
       y-res (Float/parseFloat (nth args 2))
       limit (Float/parseFloat (nth args 3))
       c-re (Float/parseFloat (nth args 4))
       c-im (Float/parseFloat (nth args 5))]
  (println x-res y-res limit " :at: " c-re " + i" c-im)
  (ascii/ascii-draw [-1.5 1.5 x-res] [-1.5 1.5 y-res] (p/julia-plotter [c-re c-im] limit))))

(defn plot-julia-rotate [args]
  (let
      [x-res (Float/parseFloat (nth args 1))
       y-res (Float/parseFloat (nth args 2))
       limit (Float/parseFloat (nth args 3))
       angle (Float/parseFloat (nth args 4))
       weight 0.7885
       c-re (* weight (Math/cos angle))
       c-im (* weight (Math/sin angle))]
  (println x-res y-res limit " :at: " c-re " + i" c-im)
  (ascii/ascii-draw [-1.5 1.5 x-res] [-1.5 1.5 y-res] (p/julia-plotter [c-re c-im] limit))))

(defn plot-julia-stepper [args]
  (let
      [x-res (Float/parseFloat (nth args 1))
       y-res (Float/parseFloat (nth args 2))
       limit (Float/parseFloat (nth args 3))
       step (Float/parseFloat (nth args 4))
       weight (Float/parseFloat (nth args 5))]
    (loop [angle 0]
      (let
          [c-re (* weight (Math/cos angle))
           c-im (* weight (Math/sin angle))]
        (println x-res y-res limit " :at: " c-re " + i" c-im)
        (ascii/ascii-draw [-1.5 1.5 x-res] [-1.5 1.5 y-res] (p/julia-plotter [c-re c-im] limit)))
      (recur (+ angle step)))))

(defn show-help []
  (println "Usage:")
  (println " mandelbrot <x-resolution> <y-resolution> <interation-limit>")
  (println "  -- Prints mandelbrot set.")
  (println " julia <x-resolution> <y-resolution> <interation-limit> <c-real> <c-imaginary>")
  (println "  -- Prints a Julia set, derived from complex number c")
  (println " julia-rotate <x-resolution> <y-resolution> <interation-limit> <angle>")
  (println "  -- Prints a Julia set, derived from angle (fixed weight 0.7885)")
  (println " julia-stepper <x-resolution> <y-resolution> <interation-limit> <angle-step> <weight>")
  (println "  -- Continuously prints Julia sets, derived from angle and weight, increasing angle by step each iteration.")
  (println "\nNote that all parameters are floats, except for iteration limit which should be an integer.\n")) 

(defn -main
  "Generate an ASCII image of a mandelbrot set."
  [& args]
  (cond
    (> 2 (count args)) (show-help)
    (= 0 (compare "mandelbrot" (str/lower-case (first args))))  (plot-mandelbrot args)
    (= 0 (compare "julia" (str/lower-case (first args))))  (plot-julia args)
    (= 0 (compare "julia-rotate" (str/lower-case (first args))))  (plot-julia-rotate args)
    (= 0 (compare "julia-stepper" (str/lower-case (first args))))  (plot-julia-stepper args)
    :else  (plot-mandelbrot args)))
