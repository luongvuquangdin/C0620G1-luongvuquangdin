package inheritance.bai_tap;

public class MovablePoint extends Point2D{
    private float xSpeed=0.0f;
    private float ySpeed=0.0f;
    public MovablePoint(){
    }
    public MovablePoint(float xSpeed,float ySpeed){
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;
    }
    public MovablePoint(float xSpeed,float ySpeed,float x, float y){
        super(x,y);
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;
    }

    public void setSpeed(float xSpeed,float ySpeed){
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;
    }
    public float[] getSpeed(){
        return new float[]{xSpeed,ySpeed};
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float XSpeed) {
        this.xSpeed = XSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float YSpeed) {
        this.ySpeed = YSpeed;
    }
    @Override
    public String toString(){
        return "( "+getX()+" , "+getY()+" ), speed=( "+xSpeed+" , "+ySpeed+" )";
    }
    public MovablePoint move(){
        float x=getX();
        x+=xSpeed;
        float y=getY();
        y+=ySpeed;
        setX(x);
        setY(y);
        return this;
    }
}

//class Test{
//    public static void main(String[] args) {
//        MovablePoint ab= new MovablePoint();
//        ab.setX(1);
//        ab.setY(1);
//        ab.setSpeed(1,1);
//        ab.move();
//        System.out.println(ab);
//    }
//}