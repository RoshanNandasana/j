import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InvestmentCalculator extends JFrame {
    private JTextField amountField, yearField, interestField, futureValueField;

    public InvestmentCalculator() {
        setTitle("Investment Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));
        setSize(300, 200);

        add(new JLabel("Amount:"));
        amountField = new JTextField(10);
        add(amountField);

        add(new JLabel("Year:"));
        yearField = new JTextField(10);
        add(yearField);

        add(new JLabel("Interest Rate:"));
        interestField = new JTextField(10);
        add(interestField);

        add(new JLabel("Future Value:"));
        futureValueField = new JTextField(10);
        futureValueField.setEditable(false);
        futureValueField.setBackground(Color.LIGHT_GRAY);
        add(futureValueField);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateFutureValue();
            }
        });
        add(calculateButton);

        setLocationRelativeTo(null);
    }

    private void calculateFutureValue() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            int year = Integer.parseInt(yearField.getText());
            double interestRate = Double.parseDouble(interestField.getText()) / 100;
            
            double futureValue = amount * Math.pow(1 + interestRate, year);
            futureValueField.setText(String.format("%.2f", futureValue));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "An error occurred!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InvestmentCalculator calc = new InvestmentCalculator();
            calc.setVisible(true);
        });
    }
}