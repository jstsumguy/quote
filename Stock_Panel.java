package stock_quote;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Stock_Panel extends JPanel {

    JButton quotebtn;
    JTextField tickerfield;
    JLabel verbose, high, low, current, ticker;

    public Stock_Panel() {
        // Init widgets
        tickerfield = new JTextField("         ");
        quotebtn = new JButton("Get Quote");
        verbose = new JLabel("   ");
        high = new JLabel("   ");
        low = new JLabel("   ");
        current = new JLabel("   ");
        ticker = new JLabel("   ");
        add(quotebtn);
        add(tickerfield);
        add(verbose);
        add(high);
        add(low);
        add(current);
        add(ticker);

        quotebtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                RestClient client = RestClient.getInstance();
                try {
                    client.getData(tickerfield.getText());
                    ArrayList<Stock> quotes = RestClient.quotes;
                    for (Stock stock : quotes) {
                        high.setText(Double.toString(stock.getHigh()));
                        low.setText(Double.toString(stock.getLow()));
                        current.setText(Double.toString(stock.getCurrent()));
                        ticker.setText(stock.getTicker());
                        verbose.setText(stock.getVerbose());
                    }
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Stock_Panel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Stock_Panel.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }
}
