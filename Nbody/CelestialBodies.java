import java.awt.Color;
import java.util.*;

public class CelestialBodies{
	private static final double G = 6.673e-11;

	private String name;
	private double mass;
	private double xcoord;
	private double ycoord;
	private double xvel;
	private double yvel;
	private int size;

	private Random rand;
	private Color color;

	private double forcex;
	private double forcey;

	public CelestialBodies(String name, String mass, String xcoord,
		String ycoord, String xvel, String yvel, String size){

		this.name = name;
		this.mass = Double.parseDouble(mass);
		this.xcoord = Double.parseDouble(xcoord);
		this.ycoord = Double.parseDouble(ycoord);
		this.xvel = Double.parseDouble(xvel);
		this.yvel = Double.parseDouble(yvel);
		this.size = Integer.parseInt(size);

		rand = new Random();
		color = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
	}

	public String name(){
		return this.name;
	}
	public double getMass(){
		return this.mass;
	}
	public double getXcoord(){
		return this.xcoord;
	}
	public double getYcoord(){
		return this.ycoord;
	}
	public double getXvel(){
		return this.xvel;
	}
	public double getYvel(){
		return this.yvel;
	}
	public int getSize(){
		return this.size;
	}
	public Color getColor(){
		return this.color;
	}
	
	public void force(CelestialBodies p2, double scale){
		CelestialBodies p1 = this;
		double dx = p1.xcoord - p1.xcoord;
		double dy = p1.ycoord - p1.ycoord;
		double dist = Math.sqrt(dx*dx + dy*dy);
		double force = (G * p1.mass * p2.mass / ((dist * dist) / scale));
		p1.forcex += force*dx / dist;
		p1.forcey += force*dy / dist;
	}
	public void updatePos(){
		xvel += forcex / mass;
		yvel += forcey / mass;
		xcoord += xvel;
		ycoord += yvel;
	}
	public void reset(){
		forcex = 0;
		forcey = 0;
	}
}