import java.util.Scanner;
import java.util.logging.Logger;

public class ComplexNumberApp {
    private static final Logger logger = Logger.getLogger(ComplexNumberApp.class.getName());
    private static final Scanner scanner = new Scanner(System.in);

    public void run() {
        ComplexNumber firstNumber = readComplexNumber("Введите первое комплексное число (a + bi): ");
        ComplexNumber secondNumber = readComplexNumber("Введите второе комплексное число (a + bi): ");

        while (true) {
            String operation = readOperation();
            ComplexNumber result;

            switch (operation) {
                case "+":
                    result = firstNumber.add(secondNumber);
                    logger.info(firstNumber + " + " + secondNumber + " = " + result);
                    break;
                case "*":
                    result = firstNumber.multiply(secondNumber);
                    logger.info(firstNumber + " * " + secondNumber + " = " + result);
                    break;
                default:
                    System.out.println("Неверная операция, попробуйте еще раз.");
                    continue;
            }

            System.out.println("Результат: " + result);
            if (!askToContinue()) {
                break;
            }
        }
    }

    private ComplexNumber readComplexNumber(String message) {
        System.out.print(message);
        double real = scanner.nextDouble();
        double imaginary = scanner.nextDouble();
        return new ComplexNumber(real, imaginary);
    }

    private String readOperation() {
        System.out.print("Выберите операцию (+, *): ");
        return scanner.next();
    }

    private boolean askToContinue() {
        System.out.print("Для продолжения введите \"y\", для выхода из программы введите \"n\": ");
        String answer = scanner.next();
        return answer.equalsIgnoreCase("y");
    }
}
