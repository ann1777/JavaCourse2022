package lesson13;

public enum Planet {

    MERCURY(1, 0, 58, 2439, null),
    VENUS(2, 50, 108, 6051.8, MERCURY),
    EARTH(3, 42, 150, 6378.1, VENUS),
    MARS(4, 78, 228, 3397.2, EARTH),
    JUPITER(5, 550, 778, 7149.2, MARS),
    SATURN(6, 651, 1429, 6026.8, JUPITER),
    URANUS(7, 1446, 2875, 255.9, SATURN),
    NEPTUN(8, 1622, 4497, 2474.6, URANUS),
    PLUTO(9, 1416, 5913, 1188.14, NEPTUN);

    private final int serialNumber;// номер по порядку от солнца (для спутников применяется номер планеты)
    private final double pathToPrev;// удаленность от предыдущей планеты (для меркурия 0)
    private final double pathToTheSun; // удаленность от солнца (вычисляется в конструкторе)
    private final double radius;// радиус
    private final Planet prev;// предыдущая планета
    public Planet next;// следующая планета

    Planet(int serialNumber, double pathToPrev, double pathToTheSun, double radius, Planet prev) {
        this.serialNumber = serialNumber;
        this.pathToPrev = pathToPrev;
        this.pathToTheSun = pathToTheSun;
        this.radius = radius;
        this.prev = prev;
        if (prev != null) {
            prev.next = this;
        }
    }

    public int serialNumber() {
        return serialNumber;
    }
    public double pathToPrev() {
        return pathToPrev;
    }
    public double pathToTheSun() {
        return pathToTheSun;
    }
    public double radius() {
        return radius;
    }
    public Planet prev() {
        return prev;
    }
}
