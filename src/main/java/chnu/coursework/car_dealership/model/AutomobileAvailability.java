package chnu.coursework.car_dealership.model;

public enum AutomobileAvailability {
    SOLD("Проданий"),
    IN_STOCK("В наявності"),
    ORDERED("Замовлений");

    private String toString;

    AutomobileAvailability(String toString) {
        this.toString = toString;
    }

    public String toString(){
        return toString;
    }

}
