import javax.swing.*;
import java.time.Duration;
import java.time.temporal.Temporal;

/**
 * Created by Eric on 5/29/2016.
 */
public class DurationField extends JTextField {
    private Duration totalTime;

    public DurationField() {
    }

    public DurationField(int col) {
        this.setColumns(col);
    }

    public DurationField(Duration totalTime) {
        this.totalTime = totalTime;
    }

    public void checkCalculatable(TimeField start, TimeField end) {
        if (start.getDateTime() != null && end.getDateTime() != null) {
            this.findSetTotalTime(start.getDateTime(), end.getDateTime());
        }
    }

    public String toHourlyString() {
        return this.totalTime.toHours() + " Hours, " + (this.totalTime.toMinutes() - (this.totalTime.toHours() * 60)) + "Minutes";
    }

    public void findSetTotalTime(Temporal start, Temporal end) {
        Duration timeSpan = Duration.between(start, end);
        setTotalTime(timeSpan);
    }

    public Duration getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Duration totalTime) {
        this.totalTime = totalTime;
        this.setText(this.toHourlyString());
    }
}
