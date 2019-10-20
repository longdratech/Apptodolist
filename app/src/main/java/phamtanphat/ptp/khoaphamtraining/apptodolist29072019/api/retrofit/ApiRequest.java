package phamtanphat.ptp.khoaphamtraining.apptodolist29072019.api.retrofit;

import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.model.response.WorkResponse;
import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.model.response.getResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiRequest {

    @FormUrlEncoded
    @POST("login.php")
    Call<getResponse> onLoginResult(
                                    @Field("user") String username,
                                    @Field("password") String password);
    @FormUrlEncoded
    @POST("register.php")
    Call<getResponse> onRegisterResult(
                                    @Field("user") String username,
                                    @Field("password") String password);
    @FormUrlEncoded
    @POST("newwork.php")
    Call<getResponse> onNewWorkResult(
                                    @Field("tencongviec") String tencongviec,
                                    @Field("thoigian") String thoigian,
                                    @Field("iduser") int iduser);
    @FormUrlEncoded
    @POST("work.php")
    Call<WorkResponse> onWorkResult(
                                    @Field("iduser") int iduser);
}
