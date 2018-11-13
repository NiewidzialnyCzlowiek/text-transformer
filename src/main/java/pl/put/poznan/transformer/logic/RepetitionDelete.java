package pl.put.poznan.transformer.logic;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Slf4j
class RepetitionDelete {

    /**
     * Delete repeating words next to each other
     * @param text string to be transformed
     * @param repetition_del whether to dedup or not
     * @return deduped string
     */
    static String repetitionDelete(String text, boolean repetition_del) {
        if(!repetition_del) return text;
        log.debug("Repetition delete invoked");

        List<String> words = Arrays.asList(text.split("\\s"));
        List<String> trans = new ArrayList<String>();
        trans.add(words.get(0));
        for( int i = 1; i< words.size(); i++){
            if(!words.get(i-1).equals(words.get(i))){
                trans.add(words.get(i));
            }
        }

        text = String.join(" ", trans);
        log.debug(String.format("Latex done, result: %s", text));
        return text;
    }
}