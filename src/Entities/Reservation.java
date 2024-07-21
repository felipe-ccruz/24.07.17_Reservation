package Entities;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import Exeptions.DomainException;

public class Reservation {
    private String name;
    private int numRoom;
    private LocalDate checkIn;
    private LocalDate checkOut;
    public Reservation() {
    }
    public Reservation(String name, int numRoom, LocalDate checkIn, LocalDate checkOut) {
        this.name = name;
        this.numRoom = numRoom;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public void creatReservation() {
        try {
            Scanner sc = new Scanner(System.in);
        
            System.out.print("\nName: ");
            String name = sc.nextLine();
            setName(name);

            System.out.print("\nRoom Number: ");
            int numRoom = sc.nextInt();
            sc.nextLine();
            setNumRoom(numRoom);

            System.err.println("\n**CHECK-IN**");
            System.out.print("\nYear: ");
            int checkInYear = sc.nextInt();
            sc.nextLine();

            System.out.print("\nMonth: ");
            int checkInMonth = sc.nextInt();
            sc.nextLine();

            System.out.print("\nDay: ");
            int checkInDay = sc.nextInt();
            sc.nextLine();

            LocalDate checkIn = LocalDate.of(checkInYear, checkInMonth, checkInDay);
            setCheckIn(checkIn);

            System.err.println("\n**CHECK-OUT**");
            System.out.print("\nYear: ");
            int checkOutYear = sc.nextInt();
            sc.nextLine();

            System.out.print("\nMonth: ");
            int checkOutMonth = sc.nextInt();
            sc.nextLine();

            System.out.print("\nDay: ");
            int checkOutDay = sc.nextInt();
            sc.nextLine();

            LocalDate checkOut = LocalDate.of(checkOutYear, checkOutMonth, checkOutDay);
            setCheckOut(checkOut);

            verifyChecks(checkIn, checkOut);

            System.out.println("\n---Reserva validada!---\n");

        sc.close();
        } catch (DomainException e) {
            System.out.println("Validation Error: " + e.getMessage());
            creatReservation();
        } catch (DateTimeException e){
            System.out.println("Date Error: " + e.getMessage());
            creatReservation();
        } catch (Exception e) {
            System.out.println("Unspected error!\n Try creat your reservation again");
            creatReservation();
        }
    }

    DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public String toString() {
        return "Reservation \n  Name: " + name + "\n  Room Number: " + numRoom + "\n  Check-in: " + checkIn.format(fmt1) + "\n  Check-out: " + checkOut.format(fmt1);
    }

    //EXCEPTIONS
    public void verifyChecks(LocalDate checkIn, LocalDate checkOut) throws DomainException{
        if(checkIn.isAfter(checkOut)){
            throw new DomainException("You can't create a reservation with check-in after check-out");
        } 
        else if(checkIn.isBefore(LocalDate.now()) || checkOut.isBefore(LocalDate.now())){
            throw new DomainException("Put future dates");
        }
    }

    //GETTER & SETTER
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getNumRoom() {
        return numRoom;
    }
    public void setNumRoom(int numRoom) {
        this.numRoom = numRoom;
    }
    public LocalDate getCheckIn() {
        return checkIn;
    }
    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }
    public LocalDate getCheckOut() {
        return checkOut;
    }
    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    
}
