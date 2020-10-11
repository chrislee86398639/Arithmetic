public class Compare {
    public Compare(String string, String[]str) {
        int i = 0;
        if(str.length != 0){
            //遍历strings数组
            for ( i = 0 ; i<str.length;i++){

                if(string.equals(str[i])){
                    System.out.println("有相等的答案");
                    System.exit(1);
                    // break;
                }
            }
        }else{
            str[i] = string;
            System.out.println("添加的元素"+str[i]);
        }

    }
}
