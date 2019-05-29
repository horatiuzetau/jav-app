package models;

import java.sql.Timestamp;

public class User {

    private int id_user;
    private String nume;
    private String prenume;
    private String parola;
    private String username;
    private String telefon;
    private String oras;
    private String rol;
    private Timestamp data_inscriere;


    //constructor cu ID
    public User(int id_user, String nume, String prenume, String username, String telefon, Timestamp data_inscriere, String oras, String rol, String parola) {
        this.id_user = id_user;
        this.nume = nume;
        this.prenume = prenume;
        this.username = username;
        this.telefon = telefon;
        this.data_inscriere = data_inscriere;
        this.oras = oras;
        this.rol = rol;
        this.parola = parola;
    }

    //constructor fara ID
    public User(String nume, String prenume, String username, String telefon, Timestamp data_inscriere, String oras, String rol, String parola) {
        this.nume = nume;
        this.prenume = prenume;
        this.username = username;
        this.telefon = telefon;
        this.data_inscriere = data_inscriere;
        this.oras = oras;
        this.rol = rol;
        this.parola = parola;
    }

    //Geteri/ Seteri

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Timestamp getData_inscriere() {
        return data_inscriere;
    }

    public void setData_inscriere(Timestamp data_inscriere) {
        this.data_inscriere = data_inscriere;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    @Override
    public String toString() {
        return "User{" +
                "id_user=" + id_user +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", parola='" + parola + '\'' +
                ", username='" + username + '\'' +
                ", telefon='" + telefon + '\'' +
                ", oras='" + oras + '\'' +
                ", rol='" + rol + '\'' +
                ", data_inscriere=" + data_inscriere +
                '}';
    }


}
