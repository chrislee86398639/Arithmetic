import java.util.Random;
import java.util.Stack;

/*
 * 构建一个分数类，用来表示分数，封装相关的方法
 */
public class Fraction {
    /*
    * 成员变量，可以直接使用；后期代码整理时，用成员变量代替一部分getDenominator或者getNumerator的方法
    * */

    private int denominator;// 分母
    private int numerator;// 分子

    // 构建一个分数
    public Fraction( int numerator,int denominator) {
        super();
        this.denominator = denominator;
        this.numerator = numerator;
    }
    // 构建一个可化简为整数的分数
    public Fraction(int numerator) {
        this.denominator = 1;
        this.numerator = numerator;
    }

    public Fraction() {
        super();
    }

    // 判断构建的是一个分数还是一个整数，不超过limit的数值
    public Fraction(boolean l, int limit) {//根据给定的范围和生成分数整数的要求，生成符合要求的数
        Random r = new Random();
        // 这是一个分数
        if (l == true) {
            int b = r.nextInt(limit);
            System.out.println("生成的index为"+b);

            int a = r.nextInt(limit);
            System.out.println("生成的a为"+b);

            while(b==0) {
                b = r.nextInt(limit);
//				System.out.println("会生成0："+b);
            }
//			System.out.println("不会生成0："+b);
            this.denominator = b;
            this.numerator = a;

            // 这是一个整数
        } else {
            int b = r.nextInt(limit);
            this.denominator = 1;
            this.numerator = b;
        }
    }

    public int getDenominator() {
        return denominator;

    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }



    // 加法运算
    public Fraction add(Fraction r) {
        int a = r.getNumerator();// 获得分子
        int b = r.getDenominator();// 获得分母
        int newNumerator = numerator * b + denominator * a;
        int newDenominator = denominator * b;
        Fraction result = new Fraction(newNumerator,newDenominator);
        return result;
    }

    // 减法运算
    public Fraction sub(Fraction r) {
        int a = r.getNumerator();// 获得分子
        int b = r.getDenominator();// 获得分母
        int newNumerator = numerator * b - denominator * a;
        int newDenominator = denominator * b;
        Fraction result = new Fraction(newNumerator,newDenominator);
        return result;
    }

    // 分数的乘法运算
    public Fraction muti(Fraction r) { // 乘法运算
        int a = r.getNumerator();// 获得分子
        int b = r.getDenominator();// 获得分母
        int newNumerator = numerator * a;
        int newDenominator = denominator * b;
        Fraction result = new Fraction(newNumerator,newDenominator);
        return result;
    }

    // 分数除法运算
    public Fraction div(Fraction r) {
        int a = r.getNumerator();// 获得分子
        int b = r.getDenominator();// 获得分母
        int newNumerator = numerator * b;
        int newDenominator = denominator * a;
        Fraction result = new Fraction(newNumerator,newDenominator);
        return result;
    }

    // 用辗转相除法求最大公约数
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // 对分数进行约分
    public void Appointment() {
        if (numerator == 0 || denominator == 1)
            return;
        // 如果分子是0或分母是1就不用约分了
        long gcd = gcd(numerator, denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
    }

    public  String transferFraction(Fraction fraction){
        int a = fraction.numerator;
        int b = fraction.denominator;
        int c = a/gcd(a,b);
        int d = b/gcd(a,b);
        int e = c/d;
        int f = c%d;
        String str = "";
        if(f==0){
            str += e;
           // System.out.println("化简后的分数为"+e);
        }else if(e!=0){
           // System.out.println("化简后的带分数为"+e+"'"+f+"/"+d);
            str = e+"'"+f+"/"+d;
        }else{
          //  System.out.println("化简后的分数为"+f+"/"+d);
            str +=f+"/"+d ;
        }
        return str;
    }


    public int existZero(){
        if(this.numerator<0||this.denominator<0){
            return 0;
        }else {
            return 1;
        }
    }

    public static void main(String[] args) {
        Fraction f1 = new Fraction(0,1);
        Fraction f2 = new Fraction(2,-6);
        f1.Appointment();
        System.out.println("分子"+f1.getNumerator());

        System.out.println("分母"+f1.getDenominator());

        f1.Appointment();//约分后若有负数，负数出现在分母；
        f2.Appointment();

        System.out.println("分子"+f2.getNumerator());
        System.out.println("分母"+f2.getDenominator());


        /*
        * fraction栈的测试
        * */
    /*    Fraction f3 = new Fraction();
        f3 = f1.add(f2);
        // fraction3 = fraction1.sub(fraction2);
        // fraction3 = fraction1.muti(fraction2);
        //fraction3 = fraction1.div(fraction2);

        int a = f3.numerator;
        int b = f3.denominator;//结果没有化简.
        System.out.println("f1+f2:"+a+"/"+b);
        System.out.println("f1-f2:"+a+"/"+b);
        System.out.println("f1*f2:"+a+"/"+b);
        System.out.println("f1/f2:"+a+"/"+b);

        Stack<Fraction> stack = new Stack<>();
        stack.push(f1);
        stack.push(f2);
      //  stack.push(f3);
        System.out.println(stack);
        System.out.println("栈顶的分数"+stack.peek().getNumerator()+"/"+stack.peek().getDenominator());*/





    }
}