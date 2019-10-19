package phamtanphat.ptp.khoaphamtraining.apptodolist29072019.respository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.api.response.LoginResponse;
import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.api.retrofit.ApiRequest;
import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.api.retrofit.RetrofitInit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepository {

    private static LoginRepository repository = null;
    private ApiRequest apiRequest;

    private LoginRepository() {
        apiRequest = RetrofitInit.initApi();
    }

    //
    public static LoginRepository getInstance() {
        if (repository == null) {
            repository = new LoginRepository();
        }
        return repository;
    }


    public MutableLiveData<LoginResponse> checkLogin(String username, String password) {
        final MutableLiveData<LoginResponse> loginResponse = new MutableLiveData<>();
        apiRequest.onLoginResult(username, password).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                loginResponse.postValue(response.body());
                Log.d("BBB", "Thành công");
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.d("BBB", t.getMessage());
            }
        });
        return loginResponse;
    }
}
