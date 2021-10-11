import java.io.IOException;
import java.io.InputStream;

public class ReadByteconsole {
    public static void main(String[] args) throws IOException {
        InputStream is = System.in;
        while (true){
            System.out.println("nhập 1 ký tự:");
            int ch  = is.read();
            if (ch == 'q'){
                System.out.println("Finished");
                break;
            }
            is.skip(2);
            System.out.println("ký tự nhận được:"+(char) ch);
        }
    }
}
