import sun.net.RegisteredDomain;

import java.io.*;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Random;
/*
* 已经过合法性检验，生成算术表达式，未查重
* */

public class Expression {
    public String generateExp(Integer limit){//生成表达式，未经过合法性检验，限定运算数的大小
        Random random = new Random();
        random.nextInt(limit);

        int e1=  random.nextInt(limit);
        int e2=  random.nextInt(limit);
        int e3=  random.nextInt(limit);
        int e4=  random.nextInt(limit);
        /*int e1= (int) (Math.random()*10);
        int e2= (int) (Math.random()*10);
        int e3= (int) (Math.random()*10);
        int e4= (int) (Math.random()*10);*/
        String str = new String();

        int []ints = {e1,e2,e3,e4};
        char []chars ={'+','-','*','/'};

        int []ints1 = {1,2,3};//控制选择的运算符(0-3)
        int i = (int) (Math.random()*10%3);
        for(int j = 0; j < ints1[i]; j++){//调整j的范围可以控制运算符的数目
            int k = (int) (Math.random()*10%4);
            str += ints[k] + " ";
            str += chars[k]+ " ";//操作数与运算符需用空格隔开，以便后续区分÷和/

        }
        int k = (int) (Math.random()*10%4);
        str += ints[k] ;
        return str;
    }



    public void legalExp () throws IOException {//生成合法未重复的表达式
        int j = 0;//控制题目生成的数量
        int limit = 10 ;//控制运算数的大小。可以接受从控制台输入
        String str1 = "";
        String str2 = "";//存放中间结果
        String str3 = "";//算术表达式，写入Expression.txt
        String str4 = "";//答案，写入Answer.txt


        HashMap<String, Integer> answers = new HashMap<String, Integer>();


        FileIO writer = new FileIO();//输入流对象
        Expression exp = new Expression();//表达式对象

        do {
            str1 = exp.generateExp(limit) + " = ";//获得原始表达式
            Calculate cal = new Calculate();
            Fraction f = cal.outcome(str1);//计算结果，未化简

            if (f.getNumerator() == 100000) {
                // //剔除表达不合法的算术表达式
                //   System.out.println("表达式出错");
                continue;
            }

            str2 = f.transferFraction(f);//最终结果，已经化简

            /*查重开始
            存放值的时候，如果先检测下碰撞，如果有碰撞，则break 跳出do while 循环
             * 如果没有碰撞，则存进去
             * */

            if(answers.containsKey(Save.string)){
                //System.out.println("key碰撞");
                continue;
            }else{
                answers.put(Save.string, null);
                System.out.print("N0." + j + "不重复的式子"+"\t" + str1 + "\n");//输出合法且没有重复的式子

                str3 += "\t"+str1+"\n";
                str4 += "N0."+j+"\t"+str1+str2+"\n";
                j++;
            }

        } while (j < 10000);

        writer.fileWrite(str3, Paths.get("textFile/Expression.txt"));//整个字符串
        writer.fileWrite(str4, Paths.get("textFile/Answer.txt"));//整个字符串

    }




    public static void main(String[] args) throws IOException {

        Expression exp = new Expression();
          exp.legalExp();
        System.out.println("答题完毕");

    }

}
