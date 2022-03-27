import java.util.*;
import java.lang.Math;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<StringBuilder> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            temp.add(new StringBuilder());
            for (int j = 0; j < n; j++) {
                temp.get(i).append('.');
            }
        }
        dfs(ans, temp, n, 0);
        return ans;
    }

    public void dfs(List<List<String>> ans, List<StringBuilder> temp, int n, int count) {
        if (count == n) {
            ans.add(new ArrayList<>());
            for (StringBuilder sb : temp) {
                ans.get(ans.size() - 1).add(sb.toString());
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValidPosition(temp, i, count)) {
                temp.get(i).setCharAt(count, 'Q');
                dfs(ans, temp, n, count + 1);
                temp.get(i).setCharAt(count, '.');
            }
        }
    }

    public boolean isValidPosition(List<StringBuilder> temp, int i, int j) {
        for (int k = 0; k < temp.size(); k++) {
            for (int l = 0; l < temp.size(); l++) {
                int a = Math.abs(k - i), b = Math.abs(l - j);
                if (temp.get(k).charAt(l) == 'Q' && (a == 0 || b == 0 || a == b))
                    return false;
            }
        }
        return true;
    }
}