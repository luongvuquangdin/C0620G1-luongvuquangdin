package inheritance.bai_tap;
import java.util.ArrayList;
import java.util.Arrays;

public class Point3D extends Point2D {
    private float z=0.0f;
    public Point3D(){
    }
    public Point3D(float x, float y, float z){
        super(x, y);
        this.z=z;
    }
    public void setXYZ(float x, float y, float z){
        super.setXY(x, y);
        setZ(z);
    }
    public float[] getXYZ(){
        float[] arr=new float[3];
        System.arraycopy(super.getXY(),0,arr,0,3);
        return arr;


    }
    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    @Override
    public String toString(){
        return super.toString()+" Z= "+z;
    }
}
