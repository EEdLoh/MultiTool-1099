import javax.swing.*;
import java.awt.*;

/**
 * Created by Eric on 5/28/2016.
 */
public class MultiTool1099 extends JPanel {

    public MultiTool1099 (){

    }

    private static void createAndShowGui(){
        //Sets up window
        JFrame frame = new JFrame("Multi-Tool 1099");
        //Sets ability to close the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add Components to window
        frame.add(new MultiTool1099(), BorderLayout.CENTER);

        //Displays Window
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}