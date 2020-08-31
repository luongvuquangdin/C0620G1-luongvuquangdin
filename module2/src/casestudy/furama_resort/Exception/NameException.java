package casestudy.furama_resort.Exception;

import string__regex.bai_tap.validate_ten_cua_lop_hoc.NameClass;

public class NameException extends Exception{
    private String error;

    public NameException(){
        this.error= "capitalizes the first character and does not allow extra space characters";
    }
    public NameException(String string){
        super(string);
        this.error=string;
    }
    public String getError(){
        return this.error;
    }
}
