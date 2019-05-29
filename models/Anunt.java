package models;

import java.sql.Timestamp;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Anunt {

    private int id_anunt;
    private int id_user;
    private String titlu;
    private String descriere;
    private int pret_inceput;
    private int pret_actual;
    private Timestamp data_incepere;
    private Timestamp data_final;
    private BufferedImage poza;


    //constructor cu ID
    public Anunt(int id_anunt, int id_user, String titlu, String descriere, int pret_inceput, int pret_actual, Timestamp data_incepere, Timestamp data_final, BufferedImage poza) {
        this.id_anunt = id_anunt;
        this.id_user = id_user;
        this.titlu = titlu;
        this.descriere = descriere;
        this. pret_inceput =  pret_inceput;
        this.pret_actual = pret_actual;
        this.data_incepere = data_incepere;
        this.data_final = data_final;
        this.poza = poza;
    }

    //constructor fara ID
    public Anunt(int id_user, String titlu, String descriere, int pret_inceput, int pret_actual, Timestamp data_incepere, Timestamp data_final, BufferedImage poza) {
        this.id_user = id_user;
        this.titlu = titlu;
        this.descriere = descriere;
        this. pret_inceput =  pret_inceput;
        this.pret_actual = pret_actual;
        this.data_incepere = data_incepere;
        this.data_final = data_final;
        this.poza = poza;
    }

    //Geteri/ Seteri

    public int getId_anunt() {
        return id_anunt;
    }

    public void setId_anunt(int id_aunt) {
        this.id_anunt = id_anunt;
    }

    public int getId_anunt() {
        return id_anunt;
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
        this.descriere =    descriere;
    }

    public int getPret_inceput() {
        return pret_inceput;
    }

    public void setPret_inceput(int pret_inceput) {
        this.pret_inceput = pret_inceput   ;
    }

    public int getPret_actual() {
        return pret_actual;
    }

    public void setPret_actual(int pret_actual) {
        this.pret_actual= pret_actual;
    }

    public Timestamp getData_inscriere() {
        return data_inscriere;
    }

    public void setData_inscriere(Timestamp data_inscriere) {
        this.data_inscriere = data_inscriere;
    }


    public Timestamp getData_final() {
        return data_final;
    }

    public void setData_final(Timestamp data_final) {
        this.data_final = data_final;
    }
}

    public BufferedImage poza() {
        return poza();
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
