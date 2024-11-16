import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class AgeCalculator {
    // подсчет возраста
    public static int calculateAge(LocalDate birthDate, LocalDate currentDate) throws DateTimeException {
        Objects.requireNonNull(birthDate, "Birth date cannot be null");
        Objects.requireNonNull(currentDate, "Current date cannot be null");

        int age = Period.between(birthDate, currentDate).getYears();

        // проверяем полученный возраст на здравый смысл
        if (birthDate.isAfter(currentDate)) {
            throw new DateTimeException("Birth date cannot be in the future.");
        } else if (age < 0 || age > 122) {
            throw new DateTimeException("Age is out of realistic bounds.");
        } else { return age; }
    }
}
