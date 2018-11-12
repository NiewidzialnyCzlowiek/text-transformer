package pl.put.poznan.transformer;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.TextTransformer;
import pl.put.poznan.transformer.logic.TransformRequestModel;

import java.util.Arrays;

public class ExampleTest {

  @Test
  public void inverseTest() {
    TransformRequestModel transformRequestModel = TransformRequestModel.builder()
            .text("MirEk")
            .transformations(Arrays.asList("inverse"))
            .build();

    TextTransformer textTransformer = new TextTransformer();

    String transformed = textTransformer.transform(transformRequestModel);
    assertEquals("KerIm", transformed);
  }

  @Test
  public void capitalizeTest() {
    TransformRequestModel transformRequestModel = TransformRequestModel.builder()
            .text("raz dwa trzy cztery")
            .transformations(Arrays.asList("capitalize"))
            .build();

    TextTransformer textTransformer = new TextTransformer();

    String transformed = textTransformer.transform(transformRequestModel);
    assertEquals("Raz Dwa Trzy Cztery", transformed);
  }

  @Test
  public void upperTest() {
    TransformRequestModel transformRequestModel = TransformRequestModel.builder()
            .text("test")
            .transformations(Arrays.asList("upper"))
            .build();

    TextTransformer textTransformer = new TextTransformer();

    String transformed = textTransformer.transform(transformRequestModel);
    assertEquals("TEST", transformed);
  }

  @Test
  public void lowerTest() {
    TransformRequestModel transformRequestModel = TransformRequestModel.builder()
            .text("TesT")
            .transformations(Arrays.asList("lower"))
            .build();

    TextTransformer textTransformer = new TextTransformer();

    String transformed = textTransformer.transform(transformRequestModel);
    assertEquals("test", transformed);
  }

  @Test
  public void singleShrinkTest() {
    TransformRequestModel transformRequestModel = TransformRequestModel.builder()
            .text("ptaki na przykład sowa")
            .shrink(true)
            .build();

    TextTransformer textTransformer = new TextTransformer();

    String transformed = textTransformer.transform(transformRequestModel);
    assertEquals("ptaki np. sowa", transformed);
  }

  @Test
  public void multipleShrinkTest() {
    TransformRequestModel transformRequestModel = TransformRequestModel.builder()
            .text("ptaki na przykład sowa oraz między Innymi czajka I Tym Podobne")
            .shrink(true)
            .build();

    TextTransformer textTransformer = new TextTransformer();

    String transformed = textTransformer.transform(transformRequestModel);
    assertEquals("ptaki np. sowa oraz m.In. czajka ITP.", transformed);
  }

  @Test
  public void singleExpandTest() {
    TransformRequestModel transformRequestModel = TransformRequestModel.builder()
            .text("Prof. Kowalski")
            .expand(true)
            .build();

    TextTransformer textTransformer = new TextTransformer();

    String transformed = textTransformer.transform(transformRequestModel);
    assertEquals("Profesor Kowalski", transformed);
  }

  @Test
  public void multipleExpandTest() {
    TransformRequestModel transformRequestModel = TransformRequestModel.builder()
            .text("prof. nie jest np. Dr. ITP.")
            .expand(true)
            .build();

    TextTransformer textTransformer = new TextTransformer();

    String transformed = textTransformer.transform(transformRequestModel);
    assertEquals("profesor nie jest na przykład Doktor I Tym Podobne", transformed);
  }

  @Test
  public void numTest() {
    TransformRequestModel transformRequestModel = TransformRequestModel.builder()
            .text("131")
            .num_to_text(true)
            .build();

    TextTransformer textTransformer = new TextTransformer();

    String transformed = textTransformer.transform(transformRequestModel);
    assertEquals("sto trzydzieści jeden", transformed);
  }

  @Test
  public void latexTest() {
    TransformRequestModel transformRequestModel = TransformRequestModel.builder()
            .text("Tekst zawierający znaki & oraz % do przetworzenia")
            .transformations(Arrays.asList("latex"))
            .build();

    TextTransformer textTransformer = new TextTransformer();

    String transformed = textTransformer.transform(transformRequestModel);
    assertEquals("Tekst zawierający znaki \\& oraz \\% do przetworzenia", transformed);
  }

  @Test
  public void multipleLatexTest() {
    TransformRequestModel transformRequestModel = TransformRequestModel.builder()
            .text("Tekst z wieloma znakami takimi & & &&& oraz takimi % & %% &")
            .transformations(Arrays.asList("latex"))
            .build();

    TextTransformer textTransformer = new TextTransformer();

    String transformed = textTransformer.transform(transformRequestModel);
    assertEquals("Tekst z wieloma znakami takimi \\& \\& \\&\\&\\& oraz takimi \\% \\& \\%\\% \\&", transformed);
  }
}
