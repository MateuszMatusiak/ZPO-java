import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        Connector c = (Connector) Naming.lookup("rmi://localhost:2107/obiektSerwer");
        Scanner sc = new Scanner(System.in);
        String text = "[Redactor's Note: This document uses the ISO 8891-1 Latin1 character\n" +
                "set (Windows). The book is composed of text, footnotes, and appendices.\n" +
                "The footnotes are included at the end of each chapter, while the\n" +
                "Appendix No. and Section are referred to in the text in parentheses,\n" +
                "the Appendices following the book text. Liberal use is made of italics,\n" +
                "and these have been indicated by bracketing italic text with the\n" +
                "underscore character \"_\".  Line length is 70-72 characters. A number of\n" +
                "graphics occur in the text, these are referred to by number as\n" +
                "\"Graphic\", etc. The Figures themselves are in a separate file. To\n" +
                "facilitate conversion to a word-processing format, an attempt has been\n" +
                "made to end each line with a space.";
        System.out.println("Choose: histogram; refactor");
        String choose = sc.nextLine();
        if(choose.equals("histogram"))
        {
            System.out.println(c.makeHistogram(text));
        }
        else if(choose.equals("refactor"))
        {
            System.out.println(c.refactorText(text));
        }
        else{
            System.out.println("Bad choice");
        }

    }
}
