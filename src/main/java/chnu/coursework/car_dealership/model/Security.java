package chnu.coursework.car_dealership.model;

public enum Security {
    ABS("ABS"),
    ESP("ESP"),
    ISOFIX("ISOFIX"),
    NIGHT_VISION_ASSIST("Асистент нічного бачення"),
    TRAFFIC_SIGN_RECOGNITION("Розпізнавання дорожніх знаків"),
    ALARM_SYSTEM("Сигналізація"),
    DISTANCE_WARNING_SYSTEM("Попередження про відстань"),
    FATIGUE_WARNING_SYSTEM("Попередження втоми"),
    HEADLIGHT_WASHER_SYSTEM("Омивання фар"),
    TYRE_PRESSURE_MONITORING("Контроль тиску в шинах"),
    AUTOMATIC_DIMMING_INTERIOR_MIRROR("Автом. затемнення внутрішнього дзеркала"),
    FOG_LAMP("Противотуманні фари"),
    HIGH_BEAM_ASSISTANT("Асистент дальнього світла"),
    SPEED_LIMIT_CONTROL_SYSTEM("Система контролю обмеження швидкості"),
    TRACTION_CONTROL("Противобуксовочна система"),
    SPARE_TYRE("Запасна шина"),
    ADAPTIVE_CRUISE_CONTROL("Адаптивний круїз-контроль");

    private String toString;

    Security(String toString){
        this.toString = toString;
    }

    public String toString(){
        return toString;
    }
}
