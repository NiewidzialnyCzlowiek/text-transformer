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
            .text("raz dwa trzy")
            .transformations(Arrays.asList("capitalize"))
            .build();

    TextTransformer textTransformer = new TextTransformer();

    String transformed = textTransformer.transform(transformRequestModel);
    assertEquals("Raz Dwa Trzy", transformed);
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
}
