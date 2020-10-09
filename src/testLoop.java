public class testLoop {
    public static void main(String[] args) {
        System.out.println("hahha");
        int i=0;
        while (i<10){
            System.out.println(i);
            ++i;
            if(i>5){
              continue;
            }
            System.out.println("正确i:6："+i);
            System.out.println("正确"+i);



        }


        System.out.println("正确跳出的话是11："+i);


        i=0;


        while (i<15){
            if(i<0){

            }else if (i>10){
               break;
            }
            ++i;
        }
        System.out.println("正确跳出的话是16："+i);


    }

}
