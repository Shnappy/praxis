import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    //turns out, hashtables and multi-maps are more wacky then I anticipated, 
    //this problem is not yeat solved due to type conversion issues and multi-map
    //being a mvn dependency :c
    public static void main(String[] args) {
        int[][]pairs = {{1, 1}, {2, 2}};
        findLongestChain(pairs);
    }

    private static int findLongestChain(int[][] pairs) {
        
        Hashtable<Integer, List<Integer>> pairsHashtable = new Hashtable<>(); 

        for(int[] arr : pairs) {
            pairsHashtable.put(Integer.valueOf(arr[0]), Integer.valueOf(arr[1]));
        }

        int lengthOfPairs = 0;

        return recursivePairChain(lengthOfPairs, pairsHashtable);
        
    }

    private static int recursivePairChain(int lengthOfPairs,  Hashtable<Integer, Integer> pairsHashtable) {
        List<Integer> keyList = new ArrayList<>(pairsHashtable.keySet());
        int minInBucket = Collections.min(keyList);
        if(pairsHashtable.containsKey(minInBucket)) {
            for(int i = 0; i < minInBucket; i++){
                pairsHashtable.remove(i);
            }
           return recursivePairChain(lengthOfPairs + 1, pairsHashtable);
        }

        else {
           if(keyList.size() == 0) {
               return lengthOfPairs;
           }
           else {
                keyList = keyList.remove(0);
                pairsHashtable.remove(minInBucket);
                pairsHashtable.put(minInBucket, keyList);
                recursivePairChain(lengthOfPairs, pairsHashtable);
           }
        }
   }
}