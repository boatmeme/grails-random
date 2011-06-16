package com.memetix.random

import grails.test.*
import org.uncommons.maths.random.*

class RandomServiceTests extends GrailsUnitTestCase {
    def randomService
	
    protected void setUp() {
        super.setUp()
        randomService = new RandomService()
        randomService.afterPropertiesSet()
    }

    protected void tearDown() {
        super.tearDown()
    }
    
    void testRandomNumberGeneratorEnum_Get() {
         def random = RandomNumberGenerator.fromString("MERSENNE_TWISTER")
         assertEquals "MERSENNE_TWISTER",random.toString()
         random = RandomNumberGenerator.fromString("AES_COUNTER")
         assertEquals "AES_COUNTER",random.toString()
         random = RandomNumberGenerator.fromString("aes_counter")
         assertEquals "AES_COUNTER",random.toString()
         random = RandomNumberGenerator.fromString("broken")
         assertNull random
    }
    
    void testShuffle() {
         List list = new ArrayList()
         for(int i = 0; i<100; i++) {
             list.add(i);
         }
         
         assertEquals 100, list.size()
         randomService.shuffle(list)
         assertEquals 100, list.size()
         
         for(iter in list) {
            assertTrue iter >= 0;
            assertTrue iter < 100;
         }
         
    }
    
     void testDraw() {
         List list = new ArrayList()
         for(int i = 1500; i<2500; i++) {
             list.add(i);
         }
         
         def pick = randomService.draw(list)
         assertTrue list.contains(pick)
         assertTrue pick >= 1500
         assertTrue pick < 2500
    }

    /* Test getInteger, all algorithms 
    
    MERSENNE_TWISTER,
    XOR_SHIFT,
    COMPLEMENTARY_MULTIPLY_WITH_CARRY,
    AES_COUNTER,
    CELLULAR_AUTOMATON;
    
    */
   
    void testGetInteger_DEFAULT() {
        for(int i = 0; i<1000;i++) {
            def result = randomService.nextInteger(10)
            assertTrue result < 10;
        }
        
        for(int i = 0; i<1000;i++) {
            def result = randomService.nextInteger(10,20)
            assertTrue result >= 10;
            assertTrue result < 20;
        }
    }
   
    void testGetInteger_MERSENNE_TWISTER() {
        for(int i = 0; i<1000;i++) {
            def result = randomService.nextInteger(10, RandomNumberGenerator.MERSENNE_TWISTER)
            assertTrue result < 10;
        }
        
        for(int i = 0; i<1000;i++) {
            def result = randomService.nextInteger(10,20, RandomNumberGenerator.MERSENNE_TWISTER)
            assertTrue result >= 10;
            assertTrue result < 20;
        }
    }
    
    void testGetInteger_XOR_SHIFT() {
        for(int i = 0; i<1000;i++) {
                def result = randomService.nextInteger(10, RandomNumberGenerator.XOR_SHIFT)
                assertTrue result < 10;
        }
        
        for(int i = 0; i<1000;i++) {
            def result = randomService.nextInteger(10,20, RandomNumberGenerator.XOR_SHIFT)
            assertTrue result >= 10;
            assertTrue result < 20;
        }
    }
    
    void testGetInteger_COMPLEMENTARY_MULTIPLY_WITH_CARRY() {
        for(int i = 0; i<1000;i++) {
                def result = randomService.nextInteger(10, RandomNumberGenerator.COMPLEMENTARY_MULTIPLY_WITH_CARRY)
                assertTrue result < 10;
        }
        
        for(int i = 0; i<1000;i++) {
            def result = randomService.nextInteger(10,20, RandomNumberGenerator.COMPLEMENTARY_MULTIPLY_WITH_CARRY)
            assertTrue result >= 10;
            assertTrue result < 20;
        }
    }
    
    void testGetInteger_AES_COUNTER() {
        for(int i = 0; i<1000;i++) {
                def result = randomService.nextInteger(10, RandomNumberGenerator.AES_COUNTER)
                assertTrue result < 10;
        }
        for(int i = 0; i<1000;i++) {
            def result = randomService.nextInteger(10,20, RandomNumberGenerator.AES_COUNTER)
            assertTrue result >= 10;
            assertTrue result < 20;
        }
    }
    
    void testGetInteger_CELLULAR_AUTOMATON() {
        for(int i = 0; i<1000;i++) {
                def result = randomService.nextInteger(10, RandomNumberGenerator.CELLULAR_AUTOMATON)
                assertTrue result < 10;
        }
        for(int i = 0; i<1000;i++) {
            def result = randomService.nextInteger(10,20, RandomNumberGenerator.CELLULAR_AUTOMATON)
            assertTrue result >= 10;
            assertTrue result < 20;
        }
    }
    
    /* Test getLong, all algorithms 
    
    MERSENNE_TWISTER,
    XOR_SHIFT,
    COMPLEMENTARY_MULTIPLY_WITH_CARRY,
    AES_COUNTER,
    CELLULAR_AUTOMATON;
    
    */
   
    void testGetLong_DEFAULT() {
        for(int i = 0; i<1000;i++) {
            def result = randomService.nextLong(10)
            assertTrue result < 10;
        }
        
        for(int i = 0; i<1000;i++) {
            def result = randomService.nextLong(1000, 2000)
            assertTrue result < 2000;
            assertTrue result >= 1000;
        }
    }
   
    void testGetLong_MERSENNE_TWISTER() {
        for(int i = 0; i<1000;i++) {
            def result = randomService.nextLong(10, RandomNumberGenerator.MERSENNE_TWISTER)
            assertTrue result < 10;
        }
        
        for(int i = 0; i<1000;i++) {
            def result = randomService.nextLong(1000, 2000, RandomNumberGenerator.MERSENNE_TWISTER)
            assertTrue result < 2000;
            assertTrue result >= 1000;
        }
    }
    
    void testGetLong_XOR_SHIFT() {
        for(int i = 0; i<1000;i++) {
            def result = randomService.nextLong(10, RandomNumberGenerator.XOR_SHIFT)
            assertTrue result < 10;
        }
        
        for(int i = 0; i<1000;i++) {
            def result = randomService.nextLong(1000, 2000, RandomNumberGenerator.XOR_SHIFT)
            assertTrue result < 2000;
            assertTrue result >= 1000;
        }
    }
    
    void testGetLong_COMPLEMENTARY_MULTIPLY_WITH_CARRY() {
        for(int i = 0; i<1000;i++) {
            def result = randomService.nextLong(10, RandomNumberGenerator.COMPLEMENTARY_MULTIPLY_WITH_CARRY)
            assertTrue result < 10;
        }
        
        for(int i = 0; i<1000;i++) {
            def result = randomService.nextLong(1000, 2000, RandomNumberGenerator.COMPLEMENTARY_MULTIPLY_WITH_CARRY)
            assertTrue result < 2000;
            assertTrue result >= 1000;
        }
    }
    
    void testGetLong_AES_COUNTER() {
       for(int i = 0; i<1000;i++) {
            def result = randomService.nextLong(10, RandomNumberGenerator.AES_COUNTER)
            assertTrue result < 10;
        }
        
        for(int i = 0; i<1000;i++) {
            def result = randomService.nextLong(1000, 2000, RandomNumberGenerator.AES_COUNTER)
            assertTrue result < 2000;
            assertTrue result >= 1000;
        }
    }
    
    void testGetLong_CELLULAR_AUTOMATON() {
        for(int i = 0; i<1000;i++) {
            def result = randomService.nextLong(10, RandomNumberGenerator.CELLULAR_AUTOMATON)
            assertTrue result < 10;
        }
        
        for(int i = 0; i<1000;i++) {
            def result = randomService.nextLong(1000, 2000, RandomNumberGenerator.CELLULAR_AUTOMATON)
            assertTrue result < 2000;
            assertTrue result >= 1000;
        }
    }
    
    /* Test getDouble, all algorithms 
    
    MERSENNE_TWISTER,
    XOR_SHIFT,
    COMPLEMENTARY_MULTIPLY_WITH_CARRY,
    AES_COUNTER,
    CELLULAR_AUTOMATON;
    
    */
   
    void testGetDouble_DEFAULT() {
        for(int i = 0; i<1000;i++) {
            def result = randomService.nextDouble()
            assertTrue result < 1.0;
            assertTrue result >= 0.0;
        }
    }
   
    void testGetDouble_MERSENNE_TWISTER() {
       for(int i = 0; i<1000;i++) {
            def result = randomService.nextDouble(RandomNumberGenerator.MERSENNE_TWISTER)
            assertTrue result < 1.0;
            assertTrue result >= 0.0;
        }
    }
    
    void testGetDouble_XOR_SHIFT() {
        for(int i = 0; i<1000;i++) {
            def result = randomService.nextDouble(RandomNumberGenerator.XOR_SHIFT)
            assertTrue result < 1.0;
            assertTrue result >= 0.0;
        }
    }
    
    void testGetDouble_COMPLEMENTARY_MULTIPLY_WITH_CARRY() {
        for(int i = 0; i<1000;i++) {
            def result = randomService.nextDouble(RandomNumberGenerator.COMPLEMENTARY_MULTIPLY_WITH_CARRY)
            assertTrue result < 1.0;
            assertTrue result >= 0.0;
        }
    }
    
    void testGetDouble_AES_COUNTER() {
       for(int i = 0; i<1000;i++) {
            def result = randomService.nextDouble(RandomNumberGenerator.AES_COUNTER)
            assertTrue result < 1.0;
            assertTrue result >= 0.0;
        }
    }
    
    void testGetDouble_CELLULAR_AUTOMATON() {
        for(int i = 0; i<1000;i++) {
            def result = randomService.nextDouble(RandomNumberGenerator.CELLULAR_AUTOMATON)
            assertTrue result < 1.0;
            assertTrue result >= 0.0;
        }
    }  
    
    /* Test getFloat, all algorithms 
    
    MERSENNE_TWISTER,
    XOR_SHIFT,
    COMPLEMENTARY_MULTIPLY_WITH_CARRY,
    AES_COUNTER,
    CELLULAR_AUTOMATON;
    
    */
   
    void testGetFloat_DEFAULT() {
        for(int i = 0; i<1000;i++) {
            def result = randomService.nextFloat()
            assertTrue result < 1.0;
            assertTrue result >= 0.0;
        }
    }
   
    void testGetFloat_MERSENNE_TWISTER() {
       for(int i = 0; i<1000;i++) {
            def result = randomService.nextFloat(RandomNumberGenerator.MERSENNE_TWISTER)
            assertTrue result < 1.0;
            assertTrue result >= 0.0;
        }
    }
    
    void testGetFloat_XOR_SHIFT() {
        for(int i = 0; i<1000;i++) {
            def result = randomService.nextFloat(RandomNumberGenerator.XOR_SHIFT)
            assertTrue result < 1.0;
            assertTrue result >= 0.0;
        }
    }
    
    void testGetFloat_COMPLEMENTARY_MULTIPLY_WITH_CARRY() {
        for(int i = 0; i<1000;i++) {
            def result = randomService.nextFloat(RandomNumberGenerator.COMPLEMENTARY_MULTIPLY_WITH_CARRY)
            assertTrue result < 1.0;
            assertTrue result >= 0.0;
        }
    }
    
    void testGetFloat_AES_COUNTER() {
       for(int i = 0; i<1000;i++) {
            def result = randomService.nextFloat(RandomNumberGenerator.AES_COUNTER)
            assertTrue result < 1.0;
            assertTrue result >= 0.0;
        }
    }
    
    void testGetFloat_CELLULAR_AUTOMATON() {
        for(int i = 0; i<1000;i++) {
            def result = randomService.nextFloat(RandomNumberGenerator.CELLULAR_AUTOMATON)
            assertTrue result < 1.0;
            assertTrue result >= 0.0;
        }
    }
    
    /* Test getGaussian, all algorithms 
    
    MERSENNE_TWISTER,
    XOR_SHIFT,
    COMPLEMENTARY_MULTIPLY_WITH_CARRY,
    AES_COUNTER,
    CELLULAR_AUTOMATON;
    
    */
   
    void testGetGaussian_DEFAULT() {
        for(int i = 0; i<1000;i++) {
            def result = randomService.nextGaussian()
            assert result
        }
    }
   
    void testGetGaussian_MERSENNE_TWISTER() {
       for(int i = 0; i<1000;i++) {
            def result = randomService.nextGaussian(RandomNumberGenerator.MERSENNE_TWISTER)
            assert result
        }
    }
    
    void testGetGaussian_XOR_SHIFT() {
        for(int i = 0; i<1000;i++) {
            def result = randomService.nextGaussian(RandomNumberGenerator.XOR_SHIFT)
            assert result
        }
    }
    
    void testGetGaussian_COMPLEMENTARY_MULTIPLY_WITH_CARRY() {
        for(int i = 0; i<1000;i++) {
            def result = randomService.nextGaussian(RandomNumberGenerator.COMPLEMENTARY_MULTIPLY_WITH_CARRY)
            assert result
        }
    }
    
    void testGetGaussian_AES_COUNTER() {
       for(int i = 0; i<1000;i++) {
            def result = randomService.nextGaussian(RandomNumberGenerator.AES_COUNTER)
            assert result
        }
    }
    
    void testGetGaussian_CELLULAR_AUTOMATON() {
        for(int i = 0; i<1000;i++) {
            def result = randomService.nextGaussian(RandomNumberGenerator.CELLULAR_AUTOMATON)
            assert result
        }
    }
    
    /* Test getBoolean, all algorithms 
    
    MERSENNE_TWISTER,
    XOR_SHIFT,
    COMPLEMENTARY_MULTIPLY_WITH_CARRY,
    AES_COUNTER,
    CELLULAR_AUTOMATON;
    
    */
   
    void testGetBoolean_DEFAULT() {
        for(int i = 0; i<1000;i++) {
            def result = randomService.nextBoolean()
            assertTrue result == new Boolean(true) || result == new Boolean(false);
        }
    }
   
    void testGetBoolean_MERSENNE_TWISTER() {
       for(int i = 0; i<1000;i++) {
            def result = randomService.nextBoolean(RandomNumberGenerator.MERSENNE_TWISTER)
            assertTrue result == new Boolean(true) || result == new Boolean(false);
        }
    }
    
    void testGetBoolean_XOR_SHIFT() {
        for(int i = 0; i<1000;i++) {
            def result = randomService.nextBoolean(RandomNumberGenerator.XOR_SHIFT)
            assertTrue result == new Boolean(true) || result == new Boolean(false);
        }
    }
    
    void testGetBoolean_COMPLEMENTARY_MULTIPLY_WITH_CARRY() {
        for(int i = 0; i<1000;i++) {
            def result = randomService.nextBoolean(RandomNumberGenerator.COMPLEMENTARY_MULTIPLY_WITH_CARRY)
            assertTrue result == new Boolean(true) || result == new Boolean(false);
        }
    }
    
    void testGetBoolean_AES_COUNTER() {
       for(int i = 0; i<1000;i++) {
            def result = randomService.nextBoolean(RandomNumberGenerator.AES_COUNTER)
            assertTrue result == new Boolean(true) || result == new Boolean(false);
        }
    }
    
    void testGetBoolean_CELLULAR_AUTOMATON() {
        for(int i = 0; i<1000;i++) {
            def result = randomService.nextBoolean(RandomNumberGenerator.CELLULAR_AUTOMATON)
            assertTrue result == new Boolean(true) || result == new Boolean(false);
        }
    }
}
