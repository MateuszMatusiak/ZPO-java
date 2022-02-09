package Main;

import org.jacop.constraints.Constraint;
import org.jacop.constraints.binpacking.Binpacking;
import org.jacop.core.IntVar;
import org.jacop.core.Store;
import org.jacop.search.*;

public class Main {

    public static void main(String[] args) {
        Store store = new Store();

        int[] w = {310, 390, 445, 550, 610, 610, 630, 640, 640, 660, 680, 725, 730, 775, 800, 810, 840, 945, 1050, 1250};

        IntVar[] b_ = new IntVar[w.length];
        for (int i = 0; i < w.length;) {
            b_[i] = new IntVar(store, "film" + ++i + ".avi", 1, 3);
        }

        int bins = 3;
        IntVar[] c = new IntVar[3];
        for (int i = 0; i < bins; i++) {
            c[i] = new IntVar(store, "c" + i, 0, 4700);
        }

        Constraint binPacking = new Binpacking(b_, c, w);
        store.impose(binPacking);

        store.consistency();
        boolean Result;

        Search<IntVar> label = new DepthFirstSearch<IntVar>();
        SelectChoicePoint<IntVar> select = new SimpleSelect<IntVar>(b_, null, new IndomainMin<IntVar>());
        label.setAssignSolution(true);
        label.setPrintInfo(false);

        Result = label.labeling(store, select);

        if (Result) {
            System.out.println("Result:");
            System.out.println("CD1: ");
            for (IntVar i : b_) {
                if (i.value() == 1) {
                    System.out.print(i.id + " ");
                }
            }

            System.out.println("\nCD2: ");
            for (IntVar i : b_) {
                if (i.value() == 2) {
                    System.out.print(i.id + " ");

                }

            }
            System.out.println("\nCD3: ");

            for (IntVar i : b_) {
                if (i.value() == 3) {
                    System.out.print(i.id + " ");

                }
            }
        } else
            System.out.println("Doesn't have result");
    }
}