package zz10;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
public class BillingSystem1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic hereimport javax.swing.*;


    new Welcome(); 
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                
               
                new LoginGUI();
            }
        });
    }
}
    
     

