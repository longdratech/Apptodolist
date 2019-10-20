package phamtanphat.ptp.khoaphamtraining.apptodolist29072019.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.model.response.getResponse;
import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.model.respository.AddWorkRepository;

public class AddWorkViewModel extends ViewModel {
    private AddWorkRepository addWorkRepository = AddWorkRepository.getInstance();

    public MutableLiveData<getResponse> onValidAddWork(String tencongviec, String thoigian, int iduser){
        return addWorkRepository.checkNewWork(tencongviec,thoigian, iduser);
    }

}
