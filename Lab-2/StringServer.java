import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

/**
 * This interface is made in case we wanted to have more than one 
 * handler for different types of data
 */
interface URLHandler {
    String handleRequest(URI url);
}

//This is not necessary to understand as of week 3
class ServerHttpHandler implements HttpHandler {
    URLHandler handler;
    ServerHttpHandler(URLHandler handler) {
      this.handler = handler;
    }
    public void handle(final HttpExchange exchange) throws IOException {
        // form return body after being handled by program
        try {
            String ret = handler.handleRequest(exchange.getRequestURI());
            // form the return string and write it on the browser
            exchange.sendResponseHeaders(200, ret.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(ret.getBytes());
            os.close();
        } catch(Exception e) {
            String response = e.toString();
            exchange.sendResponseHeaders(500, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}

//This too is not yet in the scope of week 3
class Server {
    public static void start(int port, URLHandler handler) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        //create request entrypoint
        server.createContext("/", new ServerHttpHandler(handler));

        //start the server
        server.start();
        System.out.println("Server Started! Visit http://localhost:" + port + " to visit.");
    }
}

/**
 * This class will take the url and check the path (the command it wants to do)
 * and handle the request appropriately.
 */
class StringHandler implements URLHandler{
    String message = "";

    public String handleRequest(URI url){
        if(url.getPath().equals("/add-message")){
            String[] queryFromLink = url.getQuery().split("=");
            String toAddToMsg = queryFromLink[1];
            message += toAddToMsg;
            message += "\n";
        }
        return message;
    }
}

public class StringServer{
    public static void main(String[] args) throws IOException{
        if(args.length == 0){
            System.out.println("Missing the port number! Retry and add the port number" + 
            "please. Any number between 1024 to 49151.");
            return;
        }

        int port = Integer.valueOf(args[0]);

        Server.start(port, new StringHandler());
    }

    
}
