package flowerstore;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
/*
 * Copyright (c) 2018. Schenker AG
 * All rights reserved.
 */
import org.junit.runner.notification.Failure;

public class TestRunner {
                 public static void main(String[] args){
                     
                         Result result = JUnitCore.runClasses(FlowerStoreTest.class);
                         
                         for (Failure failure : result.getFailures()){
                             System.out.println(failure.toString());
                         }
                         System.out.println(result.wasSuccessful());
                         System.out.println("success");
                 }
}

