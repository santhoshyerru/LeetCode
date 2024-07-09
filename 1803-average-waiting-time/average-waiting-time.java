class Solution {
    public double averageWaitingTime(int[][] customers) {
        double waitTime = 0;
        double timeStarted = customers[0][0];
        for(int[] customer: customers){
            if(timeStarted<customer[0]){
                timeStarted = customer[0];
            }
            waitTime += (timeStarted+customer[1])-customer[0];
            timeStarted += customer[1];
        }
        return waitTime/customers.length;
    }
}
