// Job Sequencing Problem
// Given some jobs, where each job has a deadline and a profit associated to it.
// The task is to complete the jobs within the given deadline to maximize the profit.
// Given that
//  each job takes 1 unit of time for completion
//  one can do only 1 job at a time
//  time starts from 0

package jobSequencingProblem;


import java.util.Arrays;
import java.util.Comparator;

class Jobs {
    char id;
    int deadline;
    int profit;

    public Jobs(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

class MyCmp implements Comparator<Jobs> {
    public int compare(Jobs job1, Jobs job2) {
        return job2.profit - job1.profit;
    }
}
public class JobSequencingProblem {

    // Time Complexity = O(N * N)
    // Space Complexity = O(N)
    // N = Number of Jobs
    public static void jobSequencing(Jobs[] arr, int maxTime) {

        Arrays.sort(arr, new MyCmp());

        boolean[] time = new boolean[maxTime];

        char[] result = new char[maxTime];

        for (int i = 0; i < arr.length; i++) {
            for (int j = Math.min(maxTime - 1, arr[i].deadline - 1); j >= 0; j--) {
                if (!time[j]) {
                    time[j] = true;
                    result[j] = arr[i].id;
                    break;
                }
            }
        }

        for (char ch: result) {
            System.out.print(ch + " ");
        }
        System.out.println();

    }
    public static void main(String[] args) {
        Jobs[] arr = {new Jobs('a', 2, 100),
                new Jobs('b', 1, 19),
                new Jobs('c', 2, 27),
                new Jobs('d', 1, 25),
                new Jobs('e', 3, 15)};
        System.out.println("The Job Sequence is: ");
        jobSequencing(arr, 3);
    }
}
