package gui;

import java.awt.event.*;    
import java.awt.*;    
import javax.swing.*;
import geometry.PnlDrawing;
public class ColorChooser extends JFrame implements ActionListener {
	
	public Color chosenShapeColor = Color.white;
	public Color chosenBorderColor = Color.black;
	protected boolean forShape;
	
	
	
JButton b;    
Container c;    
public ColorChooser(boolean forShape){
	setTitle("SELECT COLOR");    
    c=getContentPane();    
    c.setLayout(new FlowLayout());         
    b=new JButton("CHOOSE COLOR");    
    b.addActionListener(this);         
    c.add(b);    
    
    JButton btnNewButton = new JButton("OK");
    btnNewButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    		dispose();
    		
    	}
    });
    getContentPane().add(btnNewButton);
    this.forShape = forShape;
}    
public void actionPerformed(ActionEvent e) {    
Color initialcolor=Color.RED;    
Color color=JColorChooser.showDialog(this,"Select a color",initialcolor);    
c.setBackground(color);
if (forShape == true) {
chosenShapeColor = color;
} else {chosenBorderColor = color;}
}    
    
public static void main(String[] args) {    
    ColorChooser ch=new ColorChooser(false);    
    ch.setSize(400,400);    
    ch.setVisible(true);    
    ch.setDefaultCloseOperation(EXIT_ON_CLOSE);    
}    
}  