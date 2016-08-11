import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;

/**
 * Created by NDutton on 7/21/2016.
 */
public class MileageFormView extends JPanel {


    public MileageFormView() {
        //Sets up size of the panel
        Dimension size = getPreferredSize();
        setPreferredSize(size);

        //Sets a border around the panel and gives it a title
        setBorder(BorderFactory.createTitledBorder("Single Trip Details"));

        //Client selection dropdown component setup
        JLabel clientSelectionLabel = new JLabel("Client: ");
        //String here for testing
        //To be replaced by a function that finds and builds a keyed list from the db
        String[] clientList = {"Example", "Jimmy", "Sam", "Hal", "Malinda"};
        JComboBox clientSelectionDropdown = new JComboBox(clientList);
        clientSelectionDropdown.setSelectedIndex(-1);

        //Date Field Setup
        JLabel dateLabel = new JLabel("Date: ");
        DateTimeField dateField = new DateTimeField();

        JButton dateButton = new JButton("Today");
        dateButton.addActionListener((ActionEvent e) -> {
            dateField.setDateTime(LocalDateTime.now());
        });

        //Mileage Setup
        JLabel mileageLabel = new JLabel("Mileage: ");
        JTextField mileageField = new JTextField();

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

        //Date Label
        gcon.gridx = 0;
        gcon.gridy = 1;
        add(dateLabel);

        //Mileage Label
        gcon.gridx = 0;
        gcon.gridy = 2;
        add(mileageLabel);

        ///// Second Column /////

        //Date Field
        gcon.fill = GridBagConstraints.HORIZONTAL;
        gcon.anchor = GridBagConstraints.LINE_START;
        gcon.weightx = 3;
        gcon.gridx = 1;
        gcon.gridy = 1;
        add(dateField, gcon);

        //Mileage Field
        gcon.gridx = 1;
        gcon.gridy = 2;
        add(mileageField, gcon);










    }

}
