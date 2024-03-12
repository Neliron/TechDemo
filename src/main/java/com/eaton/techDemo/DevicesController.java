package com.eaton.techDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/devices")
public class DevicesController {

    @Autowired
    DevicesService devicesService;

    @GetMapping(path = "/getDevices")
    public ResponseEntity<?> getDevices(){
        return ResponseEntity.ok(devicesService.getAllDevicesMetrics());
    }

    @GetMapping(path = "/update")
    public ResponseEntity<?> updateDevices(){
        devicesService.updateAllDevices();
        return ResponseEntity.ok(null);
    }

}
