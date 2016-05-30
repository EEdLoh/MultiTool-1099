import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;

/**
 * Created by Eric on 5/28/2016.
 */
public class MultiTool1099 extends JPanel {

    public static DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("eee',' MMM d',' yyyy 'at' HH:mm");

    public MultiTool1099() {

    }

    private static void createAndShowGui() {
        //Sets up window
        JFrame frame = new JFrame("Multi-Tool 1099");
        //Sets ability to close the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add Components to window
        frame.add(new SessionFormView(), BorderLayout.CENTER);

        //Displays Window
        frame.pack();
        frame.setSize(400, 300);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}
