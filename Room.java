package com.hotelprogram;
import java.io.Serializable;

public class Room  implements Serializable {
    private static int roomCount;
    private int roomNumber;
    private int numOfGuests;
    private Person payingGuest;

    public Room(){
        this.roomNumber = roomCount;
        roomCount+=1;
        this.numOfGuests = 0;
        this.payingGuest = null;
    }

    public boolean isEmpty(){
        return payingGuest==null;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getNumOfGuests() {
        return numOfGuests;
    }

    public Person getPayingGuest() {
        return payingGuest;
    }

    public void setNumOfGuests(int numOfGuests) {
        this.numOfGuests = numOfGuests;
    }

    public void setPayingGuest(Person payingGuest) {
        this.payingGuest = payingGuest;
    }
}
