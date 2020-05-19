package Controller;

import Utama.Model;
import View.*;

import javax.swing.*;
import java.awt.event.*;

public class cPinjam {
    vPinjam vPinjam;
    Model model;
    int baris;
    String dataEdit;

    public cPinjam(vPinjam vPinjam, Model model) {
        this.vPinjam = vPinjam;
        this.model = model;

        if (model.getBanyakData() != 0) {

        } else {
            JOptionPane.showMessageDialog(null, "Data Pinjam Tidak Ada");
        }


        vPinjam.btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    vPinjam.dispose();
                } catch (Exception e1) {
                    System.out.println("Gagal button kembali Pinjam Data");
                }
            }
        });

        vPinjam.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (vPinjam.getAnggota().equals("") || vPinjam.getNama().equals("") ||
                            vPinjam.getId().equals("") || vPinjam.getJudul().equals("")) {
                        JOptionPane.showMessageDialog(null, "Data masih ada yang kosong");
                    } else {
                        String anggota = vPinjam.getAnggota();
                        String nama = vPinjam.getNama();
                        String id_buku = vPinjam.getId();
                        String judul = vPinjam.getJudul();
                        model.insertData(anggota, nama, id_buku, judul);
                        vPinjam.tfAnggota.setText("");
                        vPinjam.tfNama.setText("");
                        vPinjam.tfIdBuku.setText("");
                        vPinjam.tfJudul.setText("");

                        vPinjam.dispose();
                    }
                } catch (Exception e1) {
                    System.out.println("Gagal button simpan Pinjam Data!");
                }
            }
        });
    }
}
