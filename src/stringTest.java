
public class stringTest {
  public int index(String strings[]){

      int i = 0;
      while(strings[i] != null){
          System.out.println(strings[i]);
          i++;
      }
      return  i ;

  }

    public static void main(String[] args) {
        String s[] = new String[100];
        s[0]="a";
        s[1]="b";
        int index = new stringTest().index(s);
        System.out.println(index);
    }

}
