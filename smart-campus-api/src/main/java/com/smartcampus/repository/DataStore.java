package com.smartcampus.repository;

import com.smartcampus.model.Room;
import com.smartcampus.model.Sensor;
import com.smartcampus.model.SensorReading;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataStore {

    public static final Map<String, Room> rooms = new HashMap<>();
    public static final Map<String, Sensor> sensors = new HashMap<>();
    public static final Map<String, List<SensorReading>> sensorReadings = new HashMap<>();

    private DataStore() {
        // prevent object creation
    }

    static {
        // optional starter data
        Room room1 = new Room("LIB-301", "Library Quiet Study", 120);
        Room room2 = new Room("LAB-101", "Computer Lab 101", 40);

        rooms.put(room1.getId(), room1);
        rooms.put(room2.getId(), room2);

        sensorReadings.put("TEMP-001", new ArrayList<>());
        sensorReadings.put("CO2-001", new ArrayList<>());
    }
}