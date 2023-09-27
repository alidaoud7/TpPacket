package org.example;

public class Packet {
    private byte tempSensor;
    private float gpsLong;
    private float gpsLat;
    private short checksum;

    private long id;
    private long timeFrame;

    public Packet(byte tempSensor, float gpsLong, float gpsLat, short checksum, long id, long timeFrame) {
        this.tempSensor = tempSensor;
        this.gpsLong = gpsLong;
        this.gpsLat = gpsLat;
        this.checksum = checksum;
        this.id = id;
        this.timeFrame = timeFrame;
    }

    public Packet() {
    }

    public byte getTempSensor() {
        return tempSensor;
    }

    public void setTempSensor(byte tempSensor) {
        this.tempSensor = tempSensor;
    }

    public float getGpsLong() {
        return gpsLong;
    }

    public void setGpsLong(float gpsLong) {
        this.gpsLong = gpsLong;
    }

    public float getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(float gpsLat) {
        this.gpsLat = gpsLat;
    }

    public short getChecksum() {
        return checksum;
    }

    public void setChecksum(short checksum) {
        this.checksum = checksum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(long timeFrame) {
        this.timeFrame = timeFrame;
    }


}


