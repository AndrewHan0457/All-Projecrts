package com.almasb.fxglgames.spaceinvaders.level;

import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.entity.GameEntity;
import com.almasb.fxgl.entity.control.RandomMoveControl;
import com.almasb.fxglgames.spaceinvaders.Config;
import javafx.geometry.Rectangle2D;

import static com.almasb.fxgl.app.DSLKt.geti;
import static com.almasb.fxglgames.spaceinvaders.Config.ENEMIES_PER_ROW;
import static com.almasb.fxglgames.spaceinvaders.Config.ENEMY_ROWS;

/**
 * @author Almas Baimagambetov  
 */
public class Level2 extends SpaceLevel {

    @Override
    public void init() {
        for (int y = 0; y < ENEMY_ROWS; y++) {
            for (int x = 0; x < ENEMIES_PER_ROW; x++) {
                GameEntity enemy = spawnEnemy(x*60, 150 + 50 * geti("level") + y*60);
                enemy.addControl(new RandomMoveControl(FXGLMath.random(25, 75), x, y, new Rectangle2D(0, 0, Config.WIDTH, Config.HEIGHT / 2)));
            }
        }
    }

    @Override
    public void destroy() {

    }
}
