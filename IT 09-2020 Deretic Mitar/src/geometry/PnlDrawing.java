package geometry;



import java.awt.Color;


import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import geometry.Shape;
import geometry.Point;
import geometry.Line;
import geometry.Rectangle;
import geometry.Circle;
import geometry.Donut;
import gui.ColorChooser;
import gui.DrawingApp;

public class PnlDrawing extends JPanel{
	
	ArrayList<Shape> shapes = new ArrayList<Shape>();
	static PnlDrawing drawing = new PnlDrawing();
    public Point showPoint;
    public Point showPoint2;
    public int showDimension1;
    public int showDimension2;
	
	
	public void addPoint(int x , int y) {
		shapes.add(new Point(x,y,false));
		this.paint(getGraphics());
	}
	
	public void addLine(int x1, int y1, int x2, int y2) {
		shapes.add(new Line(new Point(x1, y1), new Point(x2, y2), false));
		this.paint(getGraphics());
	}
	
	public void addRect(Point p, int w, int h) {
		shapes.add(new Rectangle(p,w,h, false));
		this.paint(getGraphics());
	}
	
	public void addCircle(Point p, int r) {
		shapes.add(new Circle(p,r, false));
		this.paint(getGraphics());
	}
	
	public void addDonut(Point p, int r, int ir) {
		shapes.add(new Donut(p,r,ir, false));
		this.paint(getGraphics());
	}
	
	
	public void checkContain(int x, int y) {
		
		
        
		for (int i = 0; i <shapes.size(); i++) {
			shapes.get(i).setSelected(shapes.get(i).contains(x, y));
			System.out.println("Iz checkContaina: " + shapes.get(i).selected);
			
			if (i == 0) {
				continue;
			}
			
			//IMPLEMENTACIJA Z INDEXIRANJA
			
			for (int h = i - 1; h>=0; h--) {
			if (shapes.get(i).selected == true && shapes.get(h).selected == true) {
				shapes.get(h).selected = false;
			}
			}
		
		}
		
	    //this.paint(getGraphics());	
		
	}
	
	public boolean checkSelectedObj() {
		for (int i = 0; i<shapes.size(); i++) {
			if (shapes.get(i).selected == true) {
				return true;
			}
			
		}
		return false;
	}
	
	public int checkSelectedObjClass() {
		for (int i = 0; i<shapes.size(); i++) {
			if (shapes.get(i).selected == true) {
				if (shapes.get(i) instanceof Point) {
					showPoint = (Point) shapes.get(i);
					return 1;
				}
				if (shapes.get(i) instanceof Line) {
					Line h  = (Line) shapes.get(i);
					showPoint = h.getStartPoint();
					showPoint2 = h.getEndPoint();
					return 2;
				}
				if (shapes.get(i) instanceof Rectangle) {
					Rectangle h  = (Rectangle) shapes.get(i);
					showPoint = h.getUpperLeftPoint();
					showDimension1 = h.getWidth();
					showDimension2 = h.getHeight();
					return 3;
				}
				if (shapes.get(i) instanceof Circle == true && shapes.get(i) instanceof Donut == false) {
					Circle h  = (Circle) shapes.get(i);
					showPoint = h.getCenter();
					showDimension1 = h.getRadius();
					return 4;
				}
				if (shapes.get(i) instanceof Donut) {
					Donut h  = (Donut) shapes.get(i);
					showPoint = h.getCenter();
					showDimension1 = h.getRadius();
					showDimension2 = h.getInnerRadius();
					return 5;
				}
			}
			
		}
		return 0;
		
	}
	
	public void modifySelectedShape(int a ,int b, int c , int d) {
		for (int i = 0; i<shapes.size(); i++) {
			if (shapes.get(i).selected == true) {
				if (shapes.get(i) instanceof Point) {
					Point h = (Point) shapes.get(i);
					h.setX(a);
					h.setY(b);
				}
				if (shapes.get(i) instanceof Line) {
					Line h  = (Line) shapes.get(i);
					h.getStartPoint().setX(a);
					h.getStartPoint().setY(b);
					h.getEndPoint().setX(c);
					h.getEndPoint().setY(d);
				}
				if (shapes.get(i) instanceof Rectangle) {
					Rectangle h  = (Rectangle) shapes.get(i);
					h.getUpperLeftPoint().setX(a);
					h.getUpperLeftPoint().setY(b);
					h.setWidth(c);
					h.setHeight(d);
				}
				if (shapes.get(i) instanceof Circle == true && shapes.get(i) instanceof Donut == false) {
					Circle h  = (Circle) shapes.get(i);
					h.getCenter().setX(a);
					h.getCenter().setY(b);
					h.radius = c;
				}
				if (shapes.get(i) instanceof Donut) {
					Donut h  = (Donut) shapes.get(i);
					h.getCenter().setX(a);
					h.getCenter().setY(b);
					h.radius = c;
					h.innerRadius = d;
					
				}
			}
			
		}
		
	}
	
	public void deleteSelectedShape() {
		for (int i = 0; i<shapes.size(); i++) {
			if (shapes.get(i).selected == true) {
	             shapes.remove(i);
	             this.paint(getGraphics());
			}
			
		}
		
		
	}
	
	
	
	

	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Drawings");
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.getContentPane().add(drawing);
	}
	

	
	
	
	 

	@Override
	public void paint(Graphics g) {
		
		//shapes.add(new Point(30,30));
		//shapes.add(new Point(50,50));
		//shapes.add(new Line(new Point(60,60), new Point(80,60)));
		/*
	    Iterator<Shape> it=shapes.iterator();
		
		while(it.hasNext()) {
			Shape s = it.next();
			s.draw(g);
			System.out.println("Iz painta: " + s.selected);
			//System.out.println(s.toString());
		} 
		
		it = shapes.iterator(); */
		
		for (int i = 0; i < shapes.size(); i++) {
			shapes.get(i).draw(g);
			System.out.println("Iz painta: " + shapes.get(i).selected);
			//System.out.println(s.toString());
		}
		
		 
		 
 
	}
	
	
	

}
