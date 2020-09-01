package demo;

import casestudy.furama_resort.models.Villa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidatorDemo {
    public static void main(String[] args) {
        Queue<Integer> villas=new ArrayDeque<>(3);
        Integer i=1;
        while (villas.size()<3){
            villas.add(i);
            i++;
        }
        for (Integer t:villas){
            System.out.println(t);
        }
        }
    }