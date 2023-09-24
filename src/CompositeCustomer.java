/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zz10;

/**
 *
 * @author khalid hasan
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CompositeCustomer implements Customer {
    private String name;
    private List<Customer> customers;

    public CompositeCustomer(String name) {
        this.name = name;
        customers = new ArrayList<>();
    }

    @Override
    public void add(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void remove(Customer customer) {
        customers.remove(customer);
    }

   /* @Override
    public Customer getChild(int index) {
        return customers.get(index);
    }*/
     public Customer getChild(int index) {
        if (index >= 0 && index < customers.size()) {
            return customers.get(index);
        }
        return new NullCustomer(); 
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getMeterNumber() {
        return null; 
    }

    @Override
    public String getMeterType() {
        return null; 
    }

    @Override
    public String getPassword() {
        return null; 
    }

    @Override
    public String getAddress() {
        return null; 
    }

    @Override
    public void saveToFile() {
        for (Customer customer : customers) {
            customer.saveToFile();
        }
    }

    
    
}

