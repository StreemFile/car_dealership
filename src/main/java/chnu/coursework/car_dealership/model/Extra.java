package chnu.coursework.car_dealership.model;

public enum Extra {
    AIR_SUSPENSION("Пневматична підвіска"),
    PANORAMIC_ROOF("Панорамний дах"),
    ROOF_RACK("Багажник на даху"),
    ELECTRIC_TAILGATE("Електричні двері багажника"),
    SUNROOF("Люк");

    private String toString;

    Extra(String toString) {
        this.toString = toString;
    }

    public String toString(){
        return toString;
    }
}
