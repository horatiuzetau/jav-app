import models.Anunt;
import models.User;
import service.AnuntServiceImpl;
import service.UserServiceImpl;

import java.sql.Timestamp;
import java.time.LocalDateTime;


public class Main {

    public static void main(String[] args) {
        UserServiceImpl service = new UserServiceImpl();
        //    public User(int id_user, String nume, String prenume, String username, String telefon, Timestamp data_inscriere, String oras, String rol, String parola) {
        User user = new User(6, "Dorel", "Miquel", "miruna", "0766442312",new Timestamp(System.currentTimeMillis()), "Focsani", "USER", "mihaitza");
//        User user2 = new User(4, "Dorna", "Borsek", "dornaborsek", "0762131212",new Timestamp(System.currentTimeMillis()), "Focsani", "ADMIN", "parola");
//        service.addUser(user);
//        service.deleteUser(2);
//        service.updateUser(user2);
//        service.changePassword("parola", 7);
//            User loggedInUser = service.loginFunction("dorelmiguel", "parola");
//        System.out.println(loggedInUser.toString());
//        System.out.println(service.findByUsername("dornaborsek").toString());

//        Anunt anunt = new Anunt(4, "NonTitlu", "Desc", 34.5f, Timestamp.valueOf(LocalDateTime.now()), null );
        Anunt anuntToUpdate = new Anunt(4, "Mihaitza", "Boss", false);
//    public Anunt(int id_anunt, int id_user, String descriere, String titlu, float pret_inceput, float pret_actual, Timestamp data_incepere, Timestamp data_final, Boolean activ, int user_high_bid) {
        AnuntServiceImpl anuntService = new AnuntServiceImpl();

//        anuntService.addAnunt(anunt);
//        anuntService.deleteAnunt(3);
//        anuntService.updateAnunt(anuntToUpdate);
        anuntService.pariaza(anuntToUpdate, user,47.5f);
        System.out.println(anuntService.getAnunturi());



    }
}
