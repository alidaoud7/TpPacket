package org.example;

public class Main {
    public static void main(String[] args) {
        PacketGenerator pg = new PacketGenerator();
        Packet p =  pg.generatePacket(124512563);
        System.out.println(p.getGpsLat());
        System.out.println(p.getGpsLong());
        System.out.println(p.getId());
        System.out.println(p.getTempSensor());
        System.out.println(p.getTimeFrame());
        System.out.println(p.getChecksum());
    }
}