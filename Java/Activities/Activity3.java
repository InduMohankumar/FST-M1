package day1;

public class Activity3 {
    public static void main(String[] args) {
        double ageInSeconds = 1_000_000_000;  // example input

        double earthYearSeconds = 31557600;

        // Orbital periods relative to Earth years
        double[] orbitalPeriods = {
            1.0,          // Earth
            0.2408467,    // Mercury
            0.61519726,   // Venus
            1.8808158,    // Mars
            11.862615,    // Jupiter
            29.447498,    // Saturn
            84.016846,    // Uranus
            164.79132     // Neptune
        };

        String[] planets = {
            "Earth", "Mercury", "Venus", "Mars", 
            "Jupiter", "Saturn", "Uranus", "Neptune"
        };

        for (int i = 0; i < planets.length; i++) {
            double age = ageInSeconds / (earthYearSeconds * orbitalPeriods[i]);
            System.out.printf("Age on %s: %.2f years%n", planets[i], age);
        }
    }
}
