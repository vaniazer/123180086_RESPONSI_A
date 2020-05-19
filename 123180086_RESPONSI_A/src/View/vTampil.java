package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


    public class vTampil extends JFrame {

        public JButton btnEdit = new JButton("Edit");
        public JButton btnHapus= new JButton("Hapus");
        public JButton btnKembali = new JButton("Kembali");
        public JButton btnSearch = new JButton("Cari");
        public JButton btnRefresh = new JButton("Refresh");

        public JTextField tfSearch = new JTextField("Pencarian (Nama)");


        public JTextField tfAnggota = new JTextField();
        public JTextField tfNama = new JTextField();
        public JTextField tfIdBuku = new JTextField();
        public JTextField tfJudul = new JTextField();

        JLabel lLogo = new JLabel();
        String path = new String("src/Gambar/tampil.png");
        ImageIcon imageIcon = new ImageIcon(path);
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(600,128,Image.SCALE_SMOOTH);
        ImageIcon logo = new ImageIcon(newImage);

        public JTable tabel;
        DefaultTableModel tableModel;
        JScrollPane scrollPane;
        public Object namaKolom[] = {"No","ID_Pinjam","ID Anggota","Nama","Id Buku","Judul Buku"};
        public vTampil(){

            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("TAMPIL");
            setVisible(true);
            setLayout(null);
            setSize(600, 470);
            getContentPane().setBackground(Color.BLACK);

            add(lLogo);
            lLogo.setBounds(0,0,600,125);
            lLogo.setIcon(logo);

            add(tfSearch);
            tfSearch.setBounds(240, 105, 120, 20);
            add(btnSearch);
            btnSearch.setBounds(370,105,90,20);
            add(btnRefresh);
            btnRefresh.setBounds(470,105,90,20);

            tableModel = new DefaultTableModel(namaKolom,0);
            tabel = new JTable(tableModel);
            scrollPane = new JScrollPane(tabel);

            add(scrollPane);
            scrollPane.setBounds(20, 135, 540, 200);
            scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

            add(btnEdit);
            btnEdit.setBounds(20, 360, 90, 30);

            add(btnHapus);
            btnHapus.setBounds(120, 360, 90, 30);

            add(btnKembali);
            btnKembali.setBounds(470, 360, 90, 30);
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


