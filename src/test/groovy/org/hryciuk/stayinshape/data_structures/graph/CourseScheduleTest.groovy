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
        numberOfCourses | prerequisites    || expected
        2               | [[1, 0]]         || true
        2               | [[1, 0], [0, 1]] || false
    }
}
