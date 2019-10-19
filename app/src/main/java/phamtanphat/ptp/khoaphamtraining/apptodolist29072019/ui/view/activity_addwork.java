package phamtanphat.ptp.khoaphamtraining.apptodolist29072019.ui.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.R;

public class activity_addwork extends AppCompatActivity {
    TextInputEditText edtThoiGian;
    private static final int REQUEST_CODE_EXAMPLE = 0x9345;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addwork);

        edtThoiGian = findViewById(R.id.edtThoiGian);
        edtThoiGian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_addwork.this,activity_calendar.class);
                startActivityForResult(intent,REQUEST_CODE_EXAMPLE);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_EXAMPLE){
            if(resultCode == Activity.RESULT_OK){
                String resultDateTime = data.getStringExtra(activity_calendar.EXTRA_DATA);
                edtThoiGian.setText(resultDateTime);
            }
        }

    }
}
