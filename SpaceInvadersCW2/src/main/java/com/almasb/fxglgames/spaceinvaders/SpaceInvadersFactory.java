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

package com.almasb.fxglgames.spaceinvaders;

import com.almasb.fxgl.animation.Interpolators;
import com.almasb.fxgl.annotation.SetEntityFactory;
import com.almasb.fxgl.annotation.Spawns;
import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.ecs.Entity;
import com.almasb.fxgl.entity.*;
import com.almasb.fxgl.entity.component.CollidableComponent;
import com.almasb.fxgl.entity.control.ExpireCleanControl;
import com.almasb.fxgl.entity.control.OffscreenCleanControl;
import com.almasb.fxgl.entity.control.ProjectileControl;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.texture.Texture;
import com.almasb.fxglgames.spaceinvaders.component.HPComponent;
import com.almasb.fxglgames.spaceinvaders.component.InvincibleComponent;
import com.almasb.fxglgames.spaceinvaders.component.OwnerComponent;
import com.almasb.fxglgames.spaceinvaders.component.SubTypeComponent;
import com.almasb.fxglgames.spaceinvaders.control.*;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.Random;

import static com.almasb.fxgl.app.DSLKt.geti;
import static com.almasb.fxgl.app.DSLKt.texture;
import static com.almasb.fxglgames.spaceinvaders.Config.LEVEL_START_DELAY;

/**
 * @author Almas Baimagambetov (AlmasB)  
 */
@SetEntityFactory
public final class SpaceInvadersFactory implements EntityFactory {

    private static final Random random = FXGLMath.getRandom();

    private static final RenderLayer METEORS = new RenderLayer() {
        @Override
        public String name() {
            return "METEORS";
        }

        @Override
        public int index() {
            return 1001;
        }
    };

    private static final int NUM_STARS = 70;

    @Spawns("Background")
    public Entity newBackground(SpawnData data) {
        return Entities.builder()
                .viewFromNode(texture("background/background.png", Config.WIDTH, Config.HEIGHT))
                .renderLayer(RenderLayer.BACKGROUND)
                .build();
    }

    @Spawns("Stars")
    public Entity newStars(SpawnData data) {
        Group group = new Group();

        for (int i = 0; i < NUM_STARS; i++) {
            group.getChildren().addAll(new Rectangle());
        }

        EntityView view = new EntityView(group, RenderLayer.BACKGROUND);

        return Entities.builder()
                .viewFromNode(view)
                .with(new StarsControl())
                .build();
    }

    @Spawns("Meteor")
    public Entity newMeteor(SpawnData data) {
        double w = FXGL.getSettings().getWidth();
        double h = FXGL.getSettings().getHeight();
        double x = 0, y = 0;

        // these are deliberately arbitrary to create illusion of randomness
        if (random.nextBoolean()) {
            // left or right
            if (random.nextBoolean()) {
                x = -50;
            } else {
                x = w + 50;
            }

            y = random.nextInt((int) h);
        } else {
            // top or bot
            if (random.nextBoolean()) {
                y = -50;
            } else {
                y = h + 50;
            }

            x = random.nextInt((int) w);
        }

        GameEntity meteor = Entities.builder()
                .at(x, y)
                .viewFromTexture("background/meteor" + FXGLMath.random(1, 4) + ".png")
                .renderLayer(METEORS)
                .with(new MeteorControl())
                .build();

        // add offscreen clean a bit later so that they are not cleaned from start
        FXGL.getMasterTimer()
                .runOnceAfter(() -> {
                    meteor.addControl(new OffscreenCleanControl());
                }, Duration.seconds(5));

        return meteor;
    }

    @Spawns("Player")
    public GameEntity newPlayer(SpawnData data) {
        Texture texture = texture("player2.png");
        texture.setPreserveRatio(true);
        texture.setFitHeight(40);

        return Entities.builder()
                .from(data)
                .type(SpaceInvadersType.PLAYER)
                .viewFromNodeWithBBox(texture)
                .with(new CollidableComponent(true), new InvincibleComponent())
                .with(new PlayerControl())
                .build();
    }

    @Spawns("Enemy")
    public Entity newEnemy(SpawnData data) {
        return Entities.builder()
                .from(data)
                .type(SpaceInvadersType.ENEMY)
                .viewFromNodeWithBBox(
                        texture("enemy" + ((int)(Math.random() * 3) + 1) + ".png").toAnimatedTexture(2, Duration.seconds(2))
                )
                .with(new CollidableComponent(true), new HPComponent(2))
                .with(new EnemyControl())
                .build();
    }

    @Spawns("Boss")
    public Entity newBoss(SpawnData data) {
        return Entities.builder()
                .from(data)
                .type(SpaceInvadersType.BOSS)
                .viewFromTextureWithBBox("boss.png")
                .with(new CollidableComponent(true), new HPComponent(10))
                .with(new BossControl())
                .build();
    }

    @Spawns("Bullet")
    public Entity newBullet(SpawnData data) {
        GameEntity owner = data.get("owner");

        GameEntity bullet = new GameEntity();
        bullet.getTypeComponent().setValue(SpaceInvadersType.BULLET);

        Point2D center = Entities.getBBox(owner)
                .getCenterWorld()
                .add(-8, 20 * (owner.isType(SpaceInvadersType.PLAYER) ? -1 : 1));

        bullet.getPositionComponent().setValue(center);

        bullet.addComponent(new CollidableComponent(true));
        bullet.getViewComponent().setView(new EntityView(texture("tank_bullet.png")), true);
        bullet.addControl(new ProjectileControl(new Point2D(0, owner.isType(SpaceInvadersType.PLAYER) ? -1 : 1), 10 * 60));
        bullet.addComponent(new OwnerComponent(Entities.getType(owner).getValue()));
        bullet.addControl(new OffscreenCleanControl());

        bullet.setProperty("dead", false);

        return bullet;
    }

    @Spawns("Laser")
    public Entity newLaser(SpawnData data) {
        GameEntity owner = data.get("owner");

        GameEntity bullet = new GameEntity();
        bullet.getTypeComponent().setValue(SpaceInvadersType.BULLET);

        Point2D center = Entities.getBBox(owner)
                .getCenterWorld()
                .add(-4.5, -20);

        bullet.getPositionComponent().setValue(center);

        bullet.getBoundingBoxComponent().addHitBox(new HitBox("HIT", BoundingShape.box(9, 20)));
        bullet.addComponent(new CollidableComponent(true));
        bullet.addComponent(new OwnerComponent(Entities.getType(owner).getValue()));
        bullet.addControl(new OffscreenCleanControl());
        bullet.addControl(new BulletControl(850));

        EntityView view = new EntityView();

        Texture t = texture("laser2.png");
        t.relocate(-2, -20);

        view.addNode(t);
        view.setEffect(new Bloom(0.5));

        bullet.getViewComponent().setView(view);

        return bullet;
    }

    @Spawns("LaserHit")
    public Entity newLaserHit(SpawnData data) {
        return Entities.builder()
                .at(data.getX() - 15, data.getY() - 15)
                .viewFromNode(texture("laser_hit.png", 15, 15))
                .with(new LaserHitControl())
                .build();
    }

    @Spawns("LaserBeam")
    public Entity newLaserBeam(SpawnData data) {
        Rectangle view = new Rectangle(10, Config.HEIGHT - 25, Color.color(1.0, 1.0, 1.0, 0.86));
        view.setArcWidth(15);
        view.setArcHeight(15);
        view.setStroke(Color.BLUE);
        view.setStrokeWidth(1);

        return Entities.builder()
                .from(data)
                .type(SpaceInvadersType.LASER_BEAM)
                .viewFromNodeWithBBox(view)
                .with(new CollidableComponent(true))
                .with(new LaserBeamControl())
                .build();
    }

    @Spawns("Wall")
    public Entity newWall(SpawnData data) {
        return Entities.builder()
                .from(data)
                .type(SpaceInvadersType.WALL)
                .viewFromNodeWithBBox(texture("wall.png", 232 / 3, 104 / 3))
                .with(new CollidableComponent(true))
                .with(new WallControl(7))
                .build();
    }

    @Spawns("Bonus")
    public Entity newBonus(SpawnData data) {
        BonusType type = data.get("type");

        return Entities.builder()
                .from(data)
                .type(SpaceInvadersType.BONUS)
                .viewFromTextureWithBBox(type.textureName)
                .with(new SubTypeComponent(type), new CollidableComponent(true))
                .with(new BonusControl())
                .build();
    }

    @Spawns("Explosion")
    public Entity newExplosion(SpawnData data) {
        return Entities.builder()
                .at(data.getX() - 40, data.getY() - 40)
                // we want a smaller texture, 80x80
                // it has 16 frames, hence 80 * 16
                .viewFromNode(texture("explosion.png", 80 * 16, 80).toAnimatedTexture(16, Duration.seconds(0.5)))
                .with(new ExpireCleanControl(Duration.seconds(0.5)))
                .build();
    }

    @Spawns("LevelInfo")
    public Entity newLevelInfo(SpawnData data) {
        Text levelText = FXGL.getUIFactory().newText("Level " + geti("level"), Color.AQUAMARINE, 44);

        GameEntity levelInfo = Entities.builder()
                .viewFromNode(levelText)
                .with(new ExpireCleanControl(Duration.seconds(LEVEL_START_DELAY)))
                .build();

        Entities.animationBuilder()
                .interpolator(Interpolators.BOUNCE.EASE_OUT())
                .duration(Duration.seconds(LEVEL_START_DELAY - 0.1))
                .translate(levelInfo)
                .from(new Point2D(FXGL.getAppWidth() / 2 - levelText.getLayoutBounds().getWidth() / 2, 0))
                .to(new Point2D(FXGL.getAppWidth() / 2 - levelText.getLayoutBounds().getWidth() / 2, FXGL.getAppHeight() / 2))
                .buildAndPlay();

        return levelInfo;
    }
}
