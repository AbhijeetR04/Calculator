import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class calculator implements ActionListener {
    JFrame frame; // jframe object.
    JTextField textField; // textfield object.
    JButton[] numberButtons = new JButton[10]; // number array of size 10.
    JButton[] functionButtons = new JButton[9]; // function array of size 9.
    JButton addButton, subButton, divButton, mulButton, decButton, equButton, delButton, clrbutton, negButton;
    JPanel panel; // jpanel object.
    Font myFont = new Font("Ink Free", Font.BOLD,30); // designing new font.
    double num1 = 0, num2 = 0, result = 0;
    char operator;
    calculator(){
        // designing frame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);
        frame.setResizable(false);

        // designing textFiled
        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);
        textField.setEditable(false); // user can only edit through buttons.

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("DEL");
        clrbutton = new JButton("CLR");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrbutton;
        functionButtons[8] = negButton;

        for(int i = 0; i < 9; i++){ // setting action listner in every function button.
            functionButtons[i].addActionListener(this); // 'this' means that the actionListener constructor is in the same class.
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }
        for(int i = 0; i < 10; i++){ // giving input to number button.
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }
        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrbutton.setBounds(250,430,100,50);
        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.gray);

        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrbutton);
        frame.add(textField);
        frame.setVisible(true);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 10; i++){
            if(e.getSource() == numberButtons[i]){ // number gets written into the textfield.
                textField.setText(textField.getText().concat(String.valueOf(i))); // "" + valueof(1);
            }
        }
        if(e.getSource() == decButton){
            textField.setText(textField.getText().concat(".")); // decimal into the textfield.
        }
        if(e.getSource() == addButton){ // string to double value.
            num1 = Double.parseDouble(textField.getText()); // the number in the textfield gets assigned to num1.
            operator = '+'; // operator changes to +.
            textField.setText(""); // Nothing is written into the textfield.
        }
        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if(e.getSource() == equButton){
            num2 = Double.parseDouble(textField.getText());

            switch (operator){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if(e.getSource() == clrbutton){
            textField.setText("");
        }
        if(e.getSource() == delButton){
            String string = textField.getText();
            textField.setText("");
            for(int i = 0; i < string.length()-1; i++){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
        if(e.getSource() == negButton){
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }

    }

    public static void main(String[] args) {
        calculator cal = new calculator();
    }
}
