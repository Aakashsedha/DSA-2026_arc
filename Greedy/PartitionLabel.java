class PartitionLabel {
    public List<Integer> partitionLabels(String s)
    {
        List<Integer> res = new ArrayList<>();

        //last occurence storage
        HashMap<Character,Integer> lastIdxlookUp = new HashMap<>();
        for(int i = 0 ; i<s.length() ; i++)
        {
            if(lastIdxlookUp.containsKey(s.charAt(i))) continue;
            lastIdxlookUp.put(s.charAt(i) , s.lastIndexOf(s.charAt(i)));
        }

        int farthestBoundry = 0 ;
        int i = 0;
        int lastCut = 0;

        //traverse the String
        while(i<s.length())
        {
            //Update the farthest Boundry we can traverse till
            farthestBoundry = Math.max(farthestBoundry,lastIdxlookUp.get(s.charAt(i)));

            //where to Make cut if(i == farthestBoundry)
            if(i == farthestBoundry)
            {
                //compute the  length to store in result
                int partitionSize = i - lastCut+1;
                lastCut = i+1;

                res.add(partitionSize);
            }


            i++;
        }

        return res;

    }
}