package chnu.coursework.car_dealership.model;

public enum HeadlightsType {
    XENON("Xenon"),
    BIXENON("Bi-xenon"),
    LED("LED"),
    LASER("Laser"),
    USUAL("Звичайні");

    private final String toString;

    HeadlightsType(String toString) {
        this.toString = toString;
    }
    public String toStrting(){
        return toString;
    }
}
