package pl.put.poznan.transformer.logic

import spock.lang.Specification

class LatexDecoratorTest extends Specification{
  def "should invoke parent transformation and transform to latex"() {
    given:
    Transformer transformer = Mock(Transformer)
    LatexDecorator latexDecorator = new LatexDecorator(transformer)
    def str = "test & %"

    when:
    def actual = latexDecorator.transform(str)

    then:
    1 * transformer.transform(str) >> "% & tset"
    0 * _
    actual == "\\% \\& tset"
  }
}
