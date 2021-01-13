import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(56000);

        try (Socket socket = serverSocket.accept();
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            int n = Integer.parseInt(in.readLine());
            int c = calculateFibonacci(n);
            out.printf("Число Фибоначчи до номера %d -> %d\n", n, c);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static int calculateFibonacci(int n) {
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 1; i < (n-1); i++) {
            c = a + b;
            a = b;
            b = c;
        }
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        } else {
            return c;
        }
    }

}




