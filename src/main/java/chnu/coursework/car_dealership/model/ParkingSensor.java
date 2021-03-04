package chnu.coursework.car_dealership.model;

public enum ParkingSensor {
    REAR("Задні парктроніки"),
    FRONT("Передні парктроніки"),
    CAMERA("Камера заднього виду"),
    CAMERA_360("Камера 360°");


    private String toString;

    ParkingSensor(String toString) {
        this.toString = toString;
    }

    public String toString(){
        return toString;
    }
}
