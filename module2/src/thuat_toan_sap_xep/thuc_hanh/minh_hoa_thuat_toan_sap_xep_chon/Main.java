package thuat_toan_sap_xep.thuc_hanh.minh_hoa_thuat_toan_sap_xep_chon;

public class Main {
    public static void main(String[] args) {
        int[] list = {5,4,2,3,6,1};
        System.out.println("Mảng ban đầu là: ");
        for (int element:list){
            System.out.print(element+" ");
        }
        System.out.println("\nMô tả thuật toán");
        SelectionSort.selectionSort(list);
        System.out.println("Mảng sau khi sắp xếp là:");
        for (int element:list){
            System.out.print(element+" ");
        }

    }
}
