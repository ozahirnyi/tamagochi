module Tamagotchi.main {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires java.sql;
    requires javafx.fxml;
    requires javafx.media;
    exports world.ucode;
    exports world.ucode.control;
    exports world.ucode.view;
    exports world.ucode.model;
}