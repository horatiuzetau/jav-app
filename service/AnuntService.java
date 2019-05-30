package service;


import models.Anunt;

import java.util.List;

public interface AnuntService {

    //Get Anunt
    void updateAnunt(Anunt anuntToUpdate);

    //Adauga un anunt
    void addAnunt(Anunt anuntToAdd);

    //Sterge un anunt dupa id
    void deleteAnunt(int id);

    //Gaseste un anunt dupa titlu
    Anunt findById(int id);

    //gaseste anunturi ???????
    List<Anunt> getAnunturi();
}

