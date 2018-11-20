package flowerstore;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;
/*
 * Copyright (c) 2018. Schenker AG
 * All rights reserved.
 */

public class FlowerStoreTest {

    @Test
    public void testBundleCost() {       
        //testdata
        
        int input1 = 10;
        int input2 = 2;
        int input3 = 5;
        
        Currencies input4 = Currencies.EUR;
        FlowerStore testFlowerStore = new FlowerStore();
        testFlowerStore.createBundle(input1, input2, input3, input4);
        assertTrue(testFlowerStore.preBundle.compareTo(new BigDecimal(42)) == 0);  //why this doesnt have all branches covered ??
        
    }
    @Test
    public void testOrderFlowers() {
        //testdata
        
  
        int input1 = 5;
        int input2 = 10;
        int input3 = 15;
        
        FlowerStore testFlowerStore = new FlowerStore();
        testFlowerStore.orderFlowers(input1, input2, input3);  
        assertEquals((int)testFlowerStore.flowerMap.get(testFlowerStore.rose), 6);
        assertEquals((int)testFlowerStore.flowerMap.get(testFlowerStore.sunflower), 12);
        assertEquals((int)testFlowerStore.flowerMap.get(testFlowerStore.tulip), 18);
    }
    @Test
    public void testOrderFlowersTopConstraints(){
        //testdata
        
        int input1 = 100;
        int input2 = 100;
        int input3 = 100;
        
        FlowerStore testFlowerStore = new FlowerStore();
        testFlowerStore.orderFlowers(input1, input2, input3);
        assertEquals((int)testFlowerStore.flowerMap.get(testFlowerStore.rose), 1);
        assertEquals((int)testFlowerStore.flowerMap.get(testFlowerStore.sunflower), 2);
        assertEquals((int)testFlowerStore.flowerMap.get(testFlowerStore.tulip), 3);       
    }
    @Test
    public void testOrderFlowersBottomConstraints(){
        //testdata
        
        int input1 = 5;
        int input2 = 6;
        int input3 = 7;
        
        FlowerStore testFlowerStore = new FlowerStore();
        testFlowerStore.flowerMap.put(testFlowerStore.rose, 40);
        testFlowerStore.flowerMap.put(testFlowerStore.sunflower, 40);
        testFlowerStore.flowerMap.put(testFlowerStore.tulip, 40);
        testFlowerStore.orderFlowers(input1, input2, input3);
        assertEquals((int)testFlowerStore.flowerMap.get(testFlowerStore.rose), 40);
        assertEquals((int)testFlowerStore.flowerMap.get(testFlowerStore.sunflower), 40);
        assertEquals((int)testFlowerStore.flowerMap.get(testFlowerStore.tulip), 40);   
    }
    @Test
    public void testFlowerMap(){
        
        FlowerStore testFlowerStore = new FlowerStore();
        assertThat(testFlowerStore.flowerMap.size(), is(3));
        assertEquals((int)testFlowerStore.flowerMap.get(testFlowerStore.rose), 1);
        assertEquals((int)testFlowerStore.flowerMap.get(testFlowerStore.sunflower), 2);
        assertEquals((int)testFlowerStore.flowerMap.get(testFlowerStore.tulip), 3);
    }   
    }



