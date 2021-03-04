package chnu.coursework.car_dealership.model;

public enum TyresAndWheels {
    ALLOY_SUMMER("Титанові диски, літні шини"),
    ALLOY_WINTER("Титанові диски, зимні шини"),
    ALLOY_ALL_SEASON("Титанові диски, всесезонні шини"),
    STEEL_SUMMER("Cталеві диски, літні шини"),
    STEEL_WINTER("Cталеві диски, зимні шини"),
    STEEL_ALL_SEASON("Cталеві диски, всесезонні шини");

    private String toString;

    TyresAndWheels(String toString) {
        this.toString = toString;
    }

    public String toString(){
        return toString;
    }
}
