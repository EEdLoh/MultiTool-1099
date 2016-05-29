import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;

/**
 * Created by Eric on 5/29/2016.
 */
public class SessionFormView extends JPanel {

    public SessionFormView () {
        //Sets up size of the panel
        Dimension size = getPreferredSize();
        setPreferredSize(size);

        //Sets a border around the panel and gives it a title
        setBorder(BorderFactory.createTitledBorder("Single Session Details"));

        //Client selection dropdown component setup
        JLabel clientSelectionLabel = new JLabel("Client: ");
        //String here for testing
        //To be replaced by a function that finds and builds a keyed list from the db
        String[] clientList = {"Example", "Jimmy", "Sam", "Hal", "Malinda"};
        JComboBox clientSelectionDropdown = new JComboBox(clientList);
        clientSelectionDropdown.setSelectedIndex(-1);

        //Check-in Time Displays Setup
        JLabel checkInTimeLabel = new JLabel("Check-in Time: ");
        TimeField checkInTimeField = new TimeField();
        checkInTimeField.setEditable(false);

        //Check-in Time Button setup
        JButton checkInButton = new JButton("Check-in");
        checkInButton.addActionListener((ActionEvent e) -> {
            checkInTimeField.setDateTime(LocalDateTime.now());
            checkInTimeField.setText(checkInTimeField.toHourlyString());
        });

        //Check-out Time Displays Setup
        JLabel checkOutTimeLabel = new JLabel("Check-out Time: ");
        TimeField checkOutTimeField = new TimeField();
        checkOutTimeField.setEditable(false);

        //Check-out time Button Setup
        JButton checkOutTimeButton = new JButton("Check-out");
        checkOutTimeButton.addActionListener((ActionEvent e) -> {
            checkOutTimeField.setDateTime(LocalDateTime.now());
            checkOutTimeField.setText(checkOutTimeField.toHourlyString());
        });
    }

}
