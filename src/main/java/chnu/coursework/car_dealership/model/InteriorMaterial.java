package chnu.coursework.car_dealership.model;
public enum InteriorMaterial {
    FULL_LEATHER("Повністю шкіряний"),
    PART_LEATHER("Частково шкіряний"),
    CLOTH("Тканяний"),
    VELOUR("Велюр"),
    ALCANTARA("Алькантара"),
    OTHER("Інше");

    private String toString;

    InteriorMaterial(String toString) {
        this.toString = toString;
    }

    public String toString(){
        return toString;
    }
}
