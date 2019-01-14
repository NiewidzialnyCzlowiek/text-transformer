package pl.put.poznan.transformer.logic;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransformRequestModel {
  private String text;
  private boolean repetition_del;
  private boolean num_to_text;
  private boolean expand;
  private boolean shrink;
  private boolean latex;
  private List<String> transformations;

}
