import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution {
    public List<Long> permutations = new ArrayList<Long>();

    public void generatePossibleNumbers(int length, int start, char[] str, boolean lastZero) {
        if (start >= length) {
            Long val = Long.parseLong(new String(str));
            permutations.add(val);
            return;
        }

        if (lastZero) {
            str[start] = '0';
            generatePossibleNumbers(length, start + 1, str, true);
        } else {
            str[start] = '4';
            generatePossibleNumbers(length, start + 1, str, false);
            str[start] = '0';
            generatePossibleNumbers(length, start + 1, str, true);
        }
    }

    public Long findMultiple(long input){
        Long[] longArray = new Long[permutations.size()];
        permutations.toArray(longArray);
        Arrays.sort(longArray);

        for(Long str : longArray){
            if(str%input == 0 ){
                return str;
            }
        }
        return 0L;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        long[] inputArr = new long[t];

        for (int i = 0; i < t; i++) {
            inputArr[i] = in.nextInt();
        }
        for (int i = 0; i < t; i++) {
            findSolution(inputArr[i]);
        }

    }

    private static void findSolution(long num){
        String input = num+"";
        Solution sol = new Solution();
        for(int i=input.length(); i < 100; i++) {
            char[] str = new char[i];
            str[0] = '4';
            sol.generatePossibleNumbers(i, 1, str, false);
            if(sol.findMultiple(num) != 0L) {
                String result = (sol.findMultiple(num)).toString();

                long a = countDigit(result, '4');
                long b = countDigit(result, '0');
                long finalResult = 2 * a + b;
                System.out.println(finalResult);
                break;
            }
        }
    }
    public static int countDigit(String input, char eq){
        int count = 0;
        for(char ch : input.toCharArray()){
            if(ch == eq){
                count++;
            }
        }
        return count;
    }
}