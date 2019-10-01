/*
 * The MIT License
 *
 * Copyright 2019 Fadil Smajilbasic.
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
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duck
 */
public class Snek extends Thread {

    private final long SPEED = 200;
    private int direction = 0;
    private final int bodyWidth;
    private final int playingField;
    private final int margin;
    Point[] bodyLength;
    private Point food;
    SnekListener listener;
    private boolean collison = false;

    public void setListener(SnekListener listener) {
        this.listener = listener;
    }

    public void setDirection(int direction) {
        if (direction >= 0 && direction < 4) {
            if (direction == 0 && this.direction != 2
                    || direction == 1 && this.direction != 3
                    || direction == 3 && this.direction != 1
                    || direction == 2 && this.direction != 0) {
                this.direction = direction;
            }
        }
    }

    public Snek(int length, int fieldWidth, int bodyWidth, int margin) {

        this.playingField = fieldWidth;
        this.bodyLength = new Point[length];
        this.bodyWidth = bodyWidth;
        this.margin = margin;

        System.out.println("this.bodyWidth: " + this.bodyWidth);

        for (int i = 0; i < bodyLength.length; i++) {
            bodyLength[i] = new Point();
        }

        bodyLength[0].setLocation((int) Math.floor((playingField / (double) 2)), Math.floor((int) (playingField / (double) 2)));

        for (int i = 1; i < bodyLength.length; i++) {
            bodyLength[i].setLocation(bodyLength[0].getX(), bodyLength[0].getY() + i);
        }
        food = new Point();
        this.generateFood();

    }

    public void checkCollision() {

        Point head = bodyLength[0];

        if (head.getX() < 0 || head.getX() >= playingField || head.getY() < 0 || head.getY() >= playingField) {
            System.out.println("out of bounds");
            collison = true;
        }
        for (Point point : bodyLength) {

            if (head != point && head.distance(point) == 0) {
                System.out.println("head: " + head + " collision with point: " + point);
                collison = true;
            }
        }
    }

    public void generateFood() {
        food.setLocation(Math.floor(Math.random() * playingField), Math.floor(Math.random() * playingField));
        for (Point point : bodyLength) {
            if (food.distance(point) == 0) {
                generateFood();
            }
        }
    }

    public boolean isOverFood() {
        return food.distance(bodyLength[0]) == 0;
    }

    public void move() {
        switch (direction) {
            case 0:
                bodyLength[0].setLocation(bodyLength[0].getX(), bodyLength[0].getY() - 1);
                break;
            case 1:
                bodyLength[0].setLocation(bodyLength[0].getX() + 1, bodyLength[0].getY());
                break;
            case 2:
                bodyLength[0].setLocation(bodyLength[0].getX(), bodyLength[0].getY() + 1);
                break;
            case 3:
                bodyLength[0].setLocation(bodyLength[0].getX() - 1, bodyLength[0].getY());
                break;
        }
    }

    public void updateBody() {
        for (int i = bodyLength.length - 1; i > 0; i--) {
            bodyLength[i].setLocation(bodyLength[i - 1].getX(), bodyLength[i - 1].getY());
        }
    }

    private void addLength() {
        Point[] temp = new Point[bodyLength.length + 1];
        for (int i = 0; i < bodyLength.length; i++) {
            temp[i] = bodyLength[i];
        }
        temp[temp.length - 1] = new Point(bodyLength[bodyLength.length - 1]);
        bodyLength = temp;
    }

    @Override
    public void run() {
        listener.snekMoved(this);
        long init = System.currentTimeMillis();
        while (!collison) {

            if (System.currentTimeMillis() - init > 500) {

                listener.snekMoved(this);
                updateBody();
                move();

                if (isOverFood()) {
                    addLength();
                    generateFood();
                }
                init = System.currentTimeMillis();
                checkCollision();
            }

        }
    }

    public void paint(Graphics g) {

        g.setColor(new Color(160, 32, 240));
        g.fillRect((int) (food.getX() * bodyWidth) + margin, (int) (food.getY() * bodyWidth) + margin, bodyWidth, bodyWidth);

        g.setColor(Color.red);
        g.fillRect((int) (bodyLength[0].getX() * bodyWidth) + margin, (int) (bodyLength[0].getY() * bodyWidth) + margin, bodyWidth, bodyWidth);
        g.setColor(Color.BLACK);
        g.drawRect((int) (bodyLength[0].getX() * bodyWidth) + margin, (int) (bodyLength[0].getY() * bodyWidth) + margin, bodyWidth, bodyWidth);
        
        
        for (int i = 1; i < bodyLength.length; i++) {
            g.setColor(Color.green);
            g.fillRect((int) (bodyLength[i].getX() * bodyWidth) + margin, (int) (bodyLength[i].getY() * bodyWidth) + margin, bodyWidth, bodyWidth);

            g.setColor(Color.BLACK);
            g.drawRect((int) (bodyLength[i].getX() * bodyWidth) + margin, (int) (bodyLength[i].getY() * bodyWidth) + margin, bodyWidth, bodyWidth);
        }

    }

}
