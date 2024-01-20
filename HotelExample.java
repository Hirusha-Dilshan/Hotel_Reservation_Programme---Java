package com.hotelprogram;
import java.io.*;
import java.util.*;

public class HotelExample {
    private static final int NUMBER_OF_ROOMS = 8;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Hotel hotel = new Hotel(NUMBER_OF_ROOMS);

        System.out.println("A: Adds customer to room");
        System.out.println("V: Views All rooms");
        System.out.println("E: Display Empty Rooms");
        System.out.println("D: Delete customer from room");
        System.out.println("F: Find room from customer name");
        System.out.println("S: Store program data into file");
        System.out.println("L: Load program data from file");
        System.out.println("O: View guests Ordered alphabetically by name");
        System.out.println("-1 for quit the program");


        while (true){
            System.out.print("\nEnter : ");
            String command = input.next();
            if(command.equals("-1")) break;
            switch (command){
                case "A":
                    hotel.addCustomerToRoom();
                    break;
                case "V":
                    hotel.viewAllRooms();
                    break;
                case  "E":
                    hotel.displayEmptyRooms();
                    break;
                case "D":
                    hotel.deleteCustomerFromRoom();
                    break;
                case "F":
                    hotel.findRoomBycustomerName();
                    break;
                case "S":
                    storeProgramData(hotel);
                    break;
                case "L":
                    Hotel h = loadProgramData();
                    if(h!=null) hotel = h;
                    break;
                case "O":
                    hotel.guestsOrderedAlphabetically();
                    break;
                default:
                    System.out.println("Unknown command");
                    break;
            }
        }
    }

    public static void storeProgramData(Hotel hotel){
        /* https://www.tutorialspoint.com/java/java_serialization.htm */
        try {
            FileOutputStream fileOut = new FileOutputStream("D:\\hotelData.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(hotel);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in D:/hotelData.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static Hotel loadProgramData(){
        /* https://www.tutorialspoint.com/java/java_serialization.htm */

        Hotel hotel = new Hotel(NUMBER_OF_ROOMS);
        try {
            FileInputStream fileIn = new FileInputStream("D:\\hotelData.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            hotel = (Hotel) in.readObject();
            in.close();
            fileIn.close();
            return hotel;
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Hotel class not found");
            c.printStackTrace();
            return null;
        }
    }
}