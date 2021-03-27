import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import javax.swing.*;

public class chat extends JFrame
{
	JPanel chatarea;
	JTextField text;
	JButton receive;
	JButton send;
	
	TextArea textarea=new TextArea();
	static Box vertical = Box.createVerticalBox();
	static DataInputStream din;
    static DataOutputStream dout;
    
    public chat() 
    {
    	super("²á¤Ñ«Ç");
    	this.setSize(300,400);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setLayout(new BorderLayout());
    	this.setResizable(false);
        
        chatarea = new JPanel();
        chatarea.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        chatarea.setLayout(new GridLayout(1,6));
        
        add(textarea,BorderLayout.CENTER);
    	add(chatarea,BorderLayout.SOUTH);
        
        text = new JTextField();
        text.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        
        send = new JButton("Send");
        send.setBackground(new Color(7, 94, 84));
        send.setForeground(Color.WHITE);
        send.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
//        send.addActionListener(this);

        
        receive = new JButton("Receive");
        receive.setBackground(new Color(7, 94, 84));
        receive.setForeground(Color.WHITE);
        receive.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
//        receive.addActionListener(this);

        chatarea.add(receive);
        chatarea.add(text);
        chatarea.add(send);

//        frame.getContentPane().setBackground(Color.WHITE);
//        frame.setLayout(null);
//        frame.setSize(450, 700);
//        frame.setLocation(1100, 200); 
//        frame.setUndecorated(true);
//        frame.setVisible(true);
        textarea.setBackground(Color.WHITE);
        textarea.setVisible(true);
    }
    private class TextArea extends JPanel
    {
    	
    }
}
