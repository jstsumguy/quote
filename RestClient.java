package stock_quote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

/*
Singleton class that sends requests to yahoo finance api
*/
public class RestClient {
    private static RestClient instance;
    public static ArrayList<Stock> quotes;
    
    protected RestClient()
    {}
    
    public static RestClient getInstance()
    {
        if(instance == null)
        {
            return instance = new RestClient();
        }
        return instance;
    }
    
    public void getData(String ticker) throws UnsupportedEncodingException, MalformedURLException, IOException
    {
        String url = "http://download.finance.yahoo.com/d/quotes.csv?";
        String charset = "UTF-8";  
        String param = ticker.toLowerCase();
        String line;
        
        String query = String.format("s=%s&f=nl1jkr&e=.csv", URLEncoder.encode(param, charset));         
        HttpURLConnection connection = (HttpURLConnection) new URL(url + query).openConnection();
        connection.setRequestProperty("Accept-Charset", charset);
        InputStream response = connection.getInputStream();
        
        if(connection.getResponseCode() == 200)
        {
            if(RestClient.quotes != null)
            {
                RestClient.quotes.clear();
            }
            else
            {
                RestClient.quotes = new ArrayList<>();
            }
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(response));
            while ((line = reader.readLine()) != null) {
                String[] vals = line.split(",");
                Stock stock = new Stock(Double.parseDouble(vals[3]), 
                Double.parseDouble(vals[2]), Double.parseDouble(vals[1]), ticker, vals[0]);
                RestClient.quotes.add(stock);
            }
        }
    }
    
}
