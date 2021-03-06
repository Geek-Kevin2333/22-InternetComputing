import client.NormalClient;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class postTest {
    String host;
    int port = 80;
    NormalClient client;


    @Test
    public void simpleTestForPost() throws IOException {
        host = "127.0.0.1";
        port = 8888;
        Socket socket = new Socket(host, port);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String request = "POST /testForm HTTP/1.1\n" +
                "Host: 127.0.0.1\n" +
                "Content-Type: application/x-www-form-urlencoded\n" +
                "Content-Length: 35\n" +
                "\n" +
                "login=my_login&password=my_password";

        writer.write(request);
        writer.flush();
        writer.close();
    }

    @Test
    public void simpleRegisterTest() throws IOException {
        host = "127.0.0.1";
        port = 8888;
        Socket socket = new Socket(host, port);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String request = "POST /registerOrLogin HTTP/1.1\n" +
                "Host: 127.0.0.1\n" +
                "Content-Type: application/x-www-form-urlencoded\n" +
                "Content-Length: 39\n" +
                "\n" +
                "type=register&username=111&password=111\n";
        writer.write(request);
        writer.flush();
        writer.close();
    }

    @Test
    public void upLoadHtmlFile(){
        host = "127.0.0.1";
        port = 8888;
        client = new NormalClient(port, host,"POST");
        client.uploadFile("post.html", true);
    }

    @Test
    public void upLoadTxtFile(){
        host = "127.0.0.1";
        port = 8888;
        client = new NormalClient(port, host,"POST");
        client.uploadFile("temp.txt", false);
    }

    @Test
    public void upLoadBinaryFile(){
        host = "127.0.0.1";
        port = 8888;
        client = new NormalClient(port, host,"POST");
        client.uploadFile("4.png", true);
    }

    @Test public void RegisterOrLogin(){
        host = "127.0.0.1";
        port = 8888;
        client = new NormalClient(port, host,"POST");
        String input="type=register/login&username="+"userName"+"&password="+"pwd"+System.lineSeparator();
        try {
            client.RegisterOrLogin(input,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}