package com.memetix.random;
import org.uncommons.maths.random.*;
        
public enum RandomNumberGenerator {
    MERSENNE_TWISTER,
    XOR_SHIFT,
    COMPLEMENTARY_MULTIPLY_WITH_CARRY,
    AES_COUNTER,
    CELLULAR_AUTOMATON;
    
    private java.util.Random rng;
    
    RandomNumberGenerator() {
    }
    
    public java.util.Random getRNG() {
        if(this.rng==null)
            constructRNG();
        return rng;
    }
    
    private void constructRNG() {
        switch(this) {
            case MERSENNE_TWISTER: this.rng = new MersenneTwisterRNG();
            case XOR_SHIFT: this.rng = new XORShiftRNG();
            case COMPLEMENTARY_MULTIPLY_WITH_CARRY: this.rng = new CMWC4096RNG();
            case AES_COUNTER: 
                try {
                    this.rng = new AESCounterRNG();
                } catch(Exception e) {
                    this.rng = new MersenneTwisterRNG();
                }
            case CELLULAR_AUTOMATON: this.rng = new CellularAutomatonRNG();
        }
    }
 
    public static RandomNumberGenerator fromString(final String pRandom) {
        for (RandomNumberGenerator r : values()) {
                if (r.toString().equalsIgnoreCase(pRandom)) {
                        return r;
                }
        }
        return null;
    }
}
