package lop_va_doi_tuong_trong_java.bai_tap;

public class QuadraticEquation {
    //Phương trình ax^2+bx+c=0
    private double a;
    private double b;
    private double c;

//Constructor
    public QuadraticEquation(double a, double b, double c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
//Tính detal
    public double getDiscriminant(){
        return (this.b-(4*this.a*this.c));
    }
//Trả về nghiệm
    public double getRoot1(){
        if (this.getDiscriminant()<0){
            return 0;
        }
        return ((-this.b+Math.sqrt(Math.pow(this.b,2)-4*this.a*this.c))/2*this.a);
    }
    public double getRoot2(){
        if (this.getDiscriminant()<0){
            return 0;
        }
        return ((-this.b-Math.sqrt(this.b*this.b-4*this.a*this.c))/2*this.a);
    }
//Get và Set
    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
}
