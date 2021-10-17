package EveryDay.Oct_2021;

import java.util.ArrayList;
import java.util.List;

public class Oct13_412 {
    public static List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for(int i = 1; i <= n; i++)
        {
            if (i % 3 == 0 && i % 5 == 0)
            {
                res.add("FizzBuzz");
                continue;
            }
            if (i % 3 == 0)
            {
                res.add("Fizz");
                continue;
            }
            if (i % 5 == 0)
            {
                res.add("Buzz");
                continue;
            }

            res.add(String.valueOf(i));

        }
        return res;
    }
}
