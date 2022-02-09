import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Draw d = new Draw();
        int size = 4;
        int len = 6;
        System.out.println("Give size: ");
        size = sc.nextInt();
        System.out.println("Give length: ");
        len = sc.nextInt();

        d.drawTopLine(size, len);
        d.drawTop(size, len);
        d.drawLine(size, len);
        d.drawLine(size, len);
        d.drawDown(size, len);
        d.drawTopLine(size, len);

    }
}
