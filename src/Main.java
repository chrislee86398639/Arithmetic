import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Queue;

public class Main {//后期可以考虑拆分合法性检验和正确率判断
    public static void main(String[] args) throws IOException {
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

      //  Fraction []fractions = new Fraction[100];
        String []str = new  String[10000];

        Expression exp = new Expression();//表达式对象
        do {
            str1 = exp.generateExp()+" = ";
            Calculate cal = new Calculate();

            Fraction f=  cal.outcome(str1);
            if (f.getNumerator()==100000){
                // //剔除表达不合法的算术表达式
                continue;
            }

            str2 = f.transferFraction(f);//最终结果


/*

            System.out.println("N0."+j+"需比对的答案"+str2);
            int i = 0;//循环控制的元素
            if(str.length != 0){
                //遍历strings数组
                for ( i = 0 ; i<str.length;i++){

                    if(str2.equals(str[i])){
                        System.out.println("有相等的答案");
                        System.exit(1);
                       // break;
                    }
                }
            }else{

                str[i] = str2;
                System.out.println("添加的元素"+str[i]);
            }
*/



          /*  str3 += "N0."+j+"\t"+str1+"\n";
            str4 += "N0."+j+"\t"+str1+str2+"\n";

            System.out.print("N0."+j+"\t"+str1+"\n");

            accuracy = new Grade().gradeCalculate(j , str2);

            if(accuracy){
                correct.add(j);
            }else{
                wrong.add(j);
            }
 */           j++;

        }while(j<10);

        writer.fileWrite(str3, Paths.get("textFile/Expression.txt"));//整个字符串
        writer.fileWrite(str3, Paths.get("textFile/Test.txt"));//整个字符串
        writer.fileWrite(str4, Paths.get("textFile/Answer.txt"));//整个字符串


      /*  str5 += "Correct:"+correct.size()+correct+"\n"+
                "Wrong:"+wrong.size()+wrong+"\n";

        writer.fileWrite(str5, Paths.get("textFile/Grade.txt"));

        System.out.println("你共答对了"+correct.size()+"道题");
        System.out.println("你共错对了"+wrong.size()+"道题");
        System.out.println("正确率为"+correct.size()/5.0*100+"%");//queue.size方法可以获得队列元素的个数*/

    }
}
