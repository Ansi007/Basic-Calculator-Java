
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class GUI extends JFrame {

    JTextField tf2,tf;
    JComboBox<String> cb;
    JButton[] btn;
    
    
GUI(){

    initGUI();

}

void initGUI(){

    setTitle("Calculator");
    Image title = Toolkit.getDefaultToolkit().getImage("C:\\Users\\TAYYAB\\Desktop\\Java\\cal.png");
    setIconImage(title);
    addComponentsToPane(getContentPane());
    pack();
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setVisible(true);
    }

void addComponentsToPane(Container pane){

    pane.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    tf = new JTextField("0");
    tf2 = new JTextField("");
    tf.setHorizontalAlignment(JTextField.RIGHT);
    tf.setHorizontalAlignment(JTextField.LEFT);
    tf.setBorder(null);
    tf2.setBorder(null);
    tf.setEditable(false);
    tf2.setEditable(false);
    cb = new JComboBox<>();
    
    Font tfFont = new Font("SansSerif", Font.BOLD, 20);
    tf.setFont(tfFont); 
    Font btnFont = new Font("Arial", Font.BOLD, 15);
    
    c.gridx = 0;
    c.gridy = 0;
    c.fill = GridBagConstraints.BOTH;
    c.gridheight = 1;
    c.gridwidth = 15;
    pane.add(tf2,c);    
    
    c.gridx = 0;
    c.gridy = 1;
    c.fill = GridBagConstraints.BOTH;
    c.gridheight = 3;
    c.ipady = 50;
    c.gridwidth = 15;
    pane.add(tf,c);    
    c.gridwidth = 2;
    c.gridheight = 1;
    c.ipady = 0;
    c.ipadx = 10;
    c.ipady = 10;
    int x = 0, y = 5;
    btn = new JButton[38];
    for(int i = 0; i < 38; i++){
    btn[i] = new JButton("");
    btn[i].setFocusPainted(false);
    btn[i].setFocusable(false);
    btn[i].addActionListener(new keyHandler(this));
    btn[i].addMouseListener(new keyHandler(this));
    btn[i].setFont(btnFont);
    btn[i].setRolloverEnabled(true);
    btn[i].setBackground(Color.LIGHT_GRAY);
    c.gridx = x;
    c.gridy = y;    
    pane.add(btn[i],c);
    x += 2;
    
    if(x % 10 == 0){
    x = 0; 
    y++;
        }
    
    }
   btn[0].setText("sin");
   btn[1].setText("cos");
   btn[2].setText("tan");
   btn[3].setText("csc");
   btn[4].setText("sec");
   btn[5].setText("cot");
   btn[6].setText("π");
   btn[7].setText("e");
   btn[8].setText("CE");
   btn[9].setText("C");
   btn[10].setText("^2");
   btn[11].setText("exp");
   btn[12].setText("mod");
   btn[13].setText("sqrt");
   btn[14].setText("/");
   btn[15].setText("x^y");
   btn[16].setText("7");
   btn[17].setText("8");
   btn[18].setText("9");
   btn[19].setText("*");
   btn[20].setText("fact");
   btn[21].setText("4");
   btn[22].setText("5");
   btn[23].setText("6");
   btn[24].setText("-");
   btn[25].setText("10^x");
   btn[26].setText("1");
   btn[27].setText("2");
   btn[28].setText("3");
   btn[29].setText("+");
   btn[30].setText("(");
   btn[31].setText(")");
   btn[32].setText("0");
   btn[33].setText(".");
   btn[34].setText("=");
   btn[35].setText("log");
   btn[36].setText("ln");
   btn[37].setText("Ans");
}
}