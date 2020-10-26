package org.hryciuk.stayinshape.sachs

import spock.lang.Specification

class BindingTest extends Specification {

    def" what prints"() {
        given:
        Binding binding = new Binding()

        when:
        binding.main()

        then:
        1 == 1
    }
}
