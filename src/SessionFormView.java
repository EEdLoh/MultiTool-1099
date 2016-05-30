import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;

/**
 * Created by Eric on 5/29/2016.
 */
public class SessionFormView extends JPanel {

    public SessionFormView() {
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

        //Total Time Component setup
        JLabel totalTimeLabel = new JLabel("Session Time: ");
        DurationField totalTimeField = new DurationField(15);

        //Check-in Time Displays Setup
        JLabel checkInTimeLabel = new JLabel("Check-in Time: ");
        TimeField checkInTimeField = new TimeField(15);

        //Check-in Time Button setup
        JButton checkInButton = new JButton("Check-in");
        checkInButton.addActionListener((ActionEvent e) -> {
            checkInTimeField.setDateTime(LocalDateTime.now());
        });

        //Check-out Time Displays Setup
        JLabel checkOutTimeLabel = new JLabel("Check-out Time: ");
        TimeField checkOutTimeField = new TimeField(15);

        //Check-out time Button Setup
        JButton checkOutTimeButton = new JButton("Check-out");
        checkOutTimeButton.addActionListener((ActionEvent e) -> {
            checkOutTimeField.setDateTime(LocalDateTime.now());
            totalTimeField.checkCalculatable(checkInTimeField, checkOutTimeField);
        });

        //Calculate Time Button Setup
        JButton calcTimeButton = new JButton("Calculate");
        calcTimeButton.addActionListener((ActionEvent e) ->
                totalTimeField.checkCalculatable(checkInTimeField, checkOutTimeField));

        //Notes Component Setup
        JLabel notesLabel = new JLabel("Notes");
        JTextArea notesTextArea = new JTextArea();

        setLayout(new GridBagLayout());

        GridBagConstraints gcon = new GridBagConstraints();

        ///// First Column /////

        //Dropdown Label
        gcon.anchor = GridBagConstraints.LINE_END;
        gcon.weightx = 1;
        gcon.weighty = 1;
        gcon.gridx = 0;
        gcon.gridy = 0;
        add(clientSelectionLabel, gcon);

        //Check-in Label
        gcon.gridx = 0;
        gcon.gridy = 1;
        add(checkInTimeLabel, gcon);

        //Check-out Label
        gcon.gridx = 0;
        gcon.gridy = 2;
        add(checkOutTimeLabel, gcon);

        //Total Time Label
        gcon.gridx = 0;
        gcon.gridy = 3;
        add(totalTimeLabel, gcon);

        ///// Second Column /////

        //Check-in Field
        gcon.fill = GridBagConstraints.HORIZONTAL;
        gcon.anchor = GridBagConstraints.LINE_START;
        gcon.weightx = 3;
        gcon.gridx = 1;
        gcon.gridy = 1;
        add(checkInTimeField, gcon);

        //Check-out Fiend
        gcon.gridx = 1;
        gcon.gridy = 2;
        add(checkOutTimeField, gcon);

        //Total Time Field
        gcon.gridx = 1;
        gcon.gridy = 3;
        add(totalTimeField, gcon);

        ///// Third Column /////

        //Check-in Button
        gcon.weightx = 2;
        gcon.gridx = 2;
        gcon.gridy = 1;
        add(checkInButton, gcon);

        //Check-out Button
        gcon.gridx = 2;
        gcon.gridy = 2;
        add(checkOutTimeButton, gcon);

        //Caclulate button
        gcon.gridx = 2;
        gcon.gridy = 3;
        add(calcTimeButton, gcon);

        //Dropdown
        gcon.gridwidth = 2;
        gcon.gridx = 1;
        gcon.gridy = 0;
        add(clientSelectionDropdown, gcon);

        ///// Notes Bits /////

        //Notes Label
        gcon.anchor = GridBagConstraints.LAST_LINE_START;
        gcon.gridx = 0;
        gcon.gridy = 4;
        add(notesLabel, gcon);

        //Notes Area
        gcon.fill = GridBagConstraints.BOTH;
        gcon.gridx = 0;
        gcon.gridy = 5;
        gcon.gridwidth = 3;
        gcon.weighty = 5;
        add(notesTextArea, gcon);
    }

}
