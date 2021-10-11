package object;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ObjectOutputStreamExample {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("product.txt"));
            Product product = new Product(1,"Iphone",1000,"new");
            oos.writeObject(product);
            oos.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            oos.close();
        }
        System.out.println("Success!!!");
    }
}
