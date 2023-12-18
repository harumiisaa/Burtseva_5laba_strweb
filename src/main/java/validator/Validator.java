package validator;

import java.util.regex.Pattern;

public class Validator {

    private static final Pattern STRING_PATTERN = Pattern.compile("^[\\p{L}]+$");
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
    private static final Pattern FUEL_CONSUMPTION_PATTERN = Pattern.compile("\\-?\\d+(\\.\\d{0,})?");

    public static boolean correctCompany(String name, String country) {
        return !name.isBlank() && !country.isBlank() && STRING_PATTERN.matcher(country).matches();
    }

    public static boolean correctPerson(String name, String surname, String age, String phone, String mail) {
        return !name.isBlank() && !surname.isBlank() && !age.isBlank() && NUMBER_PATTERN.matcher(age).matches() &&
                !phone.isBlank() && !mail.isBlank();
    }

    public static boolean correctUser(String login, String password) {
        return !login.isBlank() && !password.isBlank();
    }

    public static boolean correctRole(String role) {
        return role.equals("User") || role.equals("Admin");
    }

    public static boolean correctId(String id) {
        boolean isCorrect = true;
        if (id.isBlank() || !NUMBER_PATTERN.matcher(id).matches()) {
            isCorrect = false;
        }
        return isCorrect;
    }

    public static boolean correctCar(String name, String year, String distance,
                                     String fuel, String fuelConsumption, String price) {
        boolean isCorrect = true;
        if (name.isBlank() || year.isBlank() || !NUMBER_PATTERN.matcher(year).matches() || distance.isBlank() ||
                !NUMBER_PATTERN.matcher(distance).matches() || fuel.isBlank() || fuelConsumption.isBlank() ||
                !FUEL_CONSUMPTION_PATTERN.matcher(fuelConsumption).matches() || price.isBlank() ||
                !NUMBER_PATTERN.matcher(price).matches()) {
            isCorrect = false;
        }
        return isCorrect;
    }

    public static boolean correctFuel(String fuel) {
        return fuel.equals("Бензин") || fuel.equals("Дизель") || fuel.equals("Пиво");
    }
}
