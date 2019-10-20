package phamtanphat.ptp.khoaphamtraining.apptodolist29072019.ui.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.R;
import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.model.response.getResponse;
import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.ui.viewmodel.AuthViewModel;

public class acitivity_register extends AppCompatActivity {
    TextInputEditText edtTenDangNhap, edtMatKhau,edtReMatKhau;
    Button btnDangKy;
    String ten, remk, mk;
    AuthViewModel registerViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtTenDangNhap = findViewById(R.id.edtUsername);
        edtMatKhau = findViewById(R.id.edtPass);
        edtReMatKhau = findViewById(R.id.edtRePass);

        btnDangKy = findViewById(R.id.btnDangKy);

        registerViewModel = new AuthViewModel();

        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ten = edtTenDangNhap.getText().toString().trim();
                mk = edtMatKhau.getText().toString().trim();
                remk = edtReMatKhau.getText().toString().trim();

                if(!remk.equals(mk)){
                    Toast.makeText(acitivity_register.this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                }else{
                    registerViewModel
                            .onValidAuth(ten,mk,remk)
                            .observe(acitivity_register.this, new Observer<getResponse>() {
                                @Override
                                public void onChanged(getResponse registerResponse) {
                                    if(registerResponse.getSuccess()){
                                        Log.d("BBB",registerResponse.getMessage());
                                        Toast.makeText(acitivity_register.this, registerResponse.getMessage(), Toast.LENGTH_SHORT).show();
                                    }else {
                                        Log.d("BBB",registerResponse.getMessage());
                                        Toast.makeText(acitivity_register.this, registerResponse.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
    }
}
