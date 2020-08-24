package thuat_toan_sap_xep.thuc_hanh.minh_hoa_thuat_toan_sap_xep_chon;

public class SelectionSort {
    public static void selectionSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            //min là vị trí đầu tiên i
            int min=list[i];
            int minIndex=i;
            for (int j = i+1; j < list.length; j++) {
                if (min > list[j]) {
                    min=list[j];
                    minIndex=j;
                }
            }
            if (minIndex!=i){
                System.out.println("Đổi chỗ của phần tử "+list[i]+" và phần tử "+list[minIndex]);
                list[minIndex]=list[i];
                list[i]=min;
            }else System.out.println("vì phẩn tử "+list[i]+" là nhỏ nhất so với các phần tử còn lại ở phía sau nên giữ nguyên");

            System.out.println("Mảng sau khi đổi chổ lần thứ "+(i+1));
            for (int element:list){
                System.out.print(element+" ");
            }
            System.out.println("\n-----------------------");


            /* Swap list[i] with list[currentMinIndex] if necessary */
        }
    }
}
