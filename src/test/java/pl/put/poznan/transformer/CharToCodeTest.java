package pl.put.poznan.transformer;

import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.TransformRequestModel;
import pl.put.poznan.transformer.logic.TransformerService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharToCodeTest {
    @Test
    public void shortTextToCodeTest() {
        TransformRequestModel transformRequestModel = TransformRequestModel.builder()
                .text("malo")
                .codes(true)
                .build();

        TransformerService transformerService = new TransformerService();

        String transformed = transformerService.transform(transformRequestModel);
        assertEquals("\\u006d;\\u0061;\\u006c;\\u006f;", transformed);
    }
    @Test
    public void shortTextWithSpacesTest() {
        TransformRequestModel transformRequestModel = TransformRequestModel.builder()
                .text("malo tekstu ")
                .codes(true)
                .build();

        TransformerService transformerService = new TransformerService();

        String transformed = transformerService.transform(transformRequestModel);
        assertEquals("\\u006d;\\u0061;\\u006c;\\u006f;\\u0020;\\u0074;\\u0065;\\u006b;\\u0073;\\u0074;\\u0075;\\u0020;", transformed);
    }
}
