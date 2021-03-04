package chnu.coursework.car_dealership.model;

public enum InteriorFeature {
    AMBIENT_LIGHTING("Підсвітка салону"),
    DIGITAL_COCKPIT("Цифрова панель"),
    ELECTRIC_SEAT_ADJUSTMENT("Електричне регулювання сидіння"),
    MASSAGE_SEATS("Масажні сидіння"),
    PADDLE_SHIFTERS("Лопатеві перемикачі передач"),
    TOUCHSCREEN("Сенсорний екран"),
    BLUETOOTH("Bluetooth"),
    ELECTRIC_SIDE_MIRROR("Електричні бічні дзеркала"),
    HEATED_SIDE_MIRROR("Підігрів бічних дзерках"),
    MULTIFUNCTION_STEERING_WHEEL("Мультируль"),
    ANDROID_AUTO("Android auto"),
    APPLE_CAR_PLAY("CarPlay"),
    CD_PLAYER("CD-плеєр"),
    ELECTRIC_FRONT_WINDOWS("Передні електросклопідйомники"),
    ELECTRIC_REAR_WINDOWS("Задні електросклопідйомники"),
    HEATED_STEERING_WHEEL("Руль з підігрівом"),
    LEATHER_STEERING_WHEEL("Шкіряний руль"),
    NAVIGATION_SYSTEM("Навігація"),
    RAIN_SENSOR("Датчик дощу"),
    ARM_REST("Підлокітник"),
    ELECTRIC_HEATED_FRONT_SEATS("Передні сидіння з підігрівом"),
    ELECTRIC_HEATED_REAR_SEATS("Задні сидіння з підігрівом"),
    START_STOP_SYSTEM("Старт-стоп система");

    private String toString;

    InteriorFeature(String toString) {
        this.toString = toString;
    }

    public String toString(){
        return toString;
    }
}
