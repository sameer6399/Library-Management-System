import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class ViewFrame extends JFrame
{
Label l1;
TextArea t1;
JButton b1;

ViewFrame()
{

setContentPane(new JLabel());

l1=new Label("Book Details");
t1=new TextArea(7,30);
b1=new JButton("Exit");

setTitle("View Details");
setLayout(new FlowLayout());
setSize(400,500);
setLocationRelativeTo(null);
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

add(l1);
add(t1);
add(b1);
dbasecon dc=new dbasecon();
String data= dc.viewDbase();
t1.setText(data);
Font font = t1.getFont();
float size = font.getSize() ;
t1.setFont(font.deriveFont(size));
t1.setEditable(false);
b1.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
management mg= new management();
dispose();
}
});
}
}