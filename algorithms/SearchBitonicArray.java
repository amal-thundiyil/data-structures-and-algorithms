public class SearchBitonicArray {
    public static void main(String[] args) {
        System.out.println(search(new int[] { 1, 3, 8, 4, 3 }, 4));
        System.out.println(search(new int[] { 3, 8, 3, 1 }, 8));
        System.out.println(search(new int[] { 1, 3, 8, 12 }, 12));
        System.out.println(search(new int[] { 10, 9, 8 }, 10));
    }

    public static int search(int[] arr, int key) {
        int mid = findMid(arr, key);
        if (arr[mid] == key)
            return mid;
        int left = binarySearch(arr, key, 0, mid - 1, true);
        int right = binarySearch(arr, key, mid + 1, arr.length - 1, false);
        return left == -1 ? right : left;
    }

    public static int findMid(int[] arr, int key) {
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] < arr[mid + 1]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public static int binarySearch(int[] arr, int key, int lo, int hi, boolean isAscending) {
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                if (isAscending) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (isAscending) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}
