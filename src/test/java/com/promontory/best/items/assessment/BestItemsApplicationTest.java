package com.promontory.best.items.assessment;

import com.promontory.best.items.assessment.managers.LoadManager;
import com.promontory.best.items.assessment.models.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;


import static org.junit.Assert.*;

@RunWith(BlockJUnit4ClassRunner.class)
public class BestItemsApplicationTest {
    private static final String FILEPATH = "src/test/resources/dataset";

    @Before
    public void setUp() throws Exception {
        LoadManager.loadData(FILEPATH);
    }

    @Test
    public void bestTwoItems_Valid_Input_Test() {
        Item[] items = BestItemsApplication.getBestTwoItems(FILEPATH, 8000);
        assertEquals("Item name should be Earmuffs", "Earmuffs", items[0].getItemName());
        assertEquals(2000, items[0].getPrice(), 0d);
        assertEquals("Item name should be Bluetooth Stereo", "Bluetooth Stereo", items[1].getItemName());
        assertEquals(6000, items[1].getPrice(), 0d);
    }

    @Test
    public void bestTwoItems_Balance_Less_Then_Any_Item_Price_Test() {
        Item[] items = BestItemsApplication.getBestTwoItems(FILEPATH, 100);
        assertNull( null, items[0].getItemName());
        assertNull( null, items[1].getItemName());
    }
}