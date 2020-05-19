package Utama;

import javax.swing.*;
import java.sql.*;

public class Model {
    static final String driver = "com.mysql.cj.jdbc.Driver";
    static final String dbURL = "jdbc:mysql://localhost/dbperpus";
    static final String user = "root";
    static final String pass = "";
    Connection connection;
    Statement statement;

    public Model(){
        try{
            Class.forName(driver);
            connection = (Connection) DriverManager.getConnection(dbURL,user,pass);
            System.out.println("Koneksi Berhasil!!");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Gagal Koneksi Database!", "Hasil",
                    JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null,"Driver Tidak Ditemukan!", "Hasil",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public String[] Login(String username, String password){
        try{
            String datap[] = new String[3];
            String query = "SELECT * FROM `user` WHERE username='"+username+"' AND password='"+password+"'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                datap[0] = String.valueOf(resultSet.getInt("id_user"));
                datap[1] = resultSet.getString("username");
                datap[2] = resultSet.getString("password");
                return datap;
            }
            else{
                JOptionPane.showMessageDialog(null,"Gagal Login! Username/Password salah!",
                        "Hasil", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Gagal Login Model!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public String[] dataUser(int id_user){
        try{
            String datap[] = new String[3];
            String query = "SELECT * FROM `user` WHERE id_user='"+id_user+"'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                datap[0] = String.valueOf(resultSet.getInt("id_user"));
                datap[1] = resultSet.getString("username");
                datap[2] = resultSet.getString("password");
                return datap;
            }
            else{
                JOptionPane.showMessageDialog(null,"Gagal mengambil data user!",
                        "Hasil", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Gagal Login Model!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void insertUser(String Nama, String Password){
        try{
            String query = "INSERT INTO `user` VALUES (NULL,'"+Nama+"','"+Password+"')";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Data User Berhasil Disimpan!", "Hasil",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Data User Gagal Disimpan!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateUser(int id_user,String username, String password){
        try{
            String query = "update `user` set `username` ='"+username+"',`password`='"+password+"' where id_user='"+id_user+"'";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Update Data User Berhasil!", "Hasil",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Update Data User Gagal!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteUser(int id_user){
        try {
            String query = "DELETE from `user` where id_user = '"+id_user+"'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data User Berhasil Dihapus!");
        } catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Data User Gagal Dihapus!");
        }
    }

    public String[][] getData(){
        try{
            int banyakData=0;
            String Data[][] = new String[getBanyakData()][6];
            String query = "select * from `pinjam`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Data[banyakData][0] = String.valueOf(banyakData+1);
                Data[banyakData][1] = String.valueOf(resultSet.getInt("id_pinjam"));
                Data[banyakData][2] = resultSet.getString("id_anggota");
                Data[banyakData][3] = resultSet.getString("nama");
                Data[banyakData][4] = resultSet.getString("id_buku");
                Data[banyakData][5] = resultSet.getString("judul");
                banyakData++;
            }
            return Data;
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Gagal Menampilkan Data Trainee!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public int getBanyakData(){
        int jumlahData=0;
        try{
            String query = "select * from `pinjam`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jumlahData++;
            }
            return jumlahData;
        } catch (SQLException e){
            System.out.println("Banyak Data gagal diambil!!");
            return 0;
        }
    }

    public void insertData(String anggota, String nama, String id_buku, String judul){
        try{
            String query = "INSERT INTO `pinjam` VALUES (NULL,'"+anggota+"','"+nama+"','"+id_buku+"','"+judul+"')";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Data Pinjam Berhasil Disimpan!", "Hasil",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null,"Data Pinjam Gagal Disimpan!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateData(int id_pinjam,String anggota, String nama, String id_buku, String judul){
        try{
            String query = "UPDATE `pinjam` SET `id_pinjam` = '"+id_pinjam+"', `id_anggota`= '"+anggota+"', `nama`= '"+nama+"', `id_buku`= '"+id_buku+"' , `judul`='"+judul+"'  WHERE `id_pinjam` = '"+id_pinjam+"'";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Berhasil diUpdate");
            JOptionPane.showMessageDialog(null, "Data Berhasil diupdate!");
    } catch (SQLException sqlException){
        JOptionPane.showMessageDialog(null,"Data Trainee Gagal Diupdate!",
                "Hasil", JOptionPane.ERROR_MESSAGE);
    }
    }

    public void deleteData(int id_pinjam){
        try {
            String query = "DELETE from `pinjam` where id_pinjam = '"+id_pinjam+"'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Pinjam Berhasil Dihapus!");
        } catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Data Pinjam Gagal Dihapus!");
        }
    }

    public String[][] searchData(String cari){
        try{
            int banyakData=0;
            String Data[][] = new String[getBanyakData()][6];
            String query = "select * from `pinjam` where nama like '%"+cari+"' or nama like '%"+cari+"%' or nama like '"+cari+"%'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Data[banyakData][0] = String.valueOf(banyakData+1);
                Data[banyakData][1] = String.valueOf(resultSet.getInt("id_pinjam"));
                Data[banyakData][2] = resultSet.getString("id_anggota");
                Data[banyakData][3] = resultSet.getString("nama");
                Data[banyakData][4] = resultSet.getString("id_buku");
                Data[banyakData][5] = resultSet.getString("judul");
                banyakData++;
            }
            return Data;
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Gagal Menampilkan Data Pinjam yang dicari!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

}
