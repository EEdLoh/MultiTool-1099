import com.inet.jortho.FileUserDictionary;
import com.inet.jortho.SpellChecker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;


/* Looks good on a 400 x 300 panel.
 Sizes may have to be adjusted when it's put in to the
      Split Panes view.
  */

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

        //Activities Setup
        JLabel activitiesLabel = new JLabel("Activity");
        //String here for testing
        //To be replaced by a function that finds and builds a keyed list from the db
        String[] activityList = {"Recreation", "Aquatic"};
        JComboBox activitySelectionDropdown = new JComboBox(activityList);
        activitySelectionDropdown.setSelectedIndex(-1);

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
        notesTextArea.setLineWrap(true);
        notesTextArea.setWrapStyleWord(true);

        JScrollPane notesScrollPane = new JScrollPane(notesTextArea);

        String userDictPath = "/Dictionaries/";
        SpellChecker.setUserDictionaryProvider(new FileUserDictionary(userDictPath));
        SpellChecker.registerDictionaries(getClass().getResource(userDictPath), "en");

        SpellChecker.register(notesTextArea);

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

        gcon.gridx = 0;
        gcon.gridy = 1;
        add(activitiesLabel, gcon);

        //Check-in Label
        gcon.gridx = 0;
        gcon.gridy = 2;
        add(checkInTimeLabel, gcon);

        //Check-out Label
        gcon.gridx = 0;
        gcon.gridy = 3;
        add(checkOutTimeLabel, gcon);

        //Total Time Label
        gcon.gridx = 0;
        gcon.gridy = 4;
        add(totalTimeLabel, gcon);

        ///// Second Column /////

        //Check-in Field
        gcon.fill = GridBagConstraints.HORIZONTAL;
        gcon.anchor = GridBagConstraints.LINE_START;
        gcon.weightx = 3;
        gcon.gridx = 1;
        gcon.gridy = 2;
        add(checkInTimeField, gcon);

        //Check-out Fiend
        gcon.gridx = 1;
        gcon.gridy = 3;
        add(checkOutTimeField, gcon);

        //Total Time Field
        gcon.gridx = 1;
        gcon.gridy = 4;
        add(totalTimeField, gcon);

        ///// Third Column /////

        //Check-in Button
        gcon.weightx = 2;
        gcon.gridx = 2;
        gcon.gridy = 2;
        add(checkInButton, gcon);

        //Check-out Button
        gcon.gridx = 2;
        gcon.gridy = 3;
        add(checkOutTimeButton, gcon);

        //Caclulate button
        gcon.gridx = 2;
        gcon.gridy = 4;
        add(calcTimeButton, gcon);

        ///// Dropdowns /////

        //Client Dropdown
        gcon.gridwidth = 2;
        gcon.gridx = 1;
        gcon.gridy = 0;
        add(clientSelectionDropdown, gcon);

        //Activity Dropdown
        gcon.gridx = 1;
        gcon.gridy = 1;
        add(activitySelectionDropdown, gcon);

        ///// Notes Bits /////

        //Notes Label
        gcon.anchor = GridBagConstraints.LAST_LINE_START;
        gcon.gridx = 0;
        gcon.gridy = 5;
        add(notesLabel, gcon);

        //Notes Area
        gcon.fill = GridBagConstraints.BOTH;
        gcon.gridx = 0;
        gcon.gridy = 6;
        gcon.gridwidth = 3;
        gcon.weighty = 5;
        add(notesScrollPane, gcon);
    }

}
