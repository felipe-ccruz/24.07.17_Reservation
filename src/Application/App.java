package Application;

import Entities.Reservation;

public class App {
    public static void main(String[] args) throws Exception {
        Reservation r1 = new Reservation();
        r1.creatReservation();
        System.out.println(r1.toString());
    }
}
