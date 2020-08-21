package thuat_toan_tim_kiem.thuc_hanh.binary_search_khong_su_dung_de_quy;

public class BinarySearch {

    static int binarySearch(int[] list, int key) {
        int low=0;
        int high=list.length-1;
        while (low<=high) {
            int mid = (low + high) / 2;
            if (list[mid]==key)return mid;
            if (list[mid]>key){
                high=mid-1;
                continue;}
            low=mid+1;
        }
        return -1;

    }

}
