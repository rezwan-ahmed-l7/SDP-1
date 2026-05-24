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

    private double firstNumber = 0;
    private String operator = "";
    private boolean newCalculation = false;

    @Override
    public void start(Stage stage) {

        double WIN_WIDTH = 300;
        double WIN_HEIGHT = 400;

        Image icon = new Image("Calculator.png");
        stage.getIcons().add(icon);

        TextField display = new TextField();
        display.setEditable(false);
        display.setPrefHeight(60);
        display.setStyle("-fx-font-size: 24; -fx-alignment: right;");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Button[] numbers = new Button[10];
        for (int i = 0; i <= 9; i++) {
            numbers[i] = new Button(String.valueOf(i));
            numbers[i].setPrefSize(60, 60);
            numbers[i].setStyle("-fx-font-size: 18;");
        }

        Button add = new Button("+");
        Button sub = new Button("-");
        Button mul = new Button("*");
        Button div = new Button("/");
        Button eq = new Button("=");
        Button ac = new Button("AC");
        Button dot = new Button(".");
        Button percent = new Button("%");
        Button square = new Button("x²");
        Button root = new Button("√");

        add.setPrefSize(60, 60);
        sub.setPrefSize(60, 60);
        mul.setPrefSize(60, 60);
        div.setPrefSize(60, 60);
        eq.setPrefSize(60, 60);
        ac.setPrefSize(60, 60);
        dot.setPrefSize(60, 60);
        percent.setPrefSize(60, 60);
        square.setPrefSize(60, 60);
        root.setPrefSize(60, 60);

        add.setStyle("-fx-font-size: 18; -fx-base: #99fe26;");
        sub.setStyle("-fx-font-size: 18; -fx-base: #99fe26;");
        mul.setStyle("-fx-font-size: 18; -fx-base: #99fe26;");
        div.setStyle("-fx-font-size: 18; -fx-base: #99fe26;");
        ac.setStyle("-fx-font-size: 18; -fx-base: #e9824f;");
        dot.setStyle("-fx-font-size: 18;");
        percent.setStyle("-fx-font-size: 18; -fx-base: #99fe26;");
        square.setStyle("-fx-font-size: 18; -fx-base: #99fe26;");
        root.setStyle("-fx-font-size: 18; -fx-base: #99fe26;");
        eq.setStyle("-fx-font-size: 18; -fx-base: #2e88ff;");

        grid.add(numbers[7], 0, 0);
        grid.add(numbers[8], 1, 0);
        grid.add(numbers[9], 2, 0);
        grid.add(div, 3, 0);

        grid.add(numbers[4], 0, 1);
        grid.add(numbers[5], 1, 1);
        grid.add(numbers[6], 2, 1);
        grid.add(mul, 3, 1);

        grid.add(numbers[1], 0, 2);
        grid.add(numbers[2], 1, 2);
        grid.add(numbers[3], 2, 2);
        grid.add(sub, 3, 2);

        grid.add(numbers[0], 0, 3);
        grid.add(dot, 1, 3);
        grid.add(percent, 2, 3);
        grid.add(add, 3, 3);

        grid.add(square, 0, 4);
        grid.add(root, 1, 4);
        grid.add(ac, 2, 4);
        grid.add(eq, 3, 4);

        for (int i = 0; i <= 9; i++) {
            int digit = i;
            numbers[i].setOnAction(e -> {
                if (newCalculation) {
                    display.clear();
                    newCalculation = false;
                }
                display.setText(display.getText() + digit);
            });
        }

        dot.setOnAction(e -> {
            if (newCalculation) {
                display.clear();
                newCalculation = false;
            }
            if (!display.getText().contains(".")) {
                display.setText(display.getText() + ".");
            }
        });

        add.setOnAction(e -> setOperator(display, "+"));
        sub.setOnAction(e -> setOperator(display, "-"));
        mul.setOnAction(e -> setOperator(display, "*"));
        div.setOnAction(e -> setOperator(display, "/"));

        percent.setOnAction(e -> {
            try {
                double currentValue = Double.parseDouble(display.getText());
                double percentValue = currentValue / 100;
                display.setText(String.valueOf(percentValue));
                newCalculation = true;
            } catch (NumberFormatException ex) {
                display.setText("Error");
            }
        });

        square.setOnAction(e -> {
            try {
                double currentValue = Double.parseDouble(display.getText());
                double squareValue = currentValue * currentValue;
                if (squareValue == (long) squareValue) {
                    display.setText(String.valueOf((long) squareValue));
                } else {
                    display.setText(String.valueOf(squareValue));
                }
                newCalculation = true;
            } catch (NumberFormatException ex) {
                display.setText("Error");
            }
        });

        root.setOnAction(e -> {
            try {
                double currentValue = Double.parseDouble(display.getText());
                if (currentValue < 0) {
                    display.setText("Error");
                } else {
                    double rootValue = Math.sqrt(currentValue);
                    if (rootValue == (long) rootValue) {
                        display.setText(String.valueOf((long) rootValue));
                    } else {
                        display.setText(String.valueOf(rootValue));
                    }
                    newCalculation = true;
                }
            } catch (NumberFormatException ex) {
                display.setText("Error");
            }
        });

        eq.setOnAction(e -> {
            try {
                double secondNumber = Double.parseDouble(display.getText());
                double result = 0;

                if (operator.equals("+")) {
                    result = firstNumber + secondNumber;
                } else if (operator.equals("-")) {
                    result = firstNumber - secondNumber;
                } else if (operator.equals("*")) {
                    result = firstNumber * secondNumber;
                } else if (operator.equals("/")) {
                    if (secondNumber == 0) {
                        display.setText("Error");
                        return;
                    }
                    result = firstNumber / secondNumber;
                }

                if (result == (long) result) {
                    display.setText(String.valueOf((long) result));
                } else {
                    display.setText(String.valueOf(result));
                }
                newCalculation = true;
                operator = "";
            } catch (NumberFormatException ex) {
                display.setText("Error");
            }
        });

        ac.setOnAction(e -> {
            display.clear();
            firstNumber = 0;
            operator = "";
            newCalculation = false;
        });

        VBox rootLayout = new VBox(10, display, grid);
        rootLayout.setStyle("-fx-padding: 15; -fx-background-color: #000000;");

        Scene scene = new Scene(rootLayout, WIN_WIDTH, WIN_HEIGHT);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void setOperator(TextField display, String op) {
        try {
            firstNumber = Double.parseDouble(display.getText());
            operator = op;
            display.clear();
            newCalculation = false;
        } catch (NumberFormatException e) {
            display.setText("Error");
        }
    }

    public static void main(String[] args) {
        launch();
    }
}