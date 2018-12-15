package pl.put.poznan.transformer;

import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.TransformRequestModel;
import pl.put.poznan.transformer.logic.TransformerService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumToTextTest {
    @Test
    public void singleDigitTest() {
        TransformRequestModel transformRequestModel = TransformRequestModel.builder()
                .text("7")
                .num_to_text(true)
                .build();

        TransformerService transformerService = new TransformerService();

        String transformed = transformerService.transform(transformRequestModel);
        assertEquals("siedem", transformed);
    }

    @Test
    public void multipleDigitsTest() {
        TransformRequestModel transformRequestModel = TransformRequestModel.builder()
                .text("9 8 7 6 5 4 3 2 1")
                .num_to_text(true)
                .build();

        TransformerService transformerService = new TransformerService();

        String transformed = transformerService.transform(transformRequestModel);
        assertEquals("dziewięć osiem siedem sześć pięć cztery trzy dwa jeden", transformed);
    }
    @Test
    public void twoDigitSmallTest() {
        TransformRequestModel transformRequestModel = TransformRequestModel.builder()
                .text("14")
                .num_to_text(true)
                .build();

        TransformerService transformerService = new TransformerService();

        String transformed = transformerService.transform(transformRequestModel);
        assertEquals("czternaście", transformed);
    }

    @Test
    public void twoDigitLargeTest() {
        TransformRequestModel transformRequestModel = TransformRequestModel.builder()
                .text("39")
                .num_to_text(true)
                .build();

        TransformerService transformerService = new TransformerService();

        String transformed = transformerService.transform(transformRequestModel);
        assertEquals("trzydzieści dziewięć", transformed);
    }

    @Test
    public void threeDigitTest() {
        TransformRequestModel transformRequestModel = TransformRequestModel.builder()
                .text("832")
                .num_to_text(true)
                .build();

        TransformerService transformerService = new TransformerService();

        String transformed = transformerService.transform(transformRequestModel);
        assertEquals("osiemset trzydzieści dwa", transformed);
    }

    @Test
    public void minNumberTest() {
        TransformRequestModel transformRequestModel = TransformRequestModel.builder()
                .text("1")
                .num_to_text(true)
                .build();

        TransformerService transformerService = new TransformerService();

        String transformed = transformerService.transform(transformRequestModel);
        assertEquals("jeden", transformed);
    }
    @Test
    public void maxNumberTest() {
        TransformRequestModel transformRequestModel = TransformRequestModel.builder()
                .text("9999")
                .num_to_text(true)
                .build();

        TransformerService transformerService = new TransformerService();

        String transformed = transformerService.transform(transformRequestModel);
        assertEquals("dziewięć tysięcy dziewięćset dziewiędziesiąt dziewięć", transformed);
    }
}
