import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WeatherAppGui extends JFrame {
    public WeatherAppGui(){

        // add title:
        super("Weather App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 650);
        // load a gui at the center  of screen:
        setLocationRelativeTo(null);
        setLayout(null);
        // prevent any resize
        setResizable(false);

        // now we have to add components on app
        addGuiComponents();
    }
    private void addGuiComponents(){
        // search
        JTextField searchfield = new JTextField();
        searchfield.setBounds(15,15,351, 45);

        // font and sizes
        searchfield.setFont(new Font("Dialog", Font.PLAIN,24));
        add(searchfield);
        // search button:
        JButton searchButton = new JButton(loadImage("src/assets/search.png"));

        // now i want to change the cursor to a hand when i hover it
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.setBounds(375,13,47, 45);
        add(searchButton);

        // weather image
        JLabel weatherConditionimage = new JLabel(loadImage("src/assets/cloudy.png"));
        weatherConditionimage.setBounds(0,125,450,217);
        add(weatherConditionimage);

        // temperaturre text
        JLabel temperatureText = new JLabel("10 C");
        temperatureText.setBounds(0,350,450, 54);
        temperatureText.setFont(new Font("Dialog", Font.BOLD,48));
        // center the text
        temperatureText.setHorizontalAlignment(SwingConstants.CENTER);
        add(temperatureText);

        // weather description
        JLabel weatherDesc = new JLabel("Cloudy");
        weatherDesc.setBounds(0,405,450,36);
        weatherDesc.setFont(new Font("Dialog",Font.PLAIN, 32));
        weatherDesc.setHorizontalAlignment(SwingConstants.CENTER);
        add(weatherDesc);

        //humidity image
        JLabel humidity = new JLabel(loadImage("src/assets/humidity.png"));
        humidity.setBounds(15,500,74, 66);
        add(humidity);

        // humidity text
        JLabel humidityText = new JLabel("<html><b>Humidity</b> 100%</html>");
        humidityText.setBounds(90,500,85,55);
        humidityText.setFont(new Font("Dialog",Font.PLAIN,16));
        add(humidityText);

        // windspeed image
        JLabel windSpeed = new JLabel(loadImage("src/assets/windspeed.png"));
        windSpeed.setBounds(220,500,74,66);
        add(windSpeed);
        //windspeed text
        JLabel windText = new JLabel("<html><b> Windspeed</b> 15km/h</html>");
        windText.setBounds(310,500,85, 55);
        windText.setFont(new Font("Dialog",Font.PLAIN,16));
        add(windText);

    }
    private ImageIcon loadImage(String path){
        try{
            // read the image file from path
            BufferedImage image = ImageIO.read(new File(path));
            // returns a image icon
            return new ImageIcon(image);
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Could not find a path..");
        return null;
    }

}
