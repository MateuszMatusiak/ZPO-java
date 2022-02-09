import java.util.Scanner;

public class Numbers {
    String txt;
    int number=0;

    int choose() {
        Scanner sc = new Scanner(System.in);
        txt = sc.nextLine();
        switch (txt) {
            case "dziesięć":
                return 10;
            case "osiem":
                return 8;
            case "szesnaście":
                return 16;
            default:
                return 0;
        }
    }

    void toHex(int x){
    
    }

}


