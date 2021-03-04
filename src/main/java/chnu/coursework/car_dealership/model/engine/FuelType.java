package chnu.coursework.car_dealership.model.engine;

public enum FuelType {
    PETROL("Бензин"),
    DIESEL("Дизель"),
    ELECTRIC("Електроенергія"),
    HYBRID_PETROL_ELECTRIC("Гібрид (бензин-електрроенергія)"),
    HYBRID_DIESEL_ELECTRIC("Гібрид (дизель-електрроенергія)"),
    HYBRID_PETROL_GAS("Гібрид (газ-бензин)");

    private String toString;

    FuelType(String toString) {
        this.toString = toString;
    }

    public String toString() {
        return toString;
    }
}
