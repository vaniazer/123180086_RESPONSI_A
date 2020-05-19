package View;

import javax.swing.*;
import java.awt.*;

public class vEdit extends JFrame{

    public JButton btnKembali = new JButton("Kembali");
    public JButton btnSimpan = new JButton("Simpan");

    JLabel lAnggota = new JLabel("ID ANGGOTA");
    JLabel lNama = new JLabel("NAMA");
    JLabel lIdBuku = new JLabel("ID BUKU");
    JLabel lJudul = new JLabel("JUDUL BUKU");


    public JTextField tfAnggota = new JTextField();
    public JTextField tfNama = new JTextField();
    public JTextField tfIdBuku = new JTextField();
    public JTextField tfJudul = new JTextField();

    JLabel lLogo = new JLabel();
    String path = new String("src/Gambar/edit.png");
    ImageIcon imageIcon = new ImageIcon(path);
    Image image = imageIcon.getImage();
    Image newImage = image.getScaledInstance(400,128,Image.SCALE_SMOOTH);
    ImageIcon logo = new ImageIcon(newImage);


    public vEdit(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("EDIT");
        setVisible(true);
        setLayout(null);
        setSize(400, 470);
        getContentPane().setBackground(Color.BLACK);

        add(lLogo);
        lLogo.setBounds(0,0,400,125);
        lLogo.setIcon(logo);

        add(lAnggota);
        lAnggota.setBounds(50, 135, 130, 20);
        lAnggota.setForeground(Color.WHITE);
        add(tfAnggota);
        tfAnggota.setBounds(150, 135, 130, 30);

        add(lNama);
        lNama.setBounds(50, 180, 130, 20);
        lNama.setForeground(Color.WHITE);
        add(tfNama);
        tfNama.setBounds(150, 180, 130, 30);

        add(lIdBuku);
        lIdBuku.setBounds(50, 225, 130, 20);
        lIdBuku.setForeground(Color.WHITE);
        add(tfIdBuku);
        tfIdBuku.setBounds(150, 225, 130, 30);

        add(lJudul);
        lJudul.setBounds(50, 270, 130, 20);
        lJudul.setForeground(Color.WHITE);
        add(tfJudul);
        tfJudul.setBounds(150, 270, 130, 30);

        add(btnSimpan);
        btnSimpan.setBounds(100, 360, 90, 30);

        add(btnKembali);
        btnKembali.setBounds(200, 360, 90, 30);
    }
    public String getAnggota(){
        return tfAnggota.getText();
    }

    public String getNama(){
        return tfNama.getText();
    }

    public String getId(){ return tfIdBuku.getText(); }

    public String getJudul(){
        return tfJudul.getText();
    }



}


