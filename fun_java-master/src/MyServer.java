import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer extends JFrame {

    private static Socket socket;
    private static ServerSocket serverSocket;
    private static InputStreamReader inputStreamReader;
    private static BufferedReader bufferedReader;

    private static String message;

    private static JFrame frame;

    MyServer(){
        super("");
        setSize(1000, 700);
        initComponents();
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            frame = new MyServer();
            frame.setVisible(true);
        });

        try {
            serverSocket = new ServerSocket(7800);

            while (true){

                socket = serverSocket.accept();
                inputStreamReader = new InputStreamReader(socket.getInputStream());
                bufferedReader = new BufferedReader(inputStreamReader);

                message = bufferedReader.readLine();

                System.out.println(message);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }










    private void initComponents(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel();
        label.setText("text");



        this.getContentPane().add(label, BorderLayout.CENTER);
        this.pack();

    }

}
