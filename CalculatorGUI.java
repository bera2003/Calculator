import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI {
    private JFrame frame;
    private JTextField textField1, textField2, resultField;
    private JComboBox<String> operationBox;

    public CalculatorGUI() {
        frame = new JFrame("Calculator");
        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 2));

        textField1 = new JTextField();
        textField2 = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);

        String[] operations = {"+", "-", "*", "/", "sin", "cos", "tan"};
        operationBox = new JComboBox<>(operations);
        
        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResult();
            }
        });

        frame.add(new JLabel("Number 1:"));
        frame.add(textField1);
        frame.add(new JLabel("Number 2:"));
        frame.add(textField2);
        frame.add(new JLabel("Operation:"));
        frame.add(operationBox);
        frame.add(new JLabel("Result:"));
        frame.add(resultField);
        frame.add(new JLabel(""));
        frame.add(calculateButton);
        
        frame.setVisible(true);
}
private void calculateResult() {
    try {
        double num1 = Double.parseDouble(textField1.getText());
        double num2 = textField2.getText().isEmpty() ? 0 : Double.parseDouble(textField2.getText());
        String operation = (String) operationBox.getSelectedItem();
        double result = 0;