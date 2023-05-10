package activities;
class MyBook extends Book {
    //Define abstract method
    public void setTitle(String s) {
        title = s;
    }
}

public class Activity5 {

    public static void main(String []args) {

        String title = "Harry Potter And The Sorcerer's Stone";
        //Create object for MyBook
        Book storyBook = new MyBook();
        //Set title
        storyBook.setTitle(title);

        //Print result
        System.out.println("The title is: " + storyBook.getTitle());
    }
}