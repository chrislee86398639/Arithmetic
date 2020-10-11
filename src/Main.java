import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {//后期可以考虑拆分合法性检验和正确率判断
    public static void main(String[] args) throws IOException {
        /*
        * 从命令行接受参数，题目的数量，和运算数的范围
        * */
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要生成的题目个数：");
        int i = sc.nextInt();
        System.out.println("请输入运算数的范围：");
        int limit = sc.nextInt();


        int j = 0;//控制题目数量
        String str1 = "";//算术表达式，写入Expression.txt
        String str2 = "";//答案，写入Answer.txt
        //中间结果
        String str3 = "";
        String str4 = "";

        String str5 = "";//大体情况，写入Grade.txt

        boolean accuracy = false ;//接受答题正确性
        FileIO writer = new FileIO();//输入流对象
        Queue<Integer> correct = new LinkedList<Integer>() ;//正确题目的队列
        Queue<Integer> wrong = new LinkedList<Integer>() ;//错误题目的队列

        Expression exp = new Expression();//表达式对象
        do {//生成合法不重复的式子，并且进行答题情况记录
            str1 = exp.generateExp(limit)+" = ";
            Calculate cal = new Calculate();
            Fraction f=  cal.outcome(str1);
            if (f.getNumerator()==100000){
                // //剔除表达不合法的算术表达式
                continue;
            }
            str2 = f.transferFraction(f);//最终结果

            str3 += "\t"+str1+"\n";
            str4 += "N0."+j+"\t"+str1+str2+"\n";

            System.out.println("N0."+j+"\t"+str1+"");

            accuracy = new Grade().gradeCalculate(j , str2);//答题情况

            if(accuracy){
                correct.add(j);
            }else{
                wrong.add(j);
            }

           j++;


        }while(j< i);

        System.out.println("生成结束");

        writer.fileWrite(str3, Paths.get("textFile/Expression.txt"));//整个字符串
        writer.fileWrite(str4, Paths.get("textFile/Answer.txt"));//整个字符串


        str5 += "Correct:"+correct.size()+correct+"\n"+
                "Wrong:"+wrong.size()+wrong+"\n";

        writer.fileWrite(str5, Paths.get("textFile/Grade.txt"));

        System.out.println("你共答对了"+correct.size()+"道题");
        System.out.println("你共错对了"+wrong.size()+"道题");
        System.out.println("正确率为"+correct.size()/i*1.0*100+"%");//queue.size方法可以获得队列元素的个数*/

    }
}
