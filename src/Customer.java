/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package zz10;

/**
 *
 * @author khalid hasan
 */
public interface Customer {
     void add(Customer customer);
    void remove(Customer customer);
    Customer getChild(int index);
    String getName();
    String getMeterNumber();
    String getMeterType();
    String getPassword();
    String getAddress();

    public void saveToFile();

   

}
    

