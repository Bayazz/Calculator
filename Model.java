package sample;


import java.math.BigDecimal;

public class Model {

    public double calculate (double number1, double number2, String operator){


        switch (operator){
            case "+":
                return decimalUtils(number1+number2);
            case "-":
                return decimalUtils(number1-number2);
            case "*":
                return decimalUtils(number1*number2);
            case "/":
                if (number2 ==0){
                    return 0;
                }else {
                    return decimalUtils(number1/number2);
                }
            case "1/x":
                return decimalUtils(1/number1);
            case "√":
                return decimalUtils(Math.pow(number1, 0.5));
        }
        return 0;
    }

    public  double decimalUtils (double result){
        BigDecimal bigDecimal = new BigDecimal(result);
        bigDecimal = bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP);
        return bigDecimal.doubleValue();
    }


}
