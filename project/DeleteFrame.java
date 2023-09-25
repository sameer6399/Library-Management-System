import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class DeleteFrame extends JFrame
{

JButton b1,b2;
Label l1;
TextField tf1;

DeleteFrame()
{

setContentPane(new JLabel());

l1=new Label("Enter Sr.No.");
tf1=new TextField(30);
b1=new JButton("Delete");
b2=new JButton("Exit");

setTitle("Delete Record");
setLayout(new FlowLayout());
setSize(400,500);
setVisible(true);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

add(l1);
add(tf1);
add(b1);
add(b2);

b1.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{ 
try {
int id=Integer.parseInt(tf1.getText());

dbasecon dc=new dbasecon();
dc.DeleteData(id);
}catch(Exception e) {
JOptionPane.showMessageDialog(new JDialog(), "Invalid details ");
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