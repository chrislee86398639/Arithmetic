import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Queue;

/*
* 已经过合法性检验，生成算术表达式，未查重
* */

public class expTest {
    public String expression (String str){
        int e1= (int) (Math.random()*10);
        int e2= (int) (Math.random()*10);
        int e3= (int) (Math.random()*10);
        int e4= (int) (Math.random()*10);

        int []ints = {e1,e2,e3,e4};
        char []chars ={'+','-','*','/'};
        int []ints1 = {1,2,3};
        int i = (int) (Math.random()*10%3);//控制选择的运算符(0-3)
     //   int j = (int) (Math.random()*10%4);//控制生成表达式的操作数的个数
       // if(j==0)
          // j = j+1;


        for(int j = 0; j < 3; j++){//调整j的范围可以控制运算符的数目
            int k = (int) (Math.random()*10%4);
            str += ints[k] + " ";
            str += chars[k]+ " ";//操作数与运算符需用空格隔开，以便后续区分÷和/

        }
        int k = (int) (Math.random()*10%4);
        str += ints[k] ;


    //    System.out.println(str+" = ");


        return str;
    }
/*

    public int calculate (int a,int b,char ch){
        int result = 0;
        switch (ch){
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;

            case '*':
                result = a * b;
                break;
            case '/':

                result = a / b;
                break;//应对真分数进行处理

        }
        return  result;
    }
*/

    public static void main(String[] args) throws IOException {
        int i = 0;
        int j = 0;
        fileIO writer = new fileIO();
        String str1 = "";

        String str2 = "";

        String str3 = "";

        String str4 = "";

        boolean accuracy = false ;//接受答题正确性

        Queue<Integer> correct = new LinkedList<Integer>() ;
        Queue<Integer> wrong = new LinkedList<Integer>() ;

        expTest exp = new expTest();
        do {

         //   str2 += exp.expression(str1)+"=\n";

              str2 = exp.expression(str1)+" = ";
        //    str2 = "0 + 7 * 8 / 0=";



            Calculate cal = new Calculate();

            Fraction f=  cal.outcome(str2);

            if (f.getNumerator()==100000){
               // System.out.println("表达式不合法");//剔除表达不合法的算术表达式
                continue;
            }




          //  System.out.println("exp标准答案："+f.getNumerator()+"/"+f.getDenominator());

        //    f.Appointment();
            str3 = f.transferFraction(f);//最终结果
           // System.out.println("exp简化答案："+str3+"\n");

         //   new properFraction().transferFraction();

           /* System.out.println(f.getNumerator());
            System.out.println(f.getDenominator());*/
            writer.fileWrite("N0."+j+"\t"+str2+"\n", Paths.get("src/expression.txt"));

            writer.fileWrite("N0."+j+"\t"+str2+str3+"\n", Paths.get("src/answer.txt"));


            System.out.print("N0."+j+"\t"+str2+"\n");



            accuracy = new Grade().gradeCalculate(j , str3);

            if(accuracy){
                correct.add(j);
            }else{
                wrong.add(j);
            }




            j++;


        }while(j<5);

        System.out.println("你共答对了"+correct.size()+"道题");
        System.out.println("你共错对了"+wrong.size()+"道题");
        System.out.println("正确率为"+correct.size()/5.0*100+"%");


/*
        System.out.println("Correct:"+correct.size()+correct);
        System.out.println("Wrong:"+wrong.size()+wrong);*/

        str4 += "Correct:"+correct.size()+correct+
                "Wrong:"+wrong.size()+wrong;

        writer.fileWrite(str4, Paths.get("src/Grade.txt"));

        //System.out.println("队列大小"+correct.size());//获得答对或答错的题目个数


    }

}
