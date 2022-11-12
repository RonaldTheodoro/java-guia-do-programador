package br.com.codetalker.chapter04;

import java.awt.Container;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TemperatureConversor extends JFrame {
    private JTextField celsiusInput, fahrenheitInput;
    private JButton cleanBtn, converterBtn;
    private JLabel celsiusLabel, fahrenheitLabel;
    private DecimalFormat decimalFormat = new DecimalFormat("###,##0.000");

    public TemperatureConversor() {
        super("Conversor");

        celsiusLabel = SwingFactory.createLabel("Celsius");
        fahrenheitLabel = SwingFactory.createLabel("Fahrenheit");

        celsiusInput = SwingFactory.createTextField();
        fahrenheitInput = SwingFactory.createTextField();

        cleanBtn = SwingFactory.createButton(
                "Limpar",
                "Limpa as caixas de entrada");
        converterBtn = SwingFactory.createButton(
                "Converter",
                "Efetua a conversão do valor dado");

        Container container = getContentPane();
        container.setLayout(SwingFactory.createGridLayout());
        container.add(celsiusLabel);
        container.add(celsiusInput);
        container.add(fahrenheitLabel);
        container.add(fahrenheitInput);
        container.add(cleanBtn);
        container.add(converterBtn);

        cleanBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cleanBtnClick();
            }
        });
        converterBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                converterBtnClick();
            }
        });

        container.setBackground(Color.orange);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    public static void main(String[] args) {
        new TemperatureConversor().setVisible(true);
    }

    private void converterBtnClick() {
        try {
            Temperature temperature = getTemperature();
            setCelsiusInputText(temperature.getCelsius());
            setFahrenheitInputText(temperature.getFahrenheit());
        } catch (NumberFormatException exc) {
            requestFocusForTextField(getTextFieldToFocus());
        }
    }

    private Temperature getTemperature() {
        double result = convertTemperature();
        String celsius = "";
        String fahrenheit = "";

        if (shouldConvertCelsiusToFahrenheit()) {
            fahrenheit = formatResult(result);
        } else if (shouldConvertFahrenheitToCelsius()) {
            celsius = formatResult(result);
        }

        return new Temperature(fahrenheit, celsius);
    }

    private double convertTemperature() {
        if (shouldConvertCelsiusToFahrenheit()) {
            return Conversor.celsiusToFahrenheit(getCelsius());
        } else if (shouldConvertFahrenheitToCelsius()) {
            return Conversor.fahrenheitToCelsius(getFahrenheit());
        }
        return 0;
    }

    private boolean shouldConvertCelsiusToFahrenheit() {
        return isFahrenheitInputEmpty() && !isCelsiusInputEmpty();
    }

    private boolean shouldConvertFahrenheitToCelsius() {
        return isCelsiusInputEmpty() && !isFahrenheitInputEmpty();
    }

    private boolean isCelsiusInputEmpty() {
        return celsiusInput.getText().equals("");
    }

    private boolean isFahrenheitInputEmpty() {
        return fahrenheitInput.getText().equals("");
    }

    private void cleanBtnClick() {
        setCelsiusInputText("");
        setFahrenheitInputText("");
    }

    private void setCelsiusInputText(String text) {
        celsiusInput.setText(text);
    }

    private void setFahrenheitInputText(String text) {
        fahrenheitInput.setText(text);
    }

    private double getCelsius() {
        return Double.parseDouble(celsiusInput.getText());
    }

    private double getFahrenheit() {
        return Double.parseDouble(fahrenheitInput.getText());
    }

    private void requestFocusForTextField(JTextField textField) {
        textField.selectAll();
        textField.requestFocus();
        Toolkit.getDefaultToolkit().beep();
    }

    private String formatResult(double result) {
        return "" + decimalFormat.format(result);
    }

    private JTextField getTextFieldToFocus() {
        JTextField field = null;
        if (shouldConvertCelsiusToFahrenheit()) {
            field = celsiusInput;
        } else if (shouldConvertFahrenheitToCelsius()) {
            field = fahrenheitInput;
        }
        return field;
    }

    private class Conversor {
        public static double celsiusToFahrenheit(double celsius) {
            return 9 * celsius / 5 + 32;
        }

        public static double fahrenheitToCelsius(double fahrenheit) {
            return 5 * (fahrenheit - 32) / 9;
        }
    }

    private class Temperature {
        private String fahrenheit;
        private String celsius;

        public Temperature(String fahrenheit, String celsius) {
            this.fahrenheit = fahrenheit;
            this.celsius = celsius;
        }

        public String getFahrenheit() {
            return this.fahrenheit;
        }

        public String getCelsius() {
            return this.celsius;
        }
    }
}
