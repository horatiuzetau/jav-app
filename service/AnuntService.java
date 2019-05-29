package service;

import models.Anunt;


public interface AnuntService {

    //Get Anunt
    void updateAnunt(Anunt anuntToUpdate);

    //Adauga un anunt
    void addAnunt(Anunt anuntToAdd);

    //Sterge un anunt dupa id
    void deleteAnunt(int id);

    //Gaseste un anunt dupa titlu
    Anunt findByid_anunt(String username);

    //gaseste anunturi ???????
    List<Anunt> getAnunturi();
 }

