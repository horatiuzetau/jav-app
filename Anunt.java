package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class Anunt implements Parcelable {
  private  int []imagesUrl;
  private  int pretInceput;
  private  int pretCurent;
  private String descriere;


    public Anunt(int[] imagesUrl, int pretInceput, String descriere) {
        this.imagesUrl = imagesUrl;
        this.pretInceput = pretInceput;
        this.pretCurent = pretInceput;
        this.descriere = descriere;
    }


    protected Anunt(Parcel in) {
        imagesUrl = in.createIntArray();
        pretInceput = in.readInt();
        pretCurent = in.readInt();
        descriere = in.readString();
    }

    public static final Creator<Anunt> CREATOR = new Creator<Anunt>() {
        @Override
        public Anunt createFromParcel(Parcel in) {
            return new Anunt(in);
        }

        @Override
        public Anunt[] newArray(int size) {
            return new Anunt[size];
        }
    };

    public int getPretInceput() {
        return pretInceput;
    }

    public void setPretInceput(int pretInceput) {
        this.pretInceput = pretInceput;
    }

    public int[] getImagesUrl() {
        return imagesUrl;
    }

    public int getImagineLista(){
        return imagesUrl[0];
    }

    public void setImagesUrl(int[] imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    public int getPretCurent() {
        return pretCurent;
    }

    public void setPretCurent(int pretCurent) {
        this.pretCurent = pretCurent;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeIntArray(imagesUrl);
        dest.writeInt(pretInceput);
        dest.writeInt(pretCurent);
        dest.writeString(descriere);
    }
}
