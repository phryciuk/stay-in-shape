package org.hryciuk.stayinshape.data_structures.array;

import java.util.Comparator;
import java.util.List;

public class MeetingRooms {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() == 1) {
            return false;
        }
        intervals.sort(Comparator.comparingInt(i -> i.start));
        Interval prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); ++i) {
            Interval current = intervals.get(i);
            if (prev.end > current.start) {
                return false;
            }
            prev = current;
        }
        return true;
    }
}

class Interval {
    int start;
    int end;

}