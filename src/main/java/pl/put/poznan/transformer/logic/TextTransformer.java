package pl.put.poznan.transformer.logic;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class TextTransformer {
    public String transform(TransformRequestModel requestModel) {
        String text = requestModel.getText();
        List<String> texts = Arrays.asList(text);

        List<String> transformed = texts.stream()
                .map(t -> toUpper(t, requestModel.getTransformations()))
                .map(t -> shrink(t, requestModel.isShrink()))
                .map(t -> expand(t, requestModel.isExpand()))
                .collect(Collectors.toList());

        return transformed.get(0);

    }

    String shrink(String text, boolean shrink) {
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

    String expand(String text, boolean expand) {
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

    String toUpper(String text, List<String> transformations) {
        if(transformations == null) {
            return text;
        }

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
        return text;
    }


}
