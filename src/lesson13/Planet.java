package lesson13;

public enum Planet {
    MERCURY(1, 0, 58, 2439, null, VENUS. - next),
    VENUS(2, 50, 108, 6051.8, MERCURY. - prev, EARTH. - next),
    EARTH(3, 42, 150, 6378.1, VENUS. - prev, MARS. - next),
    MARS(4, 78, 228, 3397.2, EARTH. - prev, JUPITER. - next),
    JUPITER(5, 550, 778, 7149.2, MARS. - prev, SATURN. - next),
    SATURN(6, 651, 1429, 6026.8, JUPITER. - prev, URANUS. - next),
    URANUS(7, 1446, 2875, 255.9, SATURN. - prev, NEPTUN. - next),
    NEPTUN(8, 1622, 4497, 2474.6, URANUS. - prev, PLUTO. - next),
    PLUTO(9, 1416, 5913, 1188.14, NEPTUN. - prev, null);

    private final int serialNumber;// номер по порядку от солнца (для спутников применяется номер планеты)
    private final double pathToPrev;// удаленность от предыдущей планеты (для меркурия 0)
    private final double pathToTheSun; // удаленность от солнца (вычисляется в конструкторе)
    private final double radius;// радиус
    private static Planet prev;// предыдущая планета
    public static Planet next;// следующая планета

    private Planet(int serialNumber, double pathToPrev, double pathToTheSun, double radius, Planet prev,
                   Planet next) {
        this.serialNumber = serialNumber;
        this.pathToPrev = pathToPrev;
        this.pathToTheSun = prev.pathToTheSun + this.pathToPrev;
        this.radius = radius;
        this.prev = getPrev();
        this.next = getNext();
        prev.next = this;
    }

    private Planet(int serialNumber, double pathToPrev, double pathToTheSun, double radius, Planet next) {
        this.serialNumber = serialNumber;
        this.pathToPrev = pathToPrev;
        this.pathToTheSun = pathToTheSun;
        this.radius = radius;
        this.prev = null;
        this.next = getNext();
        prev.next = this;
    }

    private Planet(int serialNumber, double pathToPrev, double pathToTheSun, double radius, Planet prev) {
        this.serialNumber = serialNumber;
        this.pathToPrev = pathToPrev;
        this.pathToTheSun = prev.pathToTheSun + this.pathToPrev;
        this.radius = radius;
        this.next = null;
        this.prev = getPrev();
        next.prev = this;
    }

    public Planet getNext() {
        return next;
    }

    public Planet getPrev() {
        return prev;
    }
}
}



