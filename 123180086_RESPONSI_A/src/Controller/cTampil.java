package Controller;

import Utama.MVC;
import Utama.Model;
import View.vEdit;
import View.vPinjam;
import View.vTampil;

import javax.swing.*;
import java.awt.event.*;

public class cTampil {
    vTampil vTampil;
    Model model;
    int baris;
    String dataEdit;

    public cTampil(vTampil vTampil, Model model) {
        this.vTampil = vTampil;
        this.model = model;

        if (model.getBanyakData() != 0) {
            String data[][] = model.getData();
            vTampil.tabel.setModel((new JTable(data,vTampil.namaKolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Pinjam Tidak Ada");
        }

            vTampil.btnKembali.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try{
                        vTampil.dispose();
                    } catch (Exception e1){
                        System.out.println("Gagal button kembali Tampil Data");
                    }
                }
            });



            vTampil.tabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    baris = vTampil.tabel.getSelectedRow();
                    dataEdit = vTampil.tabel.getValueAt(baris,1).toString();
                    vTampil.btnHapus.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                if(dataEdit!=null){
                                    int id_pinjam = Integer.parseInt(vTampil.tabel.getValueAt(baris,1).toString());
                                    model.deleteData(id_pinjam);

                                    String data[][] = model.getData();
                                    vTampil.tabel.setModel((new JTable(data,vTampil.namaKolom)).getModel());

                                }
                            } catch (Exception e1){
                                System.out.println("Gagal button Hapus Input Data");
                            }
                        }
                    });

                    vTampil.tfSearch.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            vTampil.tfSearch.setText("");
                        }
                    });

                    vTampil.btnSearch.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                String cari = vTampil.tfSearch.getText();
                                String pencarian[][] = model.searchData(cari);
                                vTampil.tabel.setModel((new JTable(pencarian,vTampil.namaKolom)).getModel());
                            } catch (Exception e1){
                                System.out.println("Gagal button pencarian Data!");
                            }
                        }
                    });

                    vTampil.btnRefresh.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                String data[][] = model.getData();
                                vTampil.tabel.setModel((new JTable(data,vTampil.namaKolom)).getModel());
                            } catch (Exception e1){
                                System.out.println("Gagal button refresh data!");
                            }
                        }
                    });

                    vTampil.btnEdit.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {

                                if (dataEdit != null) {
                                    int id_pinjam = Integer.parseInt(vTampil.tabel.getValueAt(baris, 1).toString());
                                    String anggotaA = vTampil.tabel.getValueAt(baris, 2).toString();
                                    String namaA = vTampil.tabel.getValueAt(baris, 3).toString();
                                    String id_bukuA = vTampil.tabel.getValueAt(baris, 4).toString();
                                    String judulA = vTampil.tabel.getValueAt(baris, 5).toString();

                                    vEdit vEdit = new vEdit();
                                    vTampil.dispose();
                                    vEdit.tfAnggota.setText(anggotaA);
                                    vEdit.tfNama.setText(namaA);
                                    vEdit.tfIdBuku.setText(id_bukuA);
                                    vEdit.tfJudul.setText(judulA);


                                    vEdit.btnSimpan.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            try{
                                                if(vEdit.getAnggota().equals("")|| vEdit.getNama().equals("") ||
                                                        vEdit.getId().equals("") || vEdit.getJudul().equals("") ){
                                                    JOptionPane.showMessageDialog(null, "Data masih ada yang kosong");
                                                }
                                                else{
                                                    String anggotaE = vEdit.getAnggota();
                                                    String namaE = vEdit.getNama();
                                                    String id_bukuE = vEdit.getId();
                                                    String judulE = vEdit.getJudul();
                                                    model.updateData(id_pinjam,anggotaE,namaE,id_bukuE,judulE);

                                                    vEdit.dispose();
                                                    vTampil vTampil1 = new vTampil();
                                                    cTampil cTampil = new cTampil(vTampil1,model);
                                                }
                                            } catch (Exception e1){
                                                System.out.println("Gagal button simpan");
                                            }
                                        }

                                    });
                                    vEdit.btnKembali.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            try{
                                                vEdit.dispose();
                                            } catch (Exception e1){
                                                System.out.println("Gagal button kembali edit data!");
                                            }
                                        }
                                    });

                                }
                            }catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, "Data Gagal Diubah!",
                                        "Hasil", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    });

                }
            });

        }

    }


