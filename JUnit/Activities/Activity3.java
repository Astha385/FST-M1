package activities;

public class Activity3 {
    public static void main(String[] args){
        double seconds = 1000000000;

        double EarthSeconds = 31557600;
        double MercuryOrbitalPeriod = 0.2408467;
        double VenusOrbitalPeriod = 0.61519726;
        double MarsOrbitalPeriod = 1.8808158;
        double JupiterOrbitalPeriod = 11.862615;
        double SaturnOrbitalPeriod = 29.447498;
        double UranusOrbitalPeriod = 84.016846;
        double NeptuneOrbitalPeriod = 164.79132;

        System.out.println("Age on Mercury: " + seconds / EarthSeconds / MercuryOrbitalPeriod);
        System.out.println("Age on Venus: " + seconds / EarthSeconds / VenusOrbitalPeriod);
        System.out.println("Age on Earth: " + seconds / EarthSeconds);
        System.out.println("Age on Mars: " + seconds / EarthSeconds / MarsOrbitalPeriod);
        System.out.println("Age on Jupiter: " + seconds / EarthSeconds / JupiterOrbitalPeriod);
        System.out.println("Age on Saturn: " + seconds / EarthSeconds / SaturnOrbitalPeriod);
        System.out.println("Age on Uranus: " + seconds / EarthSeconds / UranusOrbitalPeriod);
        System.out.println("Age on Neptune: " + seconds / EarthSeconds / NeptuneOrbitalPeriod);

    }
}
