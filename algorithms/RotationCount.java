public class RotationCount {
    public static void main(String[] args) {
        System.out.println(countRotations(new int[] { 10, 15, 1, 3, 8 }));
        System.out.println(countRotations(new int[] { 4, 5, 7, 9, 10, -1, 2 }));
        System.out.println(countRotations(new int[] { 1, 3, 8, 10 }));
    }

    public static int countRotations(int[] arr) {
        int lo = 0, hi = arr.length - 1;
        if (arr[lo] < arr[hi])
            return 0;
        while (lo < hi) {
            int mid = (hi + lo) / 2;
            if (arr[lo] <= arr[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo + 1;
    }
}