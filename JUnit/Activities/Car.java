package activities;

public class Car {
    //Class Member Variables
    String color;
    int make;
    String transmission;
    int tyres;
    int doors;

    //Constructor
    Car() {
        tyres = 4;
        doors = 4;
    }

    //Class Methods
    public void displayCharacterstics(){
        System.out.println(color);
        System.out.println(make);
        System.out.println(transmission);
        System.out.println(doors);
        System.out.println(tyres);
    }

    public void accelerate() {
        System.out.println("Car is moving forward.");
    }

    public void brake() {
        System.out.println("Car has stopped.");
    }
}
