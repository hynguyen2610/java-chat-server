package org.example.chat;

import org.java_websocket.server.WebSocketServer;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;

import java.net.InetSocketAddress;

public class Server extends WebSocketServer {

    public Server(int port) {
        super(new InetSocketAddress(port));
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        System.out.println("New connection opened: " + conn.getRemoteSocketAddress());
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        System.out.println("Connection closed: " + conn.getRemoteSocketAddress() + " - Reason: " + reason);
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        System.out.println("Message received: " + message);
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        System.out.println("Error occurred: " + ex.getMessage());
    }

    @Override
    public void onStart() {
        System.out.println("Server started successfully!");
        setConnectionLostTimeout(100);
    }

    public static void main(String[] args) {
        int port = 8887; // Port to listen on
        Server server = new Server(port);
        server.start();
        System.out.println("WebSocket server started on port: " + port);
    }
}
