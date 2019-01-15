package com.mygdx.main.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.main.Main;
import java.awt.Dimension;
import java.awt.Toolkit;

public class DesktopLauncher {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "PerlinNoise";
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        config.height = screenSize.height;
        config.width = screenSize.width;
        new LwjglApplication(new Main(), config);
    }
}
