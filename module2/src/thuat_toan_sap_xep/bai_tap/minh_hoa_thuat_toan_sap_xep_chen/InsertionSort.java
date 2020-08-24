package thuat_toan_sap_xep.bai_tap.minh_hoa_thuat_toan_sap_xep_chen;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        //xét từ vị trí 1 đến cuối mảng
        for (int i = 1; i < arr.length; i++) {
            //Hiển thị lần sắp xếp
            System.out.println("Thực hiện lần thứ " + i + " :");
            //Xét mảng nhỏ từ vị trí i xuống vị trí kề cuối
            for (int j = i; j >= 1; j--) {
                if (arr[j] < arr[j - 1]) {
                    System.out.println("Swap " + arr[j] + " với " + arr[j - 1]);
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    //hiển thị mảng
                    System.out.print("Mảng sau khi swap: ");
                    for (int element : arr) {
                        System.out.print(element + " ");
                    }
                    System.out.println();
                } else {
                    System.out.println("Vì element " + arr[j] + " lớn hơn hoặc bằng " + arr[j - 1] + " nên dừng");
                    System.out.println("Mảng không thay đổi gì: ");
                    //Hiển thị mảng rồi thoát vòng lăp for
                    for (int element:arr){
                        System.out.print(element+" ");
                    }
                    System.out.println();
                    break;
                }
            }
        }
    }
}
