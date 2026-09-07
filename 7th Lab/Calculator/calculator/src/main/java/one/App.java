package one;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    double firstNumber = 0;
    String operator = "";

    @Override
    public void start(Stage stage) {

        TextField display = new TextField();
        display.setEditable(false);
        display.setPrefHeight(50);
        display.setStyle("-fx-font-size: 18px;");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);

        Button btn0 = new Button("0");
        Button btn1 = new Button("1");
        Button btn2 = new Button("2");
        Button btn3 = new Button("3");
        Button btn4 = new Button("4");
        Button btn5 = new Button("5");
        Button btn6 = new Button("6");
        Button btn7 = new Button("7");
        Button btn8 = new Button("8");
        Button btn9 = new Button("9");

        Button btnAdd = new Button("+");
        Button btnSub = new Button("-");
        Button btnMul = new Button("*");
        Button btnDiv = new Button("/");
        Button btnEqual = new Button("=");
        Button clear = new Button("C");
        Button dot = new Button(".");

        grid.add(btn7, 0, 0);
        grid.add(btn8, 1, 0);
        grid.add(btn9, 2, 0);
        grid.add(btnDiv, 3, 0);

        // Row 1
        grid.add(btn4, 0, 1);
        grid.add(btn5, 1, 1);
        grid.add(btn6, 2, 1);
        grid.add(btnMul, 3, 1);

        // Row 2
        grid.add(btn1, 0, 2);
        grid.add(btn2, 1, 2);
        grid.add(btn3, 2, 2);
        grid.add(btnSub, 3, 2);

        // Row 3
        grid.add(btn0, 0, 3);
        grid.add(dot, 1, 3);
        grid.add(btnEqual, 2, 3);
        grid.add(btnAdd, 3, 3);

        // Row 4
        grid.add(clear, 0, 4);

        btn0.setOnAction(e -> display.setText(display.getText() + "0"));
        btn1.setOnAction(e -> display.setText(display.getText() + "1"));
        btn2.setOnAction(e -> display.setText(display.getText() + "2"));
        btn3.setOnAction(e -> display.setText(display.getText() + "3"));
        btn4.setOnAction(e -> display.setText(display.getText() + "4"));
        btn5.setOnAction(e -> display.setText(display.getText() + "5"));
        btn6.setOnAction(e -> display.setText(display.getText() + "6"));
        btn7.setOnAction(e -> display.setText(display.getText() + "7"));
        btn8.setOnAction(e -> display.setText(display.getText() + "8"));
        btn9.setOnAction(e -> display.setText(display.getText() + "9"));

        dot.setOnAction(e -> {
            if (!display.getText().contains(".")) {
                display.setText(display.getText() + ".");
            }
        });

        clear.setOnAction(e -> {
            display.clear();
            firstNumber = 0;
            operator = "";
        });

        btnAdd.setOnAction(e -> {
            if (!display.getText().isEmpty()) {
                firstNumber = Double.parseDouble(display.getText());
                operator = "+";
                display.clear();
            }
        });

        btnSub.setOnAction(e -> {
            if (!display.getText().isEmpty()) {
                firstNumber = Double.parseDouble(display.getText());
                operator = "-";
                display.clear();
            }
        });

        btnMul.setOnAction(e -> {
            if (!display.getText().isEmpty()) {
                firstNumber = Double.parseDouble(display.getText());
                operator = "*";
                display.clear();
            }
        });

        btnDiv.setOnAction(e -> {
            if (!display.getText().isEmpty()) {
                firstNumber = Double.parseDouble(display.getText());
                operator = "/";
                display.clear();
            }
        });

        btnEqual.setOnAction(e -> {
            if (!display.getText().isEmpty() && !operator.isEmpty()) {
                double secondNumber = Double.parseDouble(display.getText());
                double result = 0;

                if (operator.equals("+")) {
                    result = firstNumber + secondNumber;
                } else if (operator.equals("-")) {
                    result = firstNumber - secondNumber;
                } else if (operator.equals("*")) {
                    result = firstNumber * secondNumber;
                } else if (operator.equals("/")) {
                    result = firstNumber / secondNumber;
                }

                display.setText(String.valueOf(result));
                operator = "";
            }
        });

        VBox root = new VBox(15, display, grid);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-padding: 15;");

        Scene scene = new Scene(root, 340, 420);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}