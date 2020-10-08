import java.io.*;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
* 中缀转后缀，再通过栈来计算表达式的值
* */
public class stackdemo9 {

    /**
     * 计算表达式的值
     * @param s
     * @return
     */
    public int calculate(String s) {
        Queue<String> q = toSuffixExpression(s);
        return solve(q);
    }

    /**
     * 将中缀表达式转化成后缀表达式
     *
     * @param s
     * @return
     *
     */

    private Queue<String> toSuffixExpression(String s) {//生成后缀表达式
        Stack<Character> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();

        int index = 0;//队列标签
        while (index < s.length()) {
            char c = s.charAt(index);
            // 如果是数字，就入队列
            if (isDigital(c)) {
                // 入队的时候要判断后面是否还有剩余的数字，要把整个数字入队列，而不是一个数字字符
                // 在多位数的时候有用
                int p = index;
                while (p < s.length() && isDigital(s.charAt(p))) {
                    p++;
                }
                queue.add(s.substring(index, p));//截取字符串，从指定位置（start）开始截到指定的位置（end）
                index = p;
                continue;
                // 如果是左括号，就入栈
            } else if (c == '(') {
                stack.push(c);
                // 如果是右括号，就弹出栈中的元素，直到遇到左括号为止。左右括号均不入队列
            } else if (c == ')') {
                while ('(' != stack.peek()) {
                    queue.add(stack.pop() + "");
                }
                // 弹出左括号
                stack.pop();
                // 如果是运算符，分下面的情况讨论
            } else if (isOperator(c)) {
                // 如果符号栈为空，就直接压入栈
                if (stack.isEmpty()) {
                    stack.push(c);
                    // 如果符号栈的栈顶是左括号，则压入栈中
                } else if ('(' == stack.peek()) {
                    stack.push(c);
                    // 如果当前元素的优先级比符号栈的栈顶元素优先级高，则压入栈中
                } else if (priority(c) > priority(stack.peek())) {
                    stack.push(c);
                    // 如果此时遍历的运算符的优先级小于等于此时符号栈栈顶的运算符的优先级，
                    // 则将符号栈的栈顶元素弹出并且放到队列中，并且将正在遍历的符号压入符号栈
                } else if (priority(c) <= priority(stack.peek())) {
                    queue.add(stack.pop() + "");
                    stack.push(c);
                }
            }

            index++;
        }

        // 遍历完后，将栈中元素全部弹出到队列中
        while (!stack.isEmpty()) {
            queue.add(stack.pop() + "");
        }

        return queue;
    }

    /**
     * 后缀表达式求值
     *
     * @param queue
     * @return
     */
    public int solve(Queue<String> queue) {
        Stack<Integer> numberStack = new Stack<>();
        while (!queue.isEmpty()) {
            // 从队列中出队
            String s = queue.remove();
            // 如果是数字，就压入栈中
            if (isDigital(s.charAt(0))) {
                numberStack.push(Integer.parseInt(s));
                // 如果是运算符，就从栈中弹出两个元素
            } else if (isOperator(s.charAt(0))) {
                char c = s.charAt(0);
                int val1 = 0;
                int val2 = 0;
                try {
                     val1 = numberStack.pop();
                     val2 = numberStack.pop();
                }catch (EmptyStackException e){
                    System.out.println("栈空");

                }

                switch (c) {
                    case '+': {
                        numberStack.push(val2 + val1);
                        break;
                    }
                    case '-': {
                        numberStack.push(val2 - val1);
                        break;
                    }
                    case '*': {
                        numberStack.push(val2 * val1);
                        break;
                    }
                    case '/': {
                       try {
                           numberStack.push(val2 / val1);
                       }catch (ArithmeticException e){
                           System.out.println("分母为零");
                           break;
                       }
                       break;
                    }
                }
            }
        }

        return numberStack.pop();
    }

    //判断是符号
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    //判断是数字
    private boolean isDigital(char c) {
        return c >= '0' && c <= '9';
    }

    //运算符的优先级
    private int priority(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                throw new RuntimeException("Illegal operator:" + c);
        }
    }

    public static void main(String[] args) throws IOException {
        fileIO writer = new fileIO();
        String str2 ="";
        String str0 = "";
        String str1 ="";

        BufferedReader file = null;
        try {
            file = new BufferedReader(new InputStreamReader(new FileInputStream("src/expression.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String str ="";
        while(( str = file.readLine())!=null){
            System.out.println("算术表达式："+str);
        stackdemo9 expression = new stackdemo9();

        Queue<String> queue = expression.toSuffixExpression(str);

        //输出有误，3*2+2/1-(2-1)，优先级出错：后缀表达式[3, 2, *, 2, 1, /, 2, 1, -, -, +]，
        // 正确的为[3, 2, *, 2, 1, / , +,2, 1, -, -]
      //  System.out.println("后缀表达式"+queue);
        System.out.println("后缀表达式的值："+expression.solve(queue));

        }

    }


}
