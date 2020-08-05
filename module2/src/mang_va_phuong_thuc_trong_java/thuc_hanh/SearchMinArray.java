package mang_va_phuong_thuc_trong_java.thuc_hanh;

public class SearchMinArray {
    // Cài đặt nguyên mẫu phương thức
    public static int minValue(int[] array) {
        int min=array[0];
        for(int index:array){
            if(min>index){
                min=index;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int []arr = {4, 12, 7, 8, 1, 6, 9};
        int index = minValue(arr);
        System.out.println("The smallest element in the array is: " + index);
    }
}
