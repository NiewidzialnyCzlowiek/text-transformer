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
    @Test
    public void shortToCodeTest() {
        TransformRequestModel transformRequestModel = TransformRequestModel.builder()
                .text("malo")
                .transformations(Arrays.asList("toCode"))
                .build();

        TransformerService transformerService = new TransformerService();

        String transformed = transformerService.transform(transformRequestModel);
        assertEquals("\\u006d;\\u0061;\\u006c;\\u006f;", transformed);
    }
    @Test
    public void toCodeWithSpacesTest() {
        TransformRequestModel transformRequestModel = TransformRequestModel.builder()
                .text("malo tekstu ")
                .transformations(Arrays.asList("toCode"))
                .build();

        TransformerService transformerService = new TransformerService();

        String transformed = transformerService.transform(transformRequestModel);
        assertEquals("\\u006d;\\u0061;\\u006c;\\u006f;\\u0020;\\u0074;\\u0065;\\u006b;\\u0073;\\u0074;\\u0075;\\u0020;", transformed);
    }
    @Test
    public void singleWordTest() {
        TransformRequestModel transformRequestModel = TransformRequestModel.builder()
                .text("word")
                .transformations(Arrays.asList("wordReverse"))
                .build();

        TransformerService transformerService = new TransformerService();

        String transformed = transformerService.transform(transformRequestModel);
        assertEquals("drow", transformed);
    }

    @Test
    public void multipleWordsTest() {
        TransformRequestModel transformRequestModel = TransformRequestModel.builder()
                .text("words to reverse")
                .transformations(Arrays.asList("wordReverse"))
                .build();

        TransformerService transformerService = new TransformerService();

        String transformed = transformerService.transform(transformRequestModel);
        assertEquals("sdrow ot esrever", transformed);
    }
}
