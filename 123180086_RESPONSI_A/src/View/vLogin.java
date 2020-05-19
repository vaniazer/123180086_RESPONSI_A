package View;

import javax.swing.*;
import java.awt.*;

public class vLogin extends JFrame{

    public JTextField tfPeserta = new JTextField();
    public JPasswordField tfPassword = new JPasswordField();
    public JCheckBox showPassword = new JCheckBox();

    JLabel lLogo = new JLabel();
    String path = new String("src/Gambar/cover.png");
    ImageIcon imageIcon = new ImageIcon(path);
    Image image = imageIcon.getImage();
    Image newImage = image.getScaledInstance(400,400,Image.SCALE_SMOOTH);
    ImageIcon logo = new ImageIcon(newImage);
    Font font = new Font("Serif",Font.BOLD, 30);
    Font font1 = new Font("Monospaced", Font.CENTER_BASELINE,12);

    public JButton btnLogin = new JButton("Login");

    public vLogin(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("LOGIN");
        setVisible(true);
        setLayout(null);
        setSize(400,400);
        setResizable(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);

        add(lLogo);
        lLogo.setBounds(0,0,400,400);
        lLogo.setIcon(logo);

        add(tfPeserta);
        tfPeserta.setBounds(175,193,120,28);

        add(tfPassword);
        tfPassword.setBounds(175,230,120,28);
        tfPassword.setEchoChar('*');

        add(showPassword);
        showPassword.setFont(font1);
        showPassword.setBounds(195,265,20,20);
        showPassword.setForeground(Color.BLACK);

        add(btnLogin);
        btnLogin.setBounds(150,300,100,20);
    }
    public String getUsername(){
        return tfPeserta.getText();
    }
    public String getPassword(){
        return String.valueOf(tfPassword.getPassword());
    }


}





