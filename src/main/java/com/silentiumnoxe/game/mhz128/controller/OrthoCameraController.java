package com.silentiumnoxe.game.mhz128.controller;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

public class OrthoCameraController extends InputAdapter {

    private final OrthographicCamera camera;
    private final Vector3 last = new Vector3();

    public OrthoCameraController(final OrthographicCamera camera) {
        this.camera = camera;
    }

    @Override
    public boolean touchDown(final int screenX, final int screenY, final int pointer, final int button) {
        last.set(screenX, screenY, 0);
        return true;
    }

    @Override
    public boolean touchDragged(final int screenX, final int screenY, final int pointer) {
        float x = (last.x - screenX) * camera.zoom;
        float y = (screenY - last.y) * camera.zoom;
        camera.translate(x, y);
        last.set(screenX, screenY, 0);
        return true;
    }

    @Override
    public boolean scrolled(final float amountX, final float amountY) {
        camera.zoom += amountY * 0.1f; // Зум
        camera.zoom = MathUtils.clamp(camera.zoom, 0.1f, 10f);
        return true;
    }
}
