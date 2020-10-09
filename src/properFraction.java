public class properFraction {
    /*
    *生成分数，化简分数
    * */
   /* String []strings ={,};
    public void  generateFraction() {

        int []ints = {0,1,2,3,4,5,6,7,8,9};
        int []factors = new int[200];//创建数组变量
        for (int i=0,j= 0 ;i<100 && j<200;i++,j=j+2){
            int r1 = (int)( Math.random()*10);
            int r2 = (int)( Math.random()*10);
         //   System.out.println("随机数"+rand);
            int numerator = ints[r1];
          //  System.out.println("分子"+numerator);

            while ( r2 == 0){
                r2 = (int)( Math.random()*10);

            }
            *//*   while (r2<r1 || r2 == 0){
                r2 = (int)( Math.random()*10);

            }*//*
        //    System.out.println(r2);

            int denominator = ints[r2];
        //    System.out.println("分母"+denominator);



            System.out.println("NO."+i+"组合分数"+numerator+"/"+denominator);
            System.out.println();
            factors[j]=numerator;
            factors[j+1]=denominator;




        }

        for (int j=0;j<200;j=j+2){

            System.out.println("NO."+j+"分数"+factors[j]+"/"+factors[j+1]);
            transferFraction(factors[j],factors[j+1]);

        }



    }*/


    public int gcd(int a,int b){//辗转相除法求最大公因子
            if(b == 0){
                return a;
            }else{
                return gcd(b,a%b);
            }

    }
   /*
    public  void transferFraction(Fraction fraction){
        int a = fraction.getNumerator();
        int b = fraction.getDenominator();

        int c = a/gcd(a,b);
        int d = b/gcd(a,b);
        int e = c/d;
        int f = c%d;
            if(f==0){
                System.out.println("化简后的分数为"+e);
            }else if(e!=0){
                System.out.println("化简后的带分数为"+e+"'"+f+"/"+d);
            }else{
                System.out.println("化简后的分数为"+f+"/"+d);
            }

             }*/

    public  String transferFraction(Fraction fraction){
        int a = fraction.getNumerator();
        int b = fraction.getDenominator();
        int c = a/gcd(a,b);
        int d = b/gcd(a,b);
        int e = c/d;
        int f = c%d;
        String str = "";
        if(f==0){
            str += e;
            System.out.println("化简后的分数为"+e);
        }else if(e!=0){
            System.out.println("化简后的带分数为"+e+"'"+f+"/"+d);
            str = e+"'"+f+"/"+d;
        }else{
            System.out.println("化简后的分数为"+f+"/"+d);
            str +=f+"/"+d ;
        }
        return str;
    }

    public static void main(String[] args) {

          //  new properFraction().generateFraction();
           /* int factor = new properFraction().gcd(3,6);
       // System.out.println("3和6的最大公因数位"+factor);*/
      //  new properFraction().transferFraction(38,18);

        }






}
