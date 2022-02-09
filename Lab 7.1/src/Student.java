@DefaultStudent
public class Student {
    public String name;
    public String surname;

    public Student(){
        DefaultStudent defaultStudent = this.getClass().getAnnotation(DefaultStudent.class);
        try{
            name = defaultStudent.name();
            surname = defaultStudent.surname();
        } catch (NullPointerException ignored)
        {}
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
