package thuat_toan_sap_xep.thuc_hanh.minh_hoa_thuat_toan_sap_xep_noi_bot;

public class chon {
    public void sort(int[] arr) {
        boolean check=true;
        for (int j = 1; j < arr.length&check; j++) {
            check=false;
            for (int i = 0; i < arr.length-j; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    check=true;
                }
            }
        }
    }
}
