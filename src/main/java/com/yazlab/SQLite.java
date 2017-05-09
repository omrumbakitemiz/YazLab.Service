package com.yazlab;

import java.sql.*;

public class SQLite {

    public void createNewDatabase(){
        String url = "jdbc:sqlite:ev.db";

        try(Connection connection = DriverManager.getConnection(url)){
            if(connection != null){
                DatabaseMetaData meta = connection.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public Connection connect(){

        String url = "jdbc:sqlite:ev.db";

        Connection connection = null;

        try{
            connection = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return  connection;
    }

    public void selectAll() throws Exception {

        String sql = "SELECT * FROM tblEV";

        Connection connection = connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()) {
            System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
            System.out.println(resultSet.getInt(4));
            System.out.println(resultSet.getInt(5));
            System.out.println(resultSet.getInt(6));
            System.out.println(resultSet.getInt(7));
            System.out.println(resultSet.getDouble(8));
            System.out.println(resultSet.getString(9));
        }
    }

    public void insert(int column, String data) throws Exception{

        String sql = "INSERT INTO tblEV(evID, evIL, evEmlak, evAlan, evOdaSayisi, evBinaYasi, evBulKat, evFiyat, evAciklama) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection connection = connect();

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1,2);
        preparedStatement.setString(2,"İstanbul");
        preparedStatement.setString(3, "Kiralık");
        preparedStatement.setInt(4,120);
        preparedStatement.setInt(5,4);
        preparedStatement.setInt(6,5);
        preparedStatement.setInt(7,3);
        preparedStatement.setDouble(8, 150000);
        preparedStatement.setString(9, "Kiralık için uygun");

        preparedStatement.executeUpdate();
    }

    public void insertEv(Ev ev) throws Exception{
        //TODO: Ev ve Resim sınıfı türlerinden iki parametre alınacak ve db'ye kaydedilecek.

        String evSql = "INSERT INTO tblEV(evID, evIL, evEmlak, evAlan, evOdaSayisi, evBinaYasi, evBulKat, evFiyat, evAciklama) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection connection = connect();

        PreparedStatement preparedStatement = connection.prepareStatement(evSql);

        preparedStatement.setInt(1, ev.getEvID());
        preparedStatement.setString(2, ev.getEvIL());
        preparedStatement.setString(3, ev.getEvEmlakTipi());
        preparedStatement.setInt(4, ev.getEvAlan());
        preparedStatement.setInt(5, ev.getEvOdaSayisi());
        preparedStatement.setInt(6, ev.getEvBinaYasi());
        preparedStatement.setInt(7, ev.getEvBulKat());
        preparedStatement.setDouble(8, ev.getEvFiyat());
        preparedStatement.setString(9, ev.getEvAciklama());

        preparedStatement.executeUpdate();
    }

    public void insertResim(Resim resim) throws Exception{

        String resimSql = "INSERT INTO tblRESIM(resimID, resimYol, resimEvID) VALUES(?, ?, ?)";

        Connection connection = connect();

        PreparedStatement preparedStatement1 = connection.prepareStatement(resimSql);

        preparedStatement1.setInt(1, resim.getResimID());
        preparedStatement1.setString(2, resim.getResimYol());
        preparedStatement1.setInt(3, resim.getResimEvID());

        preparedStatement1.executeUpdate();
    }
}
