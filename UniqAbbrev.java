import java.util.*;

public class UniqAbbrev {
    public static void main(String[] args) {
        System.out.println(soln("BAT"));
        System.out.println(soln("code"));
    }

    public static List<String> soln(String word) {
        LinkedList<String> ans = new LinkedList<>();
        ans.add("");
        for (int i = 0; i < word.length(); i++) {
            int n = ans.size();
            for (int j = 0; j < n; j++) {
                String s = ans.removeLast();
                ans.addFirst(s + word.charAt(i));
                if (s.length() > 0 && Character.isDigit(s.charAt(s.length() - 1))) {
                    int num = s.charAt(s.length() - 1) - '0';
                    ans.addFirst(s.substring(0, s.length() - 1) + (num + 1));
                } else {
                    ans.addFirst(s + "1");
                }
            }
        }
        return new ArrayList<>(ans);
    }
}
