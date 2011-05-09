
package Fq;

public class Corner implements Comparable
{
    public int u;
    public int v;
    public double q;

    public Corner(int u,int v,double q)
    {
        this.u = u;
        this.v = v;
        this.q = q;
    }

    public int dist(Corner c2)
    {
        return (this.u-c2.u)*(this.u-c2.u)+(this.v-c2.v)*(this.v-c2.v);
    }
    
    public int compareTo(Object o)
    {
        Corner c2 = (Corner)o;
        if(this.q>c2.q) return -1;
        else if(this.q<c2.q) return 1;
        else return 0;
    }

}
