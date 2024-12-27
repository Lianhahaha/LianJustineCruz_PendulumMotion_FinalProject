/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cruzlianjustine_physicscalculator;

/**
 *
 * @author Francis
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CruzLianJustine_physicsCalculator {

        

   public static void main(String[] args) {
    // Constants
    final double defaultGravity = 9.81; // Default acceleration due to gravity in m/s² (Earth)

    // Create a JFrame for user input and output
    JFrame frame = new JFrame("Pendulum Motion Calculator");
    JPanel panel = new JPanel();
    frame.setSize(400, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create components for input and result display
    JTextField lengthField = new JTextField(10);
    JTextField angleField = new JTextField(10);
    JTextField gravityField = new JTextField(10);
    JLabel resultLabel = new JLabel("Results will appear here");
    JButton calculateButton = new JButton("Calculate");
    JButton resetButton = new JButton("Reset");
    JLabel gravityLabel = new JLabel("Gravity (m/s²) [default 9.81]:");

    // Set default values
    gravityField.setText(String.valueOf(defaultGravity));

    // Layout for user inputs
    panel.setLayout(new GridLayout(5, 2));
    panel.add(new JLabel("Pendulum Length (m):"));
    panel.add(lengthField);
    panel.add(new JLabel("Release Angle (degrees):"));
    panel.add(angleField);
    panel.add(gravityLabel);
    panel.add(gravityField);
    panel.add(calculateButton);
    panel.add(resetButton);
    panel.add(resultLabel);

                    
    frame.add(panel, BorderLayout.CENTER);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

    
    calculateButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {
                // Get the user's input
                double length = Double.parseDouble(lengthField.getText());
                double angle = Double.parseDouble(angleField.getText());
                double gravity = Double.parseDouble(gravityField.getText());

                // Calculate period, frequency, and then max velocity
                double period = 2 * Math.PI * Math.sqrt(length / gravity);
                double frequency = 1 / period;
                double maxVelocity = Math.sqrt(2 * gravity * length);

                // Calculate ur max angular displacement
                double maxAngleRad = Math.toRadians(angle);
                double displacement = length * Math.sin(maxAngleRad); // Max displacement in meters

                // Format the results
                String result = String.format(
                    "<html>Period: %.2f s<br>Frequency: %.2f Hz<br>Max Velocity: %.2f m/s<br>Max Displacement: %.2f m</html>",
                    period, frequency, maxVelocity, displacement
                );

                // Display the result
                resultLabel.setText(result);
            } catch (NumberFormatException ex) {
                // Show error message if the input is invalid
                JOptionPane.showMessageDialog(frame, "Please enter valid numbers for all fields.",
                                              "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    });

    
    resetButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            lengthField.setText("");
            angleField.setText("");
            gravityField.setText(String.valueOf(defaultGravity));
            resultLabel.setText("Results will appear here");
        }
    });
}
}