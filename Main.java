import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Coding code = new Coding('k');
        code.encryption("input.txt", "out.txt");
        //code.decryption("out.txt", "new.txt");
    }
}

