/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zz10;

/**
 *
 * @author khalid hasan
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BillSearchFrame extends JFrame {
    private JComboBox<String> monthComboBox;
    private JTextField yearTextField;
    private JTextArea displayTextArea;
  

    
        // Set up the frame properties
         public BillSearchFrame() {
     
        // ...
    
        setTitle("Bill Search");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create and add the components
        JPanel searchPanel = createSearchPanel();
        add(searchPanel, BorderLayout.NORTH);

        JPanel displayPanel = createDisplayPanel();
        add(displayPanel, BorderLayout.CENTER);
    }
         


    private JPanel createSearchPanel() {
        JPanel searchPanel = new JPanel();

        JLabel monthLabel = new JLabel("Month:");
        monthComboBox = new JComboBox<>(new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "Octuber", "November", "December"});

        JLabel yearLabel = new JLabel("Year:");
        yearTextField = new JTextField(10);

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedMonth = (String) monthComboBox.getSelectedItem();
                String selectedYear = yearTextField.getText();

                searchBill(selectedMonth, selectedYear);
            }
        });

        searchPanel.add(monthLabel);
        searchPanel.add(monthComboBox);
        searchPanel.add(yearLabel);
        searchPanel.add(yearTextField);
        searchPanel.add(searchButton);

        return searchPanel;
    }

    private JPanel createDisplayPanel() {
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BorderLayout());

        displayTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(displayTextArea);
        displayPanel.add(scrollPane, BorderLayout.CENTER);

        JButton printButton = new JButton("Print");
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printBill();
            }
        });
        displayPanel.add(printButton, BorderLayout.SOUTH);

        return displayPanel;
    }

    private void searchBill(String month, String year) {
        String filePath = "bills.txt";
        String searchTerm = month + "," + year;
        StringBuilder billDetails = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                if (line.contains(searchTerm)) {
                    // Split the line into different fields
                    String[] fields = line.split(",");

                    // Append the bill details to the StringBuilder
                    billDetails.append("Name: ").append(fields[0]).append("\n");
                    billDetails.append("Meter Number: ").append(fields[1]).append("\n");
                    billDetails.append("Month: ").append(fields[2]).append("\n");
                    billDetails.append("Year: ").append(fields[3]).append("\n");
                    billDetails.append("Bill Number: ").append(fields[4]).append("\n");
                    billDetails.append("Unit Consumed: ").append(fields[5]).append("\n");
                    billDetails.append("-----------------------------------").append("\n");
                    billDetails.append("Calculated Bill: ").append(fields[6]).append("\n");

                    found = true;
                    break;
                }
            }

            if (!found) {
                billDetails.append("Bill not currently available");
            }

            displayTextArea.setText(billDetails.toString());
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    private void printBill() {
       PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(displayTextArea.getPrintable(null, null));

        if (job.printDialog()) {
            try {
               job.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
    }

}
    

