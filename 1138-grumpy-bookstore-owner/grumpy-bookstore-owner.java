class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
      int satisfied = 0;
      //total satisfied customers
      for(int i = 0; i < customers.length; i++){
        if(grumpy[i] == 0) satisfied += customers[i];
      }

      int left = 0, bonus =0;
      //first window of unsatisfied customers turned into satisfied
      for(int i = 0; i< minutes ; i++){
        if(grumpy[i] == 1) bonus+= customers[i]; 
      }
      int curBonus = bonus;
      //get the maximum new satisfactions in "minutes" length window 
      for(int right = minutes; right < customers.length; right++){
        if(grumpy[left] == 1) curBonus -= customers[left];
        left++;
        if(grumpy[right] == 1) curBonus+= customers[right];
        bonus = Math.max(bonus,curBonus); 
      }
      return satisfied+bonus;
    }
}