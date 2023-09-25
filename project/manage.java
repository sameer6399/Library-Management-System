import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class management extends JFrame 
{

//Image img = Toolkit.getDefaultToolkit().getImage("image1.jpeg");
JLabel l1;
private JButton b1,b2,b3,b4,b5;
Container c;

management()
{
ImageIcon icon = new ImageIcon();
setContentPane(new JLabel());
//setPreferredSize(new Dimension(600,600));

c = getContentPane();

b1=new JButton("Add Books");
b2=new JButton("View Books");
b3=new JButton("Update Record");
b4=new JButton("Delete Record");
b5=new JButton("Search Book");

b1.setBounds(115,50,180,30);
b2.setBounds(115,125,180,30);
b3.setBounds(115,200,180,30);
b4.setBounds(115,275,180,30);
b5.setBounds(115,350,180,30);

setSize(400,500);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
c.setLayout(null);
setVisible(true);
setTitle("Library Management System");


b1.setFont(new Font("Arial", Font.BOLD, 10));
b2.setFont(new Font("Arial", Font.BOLD, 10));
b3.setFont(new Font("Arial", Font.BOLD, 10));
b4.setFont(new Font("Arial", Font.BOLD, 10));
b5.setFont(new Font("Arial", Font.BOLD, 10));

c.add(b1);
c.add(b2);
c.add(b3);
c.add(b4);
c.add(b5);

b1.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
AddFrame af=new AddFrame();
dispose();
}
});


b2.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
ViewFrame vf=new ViewFrame();
dispose();
}	
});


b3.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
UpdateFrame uf=new UpdateFrame();
dispose();
}
});


b4.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
DeleteFrame df=new DeleteFrame();
dispose();
}
});

b5.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
Search s = new Search();
dispose();
}
});

}
}


class manage 
{
public static void main(String args[])
	{
	management mg=new management();
	}
}


class dbasecon
{
public void addtodbase(int rnumber,String name1,int marks1)
{

try
{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");

String s1="Insert into Studentman values(?,?,?)";
PreparedStatement s2=con.prepareStatement(s1);
s2.setInt(1,rnumber);
s2.setString(2,name1);
s2.setInt(3,marks1);
ResultSet r1=s2.executeQuery();
boolean record = false;
while(!r1.next()) {
record = true;

con.close();
}
if(record)
JOptionPane.showMessageDialog(new JDialog(),  " Details inserted ");
else 
JOptionPane.showMessageDialog(new JDialog(), " Details inserted ");
}
catch(SQLException e)
{
JOptionPane.showMessageDialog(new JDialog(), "Wrong Details or Duplicate Details Entered");
}

}

public String viewDbase()
{
StringBuffer sb=new StringBuffer();

try
{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");

Statement s1=con.createStatement();
String s2="Select rnumber,name1,marks1 from Studentman";
ResultSet r1=s1.executeQuery(s2);
while(r1.next())
{
sb.append("Sr.No.: " + r1.getInt(1) + " Book Name: " + r1.getString(2) +  "  Quantity: " + r1.getInt(3) + "\n");
}
r1.close();
con.close();
}

catch(SQLException e)
{
System.out.println("Issue " + e);
}
return sb.toString();
}


public void DeleteData(int rnumber)
{
try
{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");

String s1="Delete from Studentman where rnumber= ?";
PreparedStatement s2=con.prepareStatement(s1);
s2.setInt(1,rnumber);
int i = s2.executeUpdate();
if(i > 0)
JOptionPane.showMessageDialog(new JDialog(), "Record Deleted");
else 
JOptionPane.showMessageDialog(new JDialog(), "Record Not Found");

con.close();
}
catch(SQLException e)
{
JOptionPane.showMessageDialog(new JDialog(), "Issue: " + e);
}
}


public void Update(int rnumber,String name1,int marks1) {
try {
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");

String s1 = "update Studentman SET name1 =?,marks1 =? where rnumber = ? ";
PreparedStatement s2 = con.prepareStatement(s1);

s2.setString(1, name1);
s2.setInt(2, marks1);
s2.setInt(3, rnumber);


int r1 = s2.executeUpdate();
if(r1 > 0) 
JOptionPane.showMessageDialog(new JDialog(),"Details Updated");
else 
JOptionPane.showMessageDialog(new JDialog(),"Details Not Found");

con.close();
}
catch(SQLException se) {
JOptionPane.showMessageDialog(new JDialog(), " Issue Detected ");
}
}

public String Search (int rnumber) {
StringBuffer sb=new StringBuffer();

try {
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");

Statement s1 = con.createStatement();
String s2 = "Select rnumber,name1,marks1 from Studentman where rnumber =" + rnumber;
//PreparedStatement s2 = con.prepareStatement(s1);
//s2.setInt(1,rnumber);
ResultSet r1=s1.executeQuery(s2);
if(r1.next())
{ 
sb.append("Sr.No.: " + r1.getInt(1) +"\n" + "Book Name : " + r1.getString(2) +"\n"+  "Quantity: " + r1.getInt(3) +"\n");
}
else 
JOptionPane.showMessageDialog(new JDialog(), " Sr.No. Not Found");
r1.close();
con.close();
}
catch(SQLException se) {
JOptionPane.showMessageDialog(new JDialog(), " Issue Detected");
}
catch(Exception e) {
JOptionPane.showMessageDialog(new JDialog(), "Not Valid Sr.No.");
}


return sb.toString();
}





}

