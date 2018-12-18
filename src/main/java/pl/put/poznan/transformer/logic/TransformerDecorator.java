package pl.put.poznan.transformer.logic;

public abstract class TransformerDecorator implements Transformer {

  protected Transformer transformer;

  TransformerDecorator(Transformer transformer) {
    this.transformer = transformer;
  }

  @Override
  public String transform(String text) {
    return transformer.transform(text);
  }

}
