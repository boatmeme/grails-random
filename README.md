# Grails Random

This Grail plugin wraps the [Uncommons Maths Pseudo-Random Number Generators](http://maths.uncommons.org/) in convenient, easy-to-use services and taglibs.

* MersenneTwisterRNG

A Java port of the fast and reliable Mersenne Twister RNG originally developed by Makoto Matsumoto and Takuji Nishimura. It is faster than java.util.Random, does not have the same statistical flaws as that RNG and also has a long period (219937). The Mersenne Twister is an excellent general purpose RNG.

* XORShiftRNG

A Java implementation of the very fast PRNG described by George Marsaglia. It has a period of about 2160, which although much shorter than the Mersenne Twister's, is still significantly longer than that of java.util.Random. This is the RNG to use when performance is the primary concern. It can be up to twice as fast as the Mersenne Twister.

* CMWC4096RNG

A Java implementation of a Complementary-Multiply-With-Carry (CMWC) RNG as described by George Marsaglia. It has an extremely long period (2131104) and performance comparable to the Mersenne Twister (though the Mersenne Twister has the advantage of only requiring 16 bytes of seed data rather than the 16 kilobytes required by the CMWC RNG).

* AESCounterRNG
This is a cryptographically-strong1 non-linear RNG that is around 10x faster than java.security.SecureRandom. Reverse-engineering the generator state from observations of its output would involve cracking the AES block cipher.

* CellularAutomatonRNG
A Java port of Tony Pasqualoni's fast Cellular Automaton RNG. It uses a 256-cell automaton to generate random values.


