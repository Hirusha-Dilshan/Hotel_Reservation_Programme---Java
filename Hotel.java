package com.hotelprogram;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


public class Hotel implements Serializable {
    private Room[] rooms;


    public Hotel(int numOfRomms){
        this.rooms = new Room[numOfRomms];
        initialise(numOfRomms);
    }

    private void initialise(int numOfRomms) {
        for (int x = 0; x < numOfRomms; x++ ) this.rooms[x] = new Room();
        System.out.println( "initialise ");
    }

    public boolean isRoomsAvailable(){
        for (int i=0;i<rooms.length;i++){
            if(rooms[i].isEmpty()){
                return true;
            }
        }
        return false;
    }


    public void addCustomerToRoom(){
        if(isRoomsAvailable()){
            Scanner input = new Scanner(System.in);

            System.out.print("Enter First Name : ");
            String firstName = input.next();

            System.out.print("Enter Surname : ");
            String surname = input.next();

            System.out.print("Enter Credit Card Number : ");
            String creditCardNum = input.next();

            System.out.print("Enter number of guests in a room : ");
            int numberOfGuest = input.nextInt();

            Person newCustomer = new Person(firstName,surname,creditCardNum);
            for(int i = 0;i<rooms.length;i++){
                if(rooms[i].isEmpty()){
                    rooms[i].setNumOfGuests(numberOfGuest);
                    rooms[i].setPayingGuest(newCustomer);
                    System.out.println("room " + rooms[i].getRoomNumber() + " assigned to " + firstName);
                    return;
                }
            }
        }
        else {
            System.out.println("Rooms not Available........");
        }

    }

    public void viewAllRooms(){
        for (int i=0;i<rooms.length;i++){
            if(rooms[i].isEmpty()) System.out.println( "room " + rooms[i].getRoomNumber() + " is empty");
            else System.out.println("room " + rooms[i].getRoomNumber() + " occupied by " + rooms[i].getPayingGuest().getFirstName() + " " + rooms[i].getPayingGuest().getSurname());
        }
    }

    public void displayEmptyRooms(){
        for (int i=0;i<rooms.length;i++){
            if(rooms[i].isEmpty()) System.out.println( "room " + rooms[i].getRoomNumber() + " is empty");
        }
    }


    public void deleteCustomerFromRoom(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Room Number(0 - " + (this.rooms.length-1) + ") : ");
        int roomNumber = input.nextInt();
        rooms[roomNumber].setPayingGuest(null);
        rooms[roomNumber].setNumOfGuests(0);
        System.out.println("Delete customer from room " + roomNumber);
    }

    public void findRoomBycustomerName(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Customer First Name : ");
        String firstName = input.next();
        for (int i = 0;i<rooms.length;i++){
            if(!rooms[i].isEmpty()){
                if(firstName.equals(rooms[i].getPayingGuest().getFirstName())){
                    System.out.println("Room " + rooms[i].getRoomNumber());
                    return;
                }
            }
        }
        System.out.println("Can't find.....");
    }


    public void guestsOrderedAlphabetically(){
        ArrayList<String> guests = new ArrayList<>();
        for (Room room:rooms) {
            if(!room.isEmpty()) guests.add(room.getPayingGuest().getFirstName() + " " + room.getPayingGuest().getSurname());
        }
        if(guests.isEmpty()) {
            System.out.print("Guests count 0");
            return;
        }


        /* https://beginnersbook.com/2018/10/java-program-to-sort-strings-in-an-alphabetical-order/ */

        for (int i = 0; i < guests.size(); i++)
        {
            for (int j = i + 1; j < guests.size(); j++) {
                if (guests.get(i).compareTo(guests.get(j))>0)
                {
                    String temp = guests.get(i);
                    guests.set(i,guests.get(j));
                    guests.set(j,temp);
                }
            }
        }

        for (String str: guests) {
            System.out.println(str);
        }


    }
}
