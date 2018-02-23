package com.pragmatic.util;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CustomerCareOfficer {

   private static BlockingQueue<String> queue = new ArrayBlockingQueue<String>(10, true);


    public void setCustomerID(String customerID){
        try {
            queue.put(customerID);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public String  getCustomerID(){
        String customerID = null;

        try {
            customerID = queue.take();
            return customerID;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  customerID;
    }


//    public static void main(String[] args) {
//
//        CustomerCareOfficer co = new CustomerCareOfficer();
//        co.setCustomerID("Janesh91");
//        System.out.printf("Value in the queue" + co.getCustomerID());
//
//
//    }
}
