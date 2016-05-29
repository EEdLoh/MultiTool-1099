import javax.swing.*;
import java.time.LocalDateTime;

/**
 * Created by Eric on 5/29/2016.
 */
public class TimeField extends JTextField {
    LocalDateTime dateTime;

    public TimeField (){

    }

    public TimeField (LocalDateTime dateTime){
        this.dateTime = dateTime;
    }

    public String toHourlyString() {
        return dateTime.getHour() + ":" + dateTime.getMinute();
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
