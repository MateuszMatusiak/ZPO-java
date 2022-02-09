public class Calculator {
    public static double plus(double a, double b) {
        return a + b;
    }

    public static double minus(double a, double b) {
        return a - b;
    }

    public static double razy(double a, double b) {
        return a * b;
    }

    public static double dziel(double a, double b) throws Exception {
        if(b==0)
            throw new Exception("Nie można dzielić przez 0");
            return a / b;
    }

    public static double pierwiastek(double a) {
        return Math.sqrt(a);
    }

}
