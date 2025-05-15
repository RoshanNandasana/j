import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorRectangle extends JFrame {
    private JPanel colorPanel;

    public ColorRectangle() {
        setTitle("I am a JFrame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setSize(300, 200);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 5, 5));
        
        JButton redButton = new JButton("Red");
        JButton blueButton = new JButton("Blue");
        JButton greenButton = new JButton("Green");

        redButton.addActionListener(e -> changeColor(Color.RED));
        blueButton.addActionListener(e -> changeColor(Color.BLUE));
        greenButton.addActionListener(e -> changeColor(Color.GREEN));

        buttonPanel.add(redButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(greenButton);

        colorPanel = new JPanel();
        colorPanel.setBackground(Color.BLUE);
        colorPanel.setPreferredSize(new Dimension(150, 150));

        add(buttonPanel, BorderLayout.WEST);
        add(colorPanel, BorderLayout.CENTER);

        setLocationRelativeTo(null);
    }

    private void changeColor(Color color) {
        colorPanel.setBackground(color);
        colorPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ColorRectangle frame = new ColorRectangle();
            frame.setVisible(true);
        });
    }
}