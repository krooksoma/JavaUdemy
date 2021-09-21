package com.romulo;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Cellphone mobilePhone = new Cellphone("265 532 6632");
    public static void main(String[] args) {
	// write your code here
        boolean quit = false;

        startPhone();
        printActions();
        while(!quit){
            System.out.println("Enter action: ");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action){
                case 0:
                    System.out.println("Shutting down...");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.displayAllContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }

    }

    private static void addNewContact(){
        System.out.println("Enter Contact Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter phone Number");
        String phone = scanner.nextLine();
//        the createContact method on the Contacts class was created as static allowing the method to be used
        // without creating a new instance of a class
        Contacts newContact = Contacts.createContact(name, phone);
        if(mobilePhone.addContact(newContact)){
            System.out.println("New Contact added! ");
        }else{
            System.out.println("Name already on file");
        }
    }

    private static void updateContact(){
        System.out.println("Who would you like to update?");
        String findName = scanner.nextLine();
        Contacts existingRecord = mobilePhone.queryContact(findName);
        if(existingRecord == null){
            System.out.println("Contact not found");
            return;
        }

        System.out.println("Enter new Contact Name: ");
        String newName = scanner.nextLine();
        System.out.println("Mobile Number");
        String newNumber = scanner.nextLine();
        Contacts newContactInfo = Contacts.createContact(newName, newNumber);

        if(mobilePhone.updateContact(existingRecord, newContactInfo)){
            System.out.println("Contact Updated");
        }else{
            System.out.println("Error on Updating record");
        }
    }

    private static void deleteContact(){
        System.out.println("What contact would you like to delete?");
        String contactName = scanner.nextLine();
        Contacts foundContact = mobilePhone.queryContact(contactName);
        if(mobilePhone.removeContact(foundContact)){
            System.out.println("Contact deleted");
        }else{
            System.out.println("Error deleting Contact");
        }
    }

    private static void queryContact(){
        System.out.println("Which contact would u like to find?");
        String findInfo = scanner.nextLine();
        Contacts foundContact = mobilePhone.queryContact(findInfo);
        if(foundContact == null){
            System.out.println("Contact not Found");
            return;
        }else
        mobilePhone.displaySingleContact(foundContact);
    }

    private static void startPhone(){
        System.out.println("Starting Phone...");
    }

    private static void printActions(){
        System.out.println("\t available options: ");
        System.out.println("0 - to shutdown" +
                "1 - print Contacts" +
                "2 - add new Contact" +
                "3 - update existing Contact" +
                "4 - remove Contact" +
                "5 - query for contact" +
                "6 - print list of available actions");
        System.out.println("Choose your action: ");

    }


}
