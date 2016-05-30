import javax.swing.*;
import java.time.LocalDateTime;

/**
 * Created by Eric on 5/29/2016.
 */
public class TimeField extends JTextField {
    private LocalDateTime dateTime;

    public TimeField() {
    }

    public TimeField(int col) {
        this.setColumns(col);
    }

    public String toHourlyString() {
        return dateTime.format(MultiTool1099.dtf1);
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        this.setText(this.toHourlyString());
    }
}
