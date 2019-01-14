package pl.put.poznan.transformer;

import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.TransformRequestModel;
import pl.put.poznan.transformer.logic.TransformerService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseWordsTest {
    @Test
    public void singleWordTest() {
        TransformRequestModel transformRequestModel = TransformRequestModel.builder()
                .text("word")
                .reverse(true)
                .build();

        TransformerService transformerService = new TransformerService();

        String transformed = transformerService.transform(transformRequestModel);
        assertEquals("drow", transformed);
    }

    @Test
    public void multipleWordsTest() {
        TransformRequestModel transformRequestModel = TransformRequestModel.builder()
                .text("words to reverse")
                .reverse(true)
                .build();

        TransformerService transformerService = new TransformerService();

        String transformed = transformerService.transform(transformRequestModel);
        assertEquals("sdrow ot esrever", transformed);
    }
}