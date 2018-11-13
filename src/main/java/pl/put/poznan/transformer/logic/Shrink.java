package pl.put.poznan.transformer.logic;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j
class Shrink {
  /**
   * Return string with words shrinked to abbreviations
   * @param text with abbreviations to be shrinked
   * @param shrink whether to shrink or not
   * @return transformed text with words shrinked to their abbreviations
   */
  static String shrink(String text, boolean shrink) {
    log.debug("Shrinking invoked...");
    if (!shrink) return text;

    HashMap<String, String> abbrvsMap = new HashMap<>();
    abbrvsMap.put("na przykład", "np.");
    abbrvsMap.put("Na przykład", "Np.");
    abbrvsMap.put("na Przykład", "nP.");
    abbrvsMap.put("między innymi", "m.in.");
    abbrvsMap.put("Między innymi", "M.in.");
    abbrvsMap.put("między Innymi", "m.In.");
    abbrvsMap.put("Między Innymi", "M.In.");
    abbrvsMap.put("i tym podobne", "itp.");
    abbrvsMap.put("I tym podobne", "Itp.");
    abbrvsMap.put("i Tym podobne", "iTp.");
    abbrvsMap.put("i tym Podobne", "itP.");
    abbrvsMap.put("I Tym podobne", "ITp.");
    abbrvsMap.put("i Tym Podobne", "iTP.");
    abbrvsMap.put("I tym Podobne", "IiP.");
    abbrvsMap.put("I Tym Podobne", "ITP.");

    for(String word: abbrvsMap.keySet()) {
      text = text.replaceAll(word, abbrvsMap.get(word));
    }
    return text;
  }

}
