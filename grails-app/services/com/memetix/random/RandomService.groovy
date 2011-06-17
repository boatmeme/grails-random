/**
*
*   Copyright 2011 Jonathan Griggs
*
*   Licensed under the Apache License, Version 2.0 (the "License");
*   you may not use this file except in compliance with the License.
*   You may obtain a copy of the License at
*
*       http://www.apache.org/licenses/LICENSE-2.0
*
*   Unless required by applicable law or agreed to in writing, software
*   distributed under the License is distributed on an "AS IS" BASIS,
*   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*   See the License for the specific language governing permissions and
*   limitations under the License.
**/
package com.memetix.random

import org.uncommons.maths.random.*
import org.springframework.beans.factory.InitializingBean
/**
 * RandomService
 * 
 *  Provides services for getting random numbers based off of the Pseudorandom Number Generators
 *  in the Uncommons Maths library.
 *  
 *  Also provides services for acting upon lists in a random way, including shuffle() and draw()
 * 
 * @author Jonathan Griggs  <jonathan.griggs @ gmail.com>
 * @version     0.1     2011.06.16                              
 * @since       0.1     2011.06.16                            
 */
class RandomService implements InitializingBean {
    def grailsApplication
    def defaultRNG

    static transactional = true
    
    void afterPropertiesSet() { 
        defaultRNG = grailsApplication?.config?.random?.generator?.default ? RandomNumberGenerator.fromString(grailsApplication?.config?.random?.generator?.default.toString()): RandomNumberGenerator.MERSENNE_TWISTER
    } 

    def nextInteger() {
        return nextInteger(defaultRNG)
    }
    
    def nextInteger(RandomNumberGenerator rng) {
        return rng.getRNG().nextInt()
    }
    
    def nextInteger(int ceiling) {
        return nextInteger(ceiling, defaultRNG)
    }
    
    def nextInteger(int ceiling, RandomNumberGenerator rng) {
        return rng.getRNG().nextInt(ceiling)
    }
    
    def nextInteger(int floor, int ceiling) {
        return nextInteger(floor, ceiling, defaultRNG)
    }
    
    def nextInteger(int floor, int ceiling, RandomNumberGenerator rng) {
        return floor + (int)(rng.getRNG().nextDouble()*(ceiling-floor));
    }
    
    def nextLong() {
        return nextLong(defaultRNG)
    }
    
    def nextLong(RandomNumberGenerator rng) {
        return rng.getRNG().nextLong()
    }
    
    def nextLong(long ceiling) {
        return nextLong(ceiling, defaultRNG)
    }
    
    def nextLong(long ceiling, RandomNumberGenerator rng) {
        return nextLong(0, ceiling, rng)
    }
    
    def nextLong(long floor, long ceiling) {
        return nextLong(floor, ceiling, defaultRNG)
    }
    
    def nextLong(long floor, long ceiling, RandomNumberGenerator rng) {
        return floor +(long)(rng.getRNG().nextDouble()*(ceiling-floor));
    }
    
    def nextFloat() {
        return nextFloat(defaultRNG)
    }
    
    def nextFloat(RandomNumberGenerator rng) {
        return rng.getRNG().nextFloat()
    }
    
    def nextDouble() {
        return nextDouble(defaultRNG)
    }
    
    def nextDouble(RandomNumberGenerator rng) {
        return rng.getRNG().nextDouble()
    }
    
    def nextBoolean() {
        return nextBoolean(defaultRNG)
    }
    
    def nextBoolean(RandomNumberGenerator rng) {
        return rng.getRNG().nextBoolean()
    }
    
    def nextGaussian() {
        return nextGaussian(defaultRNG)
    }
    
    def nextGaussian(RandomNumberGenerator rng) {
        return rng.getRNG().nextGaussian()
    }
    
    def draw(List list) {
        return draw(list,defaultRNG)
    }
    
    def draw(List list, RandomNumberGenerator rng) {
        return list.get(nextInteger(list.size(),rng))
    }
    
    def shuffle(List list) {
        return shuffle(list,defaultRNG)
    }
    
    def shuffle(List list, RandomNumberGenerator rng) {
        Collections.shuffle(list,rng.getRNG())
        return list
    }
}

public enum RandomNumberGenerator {
    MERSENNE_TWISTER(new MersenneTwisterRNG()),
    XOR_SHIFT(new XORShiftRNG()),
    AES_COUNTER(new AESCounterRNG()),
    CELLULAR_AUTOMATON(new CellularAutomatonRNG());
    
    private final java.util.Random rng;
    
    RandomNumberGenerator(java.util.Random rng) {
        this.rng = rng;
    }
    
    public java.util.Random getRNG() {
        return rng;
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
