package in.rohaan;

import java.util.Random;

public class JavaElse {
    private static Random rnd = new Random();
    public static void main(String[] args)
    {
        int count = 1;
        int x;
        boolean flag = true;
        while (count <= 2)
        {
            x = rnd.nextInt(99 - 10 + 1) + 10;

            if(x%7 == 0 || x%10 == 7 || x/10 == 7)
            {
                flag = true;
                System.out.println(x);
            }
            else
            {
                flag = false;
            }

            count++;
        }
        if (flag)
            System.out.println("Seven Boom!");
        else
            System.out.println("No seven boom!");

    }

}
