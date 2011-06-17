# Random - Grails Plugin for Random Number Generation

## Description

This Grail plugin wraps the high-performance, statistically sound [Uncommons Maths Pseudo-Random Number Generators](http://maths.uncommons.org/) in convenient, easy-to-use services and taglibs.

## Why would I use this?

You may be asking yourself why you would ever install a highly specialized plugin when you can get a random number using java.util.Random, and a single line of code. Although java.util.Random may suffice for many every-day randomization use-cases, there are at least 3 primary considerations to weigh when choosing to use this plugin (or the Uncommons Maths library):

1) Quality - java.util.Random, while relatively fast, is inferior in the random quality of the numbers it generates. Over large distributions it exhibits significant periodic behavior that shatters any illusion of randomness, rendering it unsuitable for industrial-strength randomization purposes. The Uncommons Maths library provides five alternative algorithms that produce higher-quality random numbers than java.util.Random.

2) Speed - core Java contains an alternative to java.util.Random in java.security.SecureRandom. While this class fills the quality gap, it does so at a cost - in speed. Using SecureRandom may be up to 60 times slower than java.util.Random. Again, this may be suitable for most casual random-number needs, but for industrial strength usage, it may well fall far short of performance requirements. The Uncommons Maths library provides five alternative algorithms that all perform faster than SecureRandom.

3) Convenience - the Random Grails plugin provides a taglib and a service, making it dead simple to add industrial-strength randomization wherever your application should need it. If you've identified a need for shuffling lists, drawing random objects from a collection, or generating a random number from a specified range, you might as well do it the right way. 

## Algorithms

* **MersenneTwisterRNG** - *default*

    A Java port of the fast and reliable Mersenne Twister RNG originally developed by Makoto Matsumoto and Takuji Nishimura. It is faster than java.util.Random, does not have the same statistical flaws as that RNG and also has a long period (219937). *The Mersenne Twister is an excellent general purpose RNG*.

    *Config.groovy*:

        random.generator.default="MERSENNE_TWISTER"

* **XORShiftRNG**

    A Java implementation of the very fast PRNG described by George Marsaglia. It has a period of about 2160, which although much shorter than the Mersenne Twister's, is still significantly longer than that of java.util.Random. *This is the RNG to use when performance is the primary concern. It can be up to twice as fast as the Mersenne Twister*.

    *Config.groovy*:

        random.generator.default="XOR_SHIFT"

* **CMWC4096RNG**

    A Java implementation of a Complementary-Multiply-With-Carry (CMWC) RNG as described by George Marsaglia. It has an extremely long period (2131104) and performance comparable to the Mersenne Twister (though the Mersenne Twister has the advantage of only requiring 16 bytes of seed data rather than the 16 kilobytes required by the CMWC RNG).

    *Config.groovy*:

        random.generator.default="COMPLEMENTARY_MULTIPLY_WITH_CARRY"

* **AESCounterRNG**

    This is a cryptographically-strong1 non-linear RNG that is around 10x faster than java.security.SecureRandom. Reverse-engineering the generator state from observations of its output would involve cracking the AES block cipher.

     *Config.groovy*:

        random.generator.default="AES_COUNTER"

* **CellularAutomatonRNG**

    A Java port of Tony Pasqualoni's fast Cellular Automaton RNG. It uses a 256-cell automaton to generate random values.

    *Config.groovy*:

        random.generator.default="CELLULAR_AUTOMATON"

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

This the...blah...blah

# RandomTagLib

## Tags

# RandomService

## Services

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


