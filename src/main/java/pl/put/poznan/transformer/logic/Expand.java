package pl.put.poznan.transformer.logic;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
class Expand {
  /**
   * Returns String with expanded abbreviations
   * @param text with abbreviations to be expanded
   * @param expand whether to expand or not
   * @return transformed text
   */
   static String expand(String text, boolean expand) {
    log.debug("Expand invoked...");
    if (!expand) return text;

    HashMap<String, String> abbrvsMap = new HashMap<>();
    abbrvsMap.put("prof.", "profesor");
    abbrvsMap.put("Prof.", "Profesor");
    abbrvsMap.put("dr.", "doktor");
    abbrvsMap.put("Dr.", "Doktor");
    abbrvsMap.put( "np.", "na przykład");
    abbrvsMap.put( "Np.", "Na przykład");
    abbrvsMap.put( "nP.", "na Przykład");
    abbrvsMap.put("itp.", "i tym podobne");
    abbrvsMap.put("Itp.", "I tym podobne");
    abbrvsMap.put("iTp.", "i Tym podobne");
    abbrvsMap.put("itP.", "i tym Podobne");
    abbrvsMap.put("ITp.", "I Tym podobne");
    abbrvsMap.put("iTP.", "i Tym Podobne");
    abbrvsMap.put("IiP.", "I tym Podobne");
    abbrvsMap.put("ITP.", "I Tym Podobne");

    List<String> abbrvs = Stream.of(text.trim().split("\\s"))
            .filter(abbrvsMap::containsKey)
            .collect(Collectors.toList());

    for (String abbvr : abbrvs) {
      text = text.replaceAll(abbvr, abbrvsMap.get(abbvr));
    }
    return text;
  }
}
