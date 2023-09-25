import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class UpdateFrame extends JFrame
{

JButton b1,b2;
Label l1,l2,l3;
TextField tf1,tf2,tf3; 


UpdateFrame()
{

setContentPane(new JLabel());

l1=new Label("Enter Sr.No");
tf1=new TextField(30);
l2=new Label("Enter Book Name");
tf2=new TextField(30);
l3=new Label("Enter Quantity");
tf3=new TextField(30);
b1=new JButton("Update");
b2=new JButton("Exit");

setTitle("Update Data");
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
dbasecon dc=new dbasecon();
int rnumber=Integer.parseInt(tf1.getText());
String name1=tf2.getText();
int marks1=Integer.parseInt(tf3.getText());

dc.Update(rnumber,name1,marks1); 
}
catch(NumberFormatException e) {
JOptionPane.showMessageDialog(new JDialog(), " please enter valid details");
}
catch(Exception e) {
JOptionPane.showMessageDialog(new JDialog(), " please enter all details " );
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
