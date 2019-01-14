package pl.put.poznan.transformer.logic

import spock.lang.Specification

class LetterTransformerDecoratorTest extends Specification{
  def "should invoke parent transformation and don't perform transformation if transformation array is empty"() {
    given:
    def transformations = null
    Transformer transformer = Mock(Transformer)
    LetterTransformerDecorator letterTransformerDecorator = new LetterTransformerDecorator(transformer, transformations)
    def str = "test test"

    when:
    def actual = letterTransformerDecorator.transform(str)

    then:
    1 * transformer.transform(str) >> "test"
    0 * _
    actual == "test"
  }

  def "should invoke parent transformation and perform transformation if transformation array is not empty"() {
    given:
    def transformations = Collections.singletonList("upper")
    Transformer transformer = Mock(Transformer)
    LetterTransformerDecorator letterTransformerDecorator = new LetterTransformerDecorator(transformer, transformations)
    def str = "test test"

    when:
    def actual = letterTransformerDecorator.transform(str)

    then:
    1 * transformer.transform(str) >> "test"
    0 * _
    actual == "TEST"
  }
}
