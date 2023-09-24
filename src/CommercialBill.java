/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zz10;

/**
 *
 * @author khalid hasan
 */
public class CommercialBill implements Bill {
    private static final double COMMERCIAL_RATE = 75.0;

    @Override
    public double calculateBill(double unitsConsumed) {
        return unitsConsumed * COMMERCIAL_RATE;
    }
}
