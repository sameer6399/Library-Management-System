import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class AddFrame extends JFrame
{
JButton b1,b2;
Label l1,l2,l3;
TextField tf1,tf2,tf3; 
AddFrame()
{

setContentPane(new JLabel());

l1=new Label("Enter Sr.No. ");
tf1=new TextField(30);
l2=new Label("Enter Book Name ");
tf2=new TextField(30);
l3=new Label("Enter Quantity ");
tf3=new TextField(30);
b1=new JButton("Enter");
b2=new JButton("Exit");
setTitle("Add Books");
setLayout(new FlowLayout());
setSize(400,500);
setVisible(true);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
add(l1);
add(tf1);
add(l2);
add(tf2);
add(l3);
add(tf3);
add(b1);
add(b2);
b1.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
try {
int rno=Integer.parseInt(tf1.getText());
String name=tf2.getText();
int marks=Integer.parseInt(tf3.getText());
if(String.valueOf(rno) == null && name == null && String.valueOf(marks) == null) 
JOptionPane.showMessageDialog(new JDialog(), "Enter All Details" );

dbasecon dc=new dbasecon();
if(rno>0 && name.length()>2 && marks<=100 && marks>0 )
{
dc.addtodbase(rno,name,marks);
}
else
{
JOptionPane.showMessageDialog(new JDialog(), " Wrong Values " );
}
}
catch(NumberFormatException e) {
JOptionPane.showMessageDialog(new JDialog(), "Enter Valid Details");
}
catch (Exception e) {
JOptionPane.showMessageDialog(new JDialog(), "Enter all Details" );
}

}
});

b2.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
management mg=new management();
dispose();
}
});



}
}
 