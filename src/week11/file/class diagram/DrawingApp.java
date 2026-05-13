import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DrawingApp extends JFrame {
    private JComboBox<String> shapeBox;
    private DrawingPanel drawingPanel;

    public DrawingApp() {
        setTitle("도형 그리기 프로그램");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        shapeBox = new JComboBox<>(new String[]{"Line", "Rectangle", "Oval", "RoundRect"});
        drawingPanel = new DrawingPanel(shapeBox);

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("도형 선택: "));
        topPanel.add(shapeBox);

        add(topPanel, BorderLayout.NORTH);
        add(drawingPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new DrawingApp().setVisible(true);
    }
}

abstract class Shape {
    protected int x1, y1, x2, y2;

    public Shape(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public abstract void draw(Graphics g);

    protected int getX() {
        return Math.min(x1, x2);
    }

    protected int getY() {
        return Math.min(y1, y2);
    }

    protected int getWidth() {
        return Math.abs(x2 - x1);
    }

    protected int getHeight() {
        return Math.abs(y2 - y1);
    }
}

class LineShape extends Shape {
    public LineShape(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
    }

    @Override
    public void draw(Graphics g) {
        g.drawLine(x1, y1, x2, y2);
    }
}

class RectShape extends Shape {
    public RectShape(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect(getX(), getY(), getWidth(), getHeight());
    }
}

class OvalShape extends Shape {
    public OvalShape(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
    }

    @Override
    public void draw(Graphics g) {
        g.drawOval(getX(), getY(), getWidth(), getHeight());
    }
}

class RoundRectShape extends Shape {
    public RoundRectShape(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
    }

    @Override
    public void draw(Graphics g) {
        g.drawRoundRect(getX(), getY(), getWidth(), getHeight(), 30, 30);
    }
}

class DrawingPanel extends JPanel {
    private ArrayList<Shape> shapes = new ArrayList<>();
    private Shape currentShape;
    private int startX, startY;
    private JComboBox<String> shapeBox;

    public DrawingPanel(JComboBox<String> shapeBox) {
        this.shapeBox = shapeBox;
        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                currentShape = createShape(startX, startY, e.getX(), e.getY());
                shapes.add(currentShape);
                currentShape = null;
                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                currentShape = createShape(startX, startY, e.getX(), e.getY());
                repaint();
            }
        });
    }

    private Shape createShape(int x1, int y1, int x2, int y2) {
        String type = (String) shapeBox.getSelectedItem();

        if ("Line".equals(type)) {
            return new LineShape(x1, y1, x2, y2);
        } else if ("Rectangle".equals(type)) {
            return new RectShape(x1, y1, x2, y2);
        } else if ("Oval".equals(type)) {
            return new OvalShape(x1, y1, x2, y2);
        } else {
            return new RoundRectShape(x1, y1, x2, y2);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Shape shape : shapes) {
            shape.draw(g);
        }

        if (currentShape != null) {
            currentShape.draw(g);
        }
    }
}