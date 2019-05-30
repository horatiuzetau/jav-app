package models;


import java.awt.image.BufferedImage;
import java.sql.Timestamp;

public class Anunt {

    private int id_anunt;
    private int id_user;
    private String titlu;
    private String descriere;
    private float pret_inceput;
    private float pret_actual;
    private Timestamp data_incepere;
    private Timestamp data_final;
    private Boolean activ;
    private int user_high_bid;

    //To do
    private BufferedImage poza;

    public Anunt(int id_anunt, int id_user, String descriere, String titlu, float pret_inceput, float pret_actual, Timestamp data_incepere, Timestamp data_final, Boolean activ, int user_high_bid) {
        this.id_anunt = id_anunt;
        this.id_user = id_user;
        this.titlu = titlu;
        this.descriere = descriere;
        this.pret_inceput = pret_inceput;
        this.pret_actual = pret_actual;
        this.data_incepere = data_incepere;
        this.data_final = data_final;
        this.activ = activ;
        this.user_high_bid = user_high_bid;
    }

    public Anunt(int id_user, String titlu, String descriere, float pret_inceput, Timestamp data_final, BufferedImage poza) {
        this.id_user = id_user;
        this.titlu = titlu;
        this.descriere = descriere;
        this.pret_inceput = pret_inceput;
        this.data_final = data_final;
        this.activ = true;
        this.poza = poza;
    }

    public Anunt(int id_anunt, String titlu, String descriere, Boolean activ) {
        this.id_anunt = id_anunt;
        this.titlu = titlu;
        this.descriere = descriere;
        this.activ = activ;
    }

    //Geteri/ Seteri


    public Boolean getActiv() {
        return activ;
    }

    public void setActiv(Boolean activ) {
        this.activ = activ;
    }

    public int getUser_high_bid() {
        return user_high_bid;
    }

    public void setUser_high_bid(int user_high_bid) {
        this.user_high_bid = user_high_bid;
    }

    public int getId_anunt() {
        return id_anunt;
    }

    public void setId_anunt(int id_anunt) {
        this.id_anunt = id_anunt;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public float getPret_inceput() {
        return pret_inceput;
    }

    public void setPret_inceput(int pret_inceput) {
        this.pret_inceput = pret_inceput;
    }

    public float getPret_actual() {
        return pret_actual;
    }

    public void setPret_actual(int pret_actual) {
        this.pret_actual = pret_actual;
    }

    public Timestamp getData_incepere() {
        return data_incepere;
    }

    public void setData_incepere(Timestamp data_incepere) {
        this.data_incepere = data_incepere;
    }

    public Timestamp getData_final() {
        return data_final;
    }

    public void setData_final(Timestamp data_final) {
        this.data_final = data_final;
    }

    public BufferedImage getPoza() {
        return poza;
    }

    public void setPoza(BufferedImage poza) {
        this.poza = poza;
    }

    @Override
    public String toString() {
        return "Anunt{" +
                "id_anunt=" + id_anunt +
                ", id_user='" + id_anunt + '\'' +
                ", titlu='" + titlu + '\'' +
                ", descriere='" + descriere + '\'' +
                ", pret_inceput='" + pret_inceput + '\'' +
                ", pret_actual='" + pret_actual + '\'' +
                ", data_ncepere='" + data_incepere + '\'' +
                ", data_final='" + data_final + '\'' +
                ", poza=" + poza +                        // tre vzaut cum pun poza aci
                '}';
    }


}
