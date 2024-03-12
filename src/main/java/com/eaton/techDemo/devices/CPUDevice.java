package com.eaton.techDemo.devices;

import java.util.HashMap;

public class CPUDevice extends Device {

    private final String CPUTEMPERATUREMETRIC = "Temperature";
    private final String CPUUSAGE = "Usage";
    private final String OVERCLOAKING = "Is Overcloacked";
    private long currentCPUTemperature;
    private long currentCPUUsage;
    private boolean isOvercloaked;
    public CPUDevice(){
        super();

        currentCPUTemperature = Math.round(Math.random()*50+30);
        metrics.put(CPUTEMPERATUREMETRIC, String.valueOf(currentCPUTemperature));

        currentCPUUsage = Math.round(Math.random()*80+20);
        metrics.put(CPUUSAGE, String.valueOf(currentCPUUsage));

        isOvercloaked = Math.random() > 0.5;
        metrics.put(OVERCLOAKING, String.valueOf(isOvercloaked));
    }

    @Override
    public void update(){
        randomizeCPUTemperature();
        randomizeCPUUsage();
    }

    private void randomizeCPUTemperature(){
        currentCPUTemperature = Math.round(Math.min(200,Math.max(25,currentCPUTemperature + Math.random()*10 - 5)));
        metrics.replace(CPUTEMPERATUREMETRIC, String.valueOf(currentCPUTemperature));
    }

    private void randomizeCPUUsage(){
        currentCPUUsage = Math.round(Math.min(100,Math.max(5,currentCPUUsage + Math.random()*10 - 5)));
        metrics.replace(CPUUSAGE, String.valueOf(currentCPUUsage));
    }

}
