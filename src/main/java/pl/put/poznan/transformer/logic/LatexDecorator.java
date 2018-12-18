package pl.put.poznan.transformer.logic;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
/**
 * Class responsible for performing latex transformations
 */
@Slf4j
class LatexDecorator extends TransformerDecorator {

  public LatexDecorator(Transformer transformer) {
    super(transformer);
  }

  /**
   * Returns String with specified characters transformed to Latex syntax
   * @param text containing characters to transform
   * @return transformed text
   */
    public String transform(String text) {
        log.debug("Latex invoked");
        text = transformer.transform(text);

        char[] latexSigns = {'%', '&'};
        for (char latexSign : latexSigns) {
            String regex = "[" + latexSign + "]";
             text = text.replaceAll(regex, Matcher.quoteReplacement("\\") + latexSign);
        }
        log.debug(String.format("Latex done, result: %s", text));
        return text;
    }
}
