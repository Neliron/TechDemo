package com.eaton.techDemo.devices;

import java.util.HashMap;

public abstract class Device {

    protected HashMap<String, String> metrics;
    protected String name;

    public HashMap<String, String> getMetrics(){
        return metrics;
    }

    protected Device(){
        metrics = new HashMap<String, String>();
        name = getClass().getSimpleName() + (int)Math.round(Math.random()*1000);
        metrics.put("Name", name);
    }

    public abstract void update();

}
