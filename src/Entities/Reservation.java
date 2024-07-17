package Entities;

import java.time.LocalDate;

public class Reservation {
    private String nome;
    private int numRoom;
    private LocalDate checkIn;
    private LocalDate checkOut;
    public Reservation(String nome, int numRoom, LocalDate checkIn, LocalDate checkOut) {
        this.nome = nome;
        this.numRoom = numRoom;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }


    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
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
