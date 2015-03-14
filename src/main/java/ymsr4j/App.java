package ymsr4j;

import java.io.IOException;

/**
 * Created by razon on 15/03/14.
 */
public class App {
    public static void main(String... args) throws IOException {
        int response = Ymsr.incenses(args[0]);
        System.out.println("response:" + response);
    }
}
