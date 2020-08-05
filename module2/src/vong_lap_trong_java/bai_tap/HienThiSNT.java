package vong_lap_trong_java.bai_tap;
//Hiển thị số nguyên tố nhỏ hơn 100
public class HienThiSNT {
    public static void main(String[] args){
        int soNT=2;
        boolean kiemTraSNT;
        while (soNT<100){
            kiemTraSNT=true;
            for (int dem=2;dem<soNT;dem++){
                if (soNT%dem==0){
                    kiemTraSNT=false;
                    break;
                }
            }
            if (kiemTraSNT==true){
                System.out.println(soNT);
            }
            soNT++;
        }
    }
}
