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

  def "should invoke parent transformation and perform transformation if transformation array contains upper"() {
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

  def "should invoke parent transformation and perform transformation if transformation array contains lower"() {
    given:
    def transformations = Collections.singletonList("lower")
    Transformer transformer = Mock(Transformer)
    LetterTransformerDecorator letterTransformerDecorator = new LetterTransformerDecorator(transformer, transformations)
    def str = "TEST TEST"

    when:
    def actual = letterTransformerDecorator.transform(str)

    then:
    1 * transformer.transform(str) >> "TEST"
    0 * _
    actual == "test"
  }

  def "should invoke parent transformation and perform transformation if transformation array contains capitalize"() {
    given:
    def transformations = Collections.singletonList("capitalize")
    Transformer transformer = Mock(Transformer)
    LetterTransformerDecorator letterTransformerDecorator = new LetterTransformerDecorator(transformer, transformations)
    def str = "test test"

    when:
    def actual = letterTransformerDecorator.transform(str)

    then:
    1 * transformer.transform(str) >> "test"
    0 * _
    actual == "Test"
  }

  def "should invoke parent transformation and perform transformation if transformation array contains inverse"() {
    given:
    def transformations = Collections.singletonList("inverse")
    Transformer transformer = Mock(Transformer)
    LetterTransformerDecorator letterTransformerDecorator = new LetterTransformerDecorator(transformer, transformations)
    def str = "test test"

    when:
    def actual = letterTransformerDecorator.transform(str)

    then:
    1 * transformer.transform(str) >> "test"
    0 * _
    actual == "tset"
  }

  def "should invoke parent transformation and perform transformation if transformation array contains upper and inverse"() {
    given:
    def transformations = Arrays.asList("upper", "inverse")
    Transformer transformer = Mock(Transformer)
    LetterTransformerDecorator letterTransformerDecorator = new LetterTransformerDecorator(transformer, transformations)
    def str = "test test"

    when:
    def actual = letterTransformerDecorator.transform(str)

    then:
    1 * transformer.transform(str) >> "test"
    0 * _
    actual == "TSET"
  }

  def "should invoke parent transformation and perform transformation if transformation array contains lower and inverse"() {
    given:
    def transformations = Arrays.asList("lower", "inverse")
    Transformer transformer = Mock(Transformer)
    LetterTransformerDecorator letterTransformerDecorator = new LetterTransformerDecorator(transformer, transformations)
    def str = "TEST TEST"

    when:
    def actual = letterTransformerDecorator.transform(str)

    then:
    1 * transformer.transform(str) >> "TEST"
    0 * _
    actual == "tset"
  }
}
