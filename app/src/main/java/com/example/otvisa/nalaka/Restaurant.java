package com.example.otvisa.nalaka;

/**
 * Created by ottov on 15.8.2017.
 */

public enum Restaurant {
    SNELLMANIA("Snellmania", "0437"),
    TIETOTEKNIA("Tietoteknia", "0439"),
    MEDITEKNIA("Mediteknia", "0442"),
    CANTHIA("Canthia", "0436");

    public final String name;
    private final String kitchenId;

    Restaurant(String name, String kitchenId) {
        this.name = name;
        this.kitchenId = kitchenId;
    }

    public String getName() {
        return this.name;
    }

    public String getKitchenId() {
        return kitchenId;

    }
}
