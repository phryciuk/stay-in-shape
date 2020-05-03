package org.hryciuk.stayinshape.data_structures.stack

import spock.lang.Specification

class BaseballGameSpec extends Specification {

  def "should count baseball points correctly"() {
    given:
    BaseballGame baseballGame = new BaseballGame()

    def myStringArray = ["5", "2", "C", "D", "+"]

    when:
    def actual = baseballGame.calPoints(myStringArray as String[])

    then:
    actual == 30

  }
}
