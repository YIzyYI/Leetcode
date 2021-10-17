package EveryDay.Oct_2021;

import java.util.ArrayList;
import java.util.List;

public class Oct16_282 {
    String s;
    int n, t;
    List<String> ans = new ArrayList<>();

    public List<String> addOperators(String num, int target) {
        s = num;
        n = s.length();
        t = target;
        backtrack(0, 0, 0, "");
        return ans;
    }

    public void backtrack(int u, long prev, long cur, String ss)
    {
        if (u == n){
            if (cur == t) ans.add(ss);
            return;
        }

        for (int i = u; i < n; i++)
        {
            if(i != u && s.charAt(u) == '0') break;
            long next = Long.parseLong(s.substring(u, i+1));
            if(u == 0)
            {
                backtrack(i+1, next, next, "" + next);
            }
            else {
                backtrack(i+1, next, cur + next, ss + "+" + next);
                backtrack(i+1, -next, cur - next, ss + "-" + next);
                long x = prev * next;
                backtrack(i+1, x, cur - prev + x, ss + "*" + next);
            }
        }

    }
}
