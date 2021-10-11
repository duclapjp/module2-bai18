import java.io.*;

public class Preson implements Serializable {
//    private static final long serialVerisonUID =L;
    private String name;
    private Integer age;

    public Preson(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Preson preson = new Preson("lập",20);
        File file = new File("Object.dat");
        try{
            if (!file.exists()){
                if (file.createNewFile()){
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    ObjectOutputStream oss = new ObjectOutputStream(fileOutputStream);
                    oss.writeObject(preson);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
