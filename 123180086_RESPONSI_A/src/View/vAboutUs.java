package View;

import javax.swing.*;
import java.awt.*;

public class vAboutUs extends JFrame{


    JLabel lLogo = new JLabel();
    String path = new String("src/Gambar/ABOUT.png");
    ImageIcon imageIcon = new ImageIcon(path);
    Image image = imageIcon.getImage();
    Image newImage = image.getScaledInstance(290,400,Image.SCALE_SMOOTH);
    ImageIcon logo = new ImageIcon(newImage);
    Font font = new Font("Serif",Font.BOLD, 30);
    Font font1 = new Font("Monospaced", Font.CENTER_BASELINE,12);

    public JButton btnHome = new JButton("Home");

    public vAboutUs(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("ABOUT US");
        setVisible(true);
        setLayout(null);
        setSize(300,400);
        setResizable(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);

        add(lLogo);
        lLogo.setBounds(0,0,300,400);
        lLogo.setIcon(logo);

        add(btnHome);
        btnHome.setBounds(100,290,90,20);

    }


}





