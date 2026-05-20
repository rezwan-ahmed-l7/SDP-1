package calculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator extends Application {

    double firstNumber = 0;
    String operator = "";

    @Override
    public void start(Stage stage) {

        Image icon = new Image("Calculator.png");
        stage.getIcons().add(icon);

        TextField display = new TextField();
        display.setEditable(false);

        GridPane grid = new GridPane();

        grid.setHgap(10);
        grid.setVgap(10);

        Button btn1 = new Button("1");
        Button btn2 = new Button("2");
        Button btn3 = new Button("3");
        Button btn4 = new Button("4");
        Button btn5 = new Button("5");
        Button btn6 = new Button("6");
        Button btn7 = new Button("7");
        Button btn8 = new Button("8");
        Button btn9 = new Button("9");
        Button btn0 = new Button("0");

        Button add = new Button("+");
        Button sub = new Button("-");
        Button mul = new Button("*");
        Button div = new Button("/");

        Button equal = new Button("=");
        Button clear = new Button("C");
        Button dot = new Button(".");

        grid.add(btn7, 0, 0);
        grid.add(btn8, 1, 0);
        grid.add(btn9, 2, 0);

        grid.add(btn4, 0, 1);
        grid.add(btn5, 1, 1);
        grid.add(btn6, 2, 1);

        grid.add(btn1, 0, 2);
        grid.add(btn2, 1, 2);
        grid.add(btn3, 2, 2);

        grid.add(btn0, 1, 3);

        grid.add(dot, 0, 3);
        grid.add(equal, 2, 3);

        grid.add(add, 3, 0);
        grid.add(sub, 3, 1);
        grid.add(mul, 3, 2);
        grid.add(div, 3, 3);

        grid.add(clear, 0, 4);

        btn1.setOnAction(e -> {
            display.setText(display.getText() + "1");
        });

        btn2.setOnAction(e -> {
            display.setText(display.getText() + "2");
        });

        btn3.setOnAction(e -> {
            display.setText(display.getText() + "3");
        });

        btn4.setOnAction(e -> {
            display.setText(display.getText() + "4");
        });

        btn5.setOnAction(e -> {
            display.setText(display.getText() + "5");
        });

        btn6.setOnAction(e -> {
            display.setText(display.getText() + "6");
        });

        btn7.setOnAction(e -> {
            display.setText(display.getText() + "7");
        });

        btn8.setOnAction(e -> {
            display.setText(display.getText() + "8");
        });

        btn9.setOnAction(e -> {
            display.setText(display.getText() + "9");
        });

        btn0.setOnAction(e -> {
            display.setText(display.getText() + "0");
        });

        dot.setOnAction(e -> {

            if (!display.getText().contains(".")) {
                display.setText(display.getText() + ".");
            }

        });

        add.setOnAction(e -> {

            firstNumber = Double.parseDouble(display.getText());
            operator = "+";
            display.clear();

        });

        sub.setOnAction(e -> {

            firstNumber = Double.parseDouble(display.getText());
            operator = "-";
            display.clear();

        });

        mul.setOnAction(e -> {

            firstNumber = Double.parseDouble(display.getText());
            operator = "*";
            display.clear();

        });

        div.setOnAction(e -> {

            firstNumber = Double.parseDouble(display.getText());
            operator = "/";
            display.clear();

        });

        equal.setOnAction(e -> {

            double secondNumber = Double.parseDouble(display.getText());

            double result = 0;

            if (operator.equals("+")) {

                result = firstNumber + secondNumber;

            }

            else if (operator.equals("-")) {

                result = firstNumber - secondNumber;

            }

            else if (operator.equals("*")) {

                result = firstNumber * secondNumber;

            }

            else if (operator.equals("/")) {

                if (secondNumber == 0) {

                    display.setText("Error");
                    return;

                }

                result = firstNumber / secondNumber;

            }

            display.setText(String.valueOf(result));

        });

        clear.setOnAction(e -> {

            display.clear();

            firstNumber = 0;
            operator = "";

        });

        VBox root = new VBox();

        root.setSpacing(10);

        root.getChildren().addAll(display, grid);

        Scene scene = new Scene(root, 300, 300);

        stage.setTitle("Calculator");

        stage.setScene(scene);

        stage.show();

    }

    public static void main(String[] args) {

        launch();

    }

}