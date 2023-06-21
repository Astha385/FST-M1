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
        Book storyBook = new MyBook();
        storyBook.setTitle(title);
        System.out.println("The title is: " + storyBook.getTitle());
    }
}