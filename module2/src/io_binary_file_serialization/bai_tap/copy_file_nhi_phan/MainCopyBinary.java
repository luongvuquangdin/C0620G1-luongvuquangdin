package io_binary_file_serialization.bai_tap.copy_file_nhi_phan;

import java.io.*;
import java.util.Scanner;

public class MainCopyBinary {
    private static void copyFileUsingStream(File fileSource,File fileDest) throws IOException {
        InputStream fileInputStream=null;
        OutputStream fileOutputStream=null;
        try{
            fileInputStream=new FileInputStream(fileSource);
            fileOutputStream=new FileOutputStream(fileDest);
            byte[] data=new byte[1024];
            int length;
            int count = 0;
            String str;
            while ((length=fileInputStream.read(data))>0){
                str=new String(data,0,length);
                System.out.println(str);
                fileOutputStream.write(data,0,length);
                count+=length;
                str=null;
                fileOutputStream.flush();
            }
            System.out.println("File Dest have "+count+" byte");
        }finally {
            if (fileInputStream!=null){
                fileInputStream.close();
            }
            if (fileOutputStream!=null){
                fileOutputStream.close();
            }

        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.printf("Enter source file:");
        String sourcePath = in.nextLine();
        System.out.printf("Enter destination file:");
        String destPath = in.nextLine();

        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        try {
            copyFileUsingStream(sourceFile,destFile);
        } catch (IOException ioe) {
            System.out.printf("Can't copy that file");
            System.out.printf(ioe.getMessage());
        }
    }
    }
