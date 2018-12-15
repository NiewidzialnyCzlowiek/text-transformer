package pl.put.poznan.transformer;

import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.TransformRequestModel;
import pl.put.poznan.transformer.logic.TransformerService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LatexTest {
    @Test
    public void latexTest() {
        TransformRequestModel transformRequestModel = TransformRequestModel.builder()
                .text("Tekst zawierający znaki & oraz % do przetworzenia")
                .latex(true)
                .build();

        TransformerService transformerService = new TransformerService();

        String transformed = transformerService.transform(transformRequestModel);
        assertEquals("Tekst zawierający znaki \\& oraz \\% do przetworzenia", transformed);
    }

    @Test
    public void multipleLatexTest() {
        TransformRequestModel transformRequestModel = TransformRequestModel.builder()
                .text("Tekst z wieloma znakami takimi & & &&& oraz takimi % & %% &")
                .latex(true)
                .build();

        TransformerService transformerService = new TransformerService();

        String transformed = transformerService.transform(transformRequestModel);
        assertEquals("Tekst z wieloma znakami takimi \\& \\& \\&\\&\\& oraz takimi \\% \\& \\%\\% \\&", transformed);
    }
}
