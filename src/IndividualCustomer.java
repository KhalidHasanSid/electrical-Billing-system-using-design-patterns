/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zz10;

/**
 *
 * @author khalid hasan
 */

import java.awt.GridLayout;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;



public class IndividualCustomer implements Customer {
    private String name;
    private String meterNumber;
    private String meterType;
    private String password;
    private String address;

    public IndividualCustomer(String name, String meterNumber, String meterType, String password, String address) {
        this.name = name;
        this.meterNumber = meterNumber;
        this.meterType = meterType;
        this.password = password;
        this.address = address;
    }

    @Override
    public void add(Customer customer) {
     
    }

    @Override
    public void remove(Customer customer) {
       
    }

    @Override
    public Customer getChild(int index) {
        // Not applicable for individual customer
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getMeterNumber() {
        return meterNumber;
    }

    @Override
    public String getMeterType() {
        return meterType;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("customers.txt", true))) {
            writer.write(String.format("%s,%s,%s,%s,%s%n", name, meterNumber, meterType, password, address));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void displayDetails() {
    JFrame detailsFrame = new JFrame("Customer Details");
    detailsFrame.setSize(300, 200);
    detailsFrame.setLayout(new GridLayout(5, 2));

    JLabel lblName = new JLabel("Name: ");
    JLabel lblMeterNumber = new JLabel("Meter Number: ");
    JLabel lblMeterType = new JLabel("Meter Type: ");
    JLabel lblAddress = new JLabel("Address: ");

    JLabel lblNameValue = new JLabel(getName());
    JLabel lblMeterNumberValue = new JLabel(getMeterNumber());
    JLabel lblMeterTypeValue = new JLabel(getMeterType());
    JLabel lblAddressValue = new JLabel(getAddress());

    detailsFrame.add(lblName);
    detailsFrame.add(lblNameValue);
    detailsFrame.add(lblMeterNumber);
    detailsFrame.add(lblMeterNumberValue);
    detailsFrame.add(lblMeterType);
    detailsFrame.add(lblMeterTypeValue);
    detailsFrame.add(lblAddress);
    detailsFrame.add(lblAddressValue);

    detailsFrame.setVisible(true);
}

}
