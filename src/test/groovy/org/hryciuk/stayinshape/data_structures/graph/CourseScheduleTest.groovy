package org.hryciuk.stayinshape.data_structures.graph

import spock.lang.Specification

class CourseScheduleTest extends Specification {

    def 'should determine whether courses can be finished'(int numberOfCourses, int[][] prerequisites, boolean expected) {
        given:
        CourseSchedule courseSchedule = new CourseSchedule()

        when:
        boolean actual = courseSchedule.canFinish(numberOfCourses, prerequisites)

        then:
        actual == expected

        where:
        numberOfCourses | prerequisites                                                                                                                                           || expected
        2               | [[1, 0]]                                                                                                                                                || true
        2               | [[1, 0], [0, 1]]                                                                                                                                        || false
        13              | [[2, 0], [2, 9], [6, 2], [10, 9], [6, 10], [6, 0], [3, 0], [7, 6], [11, 6], [1, 3], [4, 3], [4, 7], [12, 11], [12, 7], [4, 1], [5, 4], [8, 4], [8, 12]] || true
    }
}
