package service;

import models.Anunt;
import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnuntServiceImpl implements AnuntService {

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:52072/mds";
        String user = "root";
        String pass = "root";

        return DriverManager.getConnection(url, user, pass);
    }

    //Adauga anunt
    @Override
    public void addAnunt(Anunt anuntToAdd) {

        //Pornim conexiunea si creem PreparedStatement
        try (
                Connection con = getConnection();
                PreparedStatement pstm = addAnuntPS(anuntToAdd, con)
        ) {
            //Executam prepared statament si ne va returna cate linii au fost afectate
            int i = pstm.executeUpdate();

            //In functie de rezultat afisam ceva
            if (i > 0) {
                System.out.println("S-a introdus anuntul " + anuntToAdd.getTitlu());
            } else if (i == 0) {
                System.out.println("Nu s-a introdus anuntul " + anuntToAdd.getTitlu());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    private PreparedStatement addAnuntPS(Anunt anuntToAdd, Connection con) throws SQLException {

        PreparedStatement pstm = con.prepareStatement("insert into anunturi( id_user, descriere, titlu, pret_inceput,pret_actual, data_sfarsit) values(?,?,?,?,?,?)");

        if(pstm != null){
            pstm.setInt(1, anuntToAdd.getId_user());
            pstm.setString(2, anuntToAdd.getDescriere());
            pstm.setString(3, anuntToAdd.getTitlu());
            pstm.setFloat(4, anuntToAdd.getPret_inceput());
            pstm.setFloat(5, anuntToAdd.getPret_inceput());
            pstm.setTimestamp(6, anuntToAdd.getData_final());
        }

        return pstm;
    }

    @Override
    public void deleteAnunt(int id) {
        //Pornim conexiunea si creem PreparedStatement
        try (
                Connection con = getConnection();
                PreparedStatement pstm = deleteAnuntPS(id, con);
        ) {
            //Executam prepared statament si ne va returna cate linii au fost afectate
            int i = pstm.executeUpdate();

            //In functie de rezultat afisam ceva
            if (i > 0) {
                System.out.println("S-a sters anuntul " + id);
            } else if (i == 0) {
                System.out.println("Nu s-a sters anuntul " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private PreparedStatement deleteAnuntPS(int id, Connection con) throws SQLException {
        //where id in(a,b,c)
        PreparedStatement pstm = con.prepareStatement("delete from anunturi where id_anunt = ?");

        if(pstm != null)
            pstm.setInt(1, id);

        return pstm;
    }

    @Override
    public Anunt findById(int id) {

        Anunt anuntToReturn = null;

        //Pornim conexiunea si creem PreparedStatement
        try(
                Connection con = getConnection();
                PreparedStatement pstm = findByIdPS(id, con);
                //Executam query si bagam tot ce primim in acest result set
                ResultSet rs = pstm.executeQuery()
        ) {

            //Daca avem rezultat, il si folosim
            if(rs.next()){
                anuntToReturn = new Anunt(
                        rs.getInt("id_anunt"),
                        rs.getInt("id_user"),
                        rs.getString("descriere"),
                        rs.getString("titlu"),
                        rs.getFloat("pret_inceput"),
                        rs.getFloat("pret_actual"),
                        rs.getTimestamp("data_incepere"),
                        rs.getTimestamp("data_sfarsit"),
                        rs.getBoolean("activ"),
                        rs.getInt("id_user_top_bid")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return anuntToReturn;
    }
    PreparedStatement findByIdPS(int id, Connection con) throws SQLException {

        PreparedStatement pstm = con.prepareStatement("select * from anunturi where id_anunt = ? ");

        if(pstm != null)
            pstm.setInt(1, id);
        return pstm;
    }

    @Override
    public List<Anunt> getAnunturi() {

        List<Anunt > anunturiToReturn = new ArrayList<>();

        //Pornim conexiunea si creem PreparedStatement
        try(
                Connection con = getConnection();
                PreparedStatement pstm = con.prepareStatement("select * from anunturi");
                //Executam query si bagam tot ce primim in acest result set
                ResultSet rs = pstm.executeQuery()
        ) {

            //Daca avem rezultat, il si folosim
            while(rs.next()){
                anunturiToReturn.add(new Anunt(
                        rs.getInt("id_anunt"),
                        rs.getInt("id_user"),
                        rs.getString("descriere"),
                        rs.getString("titlu"),
                        rs.getFloat("pret_inceput"),
                        rs.getFloat("pret_actual"),
                        rs.getTimestamp("data_incepere"),
                        rs.getTimestamp("data_sfarsit"),
                        rs.getBoolean("activ"),
                        rs.getInt("id_user_top_bid")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return anunturiToReturn;
    }

    @Override
    public void updateAnunt(Anunt anuntToUpdate) {

        try(
                Connection con = getConnection();
                PreparedStatement pstm = updateAnuntPS(anuntToUpdate, con)
        ){

            int i = pstm.executeUpdate();

            if(i > 0){
                System.out.println("S-a realizat update pentru anuntul " + anuntToUpdate.getId_anunt());
            }else{
                System.out.println("Nu s-a realizat update pentru anuntul " + anuntToUpdate.getId_anunt());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private PreparedStatement updateAnuntPS(Anunt anunt, Connection con) throws SQLException {
        PreparedStatement pstm = con.prepareStatement("update anunturi set descriere = ?, titlu = ?, activ = ? where id_anunt = ?");

        if(pstm != null){
            pstm.setString(1, anunt.getDescriere());
            pstm.setString(2, anunt.getTitlu());
            pstm.setBoolean(3, anunt.getActiv());
            pstm.setInt(4, anunt.getId_anunt());
        }

        return pstm;
    }

    public void pariaza(Anunt anunt, User user, float suma){

        try(
                Connection con = getConnection();
                PreparedStatement pstm = pariazaPS(anunt, user, suma, con);
        ){

            int i = pstm.executeUpdate();
            if( i > 0 ){
                System.out.println("S-a pariat " + suma + " in anuntul  " + anunt.getId_anunt() + " de catre " + user.getId_user());
            }else{
                System.out.println("Nu s-a pariat  " +  suma);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    PreparedStatement pariazaPS(Anunt anunt, User user,float suma, Connection con) throws SQLException {
        PreparedStatement pstm = con.prepareStatement("update anunturi set id_user_top_bid = ?, pret_actual = ? where id_anunt = ?");

        if(pstm != null){
            pstm.setInt(1, user.getId_user());
            pstm.setFloat(2, suma);
            pstm.setInt(3, anunt.getId_anunt());
        }

        return pstm;
    }
}