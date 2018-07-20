/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg4_1;

/**
 *
 * @author Мария
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import static javafx.scene.paint.Color.color;
import javax.swing.*;

public class Main {
           
    private JFrame j;
    private JPanel mainPanel;
    private JPanel contrPanel;
    private JPanel movePanel;
    private JPanel statusPanel;
    private JLabel statusLabel = new JLabel();

    private double v, h, rotation;
    float c;

    public Main() {
        prepareGUI();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.addButtons();
        main.addStatus();
    }

    public static final int CANVAS_WIDTH = 500;
    public static final int CANVAS_HEIGHT = 500;     
    public float LineBrightness = 0.2f;
    private float moveCoef = 0;
       
    private void prepareGUI() {
        j = new JFrame("Window");
        j.setSize(500, 500);
                
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

       contrPanel = new JPanel();
       contrPanel.setLayout(new BoxLayout(contrPanel, BoxLayout.X_AXIS));

        movePanel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2 = (Graphics2D) g;
                               
              setBackground(Color.WHITE);
            BasicStroke stroke = new BasicStroke(2);
                 g2.setStroke(stroke);
                                               
              
               g2.setStroke(new BasicStroke(5));
                Dimension panelSize = this.getSize();
                double x1 = (mainPanel.getSize().width / 2) - 200;
                double x2 = x1 + 400;
                double y1 = (mainPanel.getSize().height / 2) - 100;
                double y2 = y1 + 200;

                g2.rotate(rotation, x1, y1);
                
                g2.setColor(getColor());
                g2.draw(new Line2D.Double(x1 + h, y1 + v, x2 + h, y2 + v));
            }
        };

        statusPanel = new JPanel();
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));

        j.add(mainPanel);
        j.setVisible(true);

        mainPanel.add(contrPanel);
        mainPanel.add(movePanel);
        mainPanel.add(statusPanel);
    }

    private Color getColor() {
        float colorVal = 0.6f + c;
        
        if (colorVal > 1) {
            colorVal = 1;
        } else if (colorVal < 0) {
            colorVal = 0;
        }
        
        return new Color(colorVal, colorVal, colorVal);
    }
    
    private void addButtons() {

        JButton upButton = new JButton("ВЫШЕ");
        upButton.setHorizontalTextPosition(SwingConstants.CENTER);

        JButton downButton = new JButton("НИЖЕ");
        downButton.setHorizontalTextPosition(SwingConstants.CENTER);

        JButton leftButton = new JButton("ЛЕВЕЕ");
        leftButton.setHorizontalTextPosition(SwingConstants.CENTER);

        JButton rightButton = new JButton("ПРАВЕЕ");
        rightButton.setHorizontalTextPosition(SwingConstants.CENTER);

        JButton lightButton = new JButton("СВЕТЛЕЕ");
        rightButton.setHorizontalTextPosition(SwingConstants.CENTER);

        JButton darkButton = new JButton("ТЕМНЕЕ");
        rightButton.setHorizontalTextPosition(SwingConstants.CENTER);
        
    
        upButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Последняя нажатая: ВЫШЕ ");
                v -= 10;
                movePanel.revalidate();
                movePanel.repaint();
            }
        });

        downButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Последняя нажатая: НИЖЕ");
                v += 10;
                movePanel.revalidate();
                movePanel.repaint();
            }
        });

        leftButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Последняя нажатая: ЛЕВЕЕ");
                 h -= 10;
                movePanel.revalidate();
                movePanel.repaint();
            }
        });

        rightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Последняя нажатая: ПРАВЕЕ");
                h += 10;
                movePanel.revalidate();
                movePanel.repaint();
            }
        });

        lightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Последняя нажатая: СВЕТЛЕЕ");
                c += 0.05;
                movePanel.revalidate();
                movePanel.repaint();
            }
        });

        darkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Последняя нажатая: ТЕМНЕЕ");
                c -= 0.05;
                movePanel.revalidate();
                movePanel.repaint();
            }
        });
        
  
        contrPanel.add(upButton);
        contrPanel.add(downButton);
        contrPanel.add(leftButton);
        contrPanel.add(rightButton);
        contrPanel.add(lightButton);
        contrPanel.add(darkButton);
 

        j.setVisible(true);
    }

    private void addStatus() {
        statusPanel.add(statusLabel);
    }
}

