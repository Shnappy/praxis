import java.util.List;
import java.util.stream.Collectors;

//TODO redo with sliding window and binary search
public class Solution {

    public static void main(String[] args) {
        maxVowels("abciiidef", 3);
    }

    public static int maxVowels(String s, int k) {

        List<Character> vowels = "aeiou".chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        int windowLen = 0;
        String[] splitString = s.split("");

        int currentVowels = 0;
        int maxVowels = 0;

        int slide = 0;

        for (int pointer = 0; pointer < s.length(); pointer++) {

            if (vowels.contains(s.charAt(pointer))) {
                currentVowels++;
            }

            windowLen++;

            if (windowLen == k) {

                if (currentVowels == k) {
                    return currentVowels;
                }

                if (currentVowels > maxVowels) {
                    maxVowels = currentVowels;
                }
                windowLen = 0;
                currentVowels = 0;
                slide++;
                pointer = slide;
            }
        }
        return maxVowels;
    }
}
