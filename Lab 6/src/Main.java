public class Main {
    public static void main(String[] args) {
        Student s = new Student("Mateusz", "Matusiak", 228802, "Pułtusk", "Pł", "WEEIA", "5I02");
        System.out.println(toStringGenerator.generate(s));
        kuchnia k = new kuchnia("czerwony", "gazowy", "czarna","firmowy");
        System.out.println(toStringGenerator.generate(k));
    }
}
