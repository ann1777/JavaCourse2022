package lesson13;


import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        Planet[] p = new Planet[]{Planet.MERCURY, Planet.VENUS, Planet.EARTH, Planet.MARS, Planet.JUPITER, Planet.SATURN,
                Planet.URANUS, Planet.NEPTUN, Planet.PLUTO};

        System.out.println(Arrays.toString(Planet.values()));

        for (Planet planet : p) {
            System.out.println(planet.name() + ": serialNumber " + planet.serialNumber() + ", pathToPrev " + planet.pathToPrev() +
                    ", pathToTheSun " + planet.pathToTheSun() + ". radius " + planet.radius() + ", Planet prev is " + planet.prev() +
                    ", Planet next is " + planet.next);
        }
    }
}

