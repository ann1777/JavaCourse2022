package lesson13;

import lesson13.Planet

import static lesson13.Planet.*;*;

public class SwitchPlanets {
    protected static Planet switchNext {
        switch (next) {
            case MERCURY:
                return (next = VENUS);
            case VENUS:
                return (next = EARTH);
            case EARTH:
                return (next = MARS);
            case MARS:
                return (next = JUPITER);
            case JUPITER:
                return (next = SATURN);
            case SATURN:
                return (next = URANUS);
            case URANUS:
                return (next = NEPTUN);
            case NEPTUN:
                return (next = PLUTO);
            default:
                throw new IllegalStateException("Unexpected value: " + next);
        }
        return Planet.next;
    }
}

