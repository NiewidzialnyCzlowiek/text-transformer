package pl.put.poznan.transformer.logic;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class Latex {
  /**
   * Returns String with specified characters transformed to Latex syntax
   * @param text containing characters to transform
   * @param latex whether to transform or not
   * @return transformed text
   */
    static String latex(String text, boolean latex) {
        if (!latex) return text;
        log.debug("Latex invoked");

        char[] latexSigns = {'%', '&'};
        for (char latexSign : latexSigns) {
            String regex = "[" + latexSign + "]";
            text.replaceAll(regex, "\\" + latexSign);
        }
        log.debug(String.format("Latex done, result: %s", text));
        return text;
    }
}