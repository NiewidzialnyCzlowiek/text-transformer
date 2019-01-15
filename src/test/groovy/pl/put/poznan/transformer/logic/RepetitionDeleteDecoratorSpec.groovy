package pl.put.poznan.transformer.logic

import spock.lang.Specification

class RepetitionDeleteDecoratorSpec extends Specification{
  def "should invoke parent transformation and dedup "() {
    given:
    Transformer transformer = Mock(Transformer)
    RepetitionDeleteDecorator repetitionDeleteDecorator = new RepetitionDeleteDecorator(transformer)
    def str = "test test"

    when:
    def actual = repetitionDeleteDecorator.transform(str)

    then:
    1 * transformer.transform(str) >> "TEST TEST"
    0 * _
    actual == "TEST"
  }
}
