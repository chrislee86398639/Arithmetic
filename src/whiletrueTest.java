public  class whiletrueTest{
    public static void main(String[] args) {
        heihei();
        haha();
    }
    /*heihei 方法*/
    public static void heihei(){
        //while循环
        while(true){
            if(3>0)
            {
                System.out.println("heihei");
                return ;
            }
            System.out.println("youyou!");
        }
    }
    /*haha 方法*/
    public static void haha(){
        int i;
        for(i = 0;i<10;i++){
            if(i<3){

                System.out.println("haha");
                continue;
            }
            System.out.println("WAWA");

            if (i>4) {
                System.out.println("111");
                break;
            }
            System.out.println("222");
        }
        System.out.println("333");
    }

}