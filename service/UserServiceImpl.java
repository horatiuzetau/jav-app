package service;

import models.User;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class UserServiceImpl implements UserService {

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:52072/mds";
        String user = "root";
        String pass = "root";

        return DriverManager.getConnection(url,user,pass);
    }

    @Override
    public void addUser(User userToAdd) {

        //Pornim conexiunea si creem PreparedStatement
        try(
                Connection con = getConnection();
                PreparedStatement pstm = addUserPS(userToAdd, con)
                ) {
            //Executam prepared statament si ne va returna cate linii au fost afectate
            int i = pstm.executeUpdate();

            //In functie de rezultat afisam ceva
            if(i > 0){
                System.out.println("S-a introdus userul " + userToAdd.getUsername());
            }else if(i == 0){
                System.out.println("Nu s-a introdus userul " + userToAdd.getUsername());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //Statement(sql query) pentru adaugare
    private PreparedStatement addUserPS(User userToAdd, Connection con) throws SQLException {

        //Facem asa pentru a ne feri de SQLInjection
        PreparedStatement pstm = con.prepareStatement("insert into useri(nume, prenume, telefon, oras, username, parola) values (?, ?,?,?,?,?)");

        //Atribuim valori catre ?
        if(pstm != null){
            pstm.setString(1, userToAdd.getNume());
            pstm.setString(2, userToAdd.getPrenume());
            pstm.setString(3, userToAdd.getTelefon());
            pstm.setString(4, userToAdd.getOras());
            pstm.setString(5, userToAdd.getUsername());
            pstm.setString(6, getMd5(userToAdd.getParola()));
        }

        return pstm;
    }

    //Sterge user
    @Override
    public void deleteUser(int id) {

        //Pornim conexiunea si creem PreparedStatement
        try(
                Connection con = getConnection();
                PreparedStatement pstm = deleteUserPS(id, con)
        ) {
            //Executam prepared statament si ne va returna cate linii au fost afectate
            int i = pstm.executeUpdate();

            if(i > 0){
                System.out.println("S-a sters userul cu id " + id);
            }else if(i == 0){
                System.out.println("Nu s-a sters userul cu id " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Statement(sql query) pentru delete
    private PreparedStatement deleteUserPS(int id, Connection con) throws SQLException {

        //Facem asa pentru a ne feri de SQLInjection
        PreparedStatement pstm = con.prepareStatement("delete from useri where id_user = ?");

        //Atribuim valori catre ?
        if(pstm != null){
            pstm.setInt(1, id);
        }

        return pstm;
    }

    //Modifica user
    @Override
    public void updateUser(User userToUpdate) {
        //Pornim conexiunea si creem PreparedStatement
        try(
                Connection con = getConnection();
                PreparedStatement pstm = updateUserPS(userToUpdate, con)
        ) {

            //Executam prepared statament si ne va returna cate linii au fost afectate
            int i = pstm.executeUpdate();

            if(i > 0){
                System.out.println("S-a updatat userul cu id " + userToUpdate.getId_user());
            }else if(i == 0){
                System.out.println("Nu s-a updatat userul cu id " + userToUpdate.getId_user());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Statement pentru update user
    private PreparedStatement updateUserPS(User userToUpdate, Connection con) throws SQLException {

        //Facem asa pentru a ne feri de SQLInjection
        PreparedStatement pstm = con.prepareStatement("update useri set nume = ?, prenume = ?, telefon = ?, oras = ? where id_user = ?");

        //Atribuim valori catre ?
        if(pstm != null){
            pstm.setString(1, userToUpdate.getNume());
            pstm.setString(2, userToUpdate.getPrenume());
            pstm.setString(3, userToUpdate.getTelefon());
            pstm.setString(4, userToUpdate.getOras());
            pstm.setInt(5, userToUpdate.getId_user());
        }

        return pstm;
    }


    //Schimba rolul unui user -> doar rolul si e o functie care ar putea sa fie apelata doar de un admin
    @Override
    public void updateRoleUser(String username, String rolNou) {
        //Pornim conexiunea si creem PreparedStatement
        try(
                Connection con = getConnection();
                PreparedStatement pstm = updateRoleUserPS(username, rolNou, con)
        ) {

            //Executam prepared statament si ne va returna cate linii au fost afectate
            int i = pstm.executeUpdate();

            if(i > 0){
                System.out.println("S-a schimbat rolul pentru userul " + username);
            }else if(i == 0){
                System.out.println("Nu schimbat rolul pentru userul " + username);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private PreparedStatement updateRoleUserPS(String username, String rolNou, Connection con) throws SQLException {

        //Facem asa pentru a ne feri de SQLInjection
        PreparedStatement pstm = con.prepareStatement("update useri set rol = ? where username = ? ");

        //Atribuim valori catre ?
        if(pstm != null){
            pstm.setString(1, rolNou);
            pstm.setString(2, username);
        }

        return pstm;
    }


    //Gaseste user dupa username
    @Override
    public User findByUsername(String username) {

        User userToReturn = null;

        //Pornim conexiunea si creem PreparedStatement
        try(
                Connection con = getConnection();
                PreparedStatement pstm = findByUsernamePS(username, con);
                //Executam query si bagam tot ce primim in acest result set
                ResultSet rs = pstm.executeQuery()
        ) {

            //    public User(int id_user, String nume, String prenume, String username, String telefon, Timestamp data_inscriere, String oras, String rol, String parola) {
            //Daca avem rezultat, il si folosim
            if(rs.next()){
                userToReturn = new User(
                        rs.getInt("id_user"),
                        rs.getString("nume"),
                        rs.getString("prenume"),
                        rs.getString("username"),
                        rs.getString("telefon"),
                        rs.getTimestamp("data_inscriere"),
                        rs.getString("oras"),
                        rs.getString("rol"),
                        rs.getString("parola")
                        );

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userToReturn;
    }
    private PreparedStatement findByUsernamePS(String username, Connection con) throws SQLException {

        //Facem asa pentru a ne feri de SQLInjection
        PreparedStatement pstm = con.prepareStatement("select * from useri u join user_roles r on (u.rol = r.nume) where username = ? ");

        //Atribuim valori catre ?
        if(pstm != null){
            pstm.setString(1, username);
        }

        return pstm;
    }

    //Schimba parola
    @Override
    public void changePassword(String parolaNoua, int id) {
        //Pornim conexiunea si creem PreparedStatement
        try(
                Connection con = getConnection();
                PreparedStatement pstm = changePasswordPS(parolaNoua, id, con)
        ) {

            //Executam prepared statament si ne va returna cate linii au fost afectate
            int i = pstm.executeUpdate();

            if(i > 0){
                System.out.println("S-a schimbat parola la userul cu id " + id);
            }else if(i == 0){
                System.out.println("Nu s-a schimbat parola la userul cu id " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private PreparedStatement changePasswordPS(String parolaNoua, int id, Connection con) throws SQLException {

        //Facem asa pentru a ne feri de SQLInjection
        PreparedStatement pstm = con.prepareStatement("update useri set parola = ? where id_user = ? ");

        //Atribuim valori catre ?
        if(pstm != null){
            pstm.setString(1, getMd5(parolaNoua));
            pstm.setInt(2, id);
        }

        return pstm;
    }

    //Returneaza userul daca informatiile pentru credentiale introduse sunt corecte
    //Face login pe scurt:))
    @Override
    public User loginFunction(String username, String parola) {
        //Cautam userul cu username respectiv si luam toate info din DB in "user"
        User user = findByUsername(username);

        //daca nu l-am gasit adica nu exista, returneaza null
        if(user == null) {
            System.out.println("Nu exista utilizator cu numele acesta!");
            return null;
        }

        //daca exista, compara parola pe care amm introdus-o cu parola aluia
        if(user.getParola().equals(getMd5(parola))) {
            System.out.println("Logged in!");
            return user;
        }else{
            System.out.println("Parola incorecta");
            return null;
        }

        //daca exista, dar parola nu e bine


    }

    //O fac aici pentru ca la creare parola va fi cryptata
    //Hasher
    private static String getMd5(String input){
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
