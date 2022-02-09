import java.lang.reflect.Field;

public class Student {
    private final String imie;
    private final String nazwisko;
    private final int indeks;
    private final String adres;
    private final String uczelnia;
    private final String wydzial;
    private final String grupa;

    public Student(String imie, String nazwisko, int indeks, String adres, String uczelnia, String wydzial, String grupa) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.indeks = indeks;
        this.adres = adres;
        this.uczelnia = uczelnia;
        this.wydzial = wydzial;
        this.grupa = grupa;

    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public int getIndeks() {
        return indeks;
    }

}
