 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MayProblem3 extends JFrame {
    private JTextField txtField;
    private JButton[] numberButtons;
    private JButton[] operationButtons;
    private JButton clear;
    private CalculatorLogic calculator;

    public MayProblem3() {
        setTitle("Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        txtField = new JTextField();
        txtField.setPreferredSize(new Dimension(400, 50));
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(4, 4));
        numberButtons = new JButton[10];
        
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            panel1.add(numberButtons[i]);
        }

        operationButtons = new JButton[5];
        operationButtons[0] = new JButton("+");
        operationButtons[1] = new JButton("-");
        operationButtons[2] = new JButton("*");
        operationButtons[3] = new JButton("/");
        operationButtons[4] = new JButton("=");

        for (JButton button : operationButtons) {
            panel1.add(button);
        }

        clear = new JButton("C");
        panel1.add(clear);
        add(txtField, BorderLayout.NORTH);
        add(panel1, BorderLayout.CENTER);
        calculator = new CalculatorLogic(txtField, numberButtons, operationButtons, clear);
        setVisible(true);
    }

    public static void main(String[] args) {
        MayProblem3 newCalc = new MayProblem3();
    }
}

class CalculatorLogic implements ActionListener {
    private JTextField txtField;
    private JButton[] numberButtons;
    private JButton[] operationButtons;
    private JButton clear;

    private int firstNum;
    private int secondNum;
    private int sum;
    private char operator;

    public CalculatorLogic(JTextField txtField, JButton[] numberButtons, JButton[] operationButtons, JButton clear) {
        this.txtField = txtField;
        this.numberButtons = numberButtons;
        this.operationButtons = operationButtons;
        this.clear = clear;

        for (JButton button : numberButtons) {
            button.addActionListener(this);
        }
        for (JButton button : operationButtons) {
            button.addActionListener(this);
        }
        clear.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        for (int i = 0; i < 10; i++) {
            if (source == numberButtons[i]) {
                txtField.setText(txtField.getText().concat(String.valueOf(i)));
                return;
            }
        }
        if (source == clear) {
            txtField.setText("");
            firstNum = 0;
            secondNum = 0;
            sum = 0;
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (source == operationButtons[i]) {
                firstNum = Integer.parseInt(txtField.getText());
                operator = operationButtons[i].getText().charAt(0);
                txtField.setText("");
                return;
            }
        }
        if (source == operationButtons[4]) {
            secondNum = Integer.parseInt(txtField.getText());
            switch (operator) {
                case '+':
                    sum = firstNum + secondNum;
                    break;
                case '-':
                    sum = firstNum - secondNum;
                    break;
                case '*':
                    sum = firstNum * secondNum;
                    break;
                case '/':
                    if (secondNum != 0) {
                        sum = firstNum / secondNum;
                    } else {
                        txtField.setText("Cannot divide by zero");
                        return;
                    }
                    break;
            }

            txtField.setText(String.valueOf(sum));
        }
    }
}
