package phamtanphat.ptp.khoaphamtraining.apptodolist29072019.ui.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.R;

public class activity_calendar extends AppCompatActivity {

    MaterialCalendarView mMaterialCalendarView;
    public static final String EXTRA_DATA = "EXTRA_DATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        mMaterialCalendarView = findViewById(R.id.calendarView);
        mMaterialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                String dateTime = date.getDay() + "/" + date.getMonth() + "/" + date.getYear();
                if (selected) {
                    Toast.makeText(activity_calendar.this, "Ngày được chọn là: " + dateTime, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(activity_calendar.this, activity_addwork.class);

                    intent.putExtra(EXTRA_DATA, dateTime);
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        setResult(Activity.RESULT_CANCELED);
        super.onBackPressed();
    }
}
