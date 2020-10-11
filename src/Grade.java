
import java.util.Scanner;

/*
* 计录答题情况
* */

public class Grade {
    public boolean gradeCalculate(int no , String s){//输入题号，标准答案
      /*
      * 可以把输入的答案写入file，然后与标准file对比
      * */

    Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的答案：");
        String str = sc.next();

         if (str.equals(s)){//接受控制台输入的式子str
             //不能直接写 str == s，可能str含有回车，导致不相等
            System.out.println("你真棒，答对了\n");
             return true;
        }
        else{
            System.out.println("真遗憾，答错了，正确答案为" + s + "\n");
             return false;
        }
    }
}
