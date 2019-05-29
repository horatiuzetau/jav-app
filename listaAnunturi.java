package com.example.myapplication;
import java.util.Arrays;
public class listaAnunturi {

    Anunt[] listaAnunturi=new Anunt[0];
        public listaAnunturi(){};

        public int[]getImaginiLista(){
            int []aux=new int[listaAnunturi.length];
            for(int i=0;i<listaAnunturi.length;i++)
            {
                aux[i]=listaAnunturi[i].getImagineLista();
            }
            return aux;
        }

        public String[]getTxtLista(){
            String []aux=new String[listaAnunturi.length];
            for(int i=0;i<listaAnunturi.length;i++)
            {
                aux[i]=(listaAnunturi[i].getDescriere());
                //aux[i].substring(0,50);
            }
            return aux;
        }

        public Anunt[] getListaAnunturi() {
            return listaAnunturi;
        }
        public Anunt getAnunt(int i){
            return listaAnunturi[i];
        }

        public void adaugareAnunt(Anunt newAnunt){

            this.listaAnunturi=addAnunt(newAnunt);

        }
        private Anunt[] addAnunt(Anunt newAnunt) {

            Anunt[] aux = Arrays.copyOf(this.listaAnunturi, this.listaAnunturi.length + 1);
            aux[aux.length - 1] = newAnunt;
            return aux;
        }
}
