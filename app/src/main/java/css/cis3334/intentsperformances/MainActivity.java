package css.cis3334.intentsperformances;

import android.content.Intent;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    Button btn1Web, but1Calendar, btn1Map;
    Button btn2Web, but2Calendar, btn2Map;
    Button btn3Web, but3Calendar, btn3Map;
    TextView textViewStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewStatus = (TextView) findViewById(R.id.textViewStatus);
        setupButtonClickEvents();



    }


    private void setupButtonClickEvents() {
        /**
         *   Set up button click event listener for the web info button for the first performance
         */
        btn1Web = (Button) findViewById(R.id.button1WebInfo);
        btn1Web.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                textViewStatus.setText("Code should display website for performance 1");
            }
        });

        /**
         *   Set up button click event listener for the celendar button for the first performance
         *       Use the calendar intent to set an event reminder on the calendar
         */
        but1Calendar = (Button) findViewById(R.id.button1Calendar);
        but1Calendar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                addCalendarEvent(1, "Twin Ports Chorola Project-All Things New" ,
                        "Mitchell Auditorium", new GregorianCalendar(2019,2,22,19,30),
                        new GregorianCalendar(2019,2,22,21,30));

            }
        });

        but2Calendar = (Button) findViewById(R.id.button2Calendar);
        but2Calendar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                addCalendarEvent(2, "Health, Wholeness, and Humanity: The Stewardship of Creation as if Matter Matters" ,
                        "Burns Wellness Center 249", new GregorianCalendar(2019,2,26,19,30),
                        new GregorianCalendar(2019,2,26,20,30));

            }
        });

        but3Calendar = (Button) findViewById(R.id.button3Calendar);
        but3Calendar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                addCalendarEvent(3, "The Francis X. Shea Memorial Lecture Presents Poet Jane Hirshfield" ,
                        "Mitchell Auditorium", new GregorianCalendar(2019,3,5,19,30),
                        new GregorianCalendar(2019,3,5,20,30));

            }
        });

        /**
         *   Set up button click event listener for the web info button for the first performance
         */
        btn1Map = (Button) findViewById(R.id.button1map);
        btn1Map.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                textViewStatus.setText("Code should display map for performance 1");
            }
        });


    }

    public void addCalendarEvent(int perfNum, String title, String location, GregorianCalendar beginDate, GregorianCalendar endingDate){
        textViewStatus.setText("Code should set a calendar event for performance " + perfNum);
        Intent calIntent = new Intent(Intent.ACTION_INSERT);
        calIntent.setType("vnd.android.cursor.item/event");
        calIntent.putExtra(CalendarContract.Events.TITLE, title);
        calIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, location);
        GregorianCalendar begDate = beginDate;
        GregorianCalendar endDate = endingDate;
        calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                begDate.getTimeInMillis());
        calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
                endDate.getTimeInMillis());
        startActivity(calIntent);
    }


}
