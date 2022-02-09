public class Draw {

    private int n = 1;

    void drawTopLine(int size, int len) {
        System.out.print('0');
        for (int k = 1; k < size + 1; ++k) {
            for (int i = 0; i < Math.pow(2, len - 1) - 1; ++i)
                System.out.print(' ');
            System.out.print(k);
        }
        System.out.println();
    }


    void drawTop(int size, int len) {

        if (len == 1) {
            return;
        }

        System.out.print('|');

        for (int k = 0; k < size * n; ++k) {
            for (int i = 0; i < Math.pow(2, len - 1) - 1; ++i)
                System.out.print(' ');
            System.out.print('|');
        }
        System.out.println();
        n *= 2;
        drawTop(size, len - 1);
    }

    void drawLine(int size, int len) {
        for (int i = 0; i < size * (Math.pow(2, len - 1)); ++i)
            System.out.print('|');
        System.out.println('|');
    }

    void drawDown(int size, int len) {
        if (len == 1) {
            return;
        }
        drawDown(size, len - 1);

        System.out.print('|');

        for (int k = 0; k < (size * n)/2; ++k) {
            for (int i = 0; i < Math.pow(2, len - 1) - 1; ++i)
                System.out.print(' ');
            System.out.print('|');
        }
        System.out.println();
        n/=2;
    }
}


