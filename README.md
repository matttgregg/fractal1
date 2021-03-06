# fractal1

Generate some ASCII art fractals.
(Thanks to London Clojurians meet up.)

## Installation

Download from https://github.com/matttgregg/fractal1.

## Usage

* mandelbrot _x-resolution_ _y-resolution_ _interation-limit_
  * Prints mandelbrot set.
* julia _x-resolution_ _y-resolution_ _interation-limit_ _c-real_ _c-imaginary_
  * Prints a Julia set, derived from complex number c
* julia-rotate _x-resolution_ _y-resolution_ _interation-limit_ _angle_
  * Prints a Julia set, derived from angle (fixed weight 0.7885)
* julia-stepper _x-resolution_ _y-resolution_ _interation-limit_ _angle-step_ _weight_
  * Continuously prints Julia sets, derived from angle and weight, increasing angle by step each iteration.


__Note__ that all parameters are floats, except for iteration limit which should be an integer.

## Options

Not many options yet.

## Examples

#### Generate a mandelbrot

>> lein run mandelbrot 50 30 30

```
@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%#x+x-#%%%%%%%%@@@
@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%###+x##%%%%%%%%%%@
@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%##-+ -x=%%%%%%%%%%%
@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%###x     x#%%%%%%%%%%
@@@@@%%%%%%%%%%%%%%%%%%%%%%######x.    x#####%%%%%%
@@@@%%%%%%%%%%%%%%%%%%%%%%# -xx:+==   =+x:###x#%%%%
@@@@%%%%%%%%%%%%%%%%%%%%###+  =            x +:%%%%
@@@%%%%%%%%%%%%%%%%%%%%####x                 -##%%%
@@%%%%%%%%%%%%%#%%%%%####--=                 x##%%%
@@%%%%%%%%%%%#x##########x:                   xx%%%
@%%%%%%%%%%%%#xxxxx+xx#xx-                     :#%%
@%%%%%%%%%%%###x      +x+                      ##%%
@%%%%%%%%%%%##++       ==                      x%%%
@%%%%%%%###xxx+         .                      #%%%
@%%%#######x- -                               ##%%%
                                            +x##%%%
@%%%#######x- -                               ##%%%
@%%%%%%%###xxx+         .                      #%%%
@%%%%%%%%%%%##++       ==                      x%%%
@%%%%%%%%%%%###x      +x+                      ##%%
@%%%%%%%%%%%%#xxxxx+xx#xx-                     :#%%
@@%%%%%%%%%%%#x##########x:                   xx%%%
@@%%%%%%%%%%%%%#%%%%%####--=                 x##%%%
@@@%%%%%%%%%%%%%%%%%%%%####x                 -##%%%
@@@@%%%%%%%%%%%%%%%%%%%%###+  =            x +:%%%%
@@@@%%%%%%%%%%%%%%%%%%%%%%# -xx:+==   =+x:###x#%%%%
@@@@@%%%%%%%%%%%%%%%%%%%%%%######x.    x#####%%%%%%
@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%###x     x#%%%%%%%%%%
@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%##-+ -x=%%%%%%%%%%%
@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%###+x##%%%%%%%%%%@
@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%#x+x-#%%%%%%%%@@@
```

Up the detail by increasing some of the parameters:


>> lein run mandelbrot 80 40 30

```
@@@@@@@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%##x+xxx+#%%%%%%%%%%%%%%@@@@
@@@@@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%####x++x###%%%%%%%%%%%%%%%@@
@@@@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%###x:: =x###%%%%%%%%%%%%%%%%%
@@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%###+ + .  :+ ##%%%%%%%%%%%%%%%%
@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%######x=       +###%%%%%%%%%%%%%%%
@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%#########+        +######%%%%%%%%%%%%
@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%###xx###xxxx+      =xxxx########%%%%%%%
@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%###+-:+xx= = :          += x####x+#%%%%%%
@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%####+=   =                  =x+ ++:=#%%%%%
@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%######x                        .    x##%%%%%
@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%######x++                            =x##%%%%%
@@@%%%%%%%%%%%%%%%%%%%#####%%%%%%#######-                               +x###%%%%
@@@%%%%%%%%%%%%%%%%%%##+###############xx=                               xxx#%%%%
@@%%%%%%%%%%%%%%%%%%##+=xxx#xx+xx#####x+                                    x%%%%
@@%%%%%%%%%%%%%%%%%%###x+   ++= +:xxxxx+.                                 +##%%%%
@%%%%%%%%%%%%%%%%%%####x+.  .     - +x+                                   ++#%%%%
@%%%%%%%%%%%%%%%%%####xx+.           ==                                   . #%%%%
@%%%%%%%%%%%%%%###=xxxx=              :                                   -##%%%%
@%%%%%%%%%########x.+=+:                                                 -##%%%%%
@%%%###x########xx=-                                                     ###%%%%%
                                                                      :xx###%%%%%
@%%%###x########xx=-                                                     ###%%%%%
@%%%%%%%%%########x.+=+:                                                 -##%%%%%
@%%%%%%%%%%%%%%###=xxxx=              :                                   -##%%%%
@%%%%%%%%%%%%%%%%%####xx+.           ==                                   . #%%%%
@%%%%%%%%%%%%%%%%%%####x+.  .     - +x+                                   ++#%%%%
@@%%%%%%%%%%%%%%%%%%###x+   ++= +:xxxxx+.                                 +##%%%%
@@%%%%%%%%%%%%%%%%%%##+=xxx#xx+xx#####x+                                    x%%%%
@@@%%%%%%%%%%%%%%%%%%##+###############xx=                               xxx#%%%%
@@@%%%%%%%%%%%%%%%%%%%#####%%%%%%#######-                               +x###%%%%
@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%######x++                            =x##%%%%%
@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%######x                        .    x##%%%%%
@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%####+=   =                  =x+ ++:=#%%%%%
@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%###+-:+xx= = :          += x####x+#%%%%%%
@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%###xx###xxxx+      =xxxx########%%%%%%%
@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%#########+        +######%%%%%%%%%%%%
@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%######x=       +###%%%%%%%%%%%%%%%
@@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%###+ + .  :+ ##%%%%%%%%%%%%%%%%
@@@@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%###x:: =x###%%%%%%%%%%%%%%%%%
@@@@@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%####x++x###%%%%%%%%%%%%%%%@@
@@@@@@@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%##x+xxx+#%%%%%%%%%%%%%%@@@@
```

(We can get very good results with smaller font sizes.)

#### Generate a Julia Set

>> lein run julia-rotate 80 30 30 2.0

```
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%#+#%%%%%%%%%%%%%%%%@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%#+++x##%%%%%%%%%%%%%%%%%%%%%%%@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%+x+ -=+=+###%%%%%##%%%%%%%#=-=%%%%%%@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%###xxxxxxx##x##=--+######++++x#%%%%%%%@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%###-+xx+++  ===+++++xx##x -=.-:++ ###%%%@@@
@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%%##+  =+++---- - =:+xxxxxxxx=  ::-xx+-.:#%%@@
@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%%%####xx+===:-.    ::=+xxxxxxx+++++### #%%%%%@@
@@@@@@@@@@@@@@@@@@@@%%%%%%##%%%%%%####### -.==:::---:== +x#####=+::x%%%%%%%%%%@@@
@@@@@@@@@@@@@@@@@@%%%%%%%#++x#xx-########xxxx+:.:+++++=:-.####%%%%%%%%%%%%%%@@@@@
@@@@@@@@@@@@@@%%%%%%%%%#:+. :===- xx###xxxxxxxxx+++++xxx###%%%%%%%%%%%%%%@@@@@@@@
@@@@@@@@@@@%%%%%%%%%%%%##xx+++++xxxxxxxxxxxxxxxxx+++++xx##%%%%%%%%%%%%@@@@@@@@@@@
@@@@@@@@%%%%%%%%%%%%%%###xxx+++++xxxxxxxxx###xx -===: .+:#%%%%%%%%%@@@@@@@@@@@@@@
@@@@@%%%%%%%%%%%%%%####.-:=+++++:.:+xxxx########-xx#x++#%%%%%%%@@@@@@@@@@@@@@@@@@
@@@%%%%%%%%%%x::+=#####x+ ==:---:::==.- #######%%%%%%##%%%%%%@@@@@@@@@@@@@@@@@@@@
@@%%%%%# ###+++++xxxxxxx+=::    .-:===+xx####%%%%%%%%%%%%%@@@@@@@@@@@@@@@@@@@@@@@
@@%%#:.-+xx-::  =xxxxxxxx+:= - ----+++=  +##%%%%%%%%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@
@@@%%%### ++:-.=- x##xx+++++===  +++xx+-###%%%%%%%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@%%%%%%%#x++++######+--=##x##xxxxxxx###%%%%%%%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@%%%%%%=-=#%%%%%%%##%%%%%###+=+=- +x+%%%%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%##x+++#%%%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%%%%%%#+#%%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
```
(The angle may be any value, but will repeat every 2PI).

#### Generate an animated Julia Set

>> lein run julia-stepper 80 30 30 0.1 0.7885

This does rely on the terminal running relatively well in order to produce a semi-animated effect.
(The weight of 0.7885 gives good results, but feel free to vary to investigate. The step size of 0.1 generates reasonably smooth transitions.)

### Bugs

...


## License

Copyright © 2017 Matthew Gregg

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
