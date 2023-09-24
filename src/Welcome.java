
package  zz10;


import java.awt.Color;
    import java.awt.FlowLayout;
    import java.awt.Font;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import javax.swing.ImageIcon;
    import javax.swing.JButton;
    import javax.swing.JFrame;
    import javax.swing.JLabel;


public class Welcome extends JFrame{
//    TextEditor text;
    JButton start;
    JLabel label;
     JLabel label2;
     JLabel label3;
     JLabel label4;
    JLabel background;
    Welcome(){
        
        this.setTitle("Electrical Billing");
        this.setSize(800,700);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);//TextEditor at centre
        this.getContentPane().setBackground(Color.white);
        
        ImageIcon img = new ImageIcon(getClass().getResource("ase.jpg"));
       background = new JLabel("",img,JLabel.CENTER);
       background.setSize(this.getHeight(), this.getWidth());
       this.add(background);
      
        label = new JLabel("Welcome ");
        
        label.setFont(new Font("Times New Roman",Font.BOLD,42));
        label.setForeground(Color.white);
        label.setBounds(300,50,400 ,400);
        background.add(label);
        label2 = new JLabel(" To");
        
        label2.setFont(new Font("Times New Roman",Font.BOLD,42));
        label2.setForeground(Color.white);
        label2.setBounds(339,50,400 ,500);
        background.add(label2);
        label3 = new JLabel(" Electrical Billing  ");
         label3.setFont(new Font("Times New Roman",Font.BOLD,42));
        label3.setForeground(Color.white);
        label3.setBounds(215,50,400 ,600);
        background.add(label3);
         label4 = new JLabel(" System ");
         label4.setFont(new Font("Times New Roman",Font.BOLD,42));
        label4.setForeground(Color.white);
        label4.setBounds(300,50,400 ,700);
        background.add(label4);

        
       
        this.setVisible(true);
        try {
					Thread.sleep(2500);
				} catch (InterruptedException e) {
					
				}
        this.dispose();
        
        
    
}

  
    
}
