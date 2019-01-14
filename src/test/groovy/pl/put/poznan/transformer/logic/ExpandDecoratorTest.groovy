package pl.put.poznan.transformer.logic

import spock.lang.Specification

class ExpandDecoratorTest extends Specification {
  def "should invoke parent transformation and expand abbreviations"() {
    given:
    Transformer transformer = Mock(Transformer)
    ExpandDecorator expandDecorator = new ExpandDecorator(transformer)
    def str = "test np."

    when:
    def actual = expandDecorator.transform(str)

    then:
    1 * transformer.transform(str) >> "Test np."
    0 * _
    actual == "Test na przykład"
  }
}
