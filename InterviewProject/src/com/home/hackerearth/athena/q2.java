package com.home.hackerearth.athena;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class JobWorker {
    int workerId;
    int waitingTime;

    public JobWorker(int workerId, int waitingTime) {
        this.workerId = workerId;
        this.waitingTime = waitingTime;
    }
}
public class q2 {

    public static void main(String[] args) {
        int []tasks = new int[]{1,3,1,1,3};
        //Arrays.sort(tasks);
        taskOrder(tasks,2);
    }

    private static void taskOrder(int[] tasks,int noOfWorkers) {
        Queue<JobWorker> pq= new PriorityQueue<>(noOfWorkers, new Comparator<JobWorker>() {
            @Override
            public int compare(JobWorker o1, JobWorker o2) {
                if (o2.waitingTime == o1.waitingTime){
                    return o1.workerId-o2.workerId;
                }
                    return o1.waitingTime-o2.waitingTime;

            }
        });
        for (int i = 0; i < noOfWorkers; i++) {
            pq.add(new JobWorker(i,0));
        }


        for (int task:tasks){
            JobWorker worker = pq.poll();
            System.out.println("{ " + worker.workerId +", "+ worker.waitingTime +" }");
            worker.waitingTime +=task;
            pq.offer(worker);
        }
    }
}
