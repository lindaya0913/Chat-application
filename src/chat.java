import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class chat extends JFrame implements ActionListener
{
	JPanel chatarea;
	JTextField text;
	JButton receive;
	JButton send;
	
	static JTextArea textarea = new JTextArea();
	static Box vertical = Box.createVerticalBox();
    
    public chat() 
    {
    	super("Chatroom");
    	this.setSize(300,400);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setLayout(new BorderLayout());
    	this.setResizable(false);
        
        chatarea = new JPanel();
        chatarea.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        chatarea.setLayout(new GridLayout(1,10));
        
        add(textarea,BorderLayout.CENTER);
    	add(chatarea,BorderLayout.SOUTH);
        
        text = new JTextField();
        text.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        
        send = new JButton("Send");
        send.setBackground(new Color(7, 94, 84));
        send.setForeground(Color.WHITE);
        send.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        send.addActionListener(this);
        
        receive = new JButton("Receive");
        receive.setBackground(new Color(7, 94, 84));
        receive.setForeground(Color.WHITE);
        receive.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
//        receive.addActionListener(this);

        chatarea.add(receive);
        chatarea.add(text);
        chatarea.add(send);
   
        textarea.setEditable(false);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        
        textarea.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        textarea.setBackground(Color.WHITE);
        textarea.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
    	try{
    		String out = text.getText();
    		textarea.setText(textarea.getText()+"\n"+out);
        	text.setText("");
    	}catch(Exception e){
            System.out.println(e);
        }
    }
}
