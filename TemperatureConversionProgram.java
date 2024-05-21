// libraries used are
//1. swing
//2. awt and event.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// here the class function is used as Temperature conversion program..

public class TemperatureConversionProgram {
    // GUI components used are 
    // 1. Frame.
    // 2. TextField.
    // 3.Combo box.
    // 4. Button.
    // 5. label's.
    private JFrame frame;
    private JTextField temperatureField;
    private JComboBox<String> unitComboBox;
    private JButton convertButton;
    private JLabel resultLabel;
    
    // methods formation with Temperature conversion
    public TemperatureConversionProgram() {
        // GUI formation.
        createGUI();
    }
      // Data Hiding with private.
    private void createGUI() {

        // objects creating using
        frame = new JFrame("Temperature Conversion Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel temperatureLabel = new JLabel("Enter temperature:");
        temperatureField = new JTextField(10);

        String[] units = {"Celsius", "Fahrenheit", "Kelvin"};
        unitComboBox = new JComboBox<>(units);

        convertButton = new JButton("Convert");
        convertButton.addActionListener(new ConvertButtonListener());

        resultLabel = new JLabel("");

        frame.add(temperatureLabel);
        frame.add(temperatureField);
        frame.add(unitComboBox);
        frame.add(convertButton);
        frame.add(resultLabel);

        frame.pack();
        frame.setVisible(true);
    }

    private class ConvertButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double temperature = Double.parseDouble(temperatureField.getText());
                String unit = (String) unitComboBox.getSelectedItem();

                String result = convertTemperature(temperature, unit);
                resultLabel.setText(result);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid temperature value. Please enter a number.");
            }
        }
    }

    private String convertTemperature(double temperature, String unit) {
        if (unit.equals("Celsius")) {
            double fahrenheit = celsiusToFahrenheit(temperature);
            double kelvin = celsiusToKelvin(temperature);
            return temperature + " degrees Celsius is equal to " + fahrenheit + " degrees Fahrenheit and " + kelvin + " Kelvin.";
        } else if (unit.equals("Fahrenheit")) {
            double celsius = fahrenheitToCelsius(temperature);
            double kelvin = fahrenheitToKelvin(temperature);
            return temperature + " degrees Fahrenheit is equal to " + celsius + " degrees Celsius and " + kelvin + " Kelvin.";
        } else {
            double celsius = kelvinToCelsius(temperature);
            double fahrenheit = kelvinToFahrenheit(temperature);
            return temperature + " Kelvin is equal to " + celsius + " degrees Celsius and " + fahrenheit + " degrees Fahrenheit.";
        }
    }

    private double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    private double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    private double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    private double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit - 32) * 5/9 + 273.15;
    }

    private double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    private double kelvinToFahrenheit(double kelvin) {
        return (kelvin - 273.15) * 9/5 + 32;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TemperatureConversionProgram();
            }
        });
    }
}