package thuat_toan_sap_xep.bai_tap.cai_dat_thuat_toan_sắp_xếp_chen;

public class InsertionSort {
    public static void sort(int[] arr){
        for (int i=1;i<arr.length;i++){
            int j=i-1;
            int temp=arr[i];
            for (;j>=0&&temp<arr[j];j--){
                arr[j+1]=arr[j];
            }
        }
    }
}
