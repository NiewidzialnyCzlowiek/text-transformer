package pl.put.poznan.transformer;

import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.TransformRequestModel;
import pl.put.poznan.transformer.logic.TransformerService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShrinkTest {
    @Test
    public void noShrinkTest() {
        TransformRequestModel transformRequestModel = TransformRequestModel.builder()
                .text("nothing to transform")
                .shrink(true)
                .build();

        TransformerService transformerService = new TransformerService();

        String transformed = transformerService.transform(transformRequestModel);
        assertEquals("nothing to transform", transformed);
    }

    @Test
    public void singleShrinkTest() {
        TransformRequestModel transformRequestModel = TransformRequestModel.builder()
                .text("ptaki na przykład sowa")
                .shrink(true)
                .build();

        TransformerService transformerService = new TransformerService();

        String transformed = transformerService.transform(transformRequestModel);
        assertEquals("ptaki np. sowa", transformed);
    }

    @Test
    public void multipleShrinkTest() {
        TransformRequestModel transformRequestModel = TransformRequestModel.builder()
                .text("ptaki na przykład sowa oraz między Innymi czajka I Tym Podobne")
                .shrink(true)
                .build();

        TransformerService transformerService = new TransformerService();

        String transformed = transformerService.transform(transformRequestModel);
        assertEquals("ptaki np. sowa oraz m.In. czajka ITP.", transformed);
    }

}
