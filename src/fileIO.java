import java.io.*;
import java.nio.file.Path;

/*
* 对文件进行写入或读出，用于生成或读入字符串
* */
public class fileIO {
    public String fileRead1(Path path) throws Exception {
        File file = new File(String.valueOf(path));//定义一个file对象，用来初始化FileReader
        FileReader reader = new FileReader(file);//定义一个fileReader对象，用来初始化BufferedReader
        BufferedReader bReader = new BufferedReader(reader);//new一个BufferedReader对象，将文件内容读取到缓存
        StringBuilder sb = new StringBuilder();//定义一个字符串缓存，将字符串存放缓存中

        String s = "";
        while ((s =bReader.readLine()) != null) {//逐行读取文件内容，不读取换行符和末尾的空格
            sb.append(s + "\n");//将读取的字符串添加换行符后累加存放在缓存中
            System.out.println(s);
        }
        bReader.close();
        String str = sb.toString();
        System.out.println(str );
        return str;
    }
    public void fileRead2() throws IOException {
        String str0 = "";
        String Str1 ="";
        File file1 = new File("src/data.txt");//定义一个file对象，用来初始化FileReader
        BufferedReader file2 = new BufferedReader(new InputStreamReader(new FileInputStream(file1)));
        while((str0 = file2.readLine()) != null){//将文本转化为String
            Str1 += str0 ;
        }
        System.out.println(Str1);
    }

    public void fileWrite(String s, Path path) throws IOException {


        File file = new File(String.valueOf(path));
        OutputStream f = new FileOutputStream(file,true);//第二个参数为true，不覆盖原来文件的内容
        OutputStreamWriter writer = new OutputStreamWriter(f, "UTF-8");
        if (s!=null) {
            writer.append(s);

        }

        writer.close();
        f.close();

    }
}

