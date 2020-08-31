package casestudy.furama_resort.Exception;

public class IdCardException extends Exception {
    private String error;

    public IdCardException(){
        this.error= "The IdCard must have 9 digits and be in XXX XXX XXX format";
    }
    public IdCardException(String string){
        super(string);
        this.error=string;
    }
    public String getError(){
        return this.error;
    }
}
