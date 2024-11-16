import java.time.DateTimeException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter your surname, name, patronymic, and date of birth (e.g. Иванов Иван Иванович 01.01.2000)");

        // вызываем функцию проверки пола, обрабатываем исключения
        try (Scanner in = new Scanner(System.in)) {
            String s = in.nextLine().trim();
            System.out.println(CheckSex.checkSex(s));
        } catch (NumberFormatException e) {
            System.out.println("Invalid date format. Please ensure the date is in the format DD.MM.YYYY.");
        } catch (IllegalArgumentException | DateTimeException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error. Please try again.");
        }
    }
}