import java.time.DateTimeException;
import java.time.LocalDate;


public class CheckSex {
    // проверяем корректность введенных данных, формируем результат
    public static String checkSex(String s) throws IllegalArgumentException {
        String[] parts = s.split(" ");
        if (parts.length != 4) {
            throw new IllegalArgumentException("Input must contain surname, name, patronymic, and date of birth.");
        }
        String fio = formatFio(parts);
        String sex = determineSex(parts[2]);
        int age = calculateAge(parts[3]);

        return fio + "\nПол: " + sex + "\nВозраст: " + formatAge(age);
    }

    // фамилия остается неизменной, создаем инициалы
    private static String formatFio(String[] parts) {
        return "ФИО: " + parts[0] + " " +
                parts[1].toUpperCase().charAt(0) + "." +
                parts[2].toUpperCase().charAt(0) + ". ";
    }

    // определяем пол в зависимости от последней буквы отчества
    private static String determineSex(String patronymic) {
        if (patronymic.toLowerCase().endsWith("а")) {
            return "Ж";
        } else if (patronymic.toLowerCase().endsWith("ч")) {
            return "М";
        } else {
            return "Определить не удалось";
        }
    }

    // проверяем корректность введенной даты и вызываем функцию подсчёта возраста
    private static int calculateAge(String age) {
        String[] dateOfBirth = age.split("[\\./,]");
        if (dateOfBirth.length != 3) {
            throw new IllegalArgumentException("Invalid date format. Expected format: DD.MM.YYYY");
        }

        int day = Integer.parseInt(dateOfBirth[0]);
        int month = Integer.parseInt(dateOfBirth[1]);
        int year = Integer.parseInt(dateOfBirth[2]);
        LocalDate birthDate = LocalDate.of(year, month, day);

        return AgeCalculator.calculateAge(birthDate, LocalDate.now());
    }

    // добавляем суффикс
    private static String formatAge(int age) {
        String suffix;

        if (age % 10 == 1) {
            suffix = " год";
        } else if (age % 10 == 2 || age % 10 == 3 || age % 10 == 4) {
            suffix = " года";
        } else {
            suffix = " лет";
        }

        return age + suffix;
    }
}
