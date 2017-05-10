package com.yazlab;

import java.sql.*;
import java.util.ArrayList;

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

    public ArrayList<Ev> selectEv() throws Exception {

        ArrayList<Ev> evArrayList = new ArrayList<>();


        String sql = "SELECT * FROM tblEV";

        Connection connection = connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()) {
            Ev ev = new Ev();

            ev.setEvID(resultSet.getInt(1));
            ev.setEvIL(resultSet.getString(2));
            ev.setEvEmlakTipi(resultSet.getString(3));
            ev.setEvAlan(resultSet.getInt(4));
            ev.setEvOdaSayisi(resultSet.getInt(5));
            ev.setEvBinaYasi(resultSet.getInt(6));
            ev.setEvBulKat(resultSet.getInt(7));
            ev.setEvFiyat(resultSet.getDouble(8));
            ev.setEvAciklama(resultSet.getString(9));

            evArrayList.add(ev);
        }


        return evArrayList;
    }

    public void insertEv(Ev ev) throws Exception{

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
