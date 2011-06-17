# Random - Grails Plugin for Random Number Generation

## Description

This Grails plugin wraps the high-performance, statistically sound [Uncommons Maths](http://maths.uncommons.org/)  Pseudo-Random Number Generators in convenient, easy-to-use services and taglibs.

## Why would I use this?

You may be asking yourself why you would ever install a highly specialized plugin when you can easily get a random number using java.util.Random with a single line of code. Although java.util.Random may suffice for many every-day randomization use-cases, there are at least 3 primary considerations to weigh when choosing to use this plugin (or the Uncommons Maths library):

1. **Quality** - java.util.Random, while relatively fast, is inferior in the random quality of the numbers it generates. Over large distributions it exhibits significant periodic behavior that shatters any illusion of randomness, rendering it unsuitable for industrial-strength randomization purposes. The Uncommons Maths library provides five alternative algorithms that produce higher-quality random numbers than java.util.Random.

2. **Speed** - core Java contains an alternative to java.util.Random in java.security.SecureRandom. While this class fills the quality gap, it does so at a cost - in speed. Using SecureRandom may be up to 60 times slower than java.util.Random. Again, this may be suitable for most casual random-number needs, but for industrial strength usage, it may well fall far short of performance requirements. The Uncommons Maths library provides five alternative algorithms that all perform faster than SecureRandom.

3. **Convenience** - the Random Grails plugin provides a taglib and a service, making it dead simple to add industrial-strength randomization wherever your application should need it. If you've identified a need for shuffling lists, drawing random objects from a collection, or generating a random number from a specified range, you might as well do it the right way. 

I found myself using Uncommons Maths for reasons 1 and 2 when it became clear that the core Java randoms would not suffice for my [Random Bands](http://randombands.com) experiment. I decided to package this as a plugin for reason #3 so that others might benefit. I sure could've used this a few months back.

## Installation

Enter your application directory and run the following from the command line: 

    grails install-plugin random

After you have installed the Random plugin in your application, I'd recommend you point your browser to the Plugin test page to verify all is working and familiarize yourself with the functionality it provides:

    http://localhost:8080/myAppContext/random

## Configuration

The RandomPlugin may be configured with a single paramter, specified in your application's */grails-app/conf/Config.groovy*


    random.generator.default	= 'NAME_OF_PNRG_ALGORITHM'	// The PNRG Algorithm to use by default

***
###  random.generator.default

_**optional**_

Setting this to the name of an Uncommons Maths PRNG algorithm (as listed in the next section) specifies which Random Number Generator to use as a default. You may still provide an instance of the com.memetix.random.RandomNumberGenerator to all of the service methods, this just determines which one will be used should you not provide it.

## Algorithms

First, you may want to choose an algorithm. The Mersenne Twister is the default used by this plugin.

* **Mersenne Twister** - *default*

    A Java port of the fast and reliable Mersenne Twister RNG originally developed by Makoto Matsumoto and Takuji Nishimura. It is faster than java.util.Random, does not have the same statistical flaws as that RNG and also has a long period (219937). *The Mersenne Twister is an excellent general purpose RNG*.

    *Config.groovy*:

        random.generator.default="MERSENNE_TWISTER"

* **XOR Shift**

    A Java implementation of the very fast PRNG described by George Marsaglia. It has a period of about 2160, which although much shorter than the Mersenne Twister's, is still significantly longer than that of java.util.Random. *This is the RNG to use when performance is the primary concern. It can be up to twice as fast as the Mersenne Twister*.

    *Config.groovy*:

        random.generator.default="XOR_SHIFT"

* **Complementary-Multiply-With-Carry**

    A Java implementation of a Complementary-Multiply-With-Carry (CMWC) RNG as described by George Marsaglia. It has an extremely long period (2131104) and performance comparable to the Mersenne Twister (though the Mersenne Twister has the advantage of only requiring 16 bytes of seed data rather than the 16 kilobytes required by the CMWC RNG).

    *Config.groovy*:

        random.generator.default="COMPLEMENTARY_MULTIPLY_WITH_CARRY"

* **AES Counter**

    This is a cryptographically-strong1 non-linear RNG that is around 10x faster than java.security.SecureRandom. Reverse-engineering the generator state from observations of its output would involve cracking the AES block cipher.

     *Config.groovy*:

        random.generator.default="AES_COUNTER"

* **Cellular Automaton**

    A Java port of Tony Pasqualoni's fast Cellular Automaton RNG. It uses a 256-cell automaton to generate random values.

    *Config.groovy*:

        random.generator.default="CELLULAR_AUTOMATON"

# RandomTagLib

## Tags

All tags exist in the `random` namespace and return Objects, which means you may call them as methods from within your own controllers and taglibs . For example:

    def myShuffledList = random.shuffle(list:[1,2,3,4,5,6,7,8,9,10])

***
### nextInteger

Returns a random integer

_Parameters_

* **ceiling** - _optional_ upper bound of the random number range. Non-inclusive. If a ceiling is specified without a floor, the floor becomes 0.
* **floor** - _optional_ lower bound of the random number range. Inclusive.
* **generator** - _optional_ String representing the name of the Random Number Generation algorithm or an instance of com.memetix.RandomNumberGenerator

_Example 1_:

    <random:nextInteger/>

_Output 1_:

    134925

_Example 2_:

    <random:nextInteger ceiling="100"/>

_Output 2_:

    92

_Example 3_:

    <random:nextInteger ceiling="3500" floor="2500"/>

_Output 3_:

    3317

***
### nextLong

Returns a random long

_Parameters_

* **ceiling** - _optional_ upper bound of the random number range. Non-inclusive. If a ceiling is specified without a floor, the floor becomes 0.
* **floor** - _optional_ lower bound of the random number range. Inclusive.
* **generator** - _optional_ String representing the name of the Random Number Generation algorithm or an instance of com.memetix.RandomNumberGenerator

_Example 1_:

    <random:nextLong/>

_Output 1_:

    -3462449385734449569

_Example 2_:

    <random:nextLong ceiling="100"/>

_Output 2_:

    77

_Example 3_:

    <random:nextLong ceiling="-3111111111111111111" floor="-3000000000000000000"/>

_Output 3_:

    3000005023402523523

***
### nextBoolean

Returns a random boolean - i.e. flips a coin

_Parameters_

* **generator** - _optional_ String representing the name of the Random Number Generation algorithm or an instance of com.memetix.RandomNumberGenerator

_Example 1_:

    <random:nextBoolean/>

_Output 1_:

    false

***
### shuffle

Shuffles a list and returns the shuffled list

_Parameters_

* **list** - a List of any type of object that you like shuffled in a random order
* **generator** - _optional_ String representing the name of the Random Number Generation algorithm or an instance of com.memetix.RandomNumberGenerator

_Example 1_:

    <random:shuffle list="${[1,2,3,4,5,6,7,8,9,10]}"/>

_Output 1_:

    [7, 5, 1, 8, 3, 4, 6, 2, 10, 9]

***
### draw

Draws a random object from the provided list and returns the object that was drawn

_Parameters_

* **list** - a List of any type of object from which you would like to draw a random item
* **generator** - _optional_ String representing the name of the Random Number Generation algorithm or an instance of com.memetix.RandomNumberGenerator

_Example 1_:

    <random:draw list="${[1,2,3,4,5,6,7,8,9,10]}"/>

_Output 1_:

    4

# RandomService

## Services

    TODO list of services and examples

## Source Code @ GitHub

The source code is available on GitHub at [https://github.com/boatmeme/grails-random](https://github.com/boatmeme/grails-random). 

Find a bug? Fork it. Fix it. Issue a pull request.

    git clone git://github.com/boatmeme/grails-random

Contributions welcome!

## Issue Tracking @ GitHub

Issue tracking is also on GitHub at [https://github.com/boatmeme/grails-random/issues](https://github.com/boatmeme/grails-random/issues).

Bug reports, Feature requests, and general inquiries welcome.

## Contact

Feel free to contact me by email (jonathan.griggs at gmail.com) or follow me on GitHub at [https://github.com/boatmeme](https://github.com/boatmeme).

# Change Log

## v0.1 - 2011.06.17

* Initial release


