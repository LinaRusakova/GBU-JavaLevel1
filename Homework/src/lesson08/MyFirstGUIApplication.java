package lesson08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MyFirstGUIApplication extends JFrame {


    public MyFirstGUIApplication() {
        JFrame jFrame = new JFrame();
        jFrame.setTitle("My First GUI Application");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

// узнаем размер экрана
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        //задаем расположение "по центру"
        jFrame.setBounds(width / 2 - 300, height / 2 - 200, 600, 285);
        jFrame.setAlwaysOnTop(true);
        jFrame.setLayout(null);

        Font  myFontMain  = new Font(Font.DIALOG_INPUT,  Font.BOLD|Font.ITALIC, 15);

        //add panel1
        JPanel panel1 = new JPanel();
        panel1.setSize(600, 50);
        JLabel jLabelHello = new JLabel("<html><h2 ><center>Hello World!!");
        jLabelHello.setSize(200, 45);
        panel1.add(jLabelHello);
        jFrame.add(panel1);

        //add panel2
        JPanel panel2 = new JPanel();
        panel2.setLocation(0, 51);
        panel2.setSize(600, 50);
        JLabel jLabelAbout = new JLabel("<html><h3>This my application for generate random password for you!");
        jLabelAbout.setSize(450, 40);
        panel2.add(jLabelAbout);
        jFrame.add(panel2);
        //add panel3
        JPanel panel3 = new JPanel();
        panel3.setLocation(0, 100);
        panel3.setSize(600, 40);
        JLabel numberEnter = new JLabel("Enter N from 4 to 16");
        numberEnter.setFont(myFontMain);
        JTextField field = new JTextField(3);
        //field.setSize(100,30);
        panel3.add(numberEnter);
        panel3.add(field);
        jFrame.add(panel3);

        JButton jButtonGenerate = new JButton("<html><h3><font size=\"14px\" color=\"white\">G e n e r a t e !");
        jButtonGenerate.setBounds(jFrame.getWidth() / 2 - 75, 140, 150, 30);
        Color greyColor = new Color(105, 105, 107);
        jButtonGenerate.setBackground(greyColor);
        jFrame.add(jButtonGenerate);


        //add panel4
        JPanel panel4 = new JPanel();
        panel4.setLocation(0, 170);
        panel4.setSize(600, 50);
        JLabel result = new JLabel("<html><h3>Result password:");
        result.setSize(100, 40);
        JTextField resultvalue = new JTextField(30);
        resultvalue.setSize(100, 40);
        resultvalue.setBackground(Color.white);
        resultvalue.setOpaque(true);
        panel4.add(result);
        panel4.add(resultvalue);
        jFrame.add(panel4);

        //add panel5
        JPanel panel5 = new JPanel();
        panel5.setLocation(0, 210);
        panel5.setSize(600, 40);
        JLabel author = new JLabel("<html><h3><i>By Lina Rusakova, at Student of GeekBrains University.");
        author.setLocation(10,10);
        author.setSize(600, 40);
        panel5.setBackground(Color.darkGray);
        author.setBackground(Color.darkGray);
        author.setForeground(Color.white);
        author.setOpaque(true);
        panel5.add(author);
        jFrame.add(panel5);

        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Your message: " + field.getText());
                runGenerate(field, resultvalue, panel4, jFrame);

            }
        });

        jButtonGenerate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                runGenerate(field, resultvalue, panel4, jFrame);
            }
        });


        jFrame.setVisible(true);

    }

    private void runGenerate(JTextField field, JTextField resultvalue, JPanel panel4, JFrame jFrame) {
        randomGenerate(field.getText());
        resultvalue.setText(randomGenerate(field.getText()));
        panel4.add(resultvalue);
        jFrame.add(panel4);
    }

    private String randomGenerate(String text) {

        int enterNumber = 0;
        try {
            // String преобразуем в int
            enterNumber = Integer.parseInt(text.trim());
            if (enterNumber >= 4 && enterNumber <= 16)
                return randomString(enterNumber);
            else return "Вы ввели число за пределами диапазона от 4 до 16!";



        } catch (NumberFormatException nfe) {
            return "Вы ввели не число!";
        }


    }

    private String randomString(int enterNumber) {
        String txtA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String txta = txtA.toLowerCase();
        String numbers = "1234567890";
        String passwordTxt = txtA + txta + numbers;
        String result = "";
        for (int n = 0; n < enterNumber; n++) {
            int random_number = 1 + (int) (Math.random() * passwordTxt.length()-1);
            result += passwordTxt.charAt(random_number);
        }
        return result;
    }

}


class MainClassGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyFirstGUIApplication();
            }
        });
    }

}



