package com.romulo;

import java.util.ArrayList;


public class Cellphone{

    private String myNumber;
    private ArrayList<Contacts> myContacts;

    public Cellphone(String myNumber){
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contacts>();
    }

    public String getMyNumber() {
        return myNumber;
    }

    public ArrayList<Contacts> getMyContacts() {
        return myContacts;
    }

    //    sends contact object that was created outside of this method
    public boolean addContact(Contacts contact){
        if(findContact(contact.getName()) >= 0){
            System.out.println("Contact already on file");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    private int findContact(Contacts contact){
//        returns the position of the contact
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String contactName){
        for(int i = 0; i < this.myContacts.size(); i++){
            Contacts contact = this.myContacts.get(i);
            if(contact.getName().equals(contactName)){
                return i;
            }
        }
        System.out.println("Contact not found");
        return -1;
    }

    public String queryContact(Contacts contact){
        if(findContact(contact) >= 0){
            return contact.getName();
        }
        return null;
    }

    public Contacts queryContact(String name){
        int position = findContact(name);
        if(position >= 0){
            return this.myContacts.get(position);
        }
        return null;
    }

    public boolean updateContact(Contacts oldContact, Contacts newContact){
        int foundPosition = findContact(oldContact);
        if(foundPosition < 0){
            System.out.println(oldContact.getName() + " not found.");
            return false;
        }
        this.myContacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + " was replaced by " + newContact.getName());
        return true;
    }

    public boolean removeContact(Contacts contact){
       int foundContact = findContact(contact);
       if(foundContact < 0){
           System.out.println(contact.getName() + " Contact not found");
           return false;
       }
       this.myContacts.remove(foundContact);
        System.out.println(contact.getName() + " was deleted.");
        return true;
    }

    public void displayAllContacts(){
        System.out.println("Contacts list:");
        for(int i = 0; i < this.myContacts.size();i++){
            System.out.println((i + 1) + "." + this.myContacts.get(i).getName() + " -> " +
                    this.myContacts.get(i).getPhoneNumber());
        }
    }

    public void displaySingleContact(Contacts contact){
        System.out.println("This contact's name is: " + contact.getName());
        System.out.println("This contact's number is " + contact.getPhoneNumber());
    }
}
