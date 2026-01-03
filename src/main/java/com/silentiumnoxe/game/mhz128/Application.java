package com.silentiumnoxe.game.mhz128;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.glutils.HdpiMode;
import com.silentiumnoxe.game.mhz128.scene.MainScene;

public class Application {

    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setForegroundFPS(60);
        config.setTitle("City Industry PoC");
        config.setWindowedMode(1680, 1080);
        config.setHdpiMode(HdpiMode.Logical);

        // Запуск
        new Lwjgl3Application(new MainScene(), config);
    }
}
