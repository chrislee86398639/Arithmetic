public class GCD {

    /*
    * 求得最大公因子，用于分数化简
    * */
        public static void main(String[] args) {
            System.out.println(gcd(1071,462));
        }


        public static int gcd(int a,int b){
            if(b == 0){
                return a;
            }else{
                return gcd(b,a%b);
            }
        }
    }

