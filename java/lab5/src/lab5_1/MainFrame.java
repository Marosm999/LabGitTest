/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab5_1;

import lab5_1.Human;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Maria
 */

public class MainFrame extends JFrame {
    public MainFrame(ArrayList<Human> db) {
        super("DS&A. Assignment");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        MainPanel testPanel = new MainPanel(db);
        getContentPane().add(testPanel);
        setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 3 + 150, Toolkit.getDefaultToolkit().getScreenSize().height / 3);
        setSize (500, 600);
        setVisible(true);
    }
}