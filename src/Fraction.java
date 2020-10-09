import java.util.Random;
import java.util.Stack;

/*
 * 构建一个分数类，用来表示分数，封装相关的方法
 */
public class Fraction {

    private int denominator;// 分母
    private int numerator;// 分子

    // 构建一个分数
    public Fraction( int numerator,int denominator) {
        super();
        this.denominator = denominator;
        this.numerator = numerator;
    }

    public Fraction(int numerator) {
        this.denominator = 1;
        this.numerator = numerator;
    }

    public Fraction() {
        super();
    }

    // 判断构建的是一个分数还是一个整数，不超过limit的数值
    public Fraction(boolean l, int limit) {
        Random r = new Random();
        // 这是一个分数
        if (l == true) {
            int index = r.nextInt(limit);
            int index2 = r.nextInt(limit);

            while(index==0) {
                index = r.nextInt(limit);
//				System.out.println("会生成0："+index);
            }
//			System.out.println("不会生成0："+index);
            this.denominator = index;
            this.numerator = index2;

            // 这是一个整数
        } else {
            int index = r.nextInt(limit);
            this.denominator = 1;
            this.numerator = index;
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
    private static long gcd(long a, long b) {
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

    public int existZero(){
        if(this.numerator<0||this.denominator<0){
            return 0;
        }else {
            return 1;
        }
    }

    public static void main(String[] args) {
        Fraction f1 = new Fraction(2,7);
        Fraction f2 = new Fraction(2,3);
        Fraction f3 = new Fraction();
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
        System.out.println("栈顶的分数"+stack.peek().getNumerator()+"/"+stack.peek().getDenominator());




    }
}