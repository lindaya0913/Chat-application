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

public class chat extends JFrame
{
	JPanel chatarea;
	JTextField text;
	JButton receive, send;
	
	static JPanel textarea = new JPanel();
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
        
        add(textarea,BorderLayout.NORTH);
    	add(chatarea,BorderLayout.SOUTH);
        
        text = new JTextField();
        text.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        
        send = new JButton("Send");
        send.setBackground(new Color(7, 94, 84));
        send.setForeground(Color.WHITE);
        send.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        send.addActionListener(new Button1Handler());
        
        receive = new JButton("Receive");
        receive.setBackground(new Color(7, 94, 84));
        receive.setForeground(Color.WHITE);
        receive.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        receive.addActionListener(new Button2Handler());

        chatarea.add(receive);
        chatarea.add(text);
        chatarea.add(send);
        
        textarea.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
//        textarea.setBackground(Color.WHITE);
        textarea.setVisible(true);
    }

    private class Button1Handler implements ActionListener{
    	public void actionPerformed(ActionEvent ae){
        	try{
        		String out = text.getText();
                //��r+�ɶ���
                JPanel chatpanel = formatLabel(out);

                //��r�m�k
                JPanel right = new JPanel(new BorderLayout());
                right.add(chatpanel, BorderLayout.LINE_END);
                vertical.add(right);
                vertical.add(Box.createVerticalStrut(15));

                textarea.setLayout(new BorderLayout());
                textarea.add(vertical, BorderLayout.PAGE_START);
                //��J�تť�
                text.setText("");
            }catch(Exception e){
                System.out.println(e);
            }
    	}
    	public JPanel formatLabel(String out){
        	JPanel chatbox = new JPanel();
        	chatbox.setLayout(new BoxLayout(chatbox, BoxLayout.Y_AXIS));//��r�U���ɶ�
            
        	//��r
            JLabel wordlabel = new JLabel("<html><p style = \"width : 120px\">"+out+"</p></html>");
            wordlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
            wordlabel.setBackground(new Color(37, 211, 102));
            wordlabel.setOpaque(true);
            wordlabel.setBorder(new EmptyBorder(5,5,5,5));
            
            //�ɶ�
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            JLabel timelabel = new JLabel();
            timelabel.setText(sdf.format(cal.getTime()));
            
            chatbox.add(wordlabel);
            chatbox.add(timelabel);
            return chatbox;
        }
    }

    //Receive
    private class Button2Handler implements ActionListener{
    	public void actionPerformed(ActionEvent ae){
        	try{
        		String out = text.getText();
                //��r+�ɶ���
                JPanel chatpanel = formatLabel(out);

                //��r�m��
                JPanel left = new JPanel(new BorderLayout());
                left.add(chatpanel, BorderLayout.LINE_START);
                vertical.add(left);
                vertical.add(Box.createVerticalStrut(15));

                textarea.setLayout(new BorderLayout());
                textarea.add(vertical, BorderLayout.PAGE_START);
                //��J�تť�
            }catch(Exception e){
                System.out.println(e);
            }
    	}
    	public JPanel formatLabel(String out){
        	JPanel chatbox = new JPanel();
        	chatbox.setLayout(new BoxLayout(chatbox, BoxLayout.Y_AXIS));//��r�U���ɶ�
            
        	//��r
            JLabel wordlabel = new JLabel("<html><p style = \"width : 120px\">"+out+"</p></html>");
            wordlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
            wordlabel.setBackground(new Color(37, 211, 102));
            wordlabel.setOpaque(true);
            wordlabel.setBorder(new EmptyBorder(5,5,5,5));
            
            //�ɶ�
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            JLabel timelabel = new JLabel();
            timelabel.setText(sdf.format(cal.getTime()));
            
            chatbox.add(wordlabel);
            chatbox.add(timelabel);
            return chatbox;
        }
    }
}
