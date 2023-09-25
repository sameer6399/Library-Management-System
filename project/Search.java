import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class Search extends JFrame {

JButton b1,b2;
Label l1;
TextField t1;
TextArea ta1;

Search() {
setContentPane(new JLabel());

l1 = new Label("Enter Sr.No.:     ");
t1 = new TextField(25);
ta1 = new TextArea(7,25);
b1 = new JButton("Show Books");
b2 = new JButton("Back");

setSize(400,500);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(new FlowLayout());
setVisible(true);
setTitle("Search");

add(l1);
add(t1);

add(ta1);
add(b1);
add(b2);

b1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
try {
dbasecon dc = new dbasecon();

int rnumber = Integer.parseInt(t1.getText());

String data = dc.Search(rnumber);
ta1.setText(data);
Font font = ta1.getFont();
float size = font.getSize() + 4.0f;

}catch(Exception e ) {
JOptionPane.showMessageDialog(new JDialog(), " Please Enter Valid Sr.No. ");
}

}
});

b2.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
management mg = new management();
dispose();
}
});

}

}
