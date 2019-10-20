package phamtanphat.ptp.khoaphamtraining.apptodolist29072019.model.respository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.Objects;

import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.api.retrofit.ApiRequest;
import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.api.retrofit.RetrofitInit;
import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.model.response.WorkResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WorkRepository {
    private static WorkRepository repository = null;
    private ApiRequest apiRequest;

    private WorkRepository() {
        apiRequest = RetrofitInit.initApi();
    }

    public static WorkRepository getInstance() {
        if (repository == null) {
            repository = new WorkRepository();
        }
        return repository;
    }

    public MutableLiveData<WorkResponse> checkIDUser(int iduser){
        final  MutableLiveData<WorkResponse> workResponse = new MutableLiveData<>();

        apiRequest.onWorkResult(iduser).enqueue(new Callback<WorkResponse>() {
            @Override
            public void onResponse(Call<WorkResponse> call, Response<WorkResponse> response) {
                workResponse.postValue(response.body());
                Log.d("BBB", "Thành công");
            }

            @Override
            public void onFailure(Call<WorkResponse> call, Throwable t) {
                Log.d("BBB", Objects.requireNonNull(t.getMessage()));
            }
        });

        return  workResponse;
    }

}
