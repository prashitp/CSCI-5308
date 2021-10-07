import java.util.List;

public class Calculator {
    Validation validaton;
    public Calculator(){}

    public Calculator(Validation v){
        validaton = v;
    }
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

    public String subtractStrings(String s1, String s2) throws DecimalExceededException {
        String[] forS1 = s1.split("\\.");
        String[] forS2 = s2.split("\\.");

        if(forS1[1].length() > 2 || forS2[1].length() > 2) {
            throw new DecimalExceededException("Decimal places exceeded.");
        }

        double d1 = Double.parseDouble(s1);
        double d2 = Double.parseDouble(s2);
        return String.format("%.2f",(d1-d2));
    }

    public String multiplyStrings(String s1, String s2) throws DecimalExceededException {
        String[] forS1 = s1.split("\\.");
        String[] forS2 = s2.split("\\.");

        if(forS1[1].length() > 2 || forS2[1].length() > 2) {
            throw new DecimalExceededException("Decimal places exceeded.");
        }

        double d1 = Double.parseDouble(s1);
        double d2 = Double.parseDouble(s2);
        return String.format("%.2f",(d1*d2));
    }

    public String divideStrings(String s1, String s2) throws DecimalExceededException, DivideByZeroException {
        if(Double.parseDouble(s2) == 0.0) {
            throw new DivideByZeroException("Dividing By Zero.");
        }

        String[] forS1 = s1.split("\\.");
        String[] forS2 = s2.split("\\.");

        if(forS1[1].length() > 2 || forS2[1].length() > 2) {
            throw new DecimalExceededException("Decimal places exceeded.");
        }

        double d1 = Double.parseDouble(s1);
        double d2 = Double.parseDouble(s2);
        return String.format("%.2f",(d1/d2));
    }

    public String addRevised(String s1, String s2) throws DecimalExceededException {
        List<String> validated= validaton.validate(s1,s2);
        if(validated.size() == 0) {
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);
            return String.format("%.2f",(d1+d2));
        } else {
            throw new DecimalExceededException("Decimal places exceeded for "+validated.size()+" values");
        }
    }

    public String subtractRevised(String s1, String s2) throws DecimalExceededException {
        List<String> validated= validaton.validate(s1,s2);
        if(validated.size() == 0) {
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);
            return String.format("%.2f",(d1-d2));
        } else {
            throw new DecimalExceededException("Decimal places exceeded for "+validated.size()+" values");
        }
    }

    public String multiplyRevised(String s1, String s2) throws DecimalExceededException {
        List<String> validated= validaton.validate(s1,s2);
        if(validated.size() == 0) {
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);
            return String.format("%.2f",(d1*d2));
        } else {
            throw new DecimalExceededException("Decimal places exceeded for "+validated.size()+" values");
        }
    }

    public String divideRevised(String s1, String s2) throws DecimalExceededException {
        List<String> validated= validaton.validate(s1,s2);
        if(validated.size() == 0) {
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);
            return String.format("%.2f",(d1/d2));
        } else {
            throw new DecimalExceededException("Decimal places exceeded for "+validated.size()+" values");
        }
    }
}

//Dividing By Zero.
