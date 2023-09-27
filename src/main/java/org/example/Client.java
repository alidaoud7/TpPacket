package org.example;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws Exception {
    Packet packet=receivePacket();
        System.out.println(packet.getId());
        System.out.println(packet.getTimeFrame());
        System.out.println(packet.getTempSensor());
        System.out.println(packet.getGpsLong());
        System.out.println(packet.getGpsLat());
        System.out.println(packet.getChecksum());
    }

    public static   Packet receivePacket () throws ClassNotFoundException {
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        try {
            socket = new Socket("localhost", 6666);

            System.out.println("Connected to Server");

            oos = new ObjectOutputStream(socket.getOutputStream());


            oos.writeObject("i m ready to receive");

            ois = new ObjectInputStream(socket.getInputStream());

            String msg = (String) ois.readObject();
            oos.writeObject("I received the id ");
            Long id = Long.parseLong(msg);
            System.out.println("Id received: " + id);

            msg = (String) ois.readObject();
            oos.writeObject("I received the time frame ");
            Long timeFrame = Long.parseLong(msg);
            System.out.println("time frame received: " + timeFrame);

            msg = (String) ois.readObject();
            oos.writeObject("I received the Temp sensor ");
            Byte tempSensor = Byte.parseByte(msg);
            System.out.println("temp sensor received: " + tempSensor);

            msg = (String) ois.readObject();
            oos.writeObject("I received the Longitude ");
            Float gpsLong = Float.parseFloat(msg);
            System.out.println("Longitude received: " + gpsLong);

            msg = (String) ois.readObject();
            oos.writeObject("I received the Latitude ");
            Float gpsLat = Float.parseFloat(msg);
            System.out.println("Latitude received: " + gpsLat);

            msg = (String) ois.readObject();
            oos.writeObject("I received the checksum ");
            Short checksum = Short.parseShort(msg);
            System.out.println("Checksum received: " + checksum);

            Packet packet = new Packet(tempSensor,gpsLong,gpsLat,checksum,id,timeFrame);

            //close resources
            ois.close();
            oos.close();
            Thread.sleep(100);
            return packet;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }



    }
}