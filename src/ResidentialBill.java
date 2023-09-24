/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zz10;

/**
 *
 * @author khalid hasan
 */
public class ResidentialBill implements Bill {
    private static final double RESIDENTIAL_RATE = 50.0;

    @Override
    public double calculateBill(double unitsConsumed) {
        return unitsConsumed * RESIDENTIAL_RATE;
    }
}
