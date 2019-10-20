package phamtanphat.ptp.khoaphamtraining.apptodolist29072019.ui.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.R;
import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.model.response.WorkResponse;
import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.ui.viewmodel.WorkAdapter;
import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.ui.viewmodel.WorkViewModel;

public class activity_home extends AppCompatActivity {
    FloatingActionButton mFab;
    Intent mIntentID;
    int mIDUser;
    WorkViewModel mWorkViewModel;
    RecyclerView recyclerView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Nhận id truyền từ activity_login
        mIntentID = getIntent();
        mIDUser = mIntentID.getIntExtra("iduser", 0);

        mWorkViewModel = new WorkViewModel();
        Log.d("BBB", mIDUser + "");

        textView = findViewById(R.id.edtTenCongViec);
        recyclerView = findViewById(R.id.recyclerview);
        mFab = findViewById(R.id.fab);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_home.this, activity_addwork.class);
                intent.putExtra("iduser", mIDUser);
                startActivity(intent);
            }
        });

        mWorkViewModel
                .onValidWork(mIDUser)
                .observe(activity_home.this, new Observer<WorkResponse>() {
                    @Override
                    public void onChanged(WorkResponse workResponse) {
                        // int id = workResponse.getIduser();
                        //Log.d("BBB", "login id: "+mIDUser);
                        if (workResponse.getSuccess()) {
                            WorkAdapter workAdapter = new WorkAdapter(workResponse.getMessage());
                            recyclerView.setLayoutManager(new LinearLayoutManager(activity_home.this));
                            recyclerView.setAdapter(workAdapter);
                        } else {
                            textView.setText(workResponse.getMessage().toString());
                        }
                    }
                });


    }
}
