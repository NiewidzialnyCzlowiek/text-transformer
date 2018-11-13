package pl.put.poznan.transformer.logic;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Response {
  public Response(String text) {
    this.text = text;
  }
  private String text;
}
