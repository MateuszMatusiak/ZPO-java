import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger NRB;
        String nr,temp;
        System.out.println("Give number");
        nr=sc.nextLine();
        nr=nr.trim();
        nr=nr.concat("2521");
        temp=nr.substring(0,2);
        nr=nr.substring(2);
        nr=nr.concat(temp);
        try
        {
            NRB = new BigInteger(nr);
            if(NRB.mod(new BigInteger("97")).equals(new BigInteger("1")))
            {
                System.out.println("Good");
            }
            else
            {
                System.out.println("Bad");
            }
        }catch(Exception e)
        {
            System.out.printf("It's not number");
            System.exit(1);
        }




    }
}
