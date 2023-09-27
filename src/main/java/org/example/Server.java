package org.example;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("Server started...");


        Socket socket = serverSocket.accept();
        System.out.println("Client connected: " + socket.getLocalPort());

        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        PacketGenerator pg = new PacketGenerator();
        Packet packet = pg.generatePacket(12121212);

        String readyMessage = (String) ois.readObject();
        System.out.println("The client is ready, the packet will be sent now ...");

        oos.writeObject(""+Long.toString(packet.getId()));
        String acknowledgment = (String) ois.readObject();
        System.out.println("Received acknowledgment from client: " + acknowledgment);

        oos.writeObject(""+Long.toString(packet.getTimeFrame()));
        acknowledgment = (String) ois.readObject();
        System.out.println("Received acknowledgment from client: " + acknowledgment);

        oos.writeObject(""+Byte.toString(packet.getTempSensor()));
        acknowledgment = (String) ois.readObject();
        System.out.println("Received acknowledgment from client: " + acknowledgment);

        oos.writeObject(""+Float.toString(packet.getGpsLong()));
        acknowledgment = (String) ois.readObject();
        System.out.println("Received acknowledgment from client: " + acknowledgment);

        oos.writeObject(""+Float.toString(packet.getGpsLat()));
        acknowledgment = (String) ois.readObject();
        System.out.println("Received acknowledgment from client: " + acknowledgment);

        oos.writeObject(""+Short.toString(packet.getChecksum()));
        acknowledgment = (String) ois.readObject();
        System.out.println("Received acknowledgment from client: " + acknowledgment);

        oos.close();
        ois.close();
        socket.close();

    }

}