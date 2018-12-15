package pl.put.poznan.transformer;

import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.TransformRequestModel;
import pl.put.poznan.transformer.logic.TransformerService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransformerServiceTest {
    @Test
    public void noTransformationsTest() {
        TransformerService transformerService = new TransformerService();
        TransformRequestModel transformRequestModel = TransformRequestModel.builder()
                .num_to_text(false)
                .repetition_del(false)
                .expand(false)
                .shrink(false)
                .latex(false)
                .transformations(new ArrayList<>())
                .text("Not to be transformed")
                .build();
        String response = transformerService.transform(transformRequestModel);
        assertEquals("Not to be transformed", response);
    }

    @Test
    public void allLetterTransformationsTest() {
        TransformerService transformerService = new TransformerService();
        List<String> transformations = new ArrayList<>();
        transformations.add("upper");
        transformations.add("lower");
        transformations.add("inverse");
        transformations.add("capitalize");
        TransformRequestModel transformRequestModel = TransformRequestModel.builder()
                .num_to_text(false)
                .repetition_del(false)
                .expand(false)
                .shrink(false)
                .latex(false)
                .transformations(transformations)
                .text("Use all letter transforms")
                .build();
        String response = transformerService.transform(transformRequestModel);
        assertEquals("Smrofsnart Rettel Lla Esu", response);
    }

    @Test
    public void allTransformationsNoLetterTransformsTest() {
        TransformerService transformerService = new TransformerService();
        List<String> transformations = new ArrayList<>();
        TransformRequestModel transformRequestModel = TransformRequestModel.builder()
                .num_to_text(true)
                .repetition_del(true)
                .expand(true)
                .shrink(true)
                .latex(true)
                .transformations(transformations)
                .text("Use all all 110 transforms, między innymi shrink Dr. expand and latex signs like % and &")
                .build();
        String response = transformerService.transform(transformRequestModel);
        assertEquals("Use all sto dziesięć transforms, m.in. shrink Doktor expand and latex signs like \\% and \\&", response);
    }
}
