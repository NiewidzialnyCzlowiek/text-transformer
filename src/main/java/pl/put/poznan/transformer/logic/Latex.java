package pl.put.poznan.transformer.logic;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;

@Slf4j
class Latex {
  /**
   * Returns String with specified characters transformed to Latex syntax
   * @param text containing characters to transform
   * @param latex whether to transform or not
   * @return transformed text
   */
    static String latex(String text, boolean latex) {
        log.debug("Latex invoked...");
        if (!latex) return text;
        char[] latexSigns = {'%', '&'};
        for (char latexSign : latexSigns) {
            String regex = "[" + latexSign + "]";
             text = text.replaceAll(regex, Matcher.quoteReplacement("\\") + latexSign);
        }
        return text;
    }
}