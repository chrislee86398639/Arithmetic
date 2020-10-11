import java.io.*;
import java.nio.file.Paths;
/*
* 已经过合法性检验，生成算术表达式，未查重
* */

public class Expression {
    public String generateExp(){//生成表达式，未经过合法性检验
        int e1= (int) (Math.random()*10);
        int e2= (int) (Math.random()*10);
        int e3= (int) (Math.random()*10);
        int e4= (int) (Math.random()*10);
        String str = new String();

        int []ints = {e1,e2,e3,e4};
        char []chars ={'+','-','*','/'};

        int []ints1 = {1,2,3};//控制选择的运算符(0-3)
        int i = (int) (Math.random()*10%3);

        for(int j = 0; j < 3; j++){//调整j的范围可以控制运算符的数目
            int k = (int) (Math.random()*10%4);
            str += ints[k] + " ";
            str += chars[k]+ " ";//操作数与运算符需用空格隔开，以便后续区分÷和/

        }
        int k = (int) (Math.random()*10%4);
        str += ints[k] ;
        return str;
    }


    public void legalExp (int i) throws IOException {//生成合法的表达式，未查重
        int j = 0 ;//控制题目生成的数量
        String str1 = "";//算术表达式，写入Expression.txt
        String str2 = "";//答案，写入Answer.txt
        String str3 = "";
        String str4 = "";//中间结果



        FileIO writer = new FileIO();//输入流对象
        Expression exp = new Expression();//表达式对象



        do {
            String []str = new  String[10000000];
            str1 = exp.generateExp()+" = ";//获得原始表达式

            Calculate cal = new Calculate();
            Fraction f=  cal.outcome(str1);//计算结果，未化简



            if (f.getNumerator()==100000){
                // //剔除表达不合法的算术表达式
             //   System.out.println("表达式出错");
                continue;
            }

            str2 = f.transferFraction(f);//最终结果，已经化简

            /*
            * 进行查重
            * */
            System.out.println("N0."+j+"需比对的答案"+str2);
            int k = 0;//循环控制的元素
            if(str.length != 0){
                //遍历strings数组
                for ( k = 0 ; k<str.length;k++){

                    if(str2.equals(str[k])){
                        System.out.println("有相等的答案");
                        //System.exit(1);
                        continue;
                        // break;
                    }
                }
            }else{

                str[k] = str2;
                System.out.println("添加的元素"+str[k]);
            }


             System.out.print("N0."+j+"\t"+str1+"\n");//输出

            str3 += "N0."+j+"\t"+str1+"\n";
            str4 += "N0."+j+"\t"+str1+str2+"\n";
            j++;
        }while(j<i);

        writer.fileWrite(str3, Paths.get("textFile/Expression.txt"));//整个字符串
        writer.fileWrite(str4, Paths.get("textFile/Answer.txt"));//整个字符串

    }


    public void legalExp1 () throws IOException {//生成合法的表达式，未查重
        int j = 0;//控制题目生成的数量
        String str1 = "";//算术表达式，写入Expression.txt
        String str2 = "";//答案，写入Answer.txt
        String str3 = "";
        String str4 = "";//中间结果
        String []str = new  String[100000];//存放标准答案的数组
        FileIO writer = new FileIO();//输入流对象
        Expression exp = new Expression();//表达式对象
        do {
            str1 = exp.generateExp()+" = ";//获得原始表达
            Calculate cal = new Calculate();
            Fraction f = cal.outcome(str1);//计算结果，未化简

            if (f.getNumerator() == 100000) {
                // //剔除表达不合法的算术表达式
                //   System.out.println("表达式出错");
                continue;
            }

            str2 = f.transferFraction(f);//最终结果，已经化简
            System.out.println("exp算术表达式：" + str1);
            System.out.println("答案"+str2);

            /*
             * 进行查重
             * */
            System.out.println("N0." + j + "需比对的答案" + str2);
                int k = 0;//循环控制的元素
                for (int i = 0; str[i] != null; i++) {
                   // System.out.println("当前字符串数组" + str[i]);
                }
                if (str[0] != null) {//数组不空，和已有的答案进行对比
                    //遍历strings数组k
                    System.out.println("字符串数组非空");

                    for (k = 0; str[k] != null ; k++) {//字符串数组自动初始化为null，不要把字符串检测与""对比，应与null对比
                        //System.out.println("待添加的答案" + str2);
                        if (str2.equals(str[k])) {
                            System.out.println("有相等的答案");
                            break;
                        }
                    }

                    if (str[k] == null) {//字符串不空说明有相同答案
                        System.out.println("没有相同的答案");
                           /* int i = 0;
                            while(str[i] !=null){
                                i++;
                            }*///找到第一个为空的下标kk
                        str[k] = str2;//把答案写入
                        System.out.println("非空的数组添加的元素" + k + "个" + "\t" + str[k]);
                        j++;
                        str3 += "N0."+j+"\t"+str1+"\n";
                        str4 += "N0."+j+"\t"+str1+str2+"\n";

                         continue;
                    }
                } else {//字符串数组为空，把待添加的元素加进来
                    str[0] = str2;
                    System.out.println("第一个元素" + str[0]);
                    System.out.println("空的数组添加的元素" + str[0]);
                }

                System.out.print("N0." + j + "\t" + str1 + "\n");//输出合法且没有重复的式子
            str3 += "N0."+j+"\t"+str1+"\n";
            str4 += "N0."+j+"\t"+str1+str2+"\n";

            j++;

        } while (j < 100);
        /*
        * 查重存在bug，没有剔除干净，且j的基数有误
        * */


        writer.fileWrite(str3, Paths.get("textFile/Expression1.txt"));//整个字符串
        writer.fileWrite(str4, Paths.get("textFile/Answer1.txt"));//整个字符串


    }


    public static void main(String[] args) throws IOException {

        Expression exp = new Expression();
     //   exp.legalExp(10);

        exp.legalExp1();

        System.out.println("查重完毕");

    }

}
