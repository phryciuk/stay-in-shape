package org.hryciuk.stayinshape.data_structures.array;

import java.util.Arrays;
import java.util.Comparator;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] positionToTime = new double[position.length][2];
        for (int i = 0; i < position.length; ++i) {
            positionToTime[i] = new double[] {position[i], (double) (target - position[i]) / speed[i]};
        }
        Arrays.sort(positionToTime, Comparator.comparingDouble(a -> a[0]));
        int fleetCount = 0;
        double minTimeToReachTarget = 0;
        for (int i = position.length - 1; i >= 0; i--) {
            if (positionToTime[i][1] > minTimeToReachTarget) {
                minTimeToReachTarget = positionToTime[i][1];
                fleetCount++;
            }
        }
        return fleetCount;
    }

    public int carFleet2(int target, int[] position, int[] speed) {
        double[][] positionToTime = new double[position.length][1];
        for (int i = 0; i < position.length; ++i) {
            positionToTime[i][0] = (double) (target - position[i]) / speed[i];
        }
        Arrays.sort(positionToTime, Comparator.comparingDouble(a -> a[0]));
        int fleets = 0;
        double currentTime = 0;
        for (int i = position.length - 1; i >= 0; i--) {
            if (positionToTime[i][0] > currentTime) {
                fleets++;
                currentTime = positionToTime[i][0];
            }
        }
        return fleets;
    }
}
