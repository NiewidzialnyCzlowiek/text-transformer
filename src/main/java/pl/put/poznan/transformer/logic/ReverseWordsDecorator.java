package pl.put.poznan.transformer.logic;

import lombok.extern.slf4j.Slf4j;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class responsible for reversing words
 */
@Slf4j
public class ReverseWordsDecorator extends TransformerDecorator {
    ReverseWordsDecorator(Transformer transformer) {
        super(transformer);
    }

    /**
     * Returns String with reversed words
     *
     * @param text with words to be reversed
     * @return transformed text
     */
    public String transform(String text) {
        text = transformer.transform(text);
        log.debug("Reverse words invoked");
        return String.join(" ",
                Stream.of(text.split("\\s"))
                .map(this::reverseWord)
                .collect(Collectors.toList()));
    }

    public String reverseWord(String word) {
        StringBuilder builder = new StringBuilder(word.trim());
        return builder.reverse().toString();
    }
}
