class Solution {
    public boolean isNStraightHand(int[] hands, int groupSize)
    {
        if(hands.length % groupSize != 0)
        {
            return false;
        }


        HashMap<Integer,Integer> freqMap = new HashMap<>();

        //building the frequency;
        for(int hand:hands )
        {
            freqMap.put(hand,(freqMap.getOrDefault(hand,0)+1));
        }

        //groupFormation
        Map<Integer, Integer> sortedMap = new TreeMap<>(freqMap);
        int group = 0;
        while(!sortedMap.isEmpty())
        {

            //remove 0 value
            //form a gropup


            //check for groupSize elements
            // start(1st element) , .... , (groupSize th) element
            TreeSet<Integer> nums = new TreeSet<>(sortedMap.keySet());

            int start = nums.first();
            int count = 1;
            sortedMap.put(start,sortedMap.get(start)-1);
            while(count<groupSize)
            {
                if(nums.contains(start+1) && sortedMap.get(start+1)>0)
                {
                    //decrement
                    sortedMap.put(start+1,sortedMap.get(start+1)-1);
                    count++;
                    start+=1;
                }
                else
                {
                    return false;
                }

            }
             sortedMap.entrySet().removeIf(entry -> entry.getValue() == 0);




    }
   return true;

}
}