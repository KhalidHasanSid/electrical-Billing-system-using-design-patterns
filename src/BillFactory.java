/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zz10;

/**
 *
 * @author khalid hasan
 */
public class BillFactory {
    public Bill createBill(String meterType) {
        if (meterType.equalsIgnoreCase("residential")) {
            return new ResidentialBill();
        } else if (meterType.equalsIgnoreCase("commercial")) {
            return new CommercialBill();
        }
        return null; // Invalid meter type
    }
}

