package org.hryciuk.stayinshape.data_structures.graph

import spock.lang.Specification

class CourseSchedule2Test extends Specification {
    def 'should determine whether courses can be finished'(int numberOfCourses, int[][] prerequisites, int[] expected) {
        given:
        CourseSchedule2 courseSchedule = new CourseSchedule2()

        when:
        int[] actual = courseSchedule.findOrder(numberOfCourses, prerequisites)

        then:
        actual.size() == expected.size();
        Arrays.equals(actual, expected)


        where:
        numberOfCourses | prerequisites                                                                                                                                           || expected
        2               | [[1, 0]]                                                                                                                                                || [0, 1]
        2               | [[1, 0], [0, 1]]                                                                                                                                        || []
        4               | [[1, 0], [2, 0], [3, 1], [3, 2]]                                                                                                                         | [0, 1, 2, 3]
        13              | [[2, 0], [2, 9], [6, 2], [10, 9], [6, 10], [6, 0], [3, 0], [7, 6], [11, 6], [1, 3], [4, 3], [4, 7], [12, 11], [12, 7], [4, 1], [5, 4], [8, 4], [8, 12]] || [0, 9, 3, 2, 10, 1, 6, 7, 11, 4, 12, 5, 8]
    }
}
