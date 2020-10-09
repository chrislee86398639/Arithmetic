import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.EmptyStackException;
import java.util.Stack;

@SuppressWarnings("unchecked")
/*
* 对表达式进行求值
* */

public class Calculate {
    public static void main(String[] args) throws Exception {
        fileIO writer = new fileIO();
        String str1 ="";

        BufferedReader file = null;
        try {
            file = new BufferedReader(new InputStreamReader(new FileInputStream("src/expression.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String str ="";

        while(( str = file.readLine())!=null){
            //一开始使用了两次的readline()函数导致隔行读取
           // System.out.println("待读取的字符串："+file.readLine());
          //  str = file.readLine();//一行中余下的字符串
          System.out.println("待计算的算术表达式："+str);
            Stack num = new Stack();//数字
            Stack opt = new Stack();//运算符
            opt.push('(');//运算符栈压入左括号的作用？
            str = str +")";
            for(int i = 0; i<str.length(); i++){
                char ch = str.charAt(i);//当前处理的字符
          //    System.out.println("当前处理的字符"+ch);

                /***数字部分开始***/

                int tmpInt = 0;
                boolean isDigit = false;
                // 循环处理多位数
                while(isDigit(ch)){//判断是否是数字
//
                tmpInt =   tmpInt*10 +(ch-'0');

                  //  tmpInt =  ch-'0';？？
                 //  System.out.println("当前处理的字符"+tmpInt);
                    i++;
                    ch = str.charAt(i);
                    isDigit = true;
                }
                if(isDigit){//多位数字的处理方式，不太懂？
                    i--; //多位数字最后一次i++回退
                    num.push(tmpInt);//数字入栈
                    continue;
                }
                /***数字部分结束***/

                /***运算符部分开始***/
                // 如果是(则直接压入opt？？
                if(isEqualLeft(ch)){
                    opt.push('(');
                    continue;
                }
                // 处理负号为0-x的样式,  就是这里, 之前少了 i == 0的情况
                if(ch == '-' && (((i-1)>=0 && !isDigit(str.charAt(i-1)) && !isEqualRight(str.charAt(i-1))) || i==0)){
                    num.push(0);
                }
                char ch1 =  (char)opt.peek();//太赞了，直接类型转换。不用将object类型转为string类，再转为char类
                // 大于前一个运算符优先级 或者 前面的数字少于2个(无法凑出一次运算), 则直接推入运算符
                if(isPriority(ch1, ch) || num.size()<2){
                    opt.push(ch);
                }else{
                    if(isEqualRight(ch)){
                        handleCal(num, opt, ch);
                        if(!opt.isEmpty() && isEqualLeft((char)opt.peek())){
                            opt.pop();
                        }
                    }else{
                        handleCal(num, opt, ch);
                        opt.push(ch);
                    }
                }
                /***运算符部分结束***/
            }
            try {
                str = num.pop().toString();
                System.out.println(str1);
                writer.fileWrite(str1+"\n", Paths.get("src/answer.txt"));

            }catch (EmptyStackException e){
                System.out.println("计算完成");
                break;
            }

        }
    }

    //符号匹配的作用？
    private static boolean isEqualLeft(char ch){
        if(ch == '(' || ch == '{' || ch == '['){
            return true;
        }
        return false;
    }

    private static boolean isEqualRight(char ch){
        if(ch == ')' || ch == '}' || ch == ']'){
            return true;
        }
        return false;
    }

    private static void handleCal (Stack num, Stack opt, char ch) {
        while(!opt.isEmpty() && !isEqualLeft((char)opt.peek()) && !isPriority((char)opt.peek(),ch)){

            int valb = (int)num.pop();
            int vala = (int)num.pop();
            char op = (char)opt.pop();
/*

            if(vala-valb<0 && ch =='-')
               break;
            if(valb==0 && ch =='/'){
               break;
            }
*/


            int res = calculateVal(vala, valb, op);
           // System.out.println("正确答案为"+res);
            if (res ==-1){
                System.out.println("表达式求解过程出现负数");

            } else if (res == -1) {
                System.out.println("表示求解过程分母为零");

            }
            num.push(res);
        }
    }

    private static int calculateVal(int vala, int valb, char op){//计算结果
        if(op == '+'){
            return vala + valb;
        }
        if(op == '-'){
            if (vala-valb>=0)
            return vala - valb;
            else
                return -1;
        }

        if(op == '*'){
            return vala * valb;
        }
        if(op == '/'){
            if (valb!=0)
               return vala / valb;
            else
                return -2;
        }
        return 0;
    }

    private static boolean isDigit(char ch){//判断是否是10以内的自然数
        if(ch<='9' && ch>='0'){
            return true;
        }
        return false;
    }

    /**
     * 判断优先级
     * @param ch1
     * @param ch2
     * @return
     */
    private static boolean isPriority(char ch1, char ch2){
        if(ch2 == ')'){
            return false;
        }
        if((ch2 == '*' || ch2 == '/') && (ch1 == '+' || ch1 == '-')){
            return true;
        }
        return false;
    }

}