
package sobel;

import Fq.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedWriter bw=new BufferedWriter(new FileWriter("res.txt"));
        BufferedWriter bw1=new BufferedWriter(new FileWriter("vertex.txt"));
        //for(int i=1;i<=5000;i++)
        //{
            BufferedImage im = ImageIO.read(new File("image/test5.jpg"));
            FqImage	imh = new FqImage(im);
            System.out.println("ok");
            outPut(im,imh,bw,bw1);
            //printHuJu(imh ,bw);
        //}
        bw.close();
        bw1.close();
    }

    public static void outPut(BufferedImage im,FqImage imh,BufferedWriter bw,BufferedWriter bw1) throws IOException
    {
        File outputFile = new File("res.jpg");
        File outputFileV = new File("vertex.jpg");
        int i , j;
        for( i = 0 ; i < imh.width ; i++ )
        {
            for( j = 0 ; j < imh.height ; j++ )
            {
                if( imh.edge[i][j] == 1 )
                {
                    im.setRGB(i, j, 1590888);
                    bw.write("Point:"+" "+i+" "+j);
                    bw.newLine();
                }
                else
                {
                    im.setRGB(i, j, 1);
                }
                
            }
        }
        for(int ii=0;ii<imh.width/imh.N;ii++)
            for(int jj=0;jj<imh.height/imh.N;jj++)
            {
                if( imh.vertex[ii][jj] == 1 )
                {
                    bw1.write("Vertex:"+" "+ii*imh.N+" "+jj*imh.N);
                    bw1.newLine();
                }
            }
        ImageIO.write(im, "JPEG", outputFile);

        for( i = 0 ; i < imh.width ; i++ )
        {
            for( j = 0 ; j < imh.height ; j++ )
            {
                if(isVertex(i,j,imh))
                {
                    im.setRGB(i, j, 1);
                }
                else
                {
                    im.setRGB(i, j, 6736067);
                }

            }
        }
        ImageIO.write(im, "JPEG", outputFileV);
    }

    public static boolean isVertex(int x,int y,FqImage imh)
    {
        for(int i=0;i<imh.Vertex.size();i++)
        {
            if(imh.Vertex.elementAt(i).u==x&&imh.Vertex.elementAt(i).v==y)
                return true;
        }
        return false;
    }
    
    public static void printHuJu( FqImage imh,BufferedWriter bw) throws IOException{
        bw.write("rect ");
        for( int i = 1 ; i <= 7 ; i++ )
        {
            System.out.print(imh.huJu[i]+"  ");
            //bw.write(String.valueOf(imh.huJu[i])+" ");
        }
        System.out.println();
        //bw.newLine();
    }
}
