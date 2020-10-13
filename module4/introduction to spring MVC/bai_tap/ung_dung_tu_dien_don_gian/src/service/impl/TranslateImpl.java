package service.impl;

import entity.Vocabulary;
import org.springframework.stereotype.Service;
import service.Translate;

import java.util.ArrayList;
import java.util.List;

@Service
public class TranslateImpl implements Translate {
    private static List<Vocabulary> vocabularyList=new ArrayList<>();

    static {
        vocabularyList.add(new Vocabulary("pattern","mẫu"));
        vocabularyList.add(new Vocabulary("inversion","đảo ngược"));
        vocabularyList.add(new Vocabulary("dependency","sự phụ thuộc"));
        vocabularyList.add(new Vocabulary("injection","tiêm"));
        vocabularyList.add(new Vocabulary("dispatcher","điều phối"));
        vocabularyList.add(new Vocabulary("forward","đằng trước"));
        vocabularyList.add(new Vocabulary("redirect","chuyển hướng"));
    }
    @Override
    public String translate(String english) {
        String message = "not found";
        for (Vocabulary vocabulary:vocabularyList){
            if (vocabulary.getEnglish().equals(english)){
                message=vocabulary.getMeanVietNamese();
            }
        }
        return message;
    }
}
