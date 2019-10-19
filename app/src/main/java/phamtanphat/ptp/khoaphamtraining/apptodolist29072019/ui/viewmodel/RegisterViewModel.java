package phamtanphat.ptp.khoaphamtraining.apptodolist29072019.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.api.response.RegisterResponse;
import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.respository.RegisterRepository;

public class RegisterViewModel extends ViewModel {
        private RegisterRepository repository = RegisterRepository.getInstance();

        public MutableLiveData<RegisterResponse> onValidRgister(String username, String password){
            return repository.checkRegister(username,password);
        }
}
