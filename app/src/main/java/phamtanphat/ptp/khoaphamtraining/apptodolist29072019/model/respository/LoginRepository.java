package phamtanphat.ptp.khoaphamtraining.apptodolist29072019.model.respository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.Objects;

import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.model.response.getResponse;
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


    public MutableLiveData<getResponse> checkLogin(String username, String password) {
        final MutableLiveData<getResponse> loginResponse = new MutableLiveData<>();
        //noinspection NullableProblems
        apiRequest.onLoginResult(username, password).enqueue(new Callback<getResponse>() {
            @Override
            public void onResponse(Call<getResponse> call, Response<getResponse> response) {
                loginResponse.postValue(response.body());
                Log.d("BBB", "Thành công");
            }

            @Override
            public void onFailure(Call<getResponse> call, Throwable t) {
                Log.d("BBB", Objects.requireNonNull(t.getMessage()));
            }
        });
        return loginResponse;
    }
}
