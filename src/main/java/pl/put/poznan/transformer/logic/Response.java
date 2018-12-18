package pl.put.poznan.transformer.logic;


import lombok.*;

/**
 * Dto for server response
 */
@Getter
@Setter
@NoArgsConstructor
public class Response {
  public Response(String text) {
    this.text = text;
  }
  private String text;
}
