import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj wyrażenie: plus, minus, razy, dziel, pierwiastek: ");
        String expression = sc.nextLine();
        String[] elements = expression.split(" ");
        Class<?> cls = Calculator.class;
        Calculator calculator = new Calculator();
        double a, b;
        Object o = null;
        if (elements.length == 2) {
            if (elements[0].equals("pierwiastek")) {
                try {
                    a = Double.parseDouble(elements[1]);
                    o=Calculator.pierwiastek(a);
                } catch (NumberFormatException e) {
                    System.out.println("Błędna liczba");
                } catch (ArithmeticException e) {
                    System.out.println("Ujemna wartość liczby pierwiastkowanej");
                }
            }
        } else if (elements.length == 3) {
            try {
                a = Double.parseDouble(elements[0]);
                b = Double.parseDouble(elements[2]);
                Method method = cls.getDeclaredMethod(elements[1], double.class, double.class);
                o = method.invoke(calculator,a ,b);
            } catch (NoSuchMethodException e) {
                System.out.println("Błędne działanie");
            } catch (NumberFormatException e) {
                System.out.println("Błędna liczba");
            } catch (InvocationTargetException | IllegalAccessException e) {
                System.out.println("Działanie niemożliwe");
            }

        } else {
            System.out.println("Błędna liczba elementów.");

        }
        if(o!=null)
            System.out.println("Wynik: " + o);
    }
}
