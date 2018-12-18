package pl.put.poznan.transformer.logic;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransformerService {
    public String transform(TransformRequestModel requestModel) {
        Transformer transformer = new TextTransformer();
        transformer = requestModel.isRepetition_del() ? new RepetitionDeleteDecorator(transformer) : transformer;
        transformer = requestModel.isNum_to_text() ? new NumToTextDecorator(transformer) : transformer;
        transformer = requestModel.isExpand() ? new ExpandDecorator(transformer) : transformer;
        transformer = requestModel.isShrink() ? new ShrinkDecorator(transformer) : transformer;
        transformer = requestModel.isLatex() ? new LatexDecorator(transformer) : transformer;
        transformer = new LetterTransformerDecorator(transformer, requestModel.getTransformations());

        return transformer.transform(requestModel.getText());
    }
}
