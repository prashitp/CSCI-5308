public class Calculator {
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public int subtract(int num1, int num2) {
        return num1 - num2;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public int divide(int num1, int num2) {
        return num1 / num2;
    }

    public String fizzbuzz(int input) {
        String ans = "";

        for(int j=1;j<=input;j++){
            if(j%3 == 0 && j%5 == 0) {
                ans += "FizzBuzz";
            } else if(j%3 == 0) {
                ans += "Fizz";
            } else if(j%5 == 0) {
                ans += "Buzz";
            } else {
                ans += j;
            }
        }
        return ans;
    }

    public String addStrings(String s1, String s2) throws DecimalExceededException {
        String[] forS1 = s1.split("\\.");
        String[] forS2 = s2.split("\\.");

        if(forS1[1].length() > 2 || forS2[1].length() > 2) {
            throw new DecimalExceededException("Decimal places exceeded.");
        }

        double d1 = Double.parseDouble(s1);
        double d2 = Double.parseDouble(s2);
        return String.format("%.2f",(d1+d2));
    }
}
