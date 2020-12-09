package Challenge;

public class SongsPairDivisibleBy60 {
    // https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
    public static int numPairsDivisibleBy60(int[] time) {
        int[] map = new int[60];
        for(int play: time) {
            map[play % 60]++;
        }
        int res1 = 0, res2 = 0;
        for(int i = 0; i < map.length; i++) {
            if(map[i] == 0) continue;
            
            if((i * 2) % 60 == 0) {
                res1 += ((map[i] * (map[i] - 1)) / 2);
            } else if(map[60 - i] > 0) {
                res2 += (map[i] * map[60 - i]);
            }
        }
        return res1 + (res2/2);
    
    }
    public static void main(String[] args) {
        int[] time = {20,40,20};
        System.out.print(numPairsDivisibleBy60(time));
    }
}
