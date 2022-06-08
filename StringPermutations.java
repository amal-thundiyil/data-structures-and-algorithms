import java.util.*;

public class StringPermutations {
    public static void main(String[] args) {
        System.out.println(perms("ad52"));
        System.out.println(perms("ab7c"));
    }

    public static List<String> perms(String str) {
        List<String> ans = new ArrayList<>();
        ans.add(str);

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c))
                continue;
            int n = ans.size();
            for (int j = 0; j < n; j++) {
                char[] ch = ans.get(j).toCharArray();
                if (Character.isLowerCase(ch[i]))
                    ch[i] = Character.toUpperCase(c);
                else
                    ch[i] = Character.toLowerCase(c);
                ans.add(String.valueOf(ch));
            }
        }
        return ans;
    }
}
