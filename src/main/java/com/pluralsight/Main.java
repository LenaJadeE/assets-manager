package com.pluralsight;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int thisYear = LocalDate.now().getYear();

        ArrayList<Asset> myAssets = new ArrayList<>();
        myAssets.add(new House("my house", "2020-06-15", new BigDecimal("180000"),
                "12 Maple Lane", 2, 1800, 6000));
        myAssets.add(new House("vacation home", "2018-03-02", new BigDecimal("95000"),
                "4 Lake Road", 3, 1100, 20000));
        myAssets.add(new Vehicle("my car", "2023-08-20", new BigDecimal("20000"),
                "Mazda CX-5", thisYear - 2, 35000));
        myAssets.add(new Vehicle("Tom's truck", "2015-01-10", new BigDecimal("32000"),
                "Ford F-150", thisYear - 9, 140000));
        myAssets.add(new Vehicle("Grandma's Camry", "2012-05-05", new BigDecimal("24000"),
                "Toyota Camry", thisYear - 12, 210000));
        myAssets.add(new Cash("mattress stash", "2024-12-01", new BigDecimal("2500")));

        for (Asset asset : myAssets) {
            String message = "";
            if (asset instanceof House house) {
                message = "House at " + house.getAddress();
            } else if (asset instanceof Vehicle vehicle) {
                message = "Vehicle: " + vehicle.getYear() + " " + vehicle.getMakeModel();
            } else if (asset instanceof Cash) {
                message = "Cash under the mattress";
            }

            System.out.println(asset.getDescription());
            System.out.println("  " + message);
            System.out.println("  Acquired: " + asset.getDateAcquired());
            System.out.printf("  Paid: $%,.2f%n", asset.getOriginalCost());
            System.out.printf("  Worth: $%,.2f%n", asset.getValue());
            System.out.println();
        }
    }
}
