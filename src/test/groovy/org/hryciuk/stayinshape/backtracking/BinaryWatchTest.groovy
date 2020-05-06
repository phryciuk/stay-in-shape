package org.hryciuk.stayinshape.backtracking

import spock.lang.Specification

class BinaryWatchTest extends Specification {

    def "should print out possible combinations of hours that watch could show if n lamps is lit"(int numberOfLitLights, List<String> possibleTimes) {
        given:
        BinaryWatch binaryWatch = new BinaryWatch();

        when:
        def actual = binaryWatch.readBinaryWatch(numberOfLitLights)

        then:
        actual.size() == possibleTimes.size()
        actual.sort() == possibleTimes.sort()

        where:
        numberOfLitLights | possibleTimes
        1                 | ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
        2                 | ["0:03", "0:05", "0:06", "0:09", "0:10", "0:12", "0:17", "0:18", "0:20", "0:24", "0:33", "0:34", "0:36", "0:40", "0:48", "1:01", "1:02", "1:04", "1:08", "1:16", "1:32", "2:01", "2:02", "2:04", "2:08", "2:16", "2:32", "3:00", "4:01", "4:02", "4:04", "4:08", "4:16", "4:32", "5:00", "6:00", "8:01", "8:02", "8:04", "8:08", "8:16", "8:32", "9:00", "10:00"]

    }
}
