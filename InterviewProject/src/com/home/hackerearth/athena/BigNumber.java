package com.home.hackerearth.athena;

public class BigNumber {
    StringBuilder value;

    public BigNumber(StringBuilder value) {
        this(value.toString());
    }

    public BigNumber(String value){
        for (int i=0;i<value.length()-1;i++){
            if(Math.abs((value.charAt(i)-48)) > 9){
                throw  new NumberFormatException("Invalid digit in provided input");
            }
        }

        this.value = new StringBuilder(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }


    /**
     * Method to multiply two big number
     * Algorithm :
     *      Using traditional multiplication method.
     *       - Take each individual digit from number2 , start from right side
     *       - Multiply with num1
     *       - Add the resultant after shifting it left (i.e. padding 0 at last)
     *
     *       e.g.
     *
     *       1) 5  4  3
     *             5  6
     *       ==============
     *        3 2  5  8
     *      2 7 1  5  0
     *      ================
     *      3 0 4  0   8
     * @param num1
     * @param num2
     * @return
     */
    public static BigNumber multiply(BigNumber num1, BigNumber num2){
        StringBuilder result=new StringBuilder();
        int padding=0;
        for (int i=num2.value.length()-1; i>=0;i--){

            StringBuilder multiplyResultByLastDidit = multiply(num1.value,num2.value.charAt(i) - 48);
            result = addStringToResult(result, multiplyResultByLastDidit, padding ++);
        }

        int index=0;
        while (index <result.length()-1 && result.charAt(index)=='0')
            index ++;
        return new BigNumber(result.substring(index));
    }

    /**
     * Helper method to add to stringbuilder representation of big number
     * @param num : Original number
     * @param noToAdd : Number needed to add
     * @param paddingNumber: Specify how much padding required for second number
     *
     * @return
     */
    private static StringBuilder addStringToResult(StringBuilder num, StringBuilder noToAdd, int paddingNumber) {

        StringBuilder result = new StringBuilder();
        for (int i=0; i<paddingNumber;i++){
            noToAdd.append(0);
        }

        int j=noToAdd.length()-1;
        int carry = 0;
        for (int i= num.length()-1; i>=0;i--,j--){

            int num1 = num.charAt(i)-48;
            int num2 = noToAdd.charAt(j) -48;
            int res = num1 + num2 + carry;
            result.append(res%10);
            carry = res/10;

        }
        while (j>=0){
            result.append((noToAdd.charAt(j)-48) + carry );
            j--;
        }

        return result.reverse();
    }

    /**
     * Helper method to multiply a single digit number to strigbuilder represented big number
     * @param num
     * @param numberToMultiply
     * @return
     */
    private static StringBuilder multiply(StringBuilder num, int numberToMultiply){

        int carry =0 ;
        StringBuilder res = new StringBuilder(num.length()+1);
        for (int i=num.length()-1; i>=0;i--){
            int currentDigit = num.charAt(i) - 48;
            int mulRes = currentDigit * numberToMultiply + carry;

            carry = mulRes/10;
            res.append(mulRes%10);
        }
        if (carry !=0)
            res.append(carry);
        return res.reverse();
    }

}
