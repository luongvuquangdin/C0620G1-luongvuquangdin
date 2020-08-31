package casestudy.furama_resort.Exception;

public class BirthdayException extends Exception {
    private String error;

    public BirthdayException(){
        this.error= "The year of birth must be> 1900 and 18 years less than the current year, in the correct format dd / mm / yyyy";
    }
    public BirthdayException(String string){
        super(string);
        this.error=string;
    }
    public String getError(){
        return this.error;
    }
}
