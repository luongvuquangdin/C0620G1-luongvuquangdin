package xu_ly_ngoai_le_debug.bai_tap.su_dung_lop_illegaltriangleexception;

public class IllegalTriangleException extends Exception{
    String errorMessage;
    public IllegalTriangleException(String inError){
        this.errorMessage=inError;
    }
    public String getMessage(){
        return errorMessage;
    }
}
