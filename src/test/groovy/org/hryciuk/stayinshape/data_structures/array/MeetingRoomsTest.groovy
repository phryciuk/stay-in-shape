package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification
import spock.lang.Unroll

class MeetingRoomsTest extends Specification {
    @Unroll
    def 'should see if we can meet'(int[][] intervals, boolean expected) {
        given:
        MeetingRooms meetingRooms = new MeetingRooms()
        List<Interval> newIntervals = new ArrayList<>()
        for(int[] interval : intervals) {
            Interval newOne = new Interval()
            newOne.start = interval[0]
            newOne.end = interval[1]
            newIntervals.add(newOne)
        }

        when:
        boolean actual = meetingRooms.canAttendMeetings(newIntervals)

        then:
        actual == expected

        where:
        intervals                    || expected
        [[0, 30], [5, 10], [15, 20]] || false
        [[5, 8], [9, 15]]            || true
        [[0, 8], [8, 10]]            || true
        [[7, 10], [2, 4]]            || true
    }
}
