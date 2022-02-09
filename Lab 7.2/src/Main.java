import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student MM = new Student();
        Student JZ = new Student(1,"Jakub", "Zolynski", "pierwszy");
        Student RS = new Student(2,"Rafal", "Sosnowski", "pierwszy");
        Student ML = new Student(3,"Mateusz", "Lebkowski", "pierwszy");
        Student WP = new Student(4,"Wiktor", "Pienkosz", "drugi");
        Student MM2 = new Student(5,"Mateusz", "Matusiak", "drugi");
        Student OB = new Student(6,"Aleksandra", "Banaszek","pierwszy");
        Student[] tab = new Student[]{MM,OB,JZ,RS,ML,WP};


        System.out.println("EQUALS TEST\n");
        for(int i=0;i< tab.length-1;++i)
        {
            System.out.println(tab[i].toString() + "\t" + tab[i+1].toString() + "\t equals = " + tab[i].equals(tab[i+1]));
        }
        System.out.println(ML.toString()+ "\t" + MM.toString() + "\t equals = " + ML.equals(MM));
        System.out.println(MM.toString()+ "\t" + MM.toString() + "\t equals = " + MM.equals(MM));
        System.out.println(MM.toString()+ "\t" + MM2.toString() + ": drugi\t equals = " + MM.equals(MM2));


        System.out.println("\nCOMPARE TO TEST\n");
        for(int i=0;i< tab.length-1;++i)
        {
            System.out.println(tab[i].toString() + "\t" + tab[i+1].toString() + "\t compare result = " + tab[i].compareTo(tab[i+1]));
        }
        System.out.println(ML.toString()+ "\t" + MM.toString() + "\t compare result = " + ML.compareTo(MM));
        System.out.println(MM.toString()+ "\t" + MM.toString() + "\t compare result = " + MM.compareTo(MM));
        System.out.println(MM.toString()+ "\t" + MM2.toString() + ": drugi\t compare result = " + MM.compareTo(MM2));

        System.out.println("\nSORT ARRAY\n");
        System.out.println(Arrays.toString(tab));
        Student[] sorted = tab.clone();
        Arrays.sort(sorted);
        System.out.println(Arrays.toString(sorted));

    }
}
