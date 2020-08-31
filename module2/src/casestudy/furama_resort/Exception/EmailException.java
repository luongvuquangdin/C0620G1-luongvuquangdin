package casestudy.furama_resort.Exception;

public class EmailException extends Exception{
    private String error;

    public EmailException(){
        this.error= "Email should be in the correct format abc@abc.abc";
    }
    public EmailException(String string){
        super(string);
        this.error=string;
    }
    public String getError(){
        return this.error;
    }
}
