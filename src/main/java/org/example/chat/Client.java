package org.example.chat;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.Scanner;

public class Client extends WebSocketClient {

    public Client(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        System.out.println("Connection opened");
    }

    @Override
    public void onMessage(String message) {
        System.out.println("Message received from server: " + message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("Connection closed with exit code " + code + " additional info: " + reason);
    }

    @Override
    public void onError(Exception ex) {
        System.err.println("An error occurred: " + ex);
    }

    public static void main(String[] args) throws Exception {
        String wsServerUri = "ws://localhost:8887";
        Client client = new Client(new URI(wsServerUri));
        client.connectBlocking();

        // Continuously prompt the user for messages to send
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter message to send: ");
            String message = scanner.nextLine();
            client.send(message);
        }
    }
}
