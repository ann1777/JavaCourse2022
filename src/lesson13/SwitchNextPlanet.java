package lesson13;

import static lesson13.Planet.*;

public class SwitchNextPlanet {
    protected static enum Planet {
        switch(this)

        {
            case MERCURY:
                return next = VENUS;
            case VENUS:
                return next = EARTH;
            case EARTH:
                return next = MARS;
            case MARS:
                return next = JUPITER;
            case JUPITER:
                return next = SATURN;
            case SATURN:
                return next = URANUS;
            case URANUS:
                return next = NEPTUN;
            case NEPTUN:
                return next = PLUTO;
        }
    }
}