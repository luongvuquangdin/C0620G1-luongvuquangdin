package xu_ly_ngoai_le_debug.thuc_hanh.su_dung_lop_ArrayIndexOutOfBoundsException;

import java.util.Random;

public class ArrayExample {
    public Integer[] createRandom() {
        Random rd = new Random();
        Integer[] arr = new Integer[10];
        System.out.println("Danh sách phần tử của mảng: " );
        for (int i = 0; i < 10; i++) {
            arr[i] = rd.nextInt(10);
            System.out.print(arr[i]+ " ");
        }
        return arr;
    }

}
