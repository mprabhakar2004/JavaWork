import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution {
    public List<BigInteger> permutations = new ArrayList<>();

    public void generatePossibleNumbers(int length, int start, char[] str, boolean lastZero) {
        if (start >= length) {
            BigInteger val = new BigInteger(new String(str));
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

    public BigInteger findMultiple(long input){
        BigInteger[] longArray = new BigInteger[permutations.size()];
        permutations.toArray(longArray);
        Arrays.sort(longArray);

        for(BigInteger element : longArray){
            BigInteger []rem = element.divideAndRemainder(BigInteger.valueOf(input));
            if(rem[1].intValue() == 0 ){
                return element;
            }
        }
        return BigInteger.valueOf(0L);
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        long[] inputArr = new long[t];

        for (int i = 0; i < t; i++) {
            inputArr[i] = in.nextInt();
        }
        Solution sol= new Solution();
        for (int i = 0; i < t; i++) {
            sol.findSolution(inputArr[i]);
        }
    }

    private void findSolution(long num){
        String input = num+"";
        for(int i=input.length(); i < 100; i++) {
            char[] str = new char[i];
            str[0] = '4';
            generatePossibleNumbers(i, 1, str, false);
            if(findMultiple(num).compareTo(BigInteger.valueOf(0L))!=0) {
                String result = (findMultiple(num)).toString();

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