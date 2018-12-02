package pl.put.poznan.transformer.logic;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class responsible for performing expand transformations
 */
@Slf4j
class ExpandDecorator extends TransformerDecorator{

 public ExpandDecorator(Transformer transformer) {
  super(transformer);
 }

 /**
   * Returns String with expanded abbreviations
   * @param text with abbreviations to be expanded
   * @return transformed text
   */
   public String transform(String text) {
    log.debug("Expand invoked");
    text = transformer.transform(text);

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
    log.debug(String.format("Expand done, result: %s", text));
    return text;
  }
}
