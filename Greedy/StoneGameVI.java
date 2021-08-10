//https://leetcode.com/problems/stone-game-vi/submissions/
class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        // greedy --:
        int n = aliceValues.length;
        int[][] stones = new int[n][3];
        for(int i = 0 ; i < n; i++)
        {
            stones[i] = new int[]{aliceValues[i], bobValues[i],aliceValues[i]+bobValues[i] };
            
        }
        Arrays.sort(stones, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
               return o2[2]-o1[2];
            }
        });
        int score= 0;
        for(int i =0 ; i < n ; i++)
        {
            if(i %2 == 0)
                score += stones[i][0];
            else
                score -= stones[i][1];
            
        }
        if(score >0 )
            return 1;
        if(score <0 )
            return -1;
        
        return 0;

    }
}
