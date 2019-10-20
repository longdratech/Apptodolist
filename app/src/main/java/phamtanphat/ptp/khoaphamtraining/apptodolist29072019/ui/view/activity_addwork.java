package phamtanphat.ptp.khoaphamtraining.apptodolist29072019.ui.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.R;
import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.model.response.getResponse;
import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.ui.viewmodel.AddWorkViewModel;

public class activity_addwork extends AppCompatActivity {
    TextInputEditText edtTenCongViec, edtThoiGian;
    Button btnLuu;
    String mTenCongViec, mThoiGian;
    AddWorkViewModel mAddWorkViewModel;
    Intent mIntentUser;
    int mIDUser;

    private static final int REQUEST_CODE_EXAMPLE = 0x9345;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addwork);

        edtTenCongViec = findViewById(R.id.edtTenCongViec);
        edtThoiGian = findViewById(R.id.edtThoiGian);
        btnLuu = findViewById(R.id.btnLuu);

        //Nhận id từ activity_home
        mIntentUser =getIntent();
        mIDUser = mIntentUser.getIntExtra("iduser", 0);

        edtThoiGian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_addwork.this, activity_calendar.class);
                startActivityForResult(intent, REQUEST_CODE_EXAMPLE);

            }
        });

        mAddWorkViewModel = new AddWorkViewModel();

        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTenCongViec = Objects.requireNonNull(edtTenCongViec.getText()).toString().trim();
                mThoiGian = Objects.requireNonNull(edtThoiGian.getText()).toString().trim();

                mAddWorkViewModel
                        .onValidAddWork(mTenCongViec, mThoiGian,mIDUser)
                        .observe(activity_addwork.this, new Observer<getResponse>() {
                            @Override
                            public void onChanged(getResponse authResponse) {
                                if (authResponse.getSuccess()) {
                                    Toast.makeText(activity_addwork.this, "Thêm công việc mới thành công", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(activity_addwork.this, "Thêm công việc mới thất bại", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_EXAMPLE) {
            if (resultCode == Activity.RESULT_OK) {
                assert data != null;
                String resultDateTime = data.getStringExtra(activity_calendar.EXTRA_DATA);
                edtThoiGian.setText(resultDateTime);
            }
        }

    }
}
