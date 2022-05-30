package lesson13;

public enum Planet{
    MERCURY(1, 0, 58, 2439, null, VENUS),
    VENUS(2, 50, 108, 6051.8, MERCURY, EARTH),
    EARTH(3, 42, 150, 6378.1, VENUS, MARS),
    MARS(4, 78, 228, 3397.2, EARTH, JUPITER),
    JUPITER(5, 550, 778, 7149.2, MARS, SATURN),
    SATURN(6, 651, 1429, 6026.8, JUPITER, URANUS),
    URANUS(7, 1446, 2875, 255.9, SATURN, NEPTUN),
    NEPTUN(8, 1622, 4497, 2474.6, URANUS, PLUTO),
    PLUTO(9, 1416, 5913, 1188.14, NEPTUN, null);

    private final int serialNumber;// номер по порядку от солнца (для спутников применяется номер планеты)
    private final double pathToPrev;// удаленность от предыдущей планеты (для меркурия 0)
    private final double pathToTheSun; // удаленность от солнца (вычисляется в конструкторе)
    private final double radius;// радиус
    private Planet prev;// предыдущая планета
    public Planet next;// следующая планета

    Planet(int serialNumber, double pathToPrev, double pathToTheSun, double radius, Planet prev, Planet next) {
        this.serialNumber = serialNumber;
        this.pathToPrev = pathToPrev;
        this.pathToTheSun = prev.pathToTheSun + this.pathToPrev;
        this.radius = radius;
        this.prev = prev;
        this.next = SwitchNextPlanet();
        prev.next = this;
    }

    Planet(int serialNumber, double pathToPrev, double pathToTheSun, double radius, Planet next) {
        this.serialNumber = serialNumber;
        this.pathToPrev = pathToPrev;
        this.pathToTheSun = pathToTheSun;
        this.radius = radius;
        this.prev = null;
        this.next = SwitchNextPlanet();
        prev.next = this;
    }

    protected Planet SwitchNextPlanet() {
        return this.next;
    }
}
