package com.wrightd.platformer.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.wrightd.platformer.model.Player;

public class GameScreen implements Screen {
    public TiledMap map;
    public OrthogonalTiledMapRenderer renderer;
    public OrthographicCamera camera;

    public SpriteBatch spriteBatch;
    public Player player;

    public GameScreen() {
        map = new TmxMapLoader().load("map/level01.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1/70f);

        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        camera = new OrthographicCamera(14f, 14f * (height / width));
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);

        new SpriteBatch();
        player = new Player();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.41f, 0.41f, 0.41f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        renderer.setView(camera);
        renderer.render();

        spriteBatch.begin();
//        this line (44) gives me an error :
//        "C:\Program Files\Java\jdk1.8.0_11\bin\java" -Didea.launcher.port=7542 "-Didea.launcher.bin.path=C:\Program Files (x86)\Android\android-studio1\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_11\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_11\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_11\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_11\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_11\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_11\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_11\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_11\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_11\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_11\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_11\jre\lib\rt.jar;C:\Program Files\Java\jdk1.8.0_11\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_11\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_11\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_11\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_11\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_11\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_11\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_11\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_11\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_11\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_11\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_11\jre\lib\ext\zipfs.jar;C:\Users\Student\AndroidStudioProjects\platformer\desktop\build\classes\main;C:\Users\Student\AndroidStudioProjects\platformer\core\build\classes\main;C:\Users\Student\.gradle\caches\modules-2\files-2.1\com.badlogicgames.gdx\gdx\1.2.0\eb55d6eb1165daf6be23189767c19d811ca5eb36\gdx-1.2.0.jar;C:\Users\Student\.gradle\caches\modules-2\files-2.1\com.badlogicgames.gdx\gdx-box2d\1.2.0\cc39fa3dbad14b247655266c10e64367418564bd\gdx-box2d-1.2.0.jar;C:\Users\Student\.gradle\caches\modules-2\files-2.1\com.badlogicgames.gdx\gdx-backend-lwjgl\1.2.0\4d1fc56c16aa58ad5030e2782e0fad35220d8d40\gdx-backend-lwjgl-1.2.0.jar;C:\Users\Student\.gradle\caches\modules-2\files-2.1\com.badlogicgames.gdx\gdx-platform\1.2.0\e1acebd7766db2a7c3330ff653c7eff206e7b10f\gdx-platform-1.2.0-natives-desktop.jar;C:\Users\Student\.gradle\caches\modules-2\files-2.1\com.badlogicgames.gdx\gdx-box2d-platform\1.2.0\4bc9d372e2a7f8fc1503aef5cd445dfb236de3ab\gdx-box2d-platform-1.2.0-natives-desktop.jar;C:\Users\Student\.gradle\caches\modules-2\files-2.1\org.lwjgl.lwjgl\lwjgl-platform\2.9.1\aa9aae879af8eb378e22cfc64db56ec2ca9a44d1\lwjgl-platform-2.9.1-natives-linux.jar;C:\Users\Student\.gradle\caches\modules-2\files-2.1\org.lwjgl.lwjgl\lwjgl-platform\2.9.1\2d12c83fdfbc04ecabf02c7bc8cc54d034f0daac\lwjgl-platform-2.9.1-natives-osx.jar;C:\Users\Student\.gradle\caches\modules-2\files-2.1\org.lwjgl.lwjgl\lwjgl-platform\2.9.1\4c517eca808522457dd95ee8fc1fbcdbb602efbe\lwjgl-platform-2.9.1-natives-windows.jar;C:\Users\Student\.gradle\caches\modules-2\files-2.1\net.java.jutils\jutils\1.0.0\e12fe1fda814bd348c1579329c86943d2cd3c6a6\jutils-1.0.0.jar;C:\Users\Student\.gradle\caches\modules-2\files-2.1\net.java.jinput\jinput\2.0.5\39c7796b469a600f72380316f6b1f11db6c2c7c4\jinput-2.0.5.jar;C:\Users\Student\.gradle\caches\modules-2\files-2.1\org.lwjgl.lwjgl\lwjgl\2.9.1\f58c5aabcef0e41718a564be9f8e412fff8db847\lwjgl-2.9.1.jar;C:\Users\Student\.gradle\caches\modules-2\files-2.1\net.java.jinput\jinput-platform\2.0.5\7ff832a6eb9ab6a767f1ade2b548092d0fa64795\jinput-platform-2.0.5-natives-linux.jar;C:\Users\Student\.gradle\caches\modules-2\files-2.1\net.java.jinput\jinput-platform\2.0.5\53f9c919f34d2ca9de8c51fc4e1e8282029a9232\jinput-platform-2.0.5-natives-osx.jar;C:\Users\Student\.gradle\caches\modules-2\files-2.1\net.java.jinput\jinput-platform\2.0.5\385ee093e01f587f30ee1c8a2ee7d408fd732e16\jinput-platform-2.0.5-natives-windows.jar;C:\Users\Student\.gradle\caches\modules-2\files-2.1\org.lwjgl.lwjgl\lwjgl_util\2.9.1\290d7ba8a1bd9566f5ddf16ad06f09af5ec9b20e\lwjgl_util-2.9.1.jar;C:\Users\Student\.gradle\caches\modules-2\files-2.1\com.badlogicgames.jlayer\jlayer\1.0.1-gdx\7cca83cec5c1b2f011362f4d85aabd71a73b049d\jlayer-1.0.1-gdx.jar;C:\Users\Student\.gradle\caches\modules-2\files-2.1\org.jcraft\jorbis\0.0.17\8872d22b293e8f5d7d56ff92be966e6dc28ebdc6\jorbis-0.0.17.jar;C:\Program Files (x86)\Android\android-studio1\lib\idea_rt.jar" com.intellij.rt.execution.application.AppMain com.wrightd.platformer.desktop.DesktopLauncher
//        Exception in thread "LWJGL Application" java.lang.NullPointerException
//        at com.wrightd.platformer.view.GameScreen.render(GameScreen.java:44)
//        at com.badlogic.gdx.Game.render(Game.java:46)
//        at com.badlogic.gdx.backends.lwjgl.LwjglApplication.mainLoop(LwjglApplication.java:206)
//        at com.badlogic.gdx.backends.lwjgl.LwjglApplication$1.run(LwjglApplication.java:114)
//
//        Process finished with exit code 0
        player.draw(spriteBatch);
        spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {
        camera.viewportWidth = 14f;
        camera.viewportHeight = 14f * height / width;
        camera.update();
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}