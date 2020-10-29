/*
 * The MIT License (MIT)
 *
 * FXGL - JavaFX Game Library
 *
 * Copyright (c) 2015-2017 AlmasB  
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.almasb.fxglgames.spaceinvaders.control;

import com.almasb.fxgl.animation.Interpolators;
import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.ecs.Control;
import com.almasb.fxgl.ecs.Entity;
import com.almasb.fxgl.entity.Entities;
import com.almasb.fxgl.entity.GameEntity;
import com.almasb.fxgl.entity.component.CollidableComponent;
import javafx.geometry.Point2D;
import javafx.util.Duration;

import static com.almasb.fxgl.app.DSLKt.play;
import static com.almasb.fxgl.app.DSLKt.texture;

/**
 * @author Almas Baimagambetov  
 */
public class WallControl extends Control {

    private final int originalLives;
    private int lives;

    public WallControl(int lives) {
        this.lives = lives;
        originalLives = lives;
    }

    private GameEntity wall;

    @Override
    public void onAdded(Entity entity) {
        wall = (GameEntity) entity;
    }

    @Override
    public void onUpdate(Entity entity, double tpf) {}

    public void onHit() {
        lives--;

        Entities.animationBuilder()
                .autoReverse(true)
                .repeat(2)
                .interpolator(Interpolators.CIRCULAR.EASE_IN())
                .duration(Duration.seconds(0.33))
                .scale((GameEntity) wall)
                .to(new Point2D(1.2, 1.2))
                .buildAndPlay();

        if (lives == 0) {
            wall.getComponent(CollidableComponent.class).setValue(false);

            Entities.animationBuilder()
                    .interpolator(Interpolators.EXPONENTIAL.EASE_OUT())
                    .duration(Duration.seconds(0.8))
                    .onFinished(wall::removeFromWorld)
                    .translate((GameEntity) wall)
                    .from(wall.getPosition())
                    .to(new Point2D(wall.getX(), FXGL.getAppHeight() + 10))
                    .buildAndPlay();
        } else if (lives == originalLives / 2) {
            wall.setView(texture("wall2.png", 232 / 3, 104 / 3));
            play("brick_hit.wav");
        }
    }
}
