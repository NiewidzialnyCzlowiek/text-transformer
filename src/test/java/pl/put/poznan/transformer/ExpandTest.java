package pl.put.poznan.transformer;

import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.TransformRequestModel;
import pl.put.poznan.transformer.logic.TransformerService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpandTest {
    @Test
    public void nothingToExpandTest() {
        TransformRequestModel transformRequestModel = TransformRequestModel.builder()
                .text("nic do rozszerzenia")
                .expand(true)
                .build();

        TransformerService transformerService = new TransformerService();

        String transformed = transformerService.transform(transformRequestModel);
        assertEquals("nic do rozszerzenia", transformed);
    }

    @Test
    public void singleExpandTest() {
        TransformRequestModel transformRequestModel = TransformRequestModel.builder()
                .text("Prof. Kowalski")
                .expand(true)
                .build();

        TransformerService transformerService = new TransformerService();

        String transformed = transformerService.transform(transformRequestModel);
        assertEquals("Profesor Kowalski", transformed);
    }

    @Test
    public void multipleExpandTest() {
        TransformRequestModel transformRequestModel = TransformRequestModel.builder()
                .text("Prof. Dr. Kowalski")
                .expand(true)
                .build();

        TransformerService transformerService = new TransformerService();

        String transformed = transformerService.transform(transformRequestModel);
        assertEquals("Profesor Doktor Kowalski", transformed);
    }

    @Test
    public void allAvailableExpandsTest() {
        TransformRequestModel transformRequestModel = TransformRequestModel.builder()
                .text("prof. nie jest np. Dr. ITP.")
                .expand(true)
                .build();

        TransformerService transformerService = new TransformerService();

        String transformed = transformerService.transform(transformRequestModel);
        assertEquals("profesor nie jest na przykład Doktor I Tym Podobne", transformed);
    }
}
