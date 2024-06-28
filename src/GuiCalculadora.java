import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiCalculadora {
    private JPanel Calculadora;
    private JTextField textField1;
    private JButton ACButton;
    private JButton resta;
    private JButton multiplicacion;
    private JButton igual;
    private JButton division;
    private JButton cButton;
    private JButton a7Button;
    private JButton a6Button;
    private JButton a3Button;
    private JButton a0Button;
    private JButton raiz;
    private JButton a8Button;
    private JButton a5Button;
    private JButton a2Button;
    private JButton cosenoButton;
    private JButton mas;
    private JButton a9Button;
    private JButton a4Button;
    private JButton a1Button;
    private JButton senoButton;

    // Variables para almacenar los números y el operador
    private double num1 = 0;
    private double num2 = 0;
    private String operator = "";

    public GuiCalculadora() {
        // Agregar listeners a los botones de números
        a0Button.addActionListener(e -> textField1.setText(textField1.getText() + "0"));
        a1Button.addActionListener(e -> textField1.setText(textField1.getText() + "1"));
        a2Button.addActionListener(e -> textField1.setText(textField1.getText() + "2"));
        a3Button.addActionListener(e -> textField1.setText(textField1.getText() + "3"));
        a4Button.addActionListener(e -> textField1.setText(textField1.getText() + "4"));
        a5Button.addActionListener(e -> textField1.setText(textField1.getText() + "5"));
        a6Button.addActionListener(e -> textField1.setText(textField1.getText() + "6"));
        a7Button.addActionListener(e -> textField1.setText(textField1.getText() + "7"));
        a8Button.addActionListener(e -> textField1.setText(textField1.getText() + "8"));
        a9Button.addActionListener(e -> textField1.setText(textField1.getText() + "9"));

        // Agregar listeners a los botones de operadores
        mas.addActionListener(e -> handleOperator("+"));
        resta.addActionListener(e -> handleOperator("-"));
        multiplicacion.addActionListener(e -> handleOperator("*"));
        division.addActionListener(e -> handleOperator("/"));

        // Agregar listener al botón de igual
        igual.addActionListener(e -> handleEquals());

        // Agregar listener al botón de AC (borrar todo)
        ACButton.addActionListener(e -> textField1.setText(""));

        // Agregar listener al botón de C (borrar último carácter)
        cButton.addActionListener(e -> {
            String currentText = textField1.getText();
            if (currentText.length() > 0) {
                textField1.setText(currentText.substring(0, currentText.length() - 1));
            }
        });

        // Agregar listener al botón de raíz cuadrada
        raiz.addActionListener(e -> {
            double value = Double.parseDouble(textField1.getText());
            textField1.setText(String.valueOf(Math.sqrt(value)));
        });

        // Agregar listener al botón de seno
        senoButton.addActionListener(e -> {
            double value = Double.parseDouble(textField1.getText());
            textField1.setText(String.valueOf(Math.sin(Math.toRadians(value))));
        });

        // Agregar listener al botón de coseno
        cosenoButton.addActionListener(e -> {
            double value = Double.parseDouble(textField1.getText());
            textField1.setText(String.valueOf(Math.cos(Math.toRadians(value))));
        });
    }

    // Método para manejar la selección de un operador
    private void handleOperator(String op) {
        num1 = Double.parseDouble(textField1.getText());  // Almacena el primer número
        operator = op;  // Almacena el operador
        textField1.setText("");  // Limpia el campo de texto para el segundo número
    }

    // Método para manejar la operación de igual
    private void handleEquals() {
        num2 = Double.parseDouble(textField1.getText());  // Almacena el segundo número
        double result = 0;
        switch (operator) {
            case "+":
                result = num1 + num2;  // Suma
                break;
            case "-":
                result = num1 - num2;  // Resta
                break;
            case "*":
                result = num1 * num2;  // Multiplicaci8n
                break;
            case "/":
                result = num1 / num2;  // División
                break;
        }
        textField1.setText(String.valueOf(result));  // Muestra el resultado
    }

    public static void main(String[] args) {
        // Crear la ventana de la calculadora
        JFrame frame = new JFrame("GuiCalculadora");
        frame.setContentPane(new GuiCalculadora().Calculadora);  // Agregar el panel principal
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Configurar accion de cierre
        frame.pack();  // Ajustar el tamaño de la ventana
        frame.setVisible(true);  // Hacer visible la ventana
    }
}

