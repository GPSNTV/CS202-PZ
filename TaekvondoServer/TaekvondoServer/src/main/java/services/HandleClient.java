package services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class HandleClient {
    public static void handleClient(Socket clientSocket) {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()), true)
        ) {
            String line;
            String username = "username";
            String password = "password";
            int index = 0;
            while ((line = in.readLine()) != null) {
                System.out.println("Received: " + line);

                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    System.out.println("Parsed Key: " + key + ", Parsed Value: " + value);
                    if (index == 0) {
                        username = value;
                        index++;
                    } else if (index == 1) {
                        password = value;
                        break;
                    }

                } else {
                    out.println("Invalid data format. Expected 'key:value'.");
                }
            }
            System.out.println("Username: " + username + ", Password: " + password);
            boolean result = UserLogin.login(username, password);
            out.println(result ? "Login successful" : "Login failed");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
