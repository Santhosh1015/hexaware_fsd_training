package com.main;

import com.beans.Customer;

public class HeapDemo {
    public static void main(String[] args) {
        Customer customer1 = new Customer(1 ,29 , "Thomas" );

        /* here customer1
                cusotmer2
                customer3
                are the references of the objects that is stored in the STACK(main method)
        */
        // GC - GARBAGE COLLECTOR  only cleans when the method calls end
        // but usually in the Spring project only terminates we end that
        // so have a consious on creatinf object - singleton design patter

        //new customer is what creating object in HEAP

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setName("Sameul");
        customer2.setAge(22);

        Customer customer3 = customer2;

        System.out.println("customer1 memory loc: "+customer1);
        System.out.println("customer2 memory loc: "+customer2);
        System.out.println("customer3 memory loc: "+customer3);

        // these are the memory that stored in the heap
//        customer1 memory loc: com.beans.Customer@8efb846
//        customer2 memory loc: com.beans.Customer@2a84aee7
//        customer3 memory loc: com.beans.Customer@2a84aee7
    }
}
