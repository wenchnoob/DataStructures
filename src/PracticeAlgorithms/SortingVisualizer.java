package PracticeAlgorithms;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class SortingVisualizer implements Runnable {
    private static final int Width = 640, Height = 480;
    private String name = "Sorting Visualizer";
    private Window w;
    private boolean Running = false;
    private Canvas canvas = new Canvas();
    private Thread thread;
    private final Rectangle[] rects;

    public SortingVisualizer() {
        rects = populate(Width, Height).toArray(Rectangle[]::new);
        new Window(Width, Height, name, canvas);
        Running = true;
    }

    private List<Rectangle> populate(int w, int h) {
        List<Rectangle> list = new ArrayList<>();
        Random r = new Random();
        for(int i = 0; i < w; i++) {
            list.add(new Rectangle(i, 0, 1, r.nextInt(6*h/10) + h/10));
        }
        return list;
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        Running = true;

    }

    @Override
    public void run() {
        canvas.setBackground(Color.BLACK);
        Graphics g = canvas.getGraphics();
        g.setColor(Color.WHITE);
        for(Rectangle rect: rects) rect.draw(g);
        quicksort(rects, 0, rects.length, g);
    }

    public static void main(String[] args) {
        new SortingVisualizer().start();
    }

    public void quicksort(Comparable[] arr, int start, int end, Graphics g) {
        if (end - start > 1) {
            int p = partition(arr, start, end, g);
            quicksort(arr, start, p, g);
            quicksort(arr, p+1, end, g);
        }
    }

    public int partition(Comparable[] arr, int start, int end, Graphics g) {
        Comparable pivot = arr[end-1];
        int beforePivot = start - 1;
        for(int i = start; i < end; i++) if (arr[i].compareTo(pivot) < 0) {
            swap(arr, i, ++beforePivot, g);

        }
        swap(arr, end-1, ++beforePivot, g);
        return beforePivot;
    }

    public void swap(Object[] arr, int i, int j, Graphics g) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;

        int x1 = ((Rectangle)arr[i]).getX();
        int x2 = ((Rectangle)arr[j]).getX();
        ((Rectangle)arr[i]).setX(x2);
        ((Rectangle)arr[j]).setX(x1);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Width, Height);
        g.setColor(Color.WHITE);
        for(Rectangle rect: rects) rect.draw(g);

        try {
            TimeUnit.MILLISECONDS.sleep(75);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

        /*g.setColor(Color.BLACK);
        g.fillRect(x1, 0, 1, Height);
        g.fillRect(x2, 0, 1, Height);

        g.setColor(Color.WHITE);
        ((Rectangle)arr[i]).draw(g);
        ((Rectangle)arr[j]).draw(g);*/
    }

}

class Rectangle implements Comparable<Rectangle> {
    private int x, y, width, height;

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() { return x; }
    public int getHeight() { return height; }

    public void setX(int x) { this.x = x; }

    public void draw(Graphics g) {
        g.fillRect(x, y, width, height);
    }

    @Override
    public int compareTo(@NotNull Rectangle o) {
        return this.height - o.height;
    }
}

class Window extends JFrame {
    public Window(int Width, int Height, String name, Canvas canvas) {
        JFrame frame = new JFrame(name);
        frame.setResizable(false);
        frame.setMaximumSize(new Dimension(Width, Height));
        frame.setMinimumSize(new Dimension(Width, Height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(canvas);
        frame.setVisible(true);
    }
}
