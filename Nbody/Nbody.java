import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.io.*;
import java.util.*;
//import java.util.Scanner;

public class Nbody extends JPanel implements ActionListener{ //Action Listener is an interface{	
	
	private final static int maxX = 768 , maxY = 768;
	private List<CelestialBodies> list;
	private double scale;

	public Nbody(List<CelestialBodies> list, double scale){
		this.list = list;
		this.scale = scale;
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g); //'super' bc g comes from JPanel
		Timer tm = new Timer(5, this); //this refers to actionlistener

		try{
			for(int i=0; i<list.size(); i++){
				g.setColor(list.get(i).getColor());
				g.fillOval((int)list.get(i).getXcoord(), (int)list.get(i).getYcoord(), 
							(int)list.get(i).getSize(), (int)list.get(i).getSize());
			}
		}
		catch(Exception e){
			System.out.println("Error detected\n" + e);
		}
		
		tm.start(); //starts timer and then actionListener
	}
	public void updatePos(){
		try{
			for(int i=0; i < list.size(); i++){
			list.get(i).force(list.get(i+1),scale);
			list.get(i).updatePos();
			list.get(i).reset();
			}
		}
		catch(Exception e){
				System.out.println("Error detected\n" + e);
		}
	}
	public void actionPerformed(ActionEvent e){
		updatePos();
		repaint(); //this method repaints the rect every 5 mili seconds
	}

	public static void main(String[] args){
		JFrame jf = new JFrame();

		List<CelestialBodies> readList = null;
		double readScale = 0;

	
		try{
			File file = new File(args[0]);
			Scanner scan = new Scanner(file);
			String listType = scan.nextLine();

			if(listType.equals("ArrayList"))
				readList = new ArrayList<CelestialBodies>();
			else if(listType.equals("LinkedList"))
				readList = new LinkedList<CelestialBodies>();
			else
				System.out.println("Not a valid data structure");

			readScale = Double.parseDouble(scan.nextLine());
			scan.useDelimiter(",");
			while(scan.hasNext()){
				readList.add(new CelestialBodies(scan.next(), scan.next(),scan.next(),scan.next(), scan.next(),scan.next(),scan.next()));
			}
		}
		catch(FileNotFoundException e){
			System.out.println("Sorry, unable to find file.");
		}

		Nbody nBody = new Nbody(readList, readScale);

		jf.setTitle("NBody");
		jf.setSize(nBody.maxX, nBody.maxY); //define window size in class
		jf.add(nBody);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
}