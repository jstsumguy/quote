package stock_quote;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Stock_Quote {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Stock Quoter");
        frame.setSize(660, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.WHITE);
        frame.setLayout(new GridLayout(0, 1));
        frame.add(new Stock_Panel());
        frame.setVisible(true);
    }

}
