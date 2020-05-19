package View;

import javax.swing.*;
import java.awt.*;

    public class vHome extends JFrame {

        JLabel lLogo = new JLabel();
        String path = new String("src/Gambar/home.png");
        ImageIcon imageIcon = new ImageIcon(path);
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(700,400,Image.SCALE_SMOOTH);
        ImageIcon logo = new ImageIcon(newImage);
        Font font = new Font("Serif",Font.BOLD, 20);
        Font font1 = new Font("Monospaced", Font.CENTER_BASELINE,12);

        public JButton btnLogout = new JButton("Logout");
        public JButton btnPinjam = new JButton("PINJAM");
        public JButton btnTampil = new JButton("TAMPIL");
        public JButton btnAboutUs = new JButton("ABOUT US");

        public vHome(){
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("PERPUSTAKAAN");
            setVisible(true);
            setLayout(null);
            setSize(700,420);
            setResizable(true);
            setLocationRelativeTo(null);
            getContentPane().setBackground(Color.BLACK);


            add(lLogo);
            lLogo.setBounds(0,0,700,400);
            lLogo.setIcon(logo);

            add(btnLogout);
            btnLogout.setBounds(560,10,100,20);

            add(btnPinjam);
            btnPinjam.setBounds(130,110,140,40);
            btnPinjam.setFont(font);

            add(btnTampil);
            btnTampil.setBounds(130,180,140,40);
            btnTampil.setFont(font);

            add(btnAboutUs);
            btnAboutUs.setBounds(130,250,140,40);
            btnAboutUs.setFont(font);
        }


    }






