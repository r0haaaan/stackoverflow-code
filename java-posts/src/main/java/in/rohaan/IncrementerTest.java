package in.rohaan;

import static in.rohaan.Incrementer.in;

/*
 * Code for https://stackoverflow.com/questions/65239851/
 */ 
public class IncrementerTest {
    public static void main(String[] args) {
        // simplest iteration - step = 1
        for(int k : in(1, 10)) System.out.print(k + " ");
        System.out.println();

        // The given step
        for(int k : in(1, 10).by(2)) System.out.print(k + " ");
        System.out.println();

        // It can be the other way around - step = -1 by default
        for(int k : in(10, 1)) System.out.print(k + " ");
        System.out.println();

        // But the range can be made from min to max and the given step will be
        // decide on the iteration direction
        for(int k : in(1, 10).by(-1)) System.out.print(k + " ");
        System.out.println();

        // During the iteration, you can change the step
        Incrementer inc;
        for (int i : inc = in(1,10) ) {
            if (i == 4) inc.by(2);
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : inc = in(1,10) ) {
            if (i == 8) inc.by(-2);
            System.out.print(i + " ");
        }
        System.out.println();
        for(int k : inc = in(10, 1)) {
            if (k == 5) inc.by(1);
            System.out.print(k + " ");
        }

    }
}
