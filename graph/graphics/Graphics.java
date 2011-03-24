package graph.graphics;

import java.awt.Color;

import javax.vecmath.Color3f;
import javax.vecmath.Point2d;
import javax.vecmath.Point3d;

import com.wolfram.mexpr.MExpr;
import com.wolfram.mexpr.MString;
import com.wolfram.mexpr.MSymbol;

public class Graphics {
	
	protected static final MExpr GraphicsComplex = new MSymbol("GraphicsComplex");
	protected static final MExpr PlotRange = new MSymbol("PlotRange");
	protected static final MExpr FlatSpace = new MSymbol("FlatSpace");
	protected static final MExpr Shape = new MSymbol("Shape");
	protected static final MExpr Options = new MSymbol("Options");
	protected static final MExpr Color3f = new MSymbol("Color3f");
	protected static final MExpr Color255 = new MSymbol("Color255");
	protected static final MExpr Axes = new MSymbol("Axes");
	protected static final MExpr AxesLabel = new MSymbol("AxesLabel");
	protected static final MExpr GraphLabel = new MSymbol("GraphLabel");
	protected static final MExpr True = new MSymbol("True");
	protected static final MExpr Hue = new MSymbol("Hue");
	protected static final MExpr Mesh = new MSymbol("Mesh");
	protected static final MExpr DoubleSurface = new MSymbol("DoubleSurface");
	protected static final MExpr Surface = new MSymbol("Surface");
	protected static final MExpr LightedSurface = new MSymbol("LightedSurface");
	protected static final MExpr Polygon = new MSymbol("Polygon");
	protected static final MExpr Line = new MSymbol("Line");
	protected static final MExpr ColorfulLine = new MSymbol("ColorfulLine");
	protected static final MExpr PointList = new MSymbol("PointList");
	protected static final MExpr QuadArray = new MSymbol("QuadArray");
	protected static final MExpr TriangleArray = new MSymbol("TriangleArray");
	protected static final MExpr Curve = new MSymbol("Curve");
	protected static final MExpr Real = new MSymbol("Real");
	protected static final MExpr Int = new MSymbol("Integer");
	protected static final MExpr Minus = new MSymbol("Minus");
	
	protected static int[] readIndex(MExpr expr){
		//System.out.println("read index "+expr);
		int[] index = new int[expr.length()];
		for(int i=0; i<index.length; i++){
			index[i] = readInteger(expr.part(i+1));
		}
		return index;
	}
	
	protected static Point2d[] readVerts2d(MExpr expr){
		//System.out.println("read verts "+expr);
		Point2d[] vert = new Point2d[expr.length()];
		for(int i=0; i<vert.length; i++){
			vert[i] = readPoint2d(expr.part(i+1));
		}
		return vert;
	}
	
	protected static Point2d readPoint2d(MExpr expr){
		//System.out.println("read point "+expr);
		return new Point2d(readDouble(expr.part(1)),readDouble(expr.part(2)));
	}
	
	protected static Point3d[] readVerts3d(MExpr expr){
		//System.out.println("read verts "+expr);
		Point3d[] vert = new Point3d[expr.length()];
		for(int i=0; i<vert.length; i++){
			vert[i] = readPoint3d(expr.part(i+1));
		}
		return vert;
	}
	
	protected static Point3d readPoint3d(MExpr expr){
		//System.out.println("read point "+expr);
		return new Point3d(readDouble(expr.part(1)),readDouble(expr.part(2)),readDouble(expr.part(3)));
	}
	
	protected static Color3f readColor3f(MExpr expr){
		return new Color3f((float)readDouble(expr.part(1)),(float)readDouble(expr.part(2)),(float)readDouble(expr.part(3)));
	}
	
	protected static Color readColor3fToColor255(MExpr expr){
		System.out.println("color is "+(int)(readDouble(expr.part(1))*255)+","+(int)(readDouble(expr.part(2))*255)+","+(int)(readDouble(expr.part(3))*255));
		return new Color((int)(readDouble(expr.part(1))*255),(int)(readDouble(expr.part(2))*255),(int)(readDouble(expr.part(3))*255));
	}
	
	protected static Color3f readColor255ToColor3f(MExpr expr){
		return new Color3f(((float)readInteger(expr.part(1)))/255,((float)readInteger(expr.part(2)))/255,((float)readInteger(expr.part(3)))/255);
	}
	
	protected static Color readColor255(MExpr expr){
		return new Color(readInteger(expr.part(1)),readInteger(expr.part(2)),readInteger(expr.part(3)));
	}
	
	protected static Color[] readColor255s(MExpr expr){
		Color[] colors = new Color[expr.length()];
		for(int i=1; i<=expr.length(); i++)
			colors[i-1] = readColor255(expr.part(i));

		return colors;
	}
	
	protected static Color[] readColor3fsToColor255s(MExpr expr){
		Color[] colors = new Color[expr.length()];
		for(int i=1; i<=expr.length(); i++)
			colors[i-1] = readColor3fToColor255(expr.part(i));

		return colors;
	}
	
	protected static Color readHueToColor255(MExpr expr){
		return new Color(Color.HSBtoRGB((float)readDouble(expr.part(1)),(float)readDouble(expr.part(2)),(float)readDouble(expr.part(3))));
	}

	protected static Color3f readHueToColor3f(MExpr expr){
		Color c = new Color(Color.HSBtoRGB((float)readDouble(expr.part(1)),(float)readDouble(expr.part(2)),(float)readDouble(expr.part(3))));
		return new Color3f((float)c.getRed()/255,(float)c.getGreen()/255,(float)c.getBlue()/255);
	}
	
	protected static int readInteger(MExpr expr){
		if(expr.head().sameQ(Int))
			return Integer.parseInt(expr.toString());
		else
			return Integer.MIN_VALUE;
	}
	
	protected static double readDouble(MExpr expr){
		if(expr.head().sameQ(Real))
			return Double.parseDouble(expr.toString());
		else if(expr.head().sameQ(Int))
			return Integer.parseInt(expr.toString());
		else if(expr.head().sameQ(Minus))
			return -readDouble(expr.part(1));	
		else
			return Double.NaN;
	}
	
	protected static String readString(MExpr expr){
		return ((MString)expr).toJavaString();
		
	}
}