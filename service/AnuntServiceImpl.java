package service;

import models.Anunt;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class AnuntServiceImpl implements AnuntService {

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:52072/mds";
        String user = "root";
        String pass = "root";

        return DriverManager.getConnection(url,user,pass);
    }

    //Adauga anunt
    @Override
    public void addAnunt(Anunt anuntToAdd) {

        //Pornim conexiunea si creem PreparedStatement
        try(
                Connection con = getConnection();
                PreparedStatement pstm = addAnuntPS(anuntToAdd, con)
        ) {
            //Executam prepared statament si ne va returna cate linii au fost afectate
            int i = pstm.executeUpdate();

            //In functie de rezultat afisam ceva
            if(i > 0){
                System.out.println("S-a introdus anuntul " + anuntToAdd.getTitlu());
            }else if(i == 0){
                System.out.println("Nu s-a introdus anuntul " + anuntToAdd.getTitlu());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }