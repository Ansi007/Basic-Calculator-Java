
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Stack;
import javax.swing.JButton;

public class keyHandler implements ActionListener, MouseListener{

    static String Ans = "";
    static boolean blOpr = false;
    static Stack<String> prevs;
    static double sNum1 = 0,sNum2 = 0;
    static boolean num1 = false, num2 = false;
    static boolean OPR = false;
    static boolean dot = false;
    static double number = 1;
    
    GUI refG;
    keyHandler(GUI g){
            refG = g;
            prevs = new Stack();
    }   
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        
        if(refG.tf.getText().equals("Syntax Error!") || refG.tf.getText().equals("Not defined") || refG.tf.getText().equals("Cannot divide by zero")){
        refG.tf.setText("0");
        }
        
        
        switch(ae.getActionCommand()){
            
        case "0": {
             if(blOpr){
                prevs.push(refG.tf.getText());
                refG.tf.setText(refG.tf.getText().concat(ae.getActionCommand()));
             }
            break;
        }
        
        case "1":
        case "2":
        case "3":
        case "4":
        case "5":
        case "6":
        case "7":
        case "8":
        case "9":
        {
            if(refG.tf.getText().equals("0"))
                refG.tf.setText("");
         
            if(!OPR){
            refG.tf2.setText("");
            refG.tf.setText("");
            OPR = true;
            }
            
            prevs.push(refG.tf.getText());
            blOpr = true;
            refG.tf.setText(refG.tf.getText().concat(ae.getActionCommand()));
            
            break;
        }
        
        case ".":{
        if(!dot){
            prevs.push(refG.tf.getText());
            refG.tf.setText(refG.tf.getText().concat(ae.getActionCommand()));
            dot = true;
        }
        
        break;
        }
        
        case "π":{
        if(refG.tf.getText().equals("0"))
                refG.tf.setText("");
         
            if(!OPR){
            refG.tf2.setText("");
            refG.tf.setText("");
            OPR = true;
            }
            
            prevs.push(refG.tf.getText());
            blOpr = true;
            refG.tf.setText(Math.PI + "");
            
            
        break;
        }
        
        case "e":{
        if(refG.tf.getText().equals("0"))
                refG.tf.setText("");
         
            if(!OPR){
            refG.tf2.setText("");
            refG.tf.setText("");
            OPR = true;
            }
            
            prevs.push(refG.tf.getText());
            blOpr = true;
            refG.tf.setText(Math.E + "");
            
            
        break;
        }
        
        case "sin":{
                OPR = false;
                number = Double.parseDouble(refG.tf.getText());
                refG.tf2.setText("sin(" + number + ")");
                number = Math.sin(Math.toRadians(number));
                Ans = number + "";
                refG.tf.setText(Ans);
                
                break;
               }
                 
                case "cos":{
                    OPR = false;
                number = Double.parseDouble(refG.tf.getText());
                refG.tf2.setText("cos(" + number + ")");
                number = Math.cos(Math.toRadians(number));
                Ans = number + "";
                refG.tf.setText(Ans);
                
                     
                 break;
                 }
                  
                case "tan":{
                    if(number % 180 != 90){
                        OPR = false;
                        number = Double.parseDouble(refG.tf.getText());
                        refG.tf2.setText("tan(" + number + ")");
                number = Math.tan(Math.toRadians(number));
                Ans = number + "";
                refG.tf.setText(Ans);
                
                     
                    }
                    else { 
                        refG.tf.setText("Not defined");
                    
                    }
                 break;
                 }
                   
                case "csc":{
                     if(number % 180 != 0){
                         OPR = false;
                         number = Double.parseDouble(refG.tf.getText());
                         refG.tf2.setText("csc(" + number + ")");
                number = 1/(Math.sin(Math.toRadians(number)));
                Ans = number + "";
                refG.tf.setText(Ans);
                
                     
                     }
                     else { 
                        refG.tf.setText("Not defined");
                    
                    }
                 break;
                 }
                    
                case "sec":{
                    OPR = false;
                    number = Double.parseDouble(refG.tf.getText());
                    refG.tf2.setText("sec(" + number + ")");
                number = 1/(Math.cos(Math.toRadians(number)));
                Ans = number + "";
                refG.tf.setText(Ans);
                
                     
                 break;
                 }
                     
                case "cot":{
                    
                    if(Math.tan(Math.toRadians(number)) != 0){
                        OPR = false;
                        number = Double.parseDouble(refG.tf.getText());
                        refG.tf2.setText("cot(" + number + ")");
                number = 1/(Math.tan(Math.toRadians(number)));
                Ans = number + "";
                refG.tf.setText(Ans);
                
                    
                    }
                    else { 
                        refG.tf.setText("Not defined");
                    
                    }
                 break;
                 }
                 
                case "sqrt":{
                    OPR = false;
                    number = Double.parseDouble(refG.tf.getText());
                    refG.tf2.setText("sqrt(" + number + ")");
                number = Math.sqrt(number);
                Ans = number + "";
                refG.tf.setText(Ans);
                
                
                break;
                }
                
                case "log":{
                    OPR = false;
                number = Double.parseDouble(refG.tf.getText());
                refG.tf2.setText("log(" + number + ")");
                number = Math.log10(number);
                Ans = number + "";
                refG.tf.setText(Ans);
                
                
                break;
                }
                
                case "ln":{
                    OPR = false;
                number = Double.parseDouble(refG.tf.getText());
                refG.tf2.setText("ln(" + number + ")");
                number = Math.log(number);
                Ans = number + "";
                refG.tf.setText(Ans);
                
                
                break;
                }
                
                case "fact": {
                    OPR = false;
                number = Double.parseDouble(refG.tf.getText());
                refG.tf2.setText("fact(" + number + ")");
                 double fact = 1;
                  for(int j = 1; j <= number; j++){    
                    fact = fact * j;    
                 }
                number = fact;        
                Ans = number + "";
                refG.tf.setText(Ans);
                
                 
                 
                break;
                }
     
       
        case "CE":{
        if(!(prevs.isEmpty()))       
        refG.tf.setText(prevs.pop());
        
        break;
        }
        
        case "C":{
            
        refG.tf.setText("0");
        refG.tf2.setText("");
        break;
        }
        
        case "exp":{
        if(!(num1)){
            OPR = false;
                    prevs.push(refG.tf.getText());

        sNum1 = Double.parseDouble(refG.tf.getText());
        refG.tf2.setText("" + sNum1 + ("*10^"));
        num1 = true;
        }
        
        else if((num1)){
        sNum2 = Double.parseDouble(refG.tf.getText());
        refG.tf2.setText(refG.tf2.getText().concat(sNum2 + ("*10^")));
        }
        
      
        
        refG.tf.setText("0");
        break;
        }
        
        case "10^x":{
            OPR = false;
         prevs.push(refG.tf.getText());
                number = Double.parseDouble(refG.tf.getText());
                refG.tf2.setText("10^(" + number + ")");
                number = Math.pow(10, number);
                Ans = number + "";
                refG.tf.setText(Ans);
        break;
        }
        
        case "x^y":{
            OPR = false;
        prevs.push(refG.tf.getText());
        sNum1 = Double.parseDouble(refG.tf.getText());
        refG.tf2.setText(" " + sNum1 + " " + "^" + " ");
        num1 = true;  
        refG.tf.setText("");
        OPR = true;       
        break;
        }
        
        case "^2":{
            OPR = false;
                prevs.push(refG.tf.getText());
                number = Double.parseDouble(refG.tf.getText());
                refG.tf2.setText("sqr(" + number + ")");
                number = number * (number);
                Ans = number + "";
                refG.tf.setText(Ans);
                
        break;
        }
               
        
        case "=": {
           
            
        sNum2 = Double.parseDouble(refG.tf.getText());
        refG.tf2.setText(refG.tf2.getText().concat(sNum2 + " =" ));
        num2 = true;
                
            while(!(prevs.isEmpty()))
                prevs.pop();
            
        refG.tf2.setText(refG.tf2.getText().replace("E", "*10^"));    
        refG.tf2.setText(refG.tf2.getText().replace("mod", "%"));
        refG.tf2.setText(refG.tf2.getText().replace("Ans", Ans));
        refG.tf2.setText(refG.tf2.getText().replace("π", Double.toString(Math.PI)));
        refG.tf2.setText(refG.tf2.getText().replace("e", Double.toString(Math.E)));
        
        double ret = evaluate(refG.tf2.getText());
        if(refG.tf.getText().equals("Syntax Error!") || refG.tf.getText().equals("Not defined") || refG.tf.getText().equals("Cannot divide by zero")){}
        else {
        Ans = ret + "";
        refG.tf.setText(Ans);
        }
        
        sNum1 = Double.parseDouble(Ans);
        OPR = false;
        break;
        }
        
        default:    
        {
          
              
        sNum1 = Double.parseDouble(refG.tf.getText());
        refG.tf2.setText(" " + sNum1 + " " + ae.getActionCommand() + " ");
        num1 = true;  
        refG.tf.setText("");
        OPR = true;
        }
     
    } 
        
}
     
     public double evaluate(String expression)
    {
      
        try {
        char[] tokens = expression.toCharArray();
        
        Stack<Double> values = new Stack<>();
        Stack<Character> ops = new Stack<>();
 
        for (int i = 0; i < tokens.length; i++)
        {
         
            if (tokens[i] >= '0' && tokens[i] <= '9')
            {
                StringBuilder sbuf = new StringBuilder();
                 
                while (true){
                    if(i < tokens.length && tokens[i] == '.')
                        sbuf.append(tokens[i]);
                
                    else if(i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                        sbuf.append(tokens[i]);
                    
                    else break;
                    
                    i++;
                }
                  values.push(Double.parseDouble(sbuf.toString()));  
                  i--;
            }
            
              
            else if(tokens[i] >= 'a' && tokens[i] <= 'z'){
            StringBuilder sb = new StringBuilder();
             while (true){
                   
                    sb.append(tokens[i]);          
                    if(tokens[i++] == ')')
                       break;
                   
                    
                }
             
             
             String s = sb.toString();
             s = s.substring(s.indexOf("(") + 1);
             s = s.substring(0, s.indexOf(")"));
             double number = Double.parseDouble(s);
             
             s = sb.toString();
             s = s.substring(0,s.indexOf("("));
                
                
             switch(s){
                case "sin":{
                    number = Math.sin(Math.toRadians(number));
                 break;
                 }
                 
                case "cos":{
                     number = Math.cos(Math.toRadians(number));
                 break;
                 }
                  
                case "tan":{
                    if(number % 180 != 90)
                     number = Math.tan(Math.toRadians(number));
                    else { 
                        refG.tf.setText("Not defined");
                    return 0;
                    }
                 break;
                 }
                   
                case "csc":{
                     if(number % 180 != 0)
                     number = 1/(Math.sin(Math.toRadians(number)));
                     else { 
                        refG.tf.setText("Not defined");
                    return 0;
                    }
                 break;
                 }
                    
                case "sec":{
                     number = 1/(Math.cos(Math.toRadians(number)));
                 break;
                 }
                     
                case "cot":{
                    if(Math.tan(Math.toRadians(number)) != 0)
                    number = 1/(Math.tan(Math.toRadians(number)));
                    else { 
                        refG.tf.setText("Not defined");
                    return 0;
                    }
                 break;
                 }
                 
                case "sqrt":{
                number = Math.sqrt(number);
                break;
                }
                
                case "log":{
                number = Math.log10(number);
                break;
                }
                
                case "ln":{
                number = Math.log(number);
                break;
                }
                
                case "fact": {
                  double fact = 1;
                  for(int j = 1; j <= number; j++){    
                    fact = fact * j;    
                 }
                  number = fact;        
                break;
                }
                 
             }
             
             DecimalFormat df = new DecimalFormat("#.####");
             df.setRoundingMode(RoundingMode.CEILING);
             number = Double.parseDouble(df.format(number));
             values.push(number);  
             i--;
            }
            
            else if (tokens[i] == '(')
                ops.push(tokens[i]);
 
            else if (tokens[i] == ')')
            {
                  while (ops.peek() != '(')
                  values.push(applyOp(ops.pop(),values.pop(),values.pop()));
                  ops.pop();
            }
 
            
            else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/' || tokens[i] == '^'
                    || tokens[i] == '%') 
            {   
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
 
                ops.push(tokens[i]);
            }
          
        }
 
       
        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
 
       
        return values.pop(); 
        }
        
        catch(UnsupportedOperationException e){
        refG.tf.setText(e.getMessage());  
        return -1;
        }
        
        catch(Exception e){
        refG.tf.setText("Syntax Error!");
        return -1;
        }
        
        
    }
 
    public boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        
        if ((op1 == '*' || op1 == '/' || op1 == '^'  || op1 == '%') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }
 
  
    public double applyOp(char op, double b, double a)
    {
        switch (op)
        {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0)
                throw new
                UnsupportedOperationException("Cannot divide by zero");
            return a / b;
        case '^':
            return Math.pow(a,b);  
         case '%':
            return(a % b);        
        }
        return 0;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
   
    }

    @Override
    public void mouseReleased(MouseEvent me) {
       
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        JButton button = (JButton)me.getSource();
        button.setBackground(Color.WHITE);
    }

    @Override
    public void mouseExited(MouseEvent me) {
        JButton button = (JButton)me.getSource();
        button.setBackground(Color.LIGHT_GRAY);
    }
 
    
   
       
     
     
     
     
}