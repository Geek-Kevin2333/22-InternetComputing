package client;

import message.Body;
import message.header.Header;
import message.request.HttpRequest;
import message.request.RequestLine;

/**
 * @author Kevin
 * @Description
 */
public class ClientMain {
    public static void main(String[] args) {

        RequestLine requestLine=new RequestLine("GET","/");
        Header header=new Header();
        header.put("Host","www.baidu.com");
        header.put("Accept","*/*");
        header.put("Connection","keep-alive");
        header.put("Accept-Encoding","gzip, deflate, br");

        Body body=new Body();
        HttpRequest request = new HttpRequest(requestLine, header, body);
        Client client=new NormalClient();

        client.sendHttpRequest(request);
    }
}
