/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zz10;

/**
 *
 * @author khalid hasan
 */
public class NullCustomer implements Customer {
    @Override
    public void add(Customer customer) {
        // Null implementation
    }

    @Override
    public void remove(Customer customer) {
        // Null implementation
    }

    @Override
    public Customer getChild(int index) {
        return this; // Return self for invalid index
    }
 @Override
    public String getName() {
        return "Customer does not exist";
    }

    @Override
    public String getMeterNumber() {
        return "Customer does not exist";
    }

    @Override
    public String getMeterType() {
        return "Customer does not exist";
    }

    @Override
    public String getPassword() {
        return "Customer does not exist";
    }
 public String getAddress() {
        return "Customer does not exist";
    }

    @Override
    public void saveToFile() {
        // Null implementation
    }
}
