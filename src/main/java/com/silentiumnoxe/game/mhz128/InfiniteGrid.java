package com.silentiumnoxe.game.mhz128;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class InfiniteGrid {
    private final ShapeRenderer shapeRenderer;
    private float gridSize = 50f; // Розмір клітинки
    private int majorLineEvery = 5; // Кожна 5-та лінія буде жирнішою/яскравішою

    public InfiniteGrid() {
        this.shapeRenderer = new ShapeRenderer();
    }

    public void render(OrthographicCamera camera) {
        // Налаштовуємо ShapeRenderer на роботу з матрицею камери
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);

        // Визначаємо межі екрана у світових координатах
        float zoom = camera.zoom;
        float viewportWidth = camera.viewportWidth * zoom;
        float viewportHeight = camera.viewportHeight * zoom;

        float minX = camera.position.x - viewportWidth / 2;
        float maxX = camera.position.x + viewportWidth / 2;
        float minY = camera.position.y - viewportHeight / 2;
        float maxY = camera.position.y + viewportHeight / 2;

        // Початкові точки для малювання (кратні gridSize)
        float startX = (float) Math.floor(minX / gridSize) * gridSize;
        float startY = (float) Math.floor(minY / gridSize) * gridSize;

        // Малюємо вертикальні лінії
        for (float x = startX; x <= maxX; x += gridSize) {
            setupColor(x, true);
            shapeRenderer.line(x, minY, x, maxY);
        }

        // Малюємо горизонтальні лінії
        for (float y = startY; y <= maxY; y += gridSize) {
            setupColor(y, false);
            shapeRenderer.line(minX, y, maxX, y);
        }

        shapeRenderer.end();
    }

    private void setupColor(float pos, boolean isVertical) {
        // Колір для "головних" ліній (кожна 5-та)
        if (Math.round(pos / gridSize) % majorLineEvery == 0) {
            shapeRenderer.setColor(0.4f, 0.4f, 0.4f, 1f); // Світло-сірий
        } 
        // Звичайна сітка
        else {
            shapeRenderer.setColor(0.2f, 0.2f, 0.2f, 1f); // Темно-сірий
        }
    }

    public void dispose() {
        shapeRenderer.dispose();
    }
}