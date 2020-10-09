import java.io.IOException;
import java.nio.file.Paths;

/*
* 生成算术表达式，未经过合法性检验
* */

public class expTest {
    public String expression (String str){
        int e1= (int) (Math.random()*10);
        int e2= (int) (Math.random()*10);
        int e3= (int) (Math.random()*10);
        int e4= (int) (Math.random()*10);

        int []ints = {e1,e2,e3,e4};
        char []chars ={'+','-','*','/'};
     /*   int i = (int) (Math.random()*10%4);//控制选择的运算符(0-3)
        int j = (int) (Math.random()*10%4);//控制生成表达式的操作数的个数
        if(j==0)
            j = j+1;*/

        for(int i = 0; i < 3; i++){
            int k = (int) (Math.random()*10%4);
            str += ints[k] + " ";
            str += chars[k]+ " ";//操作数与运算符需用空格隔开，以便后续区分÷和/

        }
        int k = (int) (Math.random()*10%4);
        str += ints[k] ;

        System.out.println(str+" = ");
        return str;
    }

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

    public static void main(String[] args) throws IOException {
        int j = 0;
        fileIO writer = new fileIO();
        String str1 = "";
        String str2 = "";
        expTest exp = new expTest();
        do {
            j++;
            str2 += exp.expression(str1)+"=\n";

        }while(j<100);

        writer.fileWrite(str2, Paths.get("src/expression.txt"));
    }

}
