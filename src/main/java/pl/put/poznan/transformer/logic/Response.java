package pl.put.poznan.transformer.logic;


import lombok.*;

/**
 * Dto for server response
 */
@Getter
@Setter
@NoArgsConstructor
public class Response {
  public Response(String text, Long time_nanos) {
    this.text = text;
    this.time_nanos = time_nanos;
  }
  private String text;
  private Long time_nanos;
}
