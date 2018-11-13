package pl.put.poznan.transformer.logic;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
class Transformer {
  /**
   * Transform text with 4 available options
   * @param text to be transformed
   * @param transformations list of transformations to be applied "upper" | "lower" | "capitalize" | "inverse"
   * @return transformed text
   */
  static String transform(String text, List<String> transformations) {
    if(transformations == null) {
      return text;
    }
    log.debug("Transformer invoked");

    for (String transformation : transformations) {
      if (transformation.equals("upper")) {
        text = text.toUpperCase();
      } else if (transformation.equals("lower")) {
        text = text.toLowerCase();
      } else if (transformation.equals("capitalize")) {
        text = Stream.of(text.trim().split("\\s"))
                .filter(word -> word.length() > 0)
                .map(word -> word.substring(0,1).toUpperCase() + word.substring(1))
                .collect(Collectors.joining(" "));
      } else if (transformation.equals("inverse")) {
        ArrayList<Integer> uppers = new ArrayList<>();
        int i = 0;
        for (Character letter : text.toCharArray()) {
          if(Character.isUpperCase(letter)) {
            uppers.add(i);
          }
          i++;
        }
        text = new StringBuilder(text).reverse().toString();
        text = text.toLowerCase();
        i = 0;
        StringBuilder sb = new StringBuilder();
        for (Character letter : text.toCharArray()) {
          if (uppers.contains(i)) {
            letter = Character.toUpperCase(letter);
          }
          sb.append(letter);
          i++;
        }
        text = sb.toString();
      }
    }
    log.debug(String.format("Transformer done, result: %s", text));
    return text;
  }
}
