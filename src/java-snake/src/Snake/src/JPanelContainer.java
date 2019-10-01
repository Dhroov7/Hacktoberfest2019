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

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author Fadil Smajilbasic
 */
public class JPanelContainer extends JPanel implements SnekListener, KeyListener, MouseListener {

    private final int RESOLUTION = 40;
    private final int MARGIN = 20;
    Snek snek;

    public JPanelContainer() {
        this.addKeyListener(this);
        System.out.println("added key lsitener");
    }

    public double getBlockWidth() {
        int totWidth = this.getWidth() - MARGIN * 2;
        int totHeight = this.getHeight() - MARGIN * 2;

        return (totWidth < totHeight ? (double) totWidth / (double) RESOLUTION : (double) totHeight / (double) RESOLUTION);
    }

    @Override
    protected void paintComponent(Graphics g) {
//        System.out.println("clip area : " + g.getClipBounds());
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.BLACK);
        double width = getBlockWidth();

        g.drawLine((int) (MARGIN + 0 * width), MARGIN, (int) (MARGIN + 0 * width), (int) (MARGIN + RESOLUTION * width));
        g.drawLine((int) (MARGIN + RESOLUTION * width), MARGIN, (int) (MARGIN + RESOLUTION * width), (int) (MARGIN + RESOLUTION * width));

        g.drawLine(MARGIN, (int) (MARGIN + 0 * width), (int) (MARGIN + RESOLUTION * width), (int) (MARGIN + 0 * width));
        g.drawLine(MARGIN, (int) (MARGIN + RESOLUTION * width), (int) (MARGIN + RESOLUTION * width), (int) (MARGIN + RESOLUTION * width));

//        }
        if (snek != null) {
            snek.paint(g);
        }
    }

    @Override
    public void snekMoved(Snek source) {
        repaint();
    }

    public void createSnek() {
        if (snek == null) {
            System.out.println("created snek");
            snek = new Snek(3, RESOLUTION, (int) getBlockWidth(), MARGIN);
            snek.setListener(this);
            snek.start();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 10:
                createSnek();
                break;
            case 37:
                snek.setDirection(3);
                break;
            case 38:
                snek.setDirection(0);
                break;
            case 39:
                snek.setDirection(1);
                break;
            case 40:
                snek.setDirection(2);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public boolean isFocusable() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        requestFocusInWindow();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
