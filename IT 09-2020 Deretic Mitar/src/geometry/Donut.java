  
package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle {

	protected int innerRadius;

	public Donut() {
	}

	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		this.innerRadius = innerRadius;
	}

	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this(center, radius, innerRadius);
		setSelected(selected);
	}
	
	public double area() {
		return super.area() - innerRadius*innerRadius*Math.PI;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Donut) {
			Donut pomocni = (Donut) obj;
			if (getCenter().equals(pomocni.getCenter()) && getRadius() == pomocni.getRadius() && innerRadius == pomocni.innerRadius) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public boolean contains(int x, int y) {
		double dFromCenter = getCenter().distance(x, y);
		return super.contains(x, y) && dFromCenter > innerRadius;
	}
	
	public boolean contains(Point p) {
		double dFromCenter = getCenter().distance(p.getX(), p.getY());
		return super.contains(p.getX(), p.getY()) && dFromCenter > innerRadius;
	}	

	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.drawOval(center.getX()-innerRadius, center.getY()-innerRadius, innerRadius*2, innerRadius*2);
		
		if(selected == true) {
			g.setColor(Color.blue);
			g.drawRect(this.getCenter().getX() - innerRadius - 2, this.getCenter().getY() - 2, 4, 4);
			g.drawRect(this.getCenter().getX() + innerRadius - 2, this.getCenter().getY() - 2, 4, 4);
			g.drawRect(this.getCenter().getX() - 2, this.getCenter().getY() - innerRadius - 2, 4, 4);
			g.drawRect(this.getCenter().getX() - 2, this.getCenter().getY() + innerRadius - 2, 4, 4);
		}
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Donut) {
			return (int)(this.area()-((Donut)o).area());
		}
		return 0;
	}

	public String toString() {
		return super.toString()+", innerRadius="+innerRadius;
	}
	
	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}

}