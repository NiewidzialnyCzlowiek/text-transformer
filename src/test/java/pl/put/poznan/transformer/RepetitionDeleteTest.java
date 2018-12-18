package pl.put.poznan.transformer;

import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.TransformRequestModel;
import pl.put.poznan.transformer.logic.TransformerService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepetitionDeleteTest {
    @Test
    public void noRepetitionsTest() {
        TransformRequestModel transformRequestModel = TransformRequestModel.builder()
                .text("ja do")
                .repetition_del(true)
                .build();

        TransformerService transformerService = new TransformerService();

        String transformed = transformerService.transform(transformRequestModel);
        assertEquals("ja do", transformed);
    }
    @Test
    public void singleRepetitionTest() {
        TransformRequestModel transformRequestModel = TransformRequestModel.builder()
                .text("ja do do")
                .repetition_del(true)
                .build();

        TransformerService transformerService = new TransformerService();

        String transformed = transformerService.transform(transformRequestModel);
        assertEquals("ja do", transformed);
    }
    @Test
    public void multipleRepetitionsTest() {
        TransformRequestModel transformRequestModel = TransformRequestModel.builder()
                .text("my mamy mamy coś w w w plecaku")
                .repetition_del(true)
                .build();

        TransformerService transformerService = new TransformerService();

        String transformed = transformerService.transform(transformRequestModel);
        assertEquals("my mamy coś w plecaku", transformed);
    }
    @Test
    public void repetitionsOnlyTest() {
        TransformRequestModel transformRequestModel = TransformRequestModel.builder()
                .text("ja ja ja ja ja ja ja")
                .repetition_del(true)
                .build();

        TransformerService transformerService = new TransformerService();

        String transformed = transformerService.transform(transformRequestModel);
        assertEquals("ja", transformed);
    }


}
