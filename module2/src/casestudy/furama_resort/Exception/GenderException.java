package casestudy.furama_resort.Exception;

public class GenderException extends Exception {
    private String error;

    public GenderException(){
        this.error= "Enter Male, Female or Unknow";
    }
    public GenderException(String string){
        super(string);
        this.error=string;
    }
    public String getError(){
        return this.error;
    }
}
