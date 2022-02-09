import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

@DefaultStudent
public class Student implements Comparable {
    @IgnoreEquals
    int indeks;
    @IgnoreEquals
    List<Float> oceny;
    @CompareOrder(2)
    String imie;
    @CompareOrder(1)
    String nazwisko;
    @IgnoreEquals
    String stopienStudiow;

    public Student(int indeks, String imie, String nazwisko, String stopienStudiow) {
        this.indeks = indeks;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stopienStudiow = stopienStudiow;
    }

    public Student() {
        DefaultStudent defaultStudent = this.getClass().getAnnotation(DefaultStudent.class);
        try {
            imie = defaultStudent.imie();
            nazwisko = defaultStudent.nazwisko();
        } catch (NullPointerException ignored) {
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + imie + '\'' +
                ", surname='" + nazwisko + '\'' +
                '}';
    }

    public boolean equals(Student s) {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                boolean skip = false;
                Annotation[] an = field.getDeclaredAnnotations();
                for (Annotation annotation : an) {
                    if (annotation.toString().equals("@IgnoreEquals()")) {
                        skip = true;
                    }
                }

                if (!skip) {
                    if (!field.get(this).equals(field.get(s)))
                        return false;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return true;
    }


    @Override
    public int compareTo(Object o) {
        Field[] fields = this.getClass().getDeclaredFields();
        int count=0;
        for (Field field : fields) {
            CompareOrder compareOrder = field.getAnnotation(CompareOrder.class);
            if(compareOrder!=null)
            {
                count++;
            }
        }
        Field[] fieldsToCompare= new Field[count];
        for(Field field : fields)
        {
            CompareOrder compareOrder = field.getAnnotation(CompareOrder.class);
            if(compareOrder!=null)
            {
                fieldsToCompare[compareOrder.value()-1]=field;
            }
        }
        for (Field field : fieldsToCompare) {
            try {
                try {
                    Double num1 = Double.parseDouble(field.get(this).toString());
                    Double num2 = Double.parseDouble(field.get(o).toString());
                    return num1.compareTo(num2);
                } catch (NumberFormatException e) {
                    return field.get(this).toString().compareTo(field.get(o).toString());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}
