import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGradeCalculate() {
		//从命令行接受参数，题目的数量，和运算数的范围
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入要生成的题目个数：");
		int i = sc.nextInt();
		
		System.out.println("请输入运算数的范围：");
        int limit = sc.nextInt();
        
		
		String str1 = "";//算术表达式
        String str2 = "";//答案
        String str5 = "";//大体情况
        boolean accuracy = false ;//接受答题正确性
        Queue<Integer> correct = new LinkedList<Integer>() ;//正确题目的队列
        Queue<Integer> wrong = new LinkedList<Integer>() ;//错误题目的队列
        
        int j = 0;//控制题目数量
        Expression exp = new Expression();//表达式对象
        do {
        	str1 = exp.generateExp(limit)+" = ";
        	Calculate cal = new Calculate();
            Fraction f=  cal.outcome(str1);
            str2 = f.transferFraction(f);//最终结果
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
        
        str5 += "Correct:"+correct.size()+correct+"\n"+
                "Wrong:"+wrong.size()+wrong+"\n";
        System.out.println("你共答对了"+correct.size()+"道题");
        System.out.println("你共错对了"+wrong.size()+"道题");
        System.out.println("正确率为"+correct.size()/i*1.0*100+"%");
	}

}
