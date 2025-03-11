import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        System.out.println(solution.solution(jobs));
    }


    public int solution(int[][] jobs) {
        PriorityQueue<Task> pq = new PriorityQueue<>();
        int len = jobs.length;

        Arrays.sort(jobs, (x, y) -> x[0] - y[0]);

        int[] endTime = new int[len];
        int currTime = 0;
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < len) {
            while (idx1 < len && jobs[idx1][0] <= currTime) {
                pq.add(new Task(idx1, jobs[idx1][0], jobs[idx1][1]));
                idx1++;
            }

            if (!pq.isEmpty()) {
                Task task = pq.poll();
                endTime[idx2++] = task.runTime + currTime - task.requestTime;
                currTime += task.runTime;
            } else {
                currTime = jobs[idx1][0];
            }

        }

        while (!pq.isEmpty()) {
            Task task = pq.poll();
            endTime[idx2++] = task.runTime + currTime - task.requestTime;
            currTime += task.runTime;
        }


        return Arrays.stream(endTime).sum() / len;
    }

    static class Task implements Comparable<Task>{
        int idx;
        int requestTime;
        int runTime;

        public Task(int idx, int requestTime, int runTime) {
            this.idx = idx;
            this.requestTime = requestTime;
            this.runTime = runTime;
        }

        public int compareTo(Task task) {
            if (this.runTime == task.runTime) {

                if (this.requestTime == task.requestTime) {
                    return this.idx - task.idx;
                }

                return this.requestTime - task.requestTime;
            }

            return this.runTime - task.runTime;
        }
    }

}