import javax.swing.*;

public class AppLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // display out app
                new WeatherAppGui().setVisible(true);
                System.out.println("");
                System.out.println("hahahah");
            }
        });
    }
}
