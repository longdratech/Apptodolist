package phamtanphat.ptp.khoaphamtraining.apptodolist29072019.api.retrofit;

import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.api.response.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiRequest {

    // ctrl + alt + o
    @FormUrlEncoded
    @POST("login.php")
    Call<LoginResponse> onLoginResult(
                                    @Field("username") String username,
                                    @Field("password") String password);

}
