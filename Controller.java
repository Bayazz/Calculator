package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class Controller {

    public Label output;
    private boolean start;
    private boolean end;
    private boolean backSpace;
    private boolean showResult;
    private boolean dot=true;
    private String operator;
    private double number1;
    private double number2;
    private double calculate;
    private String savedValues = "";

    Model model = new Model();


    public void processNumber(ActionEvent actionEvent) {

        if (start){
            savedValues="";
            start = false;
        }
        if (backSpace){
            output.setText("");
            backSpace = false;
        }

        dot = true;

        String value = ((Button)actionEvent.getSource()).getText();

        if (!savedValues.equals("0")){
            savedValues = savedValues +value;
            output.setText(output.getText() + value);
        }else {
            savedValues = value;
            output.setText(value);
        }


        if (operator==null){
            number1 = Double.parseDouble(savedValues);
        }else {
            number2 = Double.parseDouble(savedValues);
            end = true;
        }
    }

    public void processOperator(ActionEvent actionEvent) {

        if (operator!=null && end){
            calculate = model.calculate(number1, number2, operator);
            output.setText(String.valueOf(calculate));
            savedValues = String.valueOf(calculate);
            number1 = calculate;
            end = false;
        }


        String value = ((Button)actionEvent.getSource()).getText();
        operator = value;
        output.setText(number1 + operator );

        start = true;

    }

    public void makeNull(ActionEvent actionEvent) {
        output.setText("0");
        operator = null;
        start = true;
        backSpace = true;
        number1 =0;
        number2 = 0;
    }

    public void backSpace(ActionEvent actionEvent) {
        StringBuilder sb = new StringBuilder(output.getText());
        System.out.println(sb);

        try{
            sb.deleteCharAt(sb.length() - 1);

            output.setText(sb.toString());
            if (operator==null || !end){
                number1 = Double.parseDouble(sb.toString());
            }else {
                number2 = Double.parseDouble(sb.toString());
            }
        } catch (Exception e){

            output.setText("0");
            operator = null;
            start = true;
            backSpace = true;
        }




    }

    public void dotAction(ActionEvent actionEvent) {


        if (dot){
            savedValues = savedValues + ".";
            output.setText(output.getText() + ".");
            dot = false;
        }


    }
}
