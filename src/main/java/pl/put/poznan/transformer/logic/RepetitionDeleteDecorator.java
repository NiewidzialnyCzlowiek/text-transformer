package pl.put.poznan.transformer.logic;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Class responsible for performing repetition delete transformations
 */
@Slf4j
class RepetitionDeleteDecorator extends TransformerDecorator {

  public RepetitionDeleteDecorator(Transformer transformer) {
    super(transformer);
  }

    /**
     * Delete repeating words next to each other
     * @param text string to be transformed
     * @return deduped string
     */
     public String transform(String text) {
       log.debug("Repetition delete invoked");
       text = transformer.transform(text);

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