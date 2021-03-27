import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
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
        chatarea.setLayout(
        		new BoxLayout(chatarea, BoxLayout.X_AXIS));
        
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
        chatarea.add(Box.createHorizontalStrut(2));
        chatarea.add(text);
        chatarea.add(Box.createHorizontalStrut(6));
        chatarea.add(send);
        chatarea.add(Box.createHorizontalStrut(2));
        
        textarea.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
//        textarea.setBackground(Color.WHITE);
        textarea.setVisible(true);
        
        JScrollPane sp = new JScrollPane(textarea);
        sp.setBorder(BorderFactory.createEmptyBorder());
        
        add(sp, BorderLayout.CENTER);
    	add(chatarea, BorderLayout.SOUTH);
    }

    private class Button1Handler implements ActionListener{
    	public void actionPerformed(ActionEvent ae){
        	try{
            	String out = text.getText();
            	sendTextToFile(out);
            	
            	//image heart
        		ImageIcon heart = new ImageIcon(ClassLoader.getSystemResource("icon/heart.png"));
            	Image heart2 = heart.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
            	ImageIcon heart3 = new ImageIcon(heart2);
            	
                //文字+時間框
                JPanel chatpanel = formatLabel(out, heart3);

                //文字置右
                JPanel right = new JPanel(new BorderLayout());
                right.add(chatpanel, BorderLayout.LINE_END);
                vertical.add(right);
                vertical.add(Box.createVerticalStrut(15));

                textarea.setLayout(new BorderLayout());
                textarea.add(vertical, BorderLayout.PAGE_START);
                //輸入框空白
                text.setText("");
            }catch(Exception e){
                System.out.println(e);
            }
    	}
    	
    	public void sendTextToFile(String text) throws FileNotFoundException{
        	try(
        		FileWriter file = new FileWriter("chat_record.txt",true);
        			PrintWriter print = new PrintWriter(new BufferedWriter(file));){
        		print.println("Heart:" + text+"\r\n");
            }catch(Exception e){
                e.printStackTrace();
            }
    	}
    	
    	public JPanel formatLabel(String out, Icon heart){
        	JPanel chatbox = new JPanel();
        	chatbox.setLayout(new BoxLayout(chatbox, BoxLayout.Y_AXIS));//文字下接時間
            
        	//文字
            JLabel wordlabel = new JLabel();
            wordlabel.setText("<html><p style = \"width : 120px\">"+out+"</p></html>");
            wordlabel.setIcon(heart);
            wordlabel.setHorizontalTextPosition(JLabel.LEFT);
            wordlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
            wordlabel.setBackground(new Color(37, 211, 102));
            wordlabel.setOpaque(true);
            wordlabel.setBorder(new EmptyBorder(5,5,5,5));
            
            //時間
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
        		sendTextToFile(out);
     
        		//image smile
        		ImageIcon smile = new ImageIcon(ClassLoader.getSystemResource("icon/smile.png"));
            	Image smile2 = smile.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
            	ImageIcon smile3 = new ImageIcon(smile2);
            	
                //文字+時間框
                JPanel chatpanel = formatLabel(out, smile3);

                //文字置左
                JPanel left = new JPanel(new BorderLayout());
                left.add(chatpanel, BorderLayout.LINE_START);
                vertical.add(left);
                vertical.add(Box.createVerticalStrut(15));

                textarea.setLayout(new BorderLayout());
                textarea.add(vertical, BorderLayout.PAGE_START);
                //輸入框空白
                text.setText("");
            }catch(Exception e){
                System.out.println(e);
            }
    	}
    	
    	public void sendTextToFile(String text) throws FileNotFoundException{
        	try(FileWriter file = new FileWriter("chat_record.txt",true);
        			PrintWriter p = new PrintWriter(new BufferedWriter(file));){
        		p.println("Smile: "+text+"\t\n");
            }catch(Exception e){
                e.printStackTrace();
            }
    	}
    	
    	public JPanel formatLabel(String out, Icon smile){
        	JPanel chatbox = new JPanel();
        	chatbox.setLayout(new BoxLayout(chatbox, BoxLayout.Y_AXIS));//文字下接時間
            
        	//文字
        	JLabel wordlabel = new JLabel();
            wordlabel.setText("<html><p style = \"width : 120px\">"+out+"</p></html>");
            wordlabel.setIcon(smile);
            wordlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
            wordlabel.setBackground(new Color(37, 211, 102));
            wordlabel.setOpaque(true);
            wordlabel.setBorder(new EmptyBorder(5,5,5,5));
            
            //時間
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
