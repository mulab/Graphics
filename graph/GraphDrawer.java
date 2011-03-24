package graph;

import java.awt.Color;
import java.awt.Rectangle;

import graph.data.Graph;
import graph.data.graph2d.Graph2D;
import graph.data.graph3d.Graph3D;
import graph.drawer.BasicDrawer;
import graph.drawer.Drawer2D;
import graph.drawer.Drawer3D;
import graph.graphics.Graphics2D;
import graph.graphics.Graphics3D;

import javax.swing.*;

import com.wolfram.mexpr.MExpr;
import com.wolfram.mexpr.MSymbol;

public class GraphDrawer{
	
	private static final MExpr Graphics2D = new MSymbol("Graphics2D");
	private static final MExpr Graphics3D = new MSymbol("Graphics3D");
	
	private JPanel panel=null;
	private BasicDrawer drawer;
	private Graph graph;
	private Rectangle r1=new Rectangle(100,100,400,300);
	private Rectangle r2=new Rectangle(100,100,500,500);
	
	public GraphDrawer(MExpr expr,String path){
		System.out.println(expr);
		
		if(expr.head().sameQ(Graphics2D)){
			Graphics2D graphics = new Graphics2D(expr);
			graph = graphics.getGraph();
			drawer = new Drawer2D((Graph2D)graph,r1);
			panel = drawer.exportPanel();
			
			JFrame frame = new JFrame();
		    frame.setBackground(Color.WHITE);
			frame.setBounds(r1);
			frame.getContentPane().add(panel);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			
			drawer.exportImage(path);
			System.exit(0);
		}
		else if(expr.head().sameQ(Graphics3D)){
			Graphics3D graphics = new Graphics3D(expr);
			graph = graphics.getGraph();
			drawer = new Drawer3D((Graph3D)graph,r2);
			panel = drawer.exportPanel();
			
			JFrame frame = new JFrame();
		    frame.setBackground(Color.WHITE);
			frame.setBounds(r2);
			frame.getContentPane().add(drawer.exportPanel());
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			System.out.println("frame appear");
			
			drawer.exportImage(path);
			System.out.println("screen shot got");
			System.exit(0);
		}
		else{
			return;
		}
	}
	
	

	public void setBounds(Rectangle r){
		this.r1=r;
	}
	
	public JPanel exportPanel(){
		return panel;
	}
}
