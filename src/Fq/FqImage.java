package Fq;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;

import javax.imageio.ImageIO;

import Fq.Point;
import java.util.*;
import java.util.Vector;

public class FqImage {

	public static final double SOBELDOOR = 80.00;

        public int N = 10;
	public BufferedImage imh;
	public int height;
	public int width;
	public Point[][] points;
	public double[][] sobels;
	public int[][] edge;
        public int[][] Nedge;
        public int[][] vertex;
	public double[]	colorJuH = new double[4];
	public double[]	colorJuS = new double[4];
	public double[]	colorJuV = new double[4];
	public double[]	huJu = new double[8];
	public double[][] A;
        public double[][] B;
        public double[][] C;
        public double[][] Q;
        public double[][] Ix;
        public double[][] Iy;
        public Vector<Corner> Vertex = new Vector<Corner>();
        
	public double getAbsColorDistance( FqImage other )
        {
            int width =	FqMath.min(this.width, other.width);
            int	height = FqMath.min(this.height, other.height);

            int	sum = 0;
            for(int i=0;i<width;i++ )
            {
                for(int j=0;j<height;j++)
                {
                     sum += this.points[i][j].pointDistance(other.points[i][j]);
                }
            }
            return sum;
	}
	
	public double f(int i,int j )
        {
            double temp	= this.points[i][j].getGray();
            return temp;
	}
	
	public void toSobel()
        {
            double fx,fy;
            double sobel;
            int	i,j;
            for(i=1;i<this.width-1;i++)
            {
                for(j=1;j<this.height-1;j++)
                {
                    fx = (f(i-1,j-1) + 2*f(i-1,j) + f(i-1,j+1))	- (f(i+1,j-1) + 2*f(i+1,j) + f(i+1,j+1)	);
                    fy = (f(i-1,j-1) + 2*f(i,j-1) + f(i+1,j-1))	- (f(i-1,j+1) + 2*f(i,j+1) + f(i+1,j+1)	);
                    this.sobels[i][j] =	FqMath.max( Math.abs(fx), Math.abs(fy) );
                }
            }
	}

	public void toEdge()
        {
            int	i , j;
            for(i=0;i<this.width;i++ )
            {
                for(j=0;j<this.height;j++ )
                {
                    if( this.sobels[i][j] > SOBELDOOR )
                        this.edge[i][j] = 1;
                    else
                        this.edge[i][j] = 0;
                }
            }
            for(i=0;i<width/N;i++)
            {
                for(j=0;j<height/N;j++)
                {
                    if(exist(i*N,j*N)) this.Nedge[i][j] = 1;
                    else this.Nedge[i][j] = 0;
                }
            }
	}

        public void toVertex()
        {
            for(int i=0;i<width/N;i++)
            {
                for(int j=0;j<height/N;j++)
                {
                    if(this.Nedge[i][j]==1)
                    {
                        if(sum(i-1,j,i+1,j)==1||sum(i,j-1,i,j+1)==1||sum(i-1,j-1,i+1,j+1)==1||sum(i-1,j+1,i+1,j-1)==1)
                            //if(!exist(i,j))
                                this.vertex[i][j] = 1;
                            //else
                                //this.vertex[i][j] = 0;
                        else
                            this.vertex[i][j] = 0;
                    }
                }
            }
        }

        public boolean exist(int x,int y)
        {
            for(int i=0;i<N;i++)
                for(int j=0;j<N;j++)
                {
                    if(this.edge[x+i][y+j]==1)
                        return true;
                }
            return false;
        }

        public int sum(int x1,int y1,int x2,int y2)
        {
            return Nedge[x1][y1]+Nedge[x2][y2];
        }

	public FqImage cutSmallest()
        {
		final double EDGEDOOR = 4;
		
		int i , j;
		int left = 0;
		int right = 0;
		int top	= 0;
		int bottom = 0;
		int count = 0;
		
		
		for( i = 0 ; i < this.width ; i++ ){
			count = 0;
			for( j = 0 ; j < this.height ; j++ ){
				if( this.edge[i][j] == 1 )
					count++;
			}
			if( count >= EDGEDOOR ){
				left = i;
				break;
			}
		}
		
		for( i = this.width - 1 ; i >= 0 ; i-- ){
			count = 0;
			for( j = 0 ; j < this.height ; j++ ){
				if( this.edge[i][j] == 1 )
					count++;
			}
			if( count >= EDGEDOOR ){
				right = i;
				break;
			}
		}
		
		for( j = 0 ; j < this.height ; j++ ){
			count = 0;
			for( i = 0 ; i < this.width ; i++ ){
				if( this.edge[i][j] == 1 )
					count++;
			}
			if( count >= EDGEDOOR ){
				top = j;
				break;
			}
		}
		
		for( j = this.height - 1 ; j >= 0 ; j-- ){
			count = 0;
			for( i = 0 ; i < this.width ; i++ ){
				if( this.edge[i][j] == 1 )
					count++;
			}
			if( count >= EDGEDOOR ){
				bottom = j;
				break;
			}
		}
		
		BufferedImage subImh	=	this.imh.getSubimage(left, top, right-left , bottom-top);
		return new FqImage(subImh);	
	}
	
	public void setColorJu()
        {
		int i , j;
		int k;
		double	sumh , sums , sumv;
		
		this.colorJuH[1] = 0.0;
		this.colorJuS[1] = 0.0;
		this.colorJuV[1] = 0.0;
		
//		System.out.println(this.width * this.height);
		for( k = 1 ; k <= 3 ; k++ ){
			sumh = 0.0;
			sums = 0.0;
			sumv = 0.0;
			for( i = 0 ; i < this.width ; i++ ){
				for( j = 0 ; j < this.height ; j++ ){
//					double	temp = this.points[i][j].getHHSV();
//					temp -= this.colorJuH[1];
//					temp = Math.pow(temp, k);
//					sumh += temp;
					sumh += Math.pow(( this.points[i][j].getHHSV() - this.colorJuH[1] ),k);
					sums += Math.pow(( this.points[i][j].getSHSV() - this.colorJuS[1] ),k);
					sumv += Math.pow(( this.points[i][j].getVHSV() - this.colorJuV[1] ),k);
				}
			}
			
			
//			System.out.println(k+":");
			
			this.colorJuH[k] = sumh / ( this.width * this.height );				
			if( k == 2 )
				this.colorJuH[k] = Math.sqrt(this.colorJuH[k]);
			if( k == 3 )
				this.colorJuH[k] = Math.cbrt(this.colorJuH[k]);
			
			
//			System.out.println(colorJuH[k]);
			
			this.colorJuS[k] = sums / ( this.width * this.height );
			if( k == 2 )
				this.colorJuS[k] = Math.sqrt(this.colorJuH[k]);
			if( k == 3 )
				this.colorJuS[k] = Math.cbrt(this.colorJuH[k]);
			
			this.colorJuV[k] = sumv / ( this.width * this.height );
			if( k == 2 )
				this.colorJuV[k] = Math.sqrt(this.colorJuH[k]);
			if( k == 3 )
				this.colorJuV[k] = Math.cbrt(this.colorJuH[k]);
			
//			System.out.println("sumh"+sumh+","+"sums"+sums+","+"sumv"+sumv);
		}
	}
	
	public double dColorJu( FqImage imh ){
		double	temph =	0.0;
		double 	temps  = 0.0;
		double 	tempv = 0.0;
		int i;
		double	wh = 5.0;
		double	ws = 0.01;
		double	wv = 0.01;
		for( i = 1 ; i <= 3 ; i++ ){
			temph += (( this.colorJuH[i] - imh.colorJuH[i] ) * ( this.colorJuH[i] - imh.colorJuH[i] ));
			temps += (( this.colorJuS[i] - imh.colorJuS[i] ) * ( this.colorJuS[i] - imh.colorJuS[i] ));
			tempv += (( this.colorJuV[i] - imh.colorJuV[i] ) * ( this.colorJuV[i] - imh.colorJuV[i] ));
		}
		return	Math.sqrt( temph * wh + temps * ws + tempv * wv );
	}
	
	public double m( int p , int q ){
		int 	x , y;
		double 	sum = 0;
		for( x = 0 ; x < this.width ; x++ )
			for( y = 0 ; y < this.height ; y++ )
				sum += Math.pow(x,p) * Math.pow(y,q) * this.edge[x][y];
		return sum;
	}
	
	public double miu( int p , int q ){
		int x , y;
		double 	x0 , y0;
		double	sum = 0;
		x0 = m(1,0) / m(0,0);
		y0 = m(0,1) / m(0,0);		
		for( x = 0 ; x < this.width ; x++ )
			for( y = 0 ; y < this.height ; y++ )
				sum += Math.pow((x-x0), p) * Math.pow((y-y0), q) * this.edge[x][y];
		return sum;
	}
	
	public double eda( int p , int q ){
		int g = p+q+2;
		return miu(p,q) / Math.sqrt( Math.pow( miu(0,0), g ) );
	}
		
	
	public void toHuJu(){
		double	eda20 = eda(2,0);
		double	eda02 = eda(0,2);
		double 	eda22 = eda(2,2);
		double 	eda11 = eda(1,1);
		double	eda30 = eda(3,0);
		double	eda03 = eda(0,3);
		double	eda21 = eda(2,1);
		double	eda12 = eda(1,2);
		
		this.huJu[1] = eda20 + eda02;
		this.huJu[2] = (eda20-eda02) * (eda20-eda02)+4 * eda11 * eda11;
		this.huJu[3] = (eda30-3*eda12) * (eda30-3*eda12) + (eda03-3*eda21) * (eda03-3*eda21);
		this.huJu[4] = (eda30+eda12) * (eda30+eda12) + (eda21+eda03) * (eda21+eda03);
		this.huJu[5] = (eda30-3*eda12) * (eda30+eda12) * ((eda30+eda12)*(eda30+eda12) - 3*(eda21+eda03)*(eda21+eda03))
				+(3*eda21-eda03) * (eda21+eda03) * (3*(eda30+eda12)*(eda30+eda12) - (eda21+eda03)*(eda21+eda03));
		this.huJu[6] = (eda20-eda02) * ((eda30+eda12)*(eda30+eda12) - (eda21+eda03)*(eda21+eda03)) +
				4 * eda11 * (eda30+eda12) * (eda21+eda03);
		this.huJu[7] = (3*eda21-eda03) * (eda30+eda12) * ((eda30+eda12)*(eda30+eda12) - 3*(eda21+eda03)*(eda21+eda03))	+
				(3*eda12-eda30) * (eda03+eda21) * (	3*(eda30+eda12)*(eda30+eda12) - (eda21+eda03)*(eda21+eda03)	);							
	}
	
	public double dHuJu( FqImage imh ){
		int i;
		double[] wHu = new double[8];
		wHu[1] = 1.0;
		wHu[2] = 1.0;
		wHu[3] = 1.0;
		wHu[4] = 1.0;
		wHu[5] = 1.0;
		wHu[5] = 1.0;
		wHu[6] = 1.0;
		wHu[7] = 1.0;
		double	sum = 0.0;
		for( i = 1 ; i <= 7 ; i++ )
			sum += wHu[i] *	( this.huJu[i] - imh.huJu[i] ) * ( this.huJu[i] - imh.huJu[i] );
		return	Math.sqrt(sum) * 10000;
	}

        public void doSmooth()
        {
            for(int i=1;i<width-1;i++)
                for(int j=1;j<height-1;j++)
                {
                    this.points[i][j].gray = (4*(f(i-1,j-1)+f(i+1,j-1)+f(i-1,j+1)+f(i+1,j+1))+10*(f(i-1,j)+f(i+1,j)+f(i,j-1)+f(i,j+1))+25*f(i,j))/81;
                }
        }

        public void toIxy()
        {
            for(int i=1;i<width-1;i++)
            {
                for(int j=1;j<height-1;j++)
                {
                    this.Ix[i][j] = 0.453014*(f(i+1,j)-f(i-1,j));
                    this.Iy[i][j] = 0.453014*(f(i,j+1)-f(i,j-1));
                }
            }
        }

        public void toA()
        {
            for(int i=1;i<width-1;i++)
                for(int j=1;j<height-1;j++)
                {
                    this.A[i][j] = this.Ix[i][j]*this.Ix[i][j];
                }
        }

        public void toB()
        {
            for(int i=1;i<width-1;i++)
                for(int j=1;j<height-1;j++)
                {
                    this.B[i][j] = this.Iy[i][j]*this.Iy[i][j];
                }
        }

        public void toC()
        {
            for(int i=1;i<width-1;i++)
                for(int j=1;j<height-1;j++)
                {
                    this.C[i][j] = this.Ix[i][j]*this.Iy[i][j];
                }
        }

        public void toQ()
        {
            for(int i=1;i<width-1;i++)
                for(int j=1;j<height-1;j++)
                {
                    this.Q[i][j] = Math.abs((A[i][j]*B[i][j]-C[i][j]*C[i][j])-0.05*((A[i][j]+B[i][j])*(A[i][j]+B[i][j])));
                }
        }

        public boolean isLocalMax(int u,int v)
        {
            if(u<=0||u>=width-1||v<=0||v>=height-1)
                return false;
            else
            {
                return (Q[u][v]>Q[u-1][v-1])&&(Q[u][v]>Q[u][v-1])&&(Q[u][v]>Q[u+1][v-1])&&(Q[u][v]>Q[u-1][v])
                        &&(Q[u][v]>Q[u+1][v])&&(Q[u][v]>Q[u-1][v+1])&&(Q[u][v]>Q[u][v+1])&&(Q[u][v]>Q[u+1][v+1]);
            }
        }

        public Vector<Corner> collectCorners(int border)
        {
            Vector<Corner> cornerVector = new Vector<Corner>();
            for(int u=border;u<width-border;u++)
                for(int v=border;v<height-border;v++)
                {
                    if(Q[u][v]>25000&&isLocalMax(u,v))
                    {
                        Corner c = new Corner(u,v,Q[u][v]);
                        cornerVector.add(c);
                    }
                }
            Collections.sort(cornerVector);
            //this.printCorner(cornerVector);
            return cornerVector;
        }

        public Vector<Corner> cleanupCorner(Vector<Corner> corner)
        {
            double d = 100;
            Vector<Corner> goodCorner = new Vector<Corner>();
            while(corner.size()!=0)
            {
                Corner first = corner.get(0);
                goodCorner.add(first);
                corner.removeElementAt(0);
                for(int i=0;i<corner.size();i++)
                {
                    if(corner.get(i).dist(first)<d)
                        corner.removeElementAt(i);
                }
            }
            return goodCorner;
        }
        
        public void printCorner(Vector<Corner> corner)
        {
            for(int i=0;i<corner.size();i++)
                System.out.println(corner.elementAt(i).u+" "+corner.elementAt(i).v);
        }
        
	public FqImage( BufferedImage imh ){
		this.imh = imh;
		this.height = imh.getHeight(null);
		this.width = imh.getWidth(null);
		this.points = new Point[width][height];
		this.sobels = new double[width][height];
		this.edge = new int[width][height];
		this.vertex = new int[width/N][height/N];
                this.Nedge = new int[width/N][height/N];
                this.A = new double[width][height];
                this.B = new double[width][height];
                this.C = new double[width][height];
                this.Q = new double[width][height];
                this.Ix = new double[width][height];
                this.Iy = new double[width][height];
                
		int i,j;
		for( i = 0 ; i < this.width ; i++ ){
			for( j = 0 ; j < this.height ; j++ ){
				this.points[i][j] = new Point();
				this.points[i][j].setRGB( imh.getRGB(i, j) );
				this.points[i][j].toRed();
				this.points[i][j].toGreen();
				this.points[i][j].toBlue();
				this.points[i][j].toGray();
				this.points[i][j].toHSV();
			}
		}
                //提取轮廓
		this.toSobel();
		this.toEdge();
                //this.toVertex();
		this.setColorJu();
		this.toHuJu();
                //提取角点
                this.doSmooth();
                this.toIxy();
                
                this.toA();
                //this.printA();
                this.toB();
                this.toC();
                this.toQ();
                //printQ();
                Vector<Corner> corner = new Vector<Corner>();
                corner = this.collectCorners(10);
                corner = this.cleanupCorner(corner);
                printCorner(corner);
                this.Vertex = corner;
                //System.out.println(corner.size());
	}
		
}
