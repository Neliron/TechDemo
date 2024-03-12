package com.eaton.techDemo;

import com.eaton.techDemo.devices.CPUDevice;
import com.eaton.techDemo.devices.Device;
import com.eaton.techDemo.devices.FanDevice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class DevicesService {

    private ArrayList<Device> devices;
    private final int DEVICE_NUMBER = 10;

    private Timer timer;

    public DevicesService(){
        devices = new ArrayList<Device>();

        for(int i = 0; i<DEVICE_NUMBER; i++){
            Device device = Math.random() > 0.5 ? new CPUDevice() : new FanDevice();
            devices.add(device);
        }

        TimerTask task = new TimerTask() {
            public void run() {
                updateAllDevices();
            }
        };
        timer = new Timer("Timer");

        int delay = 200;
        timer.schedule(task, 0, delay);
    }

    public void updateAllDevices(){
        for(Device d : devices){
            d.update();
        }
    }

    public String getAllDevicesMetrics(){
        try {
            return new ObjectMapper().writeValueAsString(devices);
        } catch (JsonProcessingException e) {
            return "{" +
                        "error: Object parsing error" +
                    "}";
        }
    }

}
