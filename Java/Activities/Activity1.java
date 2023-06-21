package activities;

public class Activity1 {
    public static void main(String[] args) {
        Car Verna = new Car();
        Verna.make = 2014;
        Verna.color = "Black";
        Verna.transmission = "Manual";


        Verna.displayCharacterstics();
        Verna.accelerate();
        Verna.brake();
    }
}
