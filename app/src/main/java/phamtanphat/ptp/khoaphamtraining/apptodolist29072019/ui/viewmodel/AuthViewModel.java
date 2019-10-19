package phamtanphat.ptp.khoaphamtraining.apptodolist29072019.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.api.response.AuthResponse;
import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.respository.LoginRepository;
import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.respository.RegisterRepository;

public class AuthViewModel extends ViewModel {

    private LoginRepository loginRepository = LoginRepository.getInstance();
    private RegisterRepository registerRepository = RegisterRepository.getInstance();
    AuthResponse authResponse = new AuthResponse();

    public MutableLiveData<AuthResponse> onValidAuth(String username, String password, String rePass) {
        if (rePass == null) {
            return loginRepository.checkLogin(username, password);
        }else{
            return registerRepository.checkRegister(username, password);
        }

    }
}
