package phamtanphat.ptp.khoaphamtraining.apptodolist29072019.ui.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.google.android.material.textfield.TextInputEditText;

import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.R;
import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.model.response.getResponse;
import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.ui.viewmodel.AuthViewModel;


public class activity_login extends AppCompatActivity {

    AuthViewModel mMainViewModel;

    Button btnLogin, btnDangKy;
    String matKhau, ten;
    TextInputEditText edtTenDangNhap, edtMatKhau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtTenDangNhap = findViewById(R.id.edtUsername);
        edtMatKhau = findViewById(R.id.edtPass);

        mMainViewModel = new AuthViewModel();

        btnLogin = findViewById(R.id.buttonDangNhap);
        btnDangKy = findViewById(R.id.buttonDangky);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ten = edtTenDangNhap.getText().toString().trim();
                matKhau = edtMatKhau.getText().toString().trim();

                //Toast.makeText(activity_login.this, "ten: " + ten + "Pass: " + matKhau, Toast.LENGTH_SHORT).show();
                mMainViewModel
                        .onValidAuth(ten, matKhau, null)
                        .observe(activity_login.this, new Observer<getResponse>() {
                            @Override
                            public void onChanged(getResponse loginResponse) {
                                int id = loginResponse.getIduser();
                                Log.d("BBB", "login id: " + id);
                                if (loginResponse.getSuccess()) {
                                    Intent intent = new Intent(activity_login.this, activity_home.class);
                                    intent.putExtra("iduser", id);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(activity_login.this, "Tên đăng nhập hoặc mật khẩu không hợp lệ", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_login.this, acitivity_register.class);
                startActivity(intent);
            }
        });
    }
}
