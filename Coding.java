import java.io.*;

public class Coding {
    private final char key;

    public Coding(char key) {
        this.key = key;
    }

    public void fileStreams(String inputFile, String outputFile, boolean flag) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(inputFile);
        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        OutputStream output = outFilter(fileOutputStream, flag);
        int i;
        while ((i = fileInputStream.read()) != -1) {
            output.write(i);
        }
        output.close();
        fileInputStream.close();
    }

    public void encryption(String inputFile, String outputFile) throws IOException {
        fileStreams(inputFile, outputFile, true);
    }

    public void decryption(String inputFile, String outputFile) throws IOException {
        fileStreams(inputFile, outputFile, false);
    }

    public InputStream inFilter(InputStream in, boolean flag) {
        return new FilterInputStream(in) {
            @Override
            public int read() throws IOException {
                if (flag) {
                    return (super.read() + key);
                } else {
                    return (super.read() - key);
                }
            }
        };
    }

    public OutputStream outFilter(OutputStream out, boolean flag){
        return new FilterOutputStream(out) {
            @Override
            public void write(int s) throws IOException {
                if (flag) {
                    super.write(s + key);
                } else {
                    super.write(s - key);
                };
            }
        };
    }
}

