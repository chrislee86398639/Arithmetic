import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Grade {
    public boolean gradeCalculate(int no , String s){//输入题号，标准答案
      /*  Queue<Integer> correct = new LinkedList<Integer>() ;
        Queue<Integer> wrong = new LinkedList<Integer>() ;*/
      /*
      * 可以把输入的答案写入file，然后与标准file对比
      * */

    Scanner sc = new Scanner(System.in);
        String str = sc.next();
        //System.out.println("控制台输入的答案"+str);

         if (str.equals(s)){//接受控制台输入的式子s
             //不能直接写 str == s，可能str含有回车，导致不相等

            System.out.println("你真棒，答对了\n");
         //   correct.add(no);
             return true;

        }
        else{
            System.out.println("真遗憾，答错了，正确答案为" + s + "\n");
         //   correct.add(no);

             return false;
        }

    }
}
