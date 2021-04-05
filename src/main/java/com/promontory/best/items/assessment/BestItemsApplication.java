package com.promontory.best.items.assessment;


import com.promontory.best.items.assessment.managers.LoadManager;
import com.promontory.best.items.assessment.models.Item;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;


public class BestItemsApplication {

    public static void main(String[] args) throws IOException {
        if (args.length == 1) {
            System.out.println("Invalid number of arguments were provided");
            return;
        }
        if (args.length > 0) {
            LoadManager.loadData(args[0]);
            Item[] items = getBestTwoItems(args[0], Double.valueOf(args[1]));
            printBestTwoItems(items);
        } else {
            while (true)  {

                System.out.println("\nProvide the absolute path to the data set, and balance of your gift card");
                Scanner sc = new Scanner(System.in);
                String[] vars = new String[2];
                for (int i = 0; i < 2; i++) {
                    vars[i] = sc.next();
                }
                if (vars[0].equalsIgnoreCase("exit") || vars[1].equalsIgnoreCase("exit")) {
                    break;
                }
                LoadManager.loadData(vars[0]);
                Item[] items = getBestTwoItems(vars[0], Double.valueOf(vars[1]));
                printBestTwoItems(items);
            }
        }
    }

    private static void printBestTwoItems(Item[] items) {
        if (items == null || items.length == 0) {
            System.out.println("Not Possible");
        }
        if (items[0].getItemName() == null || items[1].getItemName() == null) {
            System.out.println("Not Possible");
        } else {
            Arrays.stream(items).forEach(item -> {
                System.out.println(item.toString());
            });
        }

    }

    public static Item[] getBestTwoItems(String pathFile, double balance) {
        Map<Double, String> itemsMap = LoadManager.getStorageManager().getItemStorage(pathFile);

        if (itemsMap != null || !itemsMap.isEmpty()) {

            double[] resultPrices = new double[2];
            Double[] prices = itemsMap.keySet().toArray(new Double[itemsMap.keySet().size()]);
            double diff = Double.MAX_VALUE;
            int left = 0;
            int right = prices.length - 1;

            while (left < right) {
                double tempSum = prices[left] + prices[right];
                if (balance == tempSum) {
                    resultPrices[0] = prices[left];
                    resultPrices[1] = prices[right];
                    break;
                }
                if (balance > tempSum) {
                    double tempDiff = balance - tempSum;
                    if (diff > tempDiff) {
                        diff = tempDiff;
                        resultPrices[0] = prices[left];
                        resultPrices[1] = prices[right];
                    }
                    left = left + 1;
                } else if (balance < tempSum) {
                    right = right - 1;
                }

            }
            Item[] toReturn = new Item[2];
            for (int i = 0; i < resultPrices.length; i++) {
                toReturn[i] = new Item(itemsMap.get(resultPrices[i]), resultPrices[i]);
            }

            return toReturn;
        } else {
            return null;
        }
    }

}