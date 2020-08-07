package lop_va_doi_tuong_trong_java.bai_tap;

public class Fan {
    static class Fan1 {
        //Tốc độ quạt
        private final int SLOW = 1;
        private final int MEDIUM = 2;
        private final int FAST = 3;
        //Xác định tốc độ mặc định là slow là 1
        private int speed = this.SLOW;
        //Quạt bật hay tắc mặc định tắt
        private boolean on = false;
        //Bán kính của quạt mặt định là 5
        private double radius = 5;
        //Màu của quạt mặt định là màu xanh
        private String color = "blue";
//Get và Set
        public void toString1(){
            if (on==false){
                System.out.printf("Color= %s\nRadius = %f\nFan is off",color,radius);
            }else {
                System.out.printf("Speed= %d\nColor= %s\nRadius = %f\n" +
                        "Fan is on",speed,color,radius);
            }
        }

        public int getSLOW() {
            return SLOW;
        }

        public int getMEDIUM() {
            return MEDIUM;
        }

        public int getFAST() {
            return FAST;
        }

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public boolean isOn() {
            return on;
        }

        public void setOn(boolean on) {
            this.on = on;
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }

    public static void main(String[] args) {
            Fan1 fan= new Fan1();
            fan.setSpeed(3);
            fan.setRadius(10);
            fan.setColor("yelow");
            fan.setOn(true);
            Fan1 fan1= new Fan1();
            fan1.setSpeed(2);

    }
}
