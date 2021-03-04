package chnu.coursework.car_dealership.model.engine;

public enum TransmissionType {
    MANUAL_GEARBOX("Механіка"),
    SEMI_AUTOMATIC("Напівавтомат"),
    AUTOMATIC("Автомат");

    private String toString;

    TransmissionType(String toString) {
        this.toString = toString;
    }

    public String toString(){
        return toString;
    }
}
