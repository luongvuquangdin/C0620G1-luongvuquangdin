package io_text_file.bai_tap.copy_file_text;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        File fileSource=new File("text.txt");
        File fileTarget=new File("text1.txt");
        CopyFileText.copy(fileSource,fileTarget);
    }
}
