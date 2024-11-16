import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class AgeCalculator {
    // подсчет возраста
    public static int calculateAge(LocalDate birthDate, LocalDate currentDate) throws DateTimeException {
        Objects.requireNonNull(birthDate, "Birth date cannot be null");
        Objects.requireNonNull(currentDate, "Current date cannot be null");

        if (birthDate.isAfter(currentDate)) {
            throw new DateTimeException("Birth date cannot be in the future.");
        }
        return Period.between(birthDate, currentDate).getYears();
    }
}
