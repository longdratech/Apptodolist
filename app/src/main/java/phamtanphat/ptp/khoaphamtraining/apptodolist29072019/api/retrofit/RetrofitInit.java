package phamtanphat.ptp.khoaphamtraining.apptodolist29072019.api.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInit {
    // 1 : Khởi tạo ra retrofit
    // 2 : Khởi tạo ra lớp interface request
    // 3 : Trả về kiểu dữ liệu chính lớp interface request
    // 4 : Không cho người khác có quyền khởi tạo ra lớp này

    private static Retrofit retrofit = null;

    private RetrofitInit() {

    }

    // ngươi dùng gọi phương thức này sẽ khởi tạo 2 thằng trên và trả về
    // interface request
    public static ApiRequest initApi() {
        if (retrofit == null) {
            retrofit = getInstance();
        }
        return retrofit.create(ApiRequest.class);
    }

    private static Retrofit getInstance() {

        // escaping character : `i\'am`
        Gson gson = new GsonBuilder()
                .setLenient()
                .disableHtmlEscaping()
                .create();

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .protocols(Arrays.asList(Protocol.HTTP_1_1))
                .build();
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("http://192.168.1.10/hihi/")
                .build();
        return retrofit;
    }

}
