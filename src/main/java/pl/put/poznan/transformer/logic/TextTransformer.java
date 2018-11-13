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
                .map(t -> RepetitionDelete.repetitionDelete(t, requestModel.isRepetition_del()))
                .map(NumToText::toText)
                .map(t -> Expand.expand(t, requestModel.isExpand()))
                .map(t -> Shrink.shrink(t, requestModel.isShrink()))
                .map(t -> Transformer.transform(t, requestModel.getTransformations()))
                .map(t -> Latex.latex(t, requestModel.isLatex()))
                .collect(Collectors.toList());

        return transformed.get(0);

    }
}
