import javax.swing.*;
import java.time.LocalDateTime;

/**
 * Created by Eric on 5/29/2016.
 */
public class DateTimeField extends JTextField {
    private LocalDateTime dateTime;

    public DateTimeField() {
    }

    public DateTimeField(int col) {
        this.setColumns(col);
    }

    public String toHourlyString() {
        return dateTime.format(MultiTool1099.dtf);
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        this.setText(this.toHourlyString());
    }

    public String toDateString () {
        return dateTime.format(MultiTool1099.dateFormat);
    }
}
