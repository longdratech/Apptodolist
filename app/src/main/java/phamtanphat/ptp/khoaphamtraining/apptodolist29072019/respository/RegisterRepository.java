package phamtanphat.ptp.khoaphamtraining.apptodolist29072019.respository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.api.response.RegisterResponse;
import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.api.retrofit.ApiRequest;
import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.api.retrofit.RetrofitInit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterRepository {
    private static RegisterRepository repository = null;
    private ApiRequest apiRequest;

    private RegisterRepository() {
        apiRequest = RetrofitInit.initApi();
    }

    //
    public static RegisterRepository getInstance() {
        if (repository == null) {
            repository = new RegisterRepository();
        }
        return repository;
    }

    public MutableLiveData<RegisterResponse> checkRegister(String username, String password) {
        final MutableLiveData<RegisterResponse> registerResponse = new MutableLiveData<>();
        apiRequest.onRegisterResult(username, password).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                registerResponse.postValue(response.body());
                Log.d("BBB",response.message());
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Log.d("BBB",t.getMessage());

            }
        });
        return registerResponse;
    }
}
