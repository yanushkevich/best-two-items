package com.promontory.best.items.assessment.managers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(BlockJUnit4ClassRunner.class)
public class LoadManagerTest {

    private static final String FILEPATH = "src/test/resources/dataset";

    @Test
    public void loadManager_Load_Data_Test() {
        String filename = FILEPATH;
        Map<Double, String> map = LoadManager.getStorageManager().getItemStorage(filename);
        assertNotNull("Loaded data to collection should not be empty", map.keySet());
    }

    @Test
    public void loadManager_Load_Data_With_Invalid_File_Path_Test() {
        String filename = FILEPATH + "testString";
        Map<Double, String> map = LoadManager.getStorageManager().getItemStorage(filename);
        assertEquals("Loaded data to collection should be 0", 0, map.keySet().size());
    }
}