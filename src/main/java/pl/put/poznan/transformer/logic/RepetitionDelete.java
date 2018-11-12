package pl.put.poznan.transformer.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class RepetitionDelete {

    static String repetitionDelete(String text, boolean repetition_del) {
        if(!repetition_del) return text;


        List<String> words = Arrays.asList(text.split("\\s"));
        List<String> trans = new ArrayList<String>();
        trans.add(words.get(0));
        for( int i = 1; i< words.size(); i++){
            if(!words.get(i-1).equals(words.get(i))){
                trans.add(words.get(i));
            }
        }

        text = String.join(" ", trans);

        return text;
    }
}