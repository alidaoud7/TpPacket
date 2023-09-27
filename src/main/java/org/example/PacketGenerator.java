package org.example;

import java.util.Random;

public class PacketGenerator {



    public static byte generateRandomByte() {
        Random random = new Random();
        byte randomByte = (byte) random.nextInt(256);
        return randomByte;
    }
    public static float generateRandomFloat() {
        Random random = new Random();
        float randomFloat = random.nextFloat();
        return randomFloat;
    }
    public static long generateRandomLong() {
        Random random = new Random();
        long randomLong = random.nextLong();
        return randomLong;
    }
    public Packet generatePacket(long id){
        Packet packet = new Packet();
        PacketService packetService = new PacketService();
        packet.setId(id);
        packet.setGpsLat(generateRandomFloat());
        packet.setGpsLong(generateRandomFloat());
        packet.setTempSensor(generateRandomByte());
        packet.setTimeFrame(generateRandomLong());
    packet.setChecksum(packetService.checkSum(packetService.serialize(packet)));
        return packet;

    }
}
