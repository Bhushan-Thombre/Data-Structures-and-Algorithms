// Activity Selection Problem
// Given a set of activities, where each activity has a start time and end time. There is an activity performing
// machine that can execute only one activity at a time.
// Find the maximum number of activity that can be executed by the machine.

package activitySelectionProblem;


import java.util.Arrays;
import java.util.Comparator;

class Activity {
    int startTime;
    int endTime;

    public Activity(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

class MyCmp implements Comparator<Activity> {
    public int compare(Activity activity1, Activity activity2) {
        return activity1.endTime - activity2.endTime;
    }
}
public class ActivitySelectionProblem {

    // Time Complexity = O(N * LogN)
    // Space Complexity = O(1)
    public static int activitySelection(Activity[] activities) {
        Arrays.sort(activities, new MyCmp());
        int res = 1;
        int prev = 0;
        for (int curr = 1; curr < activities.length; curr++) {
            if (activities[curr].startTime >= activities[prev].endTime) {
                res++;
                prev = curr;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Activity[] activities = {new Activity(12, 25),
                new Activity(10, 20),
                new Activity(20, 30)};

        int ans = activitySelection(activities);
        System.out.println("Maximum number of activities that can be executed are: ");
        System.out.println(ans);
    }
}
