package chnu.coursework.car_dealership.model;

public enum Drive {
    FOUR_WHEEL_DRIVE("Повний привід"),
    FRONT_WHEEL_DRIVE("Передній привід"),
    REAR_WHEEL_DRIVE("Задній привід");

    private String toString;

    Drive(String toString) {
        this.toString = toString;
    }
    public String toString(){
        return toString;
    }
}
