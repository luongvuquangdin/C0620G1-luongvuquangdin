package thuat_toan_tim_kiem.bai_tap.cai_dat_thuat_toan_su_dung_de_quy;

public class BinarySearch {

    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int index = binarySearch(arr, key, low, high);
        return index;
    }

    private static int binarySearch(int[] arr, int key, int low, int high) {
        int mid=-1;
        if (low <= high) {
             mid = (low + high) / 2;
            if (arr[mid] == key) return mid;
            if (arr[mid] > key) {
                high = mid - 1;
                mid=binarySearch(arr, key, low, high);
            } else {
                if (arr[mid] < key) {
                    low = mid + 1;
                    mid=binarySearch(arr, key, low, high);
                }
            }
        }
        return mid;
    }
}
