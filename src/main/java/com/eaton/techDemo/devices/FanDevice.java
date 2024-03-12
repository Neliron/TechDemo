package com.eaton.techDemo.devices;

public class FanDevice extends Device{

    private final String FANSPEEDMETRIC = "Fan speed";
    private long currentFanSpeed;
    public FanDevice(){
        super();

        currentFanSpeed = Math.round(Math.random()*1500+500);
        metrics.put(FANSPEEDMETRIC, String.valueOf(currentFanSpeed));
    }

    @Override
    public void update() {
        randomizeFanSpeed();
    }

    private void randomizeFanSpeed(){
        currentFanSpeed = Math.round(Math.min(3500,Math.max(500,currentFanSpeed + Math.random()*500 - 250)));
        metrics.replace(FANSPEEDMETRIC, String.valueOf(currentFanSpeed));
    }

}
