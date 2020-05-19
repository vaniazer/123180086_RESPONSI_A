package Controller;

import Utama.*;
import View.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cHome {
    vHome vHome;
    Model model;
    int User;

    public cHome(vHome vHome, Model model, int id_user) {
        this.vHome = vHome;
        this.model = model;
        this.User = id_user;

        vHome.btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    vHome.dispose();
                    MVC mvc = new MVC();
                } catch (Exception e1) {
                    System.out.println("Gagal button Logout!!");
                }
            }
        });

        vHome.btnPinjam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    vPinjam vPinjam = new vPinjam();
                    cPinjam cPinjam = new cPinjam(vPinjam,model);
                } catch (Exception e1){
                    System.out.println("Gagal button input data Admin!");
                }
            }
        });

        vHome.btnTampil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    vTampil vTampil= new vTampil();
                    cTampil cTampil= new cTampil(vTampil,model);
                } catch (Exception e1){
                    System.out.println("Gagal button input data Admin!");
                }
            }
        });
        vHome.btnAboutUs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    vAboutUs vAboutUs = new vAboutUs();
                    vAboutUs.btnHome.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            vAboutUs.dispose();
                        }
                    });
                } catch (Exception e1){
                    System.out.println("Gagal button input data Admin!");
                }
            }
        });


    }
}
