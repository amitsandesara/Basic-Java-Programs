import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeFormat {
      public static void main(String args[]) {
            DateFormat df = new SimpleDateFormat("MMM dd, yyyy, HH:mm:ss");
            String date = df.format(Calendar.getInstance().getTime());
            System.out.println(date);

            try {
                  Date tempDate = df.parse(date);
                  SimpleDateFormat outputDateFormat = new SimpleDateFormat("MMM dd, yyyy");
                  SimpleDateFormat outputTimeFormat = new SimpleDateFormat("hh:mm");
                  System.out.println("Output date is = " + outputDateFormat.format(tempDate));
                  System.out.println("Output time is = " + outputTimeFormat.format(tempDate));
            } catch (ParseException ex) {
                  System.out.println("Parse Exception");
            }
      }
}
