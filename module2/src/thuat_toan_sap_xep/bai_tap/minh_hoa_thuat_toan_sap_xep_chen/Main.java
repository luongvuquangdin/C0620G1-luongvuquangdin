package thuat_toan_sap_xep.bai_tap.minh_hoa_thuat_toan_sap_xep_chen;

public class Main {
    public static void main(String[] args) {
        int[] list = {5,4,2,3,6,1,5};
        System.out.println("Mảng ban đầu là: ");
        for (int element:list){
            System.out.print(element+" ");
        }
        InsertionSort.insertionSort(list);
        System.out.println("Mảng sau khi sắp xếp là:");
        for (int element:list){
            System.out.print(element+" ");
        }

    }
}
