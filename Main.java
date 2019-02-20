package com.basics1;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static String print(LinkedList<String> list) { //prints out the contents of a specified LinkedList
        String print = list.get(0);
        for (int i = 1; i < list.size()-1; i++) {
            print += ", " + list.get(i);
        }
        print += " & " + list.peekLast();
        return print;
    }

    public static void menu() {
        System.out.println("Please enter a number: " + //menu for the program
                "\n0. Exit the program." +
                "\n1. Print the current list" +
                "\n2. Add an item to the front of the list" +
                "\n3. Add an item to the end of the list" +
                "\n4. Remove an item from the list");
    }

    public static void main(String[] args) {
        LinkedList<String> rainbow = new LinkedList<>(); // creating LinkedList for rainbow
        rainbow.add("Red");
        rainbow.addLast("Orange");
        rainbow.addLast("Yellow");
        rainbow.addLast("Green");
        rainbow.addLast("Blue");
        rainbow.addLast("Violet");
        System.out.println("The size of the list is " + rainbow.size() + ".");
        System.out.println("The contents of the list consist of: " + print(rainbow) + ".");
        Scanner sc = new Scanner(System.in);
        menu();
        boolean quit = false; // flag for when the program should stop running
        while (!quit) {
            int choice = sc.nextInt();
            switch (choice) {
                case 0: // quits out of the program
                    System.out.println("Thank you, and good-bye.");
                    quit = true;
                    break;
                case 1:
                    System.out.println("Here is your current list: " + print(rainbow) + "."); //choice 1 prints out the contents of the list
                    System.out.println();
                    menu();
                    break;
                case 2:
                    System.out.println("Type below an item to add to the beginning of the rainbow: "); // prompting the desired item to be added
                    sc.nextLine();
                    String newFirstItem = sc.nextLine();
                    rainbow.addFirst(newFirstItem.substring(0,1).toUpperCase() + newFirstItem.substring(1).toLowerCase()); //adds item to the head of the list
                    System.out.println("The item, " + newFirstItem.substring(0,1).toUpperCase() + newFirstItem.substring(1).toLowerCase() +  ", has been successfully added to the beginning of the rainbow.");
                    System.out.println("The updated rainbow contains: " + print(rainbow) + ".");
                    System.out.println();
                    menu();
                    break;
                case 3:
                    System.out.println("Type below an item to add to the end of the rainbow: "); // prompting the desired item to be added
                    sc.nextLine();
                    String newLastItem = sc.nextLine();
                    rainbow.addLast(newLastItem.substring(0,1).toUpperCase() + newLastItem.substring(1).toLowerCase()); //adds item to the head of the list
                    System.out.println("The item, " + newLastItem.substring(0,1).toUpperCase() + newLastItem.substring(1).toLowerCase() + ", has been successfully added to the end of the rainbow.");
                    System.out.println("The updated rainbow contains: " + print(rainbow) + ".");
                    System.out.println();
                    menu();
                    break;

                case 4:
                    System.out.println("Please specify which item you want to remove from the rainbow:"); // removes a specific item from list
                    sc.nextLine();
                    String specItem = sc.nextLine();
                    boolean match = false; // keeps track of whether a match was found
                    for (int i = 0; i < rainbow.size(); i++) {
                        String test = rainbow.get(i);
                        if (specItem.equalsIgnoreCase(test)) {
                            rainbow.remove(i);
                            System.out.println("The item, " + specItem + ", has been successfully removed from the rainbow.");
                            match = true; // marks that a match was found
                            System.out.println("The updated rainbow contains: " + print(rainbow) + ".");
                            break;
                        }
                    }
                    if(!match) { // when no match is found
                        System.out.println("Sorry, the item, " + specItem + ", could not be found." +
                                "\nThe current items in the rainbow are " + print(rainbow));
                    }
                    System.out.println();
                    menu();
                    break;
            }
        }
    }
}
