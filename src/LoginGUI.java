package zz10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;
import java.util.Scanner;
import javax.swing.border.Border;

public class LoginGUI extends JFrame {

    private JFrame frame;
    private JComboBox<String> userTypeComboBox;
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JLabel lblMeterNumber;
    private JTextField txtMeterNumber;
    private JButton btnLogin;
   JLabel background;
    JLabel background1;

    public LoginGUI() {
        frame = new JFrame("User Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1454, 700);
         this.getContentPane().setBackground(Color.WHITE);
         ImageIcon img = new ImageIcon(getClass().getResource("pp.jpg"));
       background = new JLabel("",img,JLabel.CENTER);
       background.setSize(1454, 700);
       frame.getContentPane().add(background);
          frame.setLocationRelativeTo(null);
        
         
      //  frame.setLayout(new BorderLayout());

        
       // JPanel mainPanel = new JPanel(new GridBagLayout());
       // GridBagConstraints constraints = new GridBagConstraints();
        //constraints.fill = GridBagConstraints.HORIZONTAL;
        //constraints.insets = new Insets(10, 10, 10, 10);

        String[] userTypes = {"Admin", "Customer"};
        userTypeComboBox = new JComboBox<>(userTypes);
         userTypeComboBox.setBounds(700, 300, 80, 40);
         background.add(  userTypeComboBox );
        userTypeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedType = (String) userTypeComboBox.getSelectedItem();
                if (selectedType.equals("Admin")) {
                    lblUsername.setVisible(true);
                    lblPassword.setVisible(true);
                    txtUsername.setVisible(true);
                    txtPassword.setVisible(true);
                    lblMeterNumber.setVisible(false);
                    txtMeterNumber.setVisible(false);
                } else if (selectedType.equals("Customer")) {
                    lblUsername.setVisible(false);
                    lblPassword.setVisible(true);
                    txtUsername.setVisible(false);
                    txtPassword.setVisible(true);
                    lblMeterNumber.setVisible(true);
                    txtMeterNumber.setVisible(true);
                }
            }
        });

        lblUsername = new JLabel("Username:");
       lblUsername.setBounds(570, 350, 100, 40);
         background.add(   lblUsername);
        lblUsername.setVisible(false);
        lblPassword = new JLabel("Password:");
             lblPassword.setBounds(570, 390, 100, 40);
         background.add(       lblPassword);
        lblPassword.setVisible(false);
        txtUsername = new JTextField();
          txtUsername .setBounds(700, 358, 100, 25);
         background.add(        txtUsername );
        txtUsername.setVisible(false);
        txtPassword = new JPasswordField();
          txtPassword .setBounds(700, 397, 100, 25);
         background.add(          txtPassword);
        txtPassword.setVisible(false);
        lblMeterNumber = new JLabel("Meter Number:");
        lblMeterNumber .setBounds(570, 350, 100, 40);
         background.add(           lblMeterNumber);
        lblMeterNumber.setVisible(false);
        txtMeterNumber = new JTextField();
         txtMeterNumber .setBounds(700, 358, 100, 25);
         background.add(        txtMeterNumber );
        txtMeterNumber.setVisible(false);

        btnLogin = new JButton("Login");
    btnLogin.setBackground(Color.DARK_GRAY); // Change the background color of the button
    btnLogin.setForeground(Color.WHITE); // Change the text color of the button
     btnLogin .setBounds(700, 470, 100, 40);
    background.add(       btnLogin);
        txtMeterNumber.setVisible(false);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedType = (String) userTypeComboBox.getSelectedItem();
                if (selectedType.equals("Admin")) {
                    String username = txtUsername.getText();
                    String password = new String(txtPassword.getPassword());
                    // Validate admin credentials
                    if (username.equals("a") && password.equals("a")) {
                        showAdminDashboard();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid username or password!");
                    }
                } else if (selectedType.equals("Customer")) {
                    String meterNumber = txtMeterNumber.getText();
                    String password = new String(txtPassword.getPassword());
                    // Validate customer credentials
                    if (validateCustomerCredentials(meterNumber, password)) {
                        showCustomerDashboard();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid meter number or password!");
                    }
                }
            }
        });

    
        frame.setVisible(true);
    }

    // Rest of the code...

    private boolean validateCustomerCredentials(String meterNumber, String password) {
        try (Scanner scanner = new Scanner(new File("customers.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] customerData = line.split(",");
                String savedMeterNumber = customerData[1];
                String savedPassword = customerData[3];

                if (savedMeterNumber.equals(meterNumber) && savedPassword.equals(password)) {
                    return true; // Valid customer credentials
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return false; // Invalid customer credentials
    }

    private void showAdminDashboard() {
        
        frame.dispose();

        CompositeCustomer customerGroup = new CompositeCustomer("Customers");

        JFrame adminFrame = new JFrame("Admin Dashboard");
        adminFrame.setSize(1050, 700);
         adminFrame.setLocationRelativeTo(null);
         /*ImageIcon img=new ImageIcon("eee.jpg");
         background=new JLabel("",img,JLabel.CENTER);
          background.setBounds(0, 0, 1050, 700);
           add(background);*/
          /* JLabel lblTitle = new JLabel("My Electrical Billing App", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));*/
            JLabel headingLabel = new JLabel("ELECTRICAL BILLING SYSTEM                                                                Admin Dashboard");
    headingLabel.setFont(new Font("Arial", Font.BOLD, 24));
    headingLabel.setForeground(Color.WHITE);
    headingLabel.setHorizontalAlignment(SwingConstants.CENTER);

    // Create the heading panel and set its properties
    JPanel headingPanel = new JPanel();
    headingPanel.setBackground(Color.BLACK);
    headingPanel.setLayout(new BorderLayout());
    headingPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
    headingPanel.add(headingLabel, BorderLayout.CENTER);

    // Add the heading panel to the frame
    adminFrame.getContentPane().add(headingPanel, BorderLayout.NORTH);
           adminFrame.getContentPane().setBackground(Color.BLACK);
         ImageIcon img = new ImageIcon(getClass().getResource("eee.jpg"));
       background = new JLabel("",img,JLabel.CENTER);
       background.setSize(1050, 700);
       adminFrame.getContentPane().add(background);
        
          
      // adminFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
       //adminFrame.setLayout(new BorderLayout());

        
        
 
      
      
   
        
        JButton btnAddCustomer = new JButton("Add New Customer");
        btnAddCustomer.setBackground(Color.DARK_GRAY); // Change the background color of the button
        btnAddCustomer.setForeground(Color.WHITE);
       // btnAddCustomer.setPreferredSize(new Dimension(00, 100));
         btnAddCustomer. setBounds(20, 80, 160, 80);
           background.add(  btnAddCustomer);
        JButton btnViewCustomer = new JButton("View Customer Detail");
        btnViewCustomer.setBackground(Color.DARK_GRAY); // Change the background color of the button
        btnViewCustomer.setForeground(Color.WHITE); // Change the text color of the button
     
         btnViewCustomer. setBounds(20, 190, 160, 80);
            background.add(   btnViewCustomer);
        JButton btnCalculateBill = new JButton("Calculate Bill");
        btnCalculateBill.setBackground(Color.DARK_GRAY); // Change the background color of the button
        btnCalculateBill.setForeground(Color.WHITE); // Change the text color of the button
                     btnCalculateBill. setBounds(20, 300, 160, 80);
                       background.add(     btnCalculateBill);
        JButton btnLogout = new JButton("Logout");
        btnLogout.setBackground(Color.DARK_GRAY); // Change the background color of the button
        btnLogout.setForeground(Color.WHITE); // Change the text color of the button
           btnLogout. setBounds(20, 410, 160, 80);
                background.add(     btnLogout);

        btnAddCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addCustomerFrame = new JFrame("Add New Customer");
                addCustomerFrame.setSize(300, 200);
                addCustomerFrame.setLayout(new GridLayout(6, 2));
                 addCustomerFrame.setLocationRelativeTo(null);

                JLabel lblName = new JLabel("Name:");
                JTextField txtName = new JTextField();

                JLabel lblMeterNumber = new JLabel("Meter Number:");
                JTextField txtMeterNumber = new JTextField();

                JLabel lblMeterType = new JLabel("Meter Type:");
                JTextField txtMeterType = new JTextField();

                JLabel lblPassword = new JLabel("Password:");
                JPasswordField txtPassword = new JPasswordField();

                JLabel lblAddress = new JLabel("Address:");
                JTextField txtAddress = new JTextField();

                JButton btnSave = new JButton("Save");

                btnSave.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String name = txtName.getText();
                        String meterNumber = txtMeterNumber.getText();
                        String meterType = txtMeterType.getText();
                        String password = new String(txtPassword.getPassword());
                        String address = txtAddress.getText();

                        Customer customer = new IndividualCustomer(name, meterNumber, meterType, password, address);
                        customerGroup.add(customer);
                        customer.saveToFile();

                        addCustomerFrame.dispose();
                        JOptionPane.showMessageDialog(adminFrame, "New customer added successfully!");
                    }
                });

                addCustomerFrame.add(lblName);
                addCustomerFrame.add(txtName);
                addCustomerFrame.add(lblMeterNumber);
                addCustomerFrame.add(txtMeterNumber);
                addCustomerFrame.add(lblMeterType);
                addCustomerFrame.add(txtMeterType);
                addCustomerFrame.add(lblPassword);
                addCustomerFrame.add(txtPassword);
                addCustomerFrame.add(lblAddress);
                addCustomerFrame.add(txtAddress);
                addCustomerFrame.add(btnSave);

                addCustomerFrame.setVisible(true);
            }
        });

        btnViewCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String meterNumber = JOptionPane.showInputDialog(adminFrame, "Enter Meter Number:");
                if (meterNumber != null) {
                    Customer customer = findCustomerByMeterNumber(meterNumber);
                    if (customer != null && !(customer instanceof NullCustomer)) {
                        // Display customer details
                        JOptionPane.showMessageDialog(adminFrame, "Customer Name: " + customer.getName() +
                                "\nAddress: " + customer.getAddress() +
                                "\nMeter Type: " + customer.getMeterType());
                    } else {
                        JOptionPane.showMessageDialog(adminFrame, "Customer does not exist!");
                    }
                }
            }
        });


      
     btnCalculateBill.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String meterNumber = JOptionPane.showInputDialog(adminFrame, "Enter meter number:");
            String monthName = JOptionPane.showInputDialog(adminFrame, "Enter month name:");
            String yearString = JOptionPane.showInputDialog(adminFrame, "Enter year:");
            String unitsConsumedString = JOptionPane.showInputDialog(adminFrame, "Enter units consumed:");

            int year = Integer.parseInt(yearString);
            int unitsConsumed = Integer.parseInt(unitsConsumedString);

            Customer customer = findCustomerByMeterNumber(meterNumber);
            if (customer != null) {
                BillFactory billFactory = new BillFactory();
                Bill bill = billFactory.createBill(customer.getMeterType());
                double billAmount = bill.calculateBill(unitsConsumed);

                saveBillToFile(customer.getName(), meterNumber, monthName, unitsConsumed, billAmount, year);

                JOptionPane.showMessageDialog(adminFrame, "Bill calculated successfully!");
            } else {
                JOptionPane.showMessageDialog(adminFrame, "Customer not available!");
            }
        }
    });

    // ...


        // ...
    

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminFrame.dispose();
                new LoginGUI();
            }
        });

      /*  panel.add(btnAddCustomer);
       panel.add(btnViewCustomer);
       panel.add(btnCalculateBill);
      panel.add(btnLogout);*/

       

       

        adminFrame.setVisible(true);
    }
    private IndividualCustomer getCustomerByMeterNumber(String meterNumber) {
    try (Scanner scanner = new Scanner(new File("customers.txt"))) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] customerData = line.split(",");
            String savedMeterNumber = customerData[1];
            if (savedMeterNumber.equals(meterNumber)) {
                String name = customerData[0];
                String meterType = customerData[2];
                String password = customerData[3];
                String address = customerData[4];
                return new IndividualCustomer(name, meterNumber, meterType, password, address);
            }
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    return null;
}

    

    private void showCustomerDashboard() {
        frame.dispose();

        JFrame customerFrame = new JFrame("Customer Dashboard");
        customerFrame.setSize(1050, 700);
              customerFrame.setLocationRelativeTo(null);
        customerFrame.getContentPane().setBackground(Color.PINK);
      JLabel headingLabel = new JLabel("ELECTRICAL BILLING SYSTEM                                                            Customer Dashboard");
    headingLabel.setFont(new Font("Arial", Font.BOLD, 24));
    headingLabel.setForeground(Color.WHITE);
    headingLabel.setHorizontalAlignment(SwingConstants.CENTER);

    // Create the heading panel and set its properties
    JPanel headingPanel = new JPanel();
    headingPanel.setBackground(Color.BLACK);
    headingPanel.setLayout(new BorderLayout());
    headingPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
    headingPanel.add(headingLabel, BorderLayout.CENTER);

    // Add the heading panel to the frame
    customerFrame.getContentPane().add(headingPanel, BorderLayout.NORTH);
           customerFrame.getContentPane().setBackground(Color.BLACK);
         ImageIcon img = new ImageIcon(getClass().getResource("iii.jpg"));
       background1 = new JLabel("",img,JLabel.CENTER);
       background1.setSize(1050, 700);
         customerFrame.getContentPane().add(background1);
        
          
      // adminFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
       //adminFrame.setLayout(new BorderLayout());

        
        
 
      
      
   
        
        JButton   btnViewDetails = new JButton("View My Details");
         btnViewDetails.setBackground(Color.darkGray); // Change the background color of the button
         btnViewDetails.setForeground(Color.WHITE);
       // btnAddCustomer.setPreferredSize(new Dimension(00, 100));
          btnViewDetails. setBounds(20, 80, 160, 80);
           background1.add(    btnViewDetails);
        JButton    btnGenerateBill = new JButton("Generate Bill");
           btnGenerateBill.setBackground(Color.darkGray); // Change the background color of the button
           btnGenerateBill.setForeground(Color.WHITE); // Change the text color of the button
     
           btnGenerateBill. setBounds(20, 190, 160, 80);
            background1.add(       btnGenerateBill);
        JButton  btnPaymentMethod = new JButton("Payment Methods");
      btnPaymentMethod.setBackground(Color.darkGray); // Change the background color of the button
        btnPaymentMethod.setForeground(Color.WHITE); // Change the text color of the button
                     btnPaymentMethod. setBounds(20, 300, 160, 80);
                       background1.add(      btnPaymentMethod);
        JButton btnLogout = new JButton("Logout");
        btnLogout.setBackground(Color.darkGray); // Change the background color of the button
        btnLogout.setForeground(Color.WHITE); // Change the text color of the button
           btnLogout. setBounds(20, 410, 160, 80);
                background1.add(     btnLogout);

       
        btnViewDetails.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Add logic for viewing customer details
        // Display customer details on a new frame
        IndividualCustomer customer = getCustomerByMeterNumber(txtMeterNumber.getText());
        if (customer != null) {
            customer.displayDetails();
        } else {
            JOptionPane.showMessageDialog(customerFrame, "Customer not found!");
        }
    }
});

       

       btnGenerateBill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BillSearchFrame billSearchFrame = new BillSearchFrame();
        billSearchFrame.setVisible(true);
                 }
                    });

               

        // ...
    

        btnPaymentMethod.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
            // Add logic for selecting payment method
            String[] options = {"By Cash", "Transfer by Application"};
            int paymentOption = JOptionPane.showOptionDialog(
                customerFrame,
                "Dear customer, choose payment option:",
                "Payment Method",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
            );

            if (paymentOption == 1) {
                // Redirect to Easy Paisa website
                try {
                    Desktop.getDesktop().browse(new URI("https://easypaisa.com.pk/"));
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
        }
    });

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerFrame.dispose();
                new LoginGUI();
            }
        });

     

       

        customerFrame.setVisible(true);
    }
    private Customer findCustomerByMeterNumber(String meterNumber) {
        try (Scanner scanner = new Scanner(new File("customers.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] customerData = line.split(",");
                String savedMeterNumber = customerData[1];
                String savedPassword = customerData[3];

                if (savedMeterNumber.equals(meterNumber)) {
                    String name = customerData[0];
                    String meterType = customerData[2];
                    String password = savedPassword;
                    String address = customerData[4];

                    return new IndividualCustomer(name, meterNumber, meterType, password, address);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return new NullCustomer(); // Customer with the given meter number not found
    }
     private Customer findCustomerByMeterNumber1(String meterNumber) {
        try (Scanner scanner = new Scanner(new File("customers.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] customerData = line.split(",");
                String savedMeterNumber = customerData[1];

                if (savedMeterNumber.equals(meterNumber)) {
                    String name = customerData[0];
                    String meterType = customerData[2];
                    String password = customerData[3];
                    String address = customerData[4];

                    if (meterType.equalsIgnoreCase("composite")) {
                        return new CompositeCustomer(name);
                    } else if (meterType.equalsIgnoreCase("individual")) {
                        return new IndividualCustomer(name, meterNumber, meterType, password, address);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null; // Customer not found
    }

 private void saveBillToFile(String customerName, String meterNumber, String monthName, int unitsConsumed, double billAmount, int year) {
    Random random = new Random();
    int billNumber = random.nextInt(1000000); // Generate a random bill number

    try (PrintWriter writer = new PrintWriter(new FileWriter("bills.txt", true))) {
        writer.println(customerName + "," + meterNumber + "," + monthName + "," + year + "," +billNumber + "," +  unitsConsumed+ "," +  billAmount);
    } catch (IOException e) {
        e.printStackTrace();
    }
    
}

 

    // ...
}



