
public class Fraction {
    public static void main(String[] args)
    {
        TestFraction f1=new TestFraction(14,21);//给出操作数f1的分子分母
        TestFraction f2=new TestFraction(20,30);//给出操作数f2的分子分母
        TestFraction f3;//运算结果

        f3=f1.plus(f2);//加法
        System.out.println(f1+"+"+f2+"= "+f3);
        f3=f1.minus(f2);//减法
        System.out.println(f1+"-"+f2+"= "+f3);
        f3=f1.multiply(f2);//乘法
        System.out.println(f1+"*"+f2+"= "+f3);
        f3=f1.divide(f2);//除法
        System.out.println(f1+"/"+f2+"= "+f3);
    }
}

class TestFraction
{
    private int c;//分子c
    private int d;//分母d

    public TestFraction()				//默认构造函数，分子分母都为1。
    {
        c=1;
        d=1;
    }

    public TestFraction(int a,int b)	//带参数构造函数，判断分母是否为0。
    {
        if(b==0)
        {
            System.out.println("分母 不能为0!");
            System.exit(0);
        }
        c=a;
        d=b;
        selfTrim();
    }

    public int getNumerator()	//获得分子c
    {
        return c;
    }
    public int getDinominator()	//获得分母d
    {
        return d;
    }

    public void selfTrim()	//公约数化简，整理正负号
    {
        int maxCommon=commonDivisor(c,d);	//求出两个数的最大公约数。
        c=c/maxCommon;                  	//分式为最简。
        d=d/maxCommon;
        //整理正负号。
        if((c>0&&d<0)||(c<0&&d<0))
        {
            c=-c;
            d=-d;
        }
    }

    public String toString()	//重写tostring(). 分母为1 直接输出分子.  分母不为1 输出c/d.
    {
        if(c==0||d==1)                          //分母为1 直接输出分子.
        {
            return Integer.toString(c);
        }
        return Integer.toString(c)+"/"+Integer.toString(d);     //输出c/d.
    }

    //减法
    public TestFraction minus(TestFraction f2)
    {
        int newNumerator=c*f2.getDinominator()-f2.getNumerator()*d;
        int newDinominator=d*f2.getDinominator();

        int maxCommon=commonDivisor(newNumerator,newDinominator);
        return new TestFraction(newNumerator/maxCommon,newDinominator/maxCommon);
    }
    //加法
    public TestFraction plus(TestFraction f2)
    {
        int newNumerator=c*f2.getDinominator()+f2.getNumerator()*d;
        int newDinominator=d*f2.getDinominator();

        int maxCommon=commonDivisor(newNumerator,newDinominator);
        return new TestFraction(newNumerator/maxCommon,newDinominator/maxCommon);
    }
    //乘法
    public TestFraction multiply(TestFraction f2)
    {
        int newNumerator=c*f2.getNumerator();
        int newDinominator=d*f2.getDinominator();

        int maxCommon=commonDivisor(newNumerator,newDinominator);
        return new TestFraction(newNumerator/maxCommon,newDinominator/maxCommon);
    }
    //除法
    public TestFraction divide(TestFraction f2)
    {
        if(f2.getNumerator()==0)
        {
            System.out.println("0不能做除数！");
            System.exit(0);
        }
        TestFraction result=new TestFraction();
        int newNumerator=c*f2.getDinominator();
        int newDinominator=d*f2.getNumerator();

        int maxCommon=commonDivisor(newNumerator,newDinominator);
        return new TestFraction(newNumerator/maxCommon,newDinominator/maxCommon);
    }

    //计算2个数的最大公约数。按绝对值计算。
    public static  int commonDivisor(int x,int y)
    {
        if(x==0||y==0)
        {
            return 1;
        }
        int x1;
        int y1;

        x1=(Math.abs(x)>Math.abs(y))?Math.abs(x):Math.abs(y);                //使x1>y1.
        y1=(Math.abs(x)>Math.abs(y))?Math.abs(y):Math.abs(x);
        int z=1;
        while(z!=0)
        {
            z=x1%y1;
            x1=y1;
            y1=z;
        }
        return x1;
    }
}
