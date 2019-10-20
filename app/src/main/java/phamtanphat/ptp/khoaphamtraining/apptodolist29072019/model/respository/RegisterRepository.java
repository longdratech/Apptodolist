package phamtanphat.ptp.khoaphamtraining.apptodolist29072019.model.respository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.model.response.getResponse;
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


    public MutableLiveData<getResponse> checkRegister(String username, String password) {
        final MutableLiveData<getResponse> registerResponse = new MutableLiveData<>();
        apiRequest.onRegisterResult(username, password).enqueue(new Callback<getResponse>() {
            @Override
            public void onResponse(Call<getResponse> call, Response<getResponse> response) {
                registerResponse.postValue(response.body());
                Log.d("BBB", "Thành công");
            }

            @Override
            public void onFailure(Call<getResponse> call, Throwable t) {
                Log.d("BBB", t.getMessage());
            }
        });
        return registerResponse;
    }
}
