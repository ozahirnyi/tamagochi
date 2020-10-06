module Tamagotchi.main {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
//    requires javafx.sql;
    requires javafx.fxml;
    exports world.ucode;
    exports world.ucode.control;
    exports world.ucode.view;
    exports world.ucode.model;
}