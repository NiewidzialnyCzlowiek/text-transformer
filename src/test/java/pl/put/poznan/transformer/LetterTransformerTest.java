package pl.put.poznan.transformer;

import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.TransformRequestModel;
import pl.put.poznan.transformer.logic.TransformerService;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LetterTransformerTest {
    @Test
    public void inverseTest() {
        TransformRequestModel transformRequestModel = TransformRequestModel.builder()
                .text("MirEk")
                .transformations(Arrays.asList("inverse"))
                .build();

        TransformerService transformerService = new TransformerService();

        String transformed = transformerService.transform(transformRequestModel);
        assertEquals("KerIm", transformed);
    }

    @Test
    public void capitalizeTest() {
        TransformRequestModel transformRequestModel = TransformRequestModel.builder()
                .text("raz dwa trzy cztery")
                .transformations(Arrays.asList("capitalize"))
                .build();

        TransformerService transformerService = new TransformerService();

        String transformed = transformerService.transform(transformRequestModel);
        assertEquals("Raz Dwa Trzy Cztery", transformed);
    }

    @Test
    public void upperTest() {
        TransformRequestModel transformRequestModel = TransformRequestModel.builder()
                .text("test")
                .transformations(Arrays.asList("upper"))
                .build();

        TransformerService transformerService = new TransformerService();

        String transformed = transformerService.transform(transformRequestModel);
        assertEquals("TEST", transformed);
    }

    @Test
    public void lowerTest() {
        TransformRequestModel transformRequestModel = TransformRequestModel.builder()
                .text("TesT")
                .transformations(Arrays.asList("lower"))
                .build();

        TransformerService transformerService = new TransformerService();

        String transformed = transformerService.transform(transformRequestModel);
        assertEquals("test", transformed);
    }

}
