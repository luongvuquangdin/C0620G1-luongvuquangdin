package vong_lap_trong_java.bai_tap;

public class HienThi20SNT {
    public static void main(String[] args) {
        int soNT = 2;
        boolean kiemTraSNT;
        for (int i = 0; i < 20;) {
            kiemTraSNT = true;
            for (int dem = 2; dem < soNT; dem++) {
                if (soNT % dem == 0) {
                    kiemTraSNT = false;
                    break;
                }
            }
            if (kiemTraSNT == true) {
                System.out.println(soNT);
                i++;
            }
            soNT++;
        }
    }
}
