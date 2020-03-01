package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */

public class PhoneBook {
    private Map<String, List<String>> myMap;
    public PhoneBook(Map<String, List<String>> map) {
        this.myMap = map;
    }

    public PhoneBook() {
        this.myMap = new LinkedHashMap<>();
    }

    public void add(String name, String phoneNumber) {
        if(this.myMap.containsKey(name)){
            this.myMap.get(name).add(phoneNumber);
        }
        else{
            ArrayList<String> list = new ArrayList<>();
            list.add(phoneNumber);
            this.myMap.put(name, list);
        }
    }

    public void addAll(String name, String... phoneNumbers) {
        for(String phoneNumber : phoneNumbers){
            this.add(name, phoneNumber);
        }

    }

    public void remove(String name) {
        if(this.myMap.containsKey(name)){
            this.myMap.remove(name);
        }
    }

    public Boolean hasEntry(String name) {
        boolean isValid = false;
        for(List<String> numbers : this.myMap.values()){
            if(numbers.contains(name)){
                isValid = true;
                break;
            }
        }
        return isValid;


    }

    public List<String> lookup(String name) {
        return this.myMap.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        String user = "";
        for(String name : this.myMap.keySet()) {
            for(String number : this.myMap.get(name)){
                if(number.equals(phoneNumber)){
                    user = name;
                    break;
                }
            }
        }
        return user;
    }

    public List<String> getAllContactNames() {
        ArrayList<String> names = new ArrayList<>();
        for(String name: this.myMap.keySet()){
            names.add(name);
        }
        return names;
    }

    public Map<String, List<String>> getMap() {
        return this.myMap;
    }
}
