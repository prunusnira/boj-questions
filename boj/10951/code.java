import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String[] sp = line.split(" ");
            int a = Integer.parseInt(sp[0]);
            int b = Integer.parseInt(sp[1]);
            bw.write(a + b + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}