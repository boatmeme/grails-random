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
/**
 * RandomTagLib 
 * 
 * namespace:random
 * 
 * tags:    nextInteger
 *        
 * 
 * @author Jonathan Griggs  <twitcaps.developer @ gmail.com>
 * @version     1.0     2011.05.17                              
 * @since       1.0     2011.05.17                            
 */
class RandomTagLib {
    def randomService
    static namespace = "random"
    static returnObjectForTags = ['shuffle','draw']
    
    def nextInteger = { attrs ->
        def floor   = attrs?.floor as int;
        def ceiling = attrs?.ceiling as int;
        def rng = attrs?.rng ? RandomNumberGenerator.fromString(attrs.rng.toString()) : randomService.defaultRNG
        def random
 
        if(!ceiling&&!floor) {
          random = randomService.nextInteger(rng)
        } else if(ceiling&&floor) {
          random = randomService.nextInteger(floor,ceiling,rng)  
        } else if(!ceiling&&floor){
            throw new RuntimeException("RandomTagLib.nextInteger(): If you specify a floor, you must specify a ceiling")
        } else if(ceiling&&!floor) {
          random = randomService.nextInteger(ceiling,rng)
        }   
        out << random
    }
    
    def nextLong = { attrs ->
        def floor   = attrs?.floor as long;
        def ceiling = attrs?.ceiling as long;
        def rng = attrs?.rng ? RandomNumberGenerator.fromString(attrs.rng.toString()) : randomService.defaultRNG
        def random
        
        if(!ceiling&&!floor) {
          random = randomService.nextLong(rng)
        } else if(ceiling&&floor) {
          random = randomService.nextLong(floor,ceiling,rng)  
        } else if(!ceiling&&floor){
            throw new RuntimeException("RandomTagLib.nextLong(): If you specify a floor, you must specify a ceiling")
        } else if(ceiling&&!floor) {
          random = randomService.nextLong(ceiling,rng)
        }   
        out << random
    }
    
    def nextBoolean = { attrs ->
        def rng = attrs?.rng ? RandomNumberGenerator.fromString(attrs.rng.toString()) : randomService.defaultRNG
        def random = randomService.nextBoolean(rng)  
        out << random
    }
    
    def shuffle = { attrs ->
        def list = attrs?.list ?: new ArrayList()
        randomService.shuffle(list)
        return list
    }    
    
    def draw = { attrs ->
        def list = attrs?.list ?: new ArrayList()
        def random = randomService.draw(list)
        return random
    } 
}
