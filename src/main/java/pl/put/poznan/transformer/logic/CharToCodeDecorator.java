package pl.put.poznan.transformer.logic;

import lombok.extern.slf4j.Slf4j;

/**
 * Class responsible for performing character to character code transformation
 */
@Slf4j
public class CharToCodeDecorator extends TransformerDecorator {
    CharToCodeDecorator(Transformer transformer) {
        super(transformer);
    }
    /**
     * Returns String with characters transformed to UTF-8 codes
     * @param text to be transformed
     * @return transformed text
     */
    public String transform(String text) {
        String coded = "";
        log.debug("CharToCode invoked");
        this.transformer.transform(text);
        for (char c : text.toCharArray()) {
            coded += transformChar(c);
        }
        return coded;
    }

    public String transformChar(char c) {
        return String.format("\\u%04x;", (int) c);
    }
}
