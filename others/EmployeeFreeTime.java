import java.util.*;

public class EmployeeFreeTime {
    public static List<int[]> solve(List<List<int[]>> schedule) {
        List<int[]> ans = new ArrayList<>();
        PriorityQueue<int[]> q = new PriorityQueue<>((int[] a, int[] b) -> a[3] - b[3]);
        for (int i = 0; i < schedule.size(); i++) {
            q.add(new int[] { i, 0, schedule.get(i).get(0)[0], schedule.get(i).get(0)[1] });
        }
        int[] prevInterval = q.peek();
        while (!q.isEmpty()) {
            int[] interval = q.poll();
            if (interval[2] > prevInterval[3]) {
                ans.add(new int[] { prevInterval[3], interval[2] });
            }
            prevInterval = interval;
            if (++interval[1] < schedule.get(interval[0]).size()) {
                q.add(new int[] { interval[0], interval[1], schedule.get(interval[0]).get(interval[1])[0],
                        schedule.get(interval[0]).get(interval[1])[1] });
            }
        }
        for (int[] arr : ans)
            System.out.println(Arrays.toString(arr));
        return ans;
    }

    public static void main(String[] args) {
        List<List<int[]>> schedule = new ArrayList<>();

        List<int[]> emp = new ArrayList<>();
        emp.add(new int[] { 1, 3 });
        emp.add(new int[] { 9, 12 });
        schedule.add(emp);
        List<int[]> emp2 = new ArrayList<>();
        emp2.add(new int[] { 2, 4 });
        schedule.add(emp2);
        List<int[]> emp3 = new ArrayList<>();
        emp3.add(new int[] { 6, 8 });
        schedule.add(emp3);

        solve(schedule);
    }
}