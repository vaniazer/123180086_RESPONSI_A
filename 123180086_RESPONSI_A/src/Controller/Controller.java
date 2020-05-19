package Controller;

import Utama.*;
import View.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    vLogin vlogin;
    Model model;

    public Controller(vLogin vlogin,Model model){
        this.vlogin = vlogin;
        this.model = model;

        vlogin.btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(vlogin.getUsername().equals("") || vlogin.getPassword().equals("")){
                        JOptionPane.showMessageDialog(null, "Data masih ada yang kosong");
                    }
                    else{
                        String username = vlogin.getUsername();
                        String password = vlogin.getPassword();
                        String user[] = model.Login(username,password);
                        int id_user = Integer.parseInt(user[0]);
                        if(user[1].equals(username) && user[2].equals(password)){
                                vlogin.dispose();
                                vHome vHome = new vHome();
                                cHome cHome = new cHome(vHome,model,id_user);
                        }
                    }
                } catch (Exception e1){
                    vlogin.tfPassword.setText("");
                    System.out.println("Gagal button login");
                }
            }
        });

        vlogin.showPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(vlogin.showPassword.isSelected()){
                    vlogin.tfPassword.setEchoChar((char)0);
                }
                else{
                    vlogin.tfPassword.setEchoChar('*');
                }
            }
        });

    }
}
