package com.silentiumnoxe.game.mhz128.scene;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.silentiumnoxe.game.mhz128.InfiniteGrid;
import com.silentiumnoxe.game.mhz128.controller.OrthoCameraController;

public class MainScene extends ApplicationAdapter {

    private OrthographicCamera camera;
    private Viewport viewport;
    private InfiniteGrid grid;
    private InputMultiplexer inputListener;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1680, 1080);
        viewport = new ExtendViewport(1680, 1080, camera);

        grid = new InfiniteGrid();

        var camController = new OrthoCameraController(camera);

        inputListener = new InputMultiplexer();
        inputListener.addProcessor(camController);

        Gdx.input.setInputProcessor(inputListener);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.1f, 0.1f, 0.1f, 1f);

        camera.update();

        grid.render(camera);
    }

    @Override
    public void resize(final int width, final int height) {
        viewport.update(width, height, false);
    }

    @Override
    public void dispose() {
        grid.dispose();
    }
}
