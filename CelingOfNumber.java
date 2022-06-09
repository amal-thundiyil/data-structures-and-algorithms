public class CelingOfNumber {
    public static void main(String[] args) {
        System.out.println(findCeil(new int[] { 4, 6, 10 }, 6));
        System.out.println(findCeil(new int[] { 1, 3, 8, 10, 15 }, 12));
        System.out.println(findCeil(new int[] { 4, 6, 10 }, 17));
        System.out.println(findCeil(new int[] { 4, 6, 10 }, -1));
    }

    public static int findCeil(int[] arr, int key) {
        return findCeilHelper(arr, key, 0, arr.length - 1);
    }

    public static int findCeilHelper(int[] arr, int key, int lo, int hi) {
        if (lo > hi) {
            if (lo >= arr.length)
                return -1;
            return lo;
        }

        int mid = (hi + lo) / 2;
        if (arr[mid] > key)
            return findCeilHelper(arr, key, lo, mid - 1);
        if (arr[mid] < key)
            return findCeilHelper(arr, key, mid + 1, hi);
        return mid;
    }
}
