package activities;

import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();
        hs.add("Asha");
        hs.add("Neha");
        hs.add("Lata");
        hs.add("Siya");
        hs.add("Mona");
        hs.add("Ziva");

        System.out.println("Original HashSet: " + hs);
        System.out.println("Size of HashSet: " + hs.size());

        //Remove element
        System.out.println("Remove Lata from HashSet: " + hs.remove("Lata"));
        //Remove element that is not present
        if(hs.remove("Zoya")) {
            System.out.println("Zoya removed from the Set");
        } else {
            System.out.println("Zoya is not present in the Set");
        }
        System.out.println("Is Mona present in the list: " + hs.contains("Mona"));
        System.out.println("Updated HashSet: " + hs);
    }
}