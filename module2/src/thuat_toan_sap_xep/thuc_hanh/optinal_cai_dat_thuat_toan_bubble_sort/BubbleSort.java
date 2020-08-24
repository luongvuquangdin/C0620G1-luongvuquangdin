package thuat_toan_sap_xep.thuc_hanh.optinal_cai_dat_thuat_toan_bubble_sort;

public class BubbleSort {
    public static void sort(int[] arr){
        boolean check=true;
        for (int i=1;i<arr.length&check;i++){
            check=false;
            for (int j=0;j<arr.length-i;i++){
                if (arr[j]<arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    check=true;
                }
            }
        }
    }
}
