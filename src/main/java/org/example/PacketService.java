package org.example;

public class PacketService {
    public PacketService() {
    }

    public byte[] serialize(Packet packet){
        byte[] b = new byte[25];
        b[0] = packet.getTempSensor();
        int latI = Float.floatToIntBits(packet.getGpsLat());
        int longI = Float.floatToIntBits(packet.getGpsLong());
        b[1] = (byte) (latI << 24);
        b[2] = (byte) (latI << 16);
        b[3] = (byte) (latI << 8);
        b[4] = (byte) (latI);
        b[5] = (byte) (longI << 24);
        b[6] = (byte) (longI << 16);
        b[7] = (byte) (longI << 8);
        b[8] = (byte) (longI);
        b[9] = (byte) (packet.getId() << 56);
        b[10] = (byte) (packet.getId() << 48);
        b[11] = (byte) (packet.getId() << 40);
        b[12] = (byte) (packet.getId() << 32);
        b[13] = (byte) (packet.getId() << 24);
        b[14] = (byte) (packet.getId() << 16);
        b[15] = (byte) (packet.getId() << 8);
        b[16] = (byte) (packet.getId() );
        b[17] = (byte) (packet.getTimeFrame() << 56);
        b[18] = (byte) (packet.getTimeFrame() << 48);
        b[19] = (byte) (packet.getTimeFrame() << 40);
        b[20] = (byte) (packet.getTimeFrame() << 32);
        b[21] = (byte) (packet.getTimeFrame() << 24);
        b[22] = (byte) (packet.getTimeFrame() << 16);
        b[23] = (byte) (packet.getTimeFrame() << 8);
        b[24] = (byte) (packet.getTimeFrame());
        return b;
    }
    public short checkSum (byte[] b){

        short res =0;
        for ( byte i : b){
            res += i;
        }


        return res;
    }
}
