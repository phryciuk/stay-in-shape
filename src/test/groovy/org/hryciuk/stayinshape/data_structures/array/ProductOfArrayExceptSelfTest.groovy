package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification

class ProductOfArrayExceptSelfTest extends Specification {
    def 'should return the product of array except self'(int[] input, int[] expected) {
        given:
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf()

        when:
        int[] actual = productOfArrayExceptSelf.productExceptSelf(input)

        then:
        Arrays.equals(expected, actual)

        where:
        input        | expected
        [1, 2, 3, 4] | [24, 12, 8, 6]
    }
}
