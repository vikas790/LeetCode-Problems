class Solution {
    public double averageWaitingTime(int[][] customers) {
        long totalWaitTime = 0;
        int currentTime = 0;
        
        for (int[] customer : customers) {
            int arrivalTime = customer[0];
            int prepTime = customer[1];
            
            // Update current time to the customer's arrival time if the chef is idle
            if (currentTime < arrivalTime) {
                currentTime = arrivalTime;
            }
            
            // Calculate the waiting time for the current customer
            int waitTime = currentTime - arrivalTime + prepTime;
            totalWaitTime += waitTime;
            
            // Update the current time to the time when this customer is finished
            currentTime += prepTime;
        }
        
        // Calculate the average waiting time
        return (double) totalWaitTime / customers.length;
    }
}
