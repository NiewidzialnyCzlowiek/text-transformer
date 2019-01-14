package pl.put.poznan.transformer.logic

import spock.lang.Specification

class ShrinkDecoratorTest extends Specification{
  def "should invoke parent transformation and shrink to abbreviations "() {
    given:
    Transformer transformer = Mock(Transformer)
    ShrinkDecorator shrinkDecorator = new ShrinkDecorator(transformer)
    def str = "na przykład"

    when:
    def actual = shrinkDecorator.transform(str)

    then:
    1 * transformer.transform(str) >> "Na przykład"
    0 * _
    actual == "Np."
  }
}
