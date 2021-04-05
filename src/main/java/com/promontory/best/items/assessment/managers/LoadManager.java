package com.promontory.best.items.assessment.managers;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class LoadManager {

    private static final ItemsStorageManager storageManager = new ItemsStorageManager();

    public static ItemsStorageManager getStorageManager() {
        return storageManager;
    }

    public static void loadData(String sourcePath) throws IOException {
        try (
                Stream<String> lines = Files.lines(Paths.get(sourcePath));
        ) {
            long start = System.currentTimeMillis();

            lines.map(
                    line -> line.split(",")
            )
                    .forEach(line -> {
                            storageManager.getItemStorage(sourcePath).put(Double.valueOf(line[1]), line[0]);
                            }
                    );

            long end = System.currentTimeMillis();
            System.out.println("Data loaded from Datasource in : " + (end - start) +"ms");
        }
    }
}
