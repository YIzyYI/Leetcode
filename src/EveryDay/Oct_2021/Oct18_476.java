package EveryDay.Oct_2021;

public class Oct18_476 {
    public int findComplement(int num) {
        long ans = 1;
        while (ans <= num)
        {
            ans *= 2;
        }

        return (int) ans - 1 - num;
    }
}
