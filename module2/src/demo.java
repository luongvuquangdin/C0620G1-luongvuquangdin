public class demo {
    static public int X = 2;

    static class demo2{
        static void get(){
            System.out.println(demo.X);
        }
    }
    public static void main(String[] args) {
        demo o1 = new demo();
        demo o2 = new demo();
        o2.X = 5;
        System.out.printf("x=%d, y=%d, z=%d\n", o1.X, o2.X, demo.X);
        demo2.get();

    }
    }
