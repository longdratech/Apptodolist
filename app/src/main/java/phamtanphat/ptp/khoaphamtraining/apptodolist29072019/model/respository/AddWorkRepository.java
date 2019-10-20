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

public class AddWorkRepository {
    private static AddWorkRepository repository = null;
    private ApiRequest apiRequest;

    private AddWorkRepository() {
        apiRequest = RetrofitInit.initApi();
    }

    //
    public static AddWorkRepository getInstance() {
        if (repository == null) {
            repository = new AddWorkRepository();
        }
        return repository;
    }

    public MutableLiveData<getResponse> checkNewWork(String tencongviec, String thoigian, int iduser) {
        final MutableLiveData<getResponse> addResponse = new MutableLiveData<>();

        //noinspection NullableProblems
        apiRequest.onNewWorkResult(tencongviec, thoigian, iduser).enqueue(new Callback<getResponse>() {
            @Override
            public void onResponse(Call<getResponse> call, Response<getResponse> response) {
                addResponse.postValue(response.body());
                Log.d("BBB", "Thêm công việc mới thành công");
            }

            @Override
            public void onFailure(Call<getResponse> call, Throwable t) {
                Log.d("BBB", Objects.requireNonNull(t.getMessage()));
            }
        });

        return addResponse;
    }
}
