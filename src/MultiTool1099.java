import javax.swing.*;

/**
 * Created by Eric on 5/28/2016.
 */
public class MultiTool1099 {

    public static void main (String[] args){

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

    private static void createAndShowGui(){
        JFrame frame = new JFrame("MultiTool 1099");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MultiTool1099 multiTool1099 = new MultiTool1099();
        multiTool1099.addComponentToPane(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private
}

