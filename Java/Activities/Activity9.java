package activities;

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("Ajay");
        myList.add("Vijay");
        myList.add("Rama");
        myList.add(3, "Tarun");
        myList.add(1, "Manan");

        System.out.println("Objects in the list:");
        for(String l:myList){
            System.out.println(l);
        }

        System.out.println("3rd element in the list is: " + myList.get(2));
        System.out.println("Is Shreya in list: " + myList.contains("Shreya"));
        System.out.println("Size of ArrayList: " + myList.size());
        myList.remove("Rama");
        System.out.println("New size of ArrayList: " + myList.size());
    }
}
