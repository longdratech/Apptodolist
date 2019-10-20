package phamtanphat.ptp.khoaphamtraining.apptodolist29072019.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.model.response.WorkResponse;
import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.model.respository.WorkRepository;

public class WorkViewModel extends ViewModel {

    private WorkRepository workRepository = WorkRepository.getInstance();

    public MutableLiveData<WorkResponse> onValidWork(int iduser){
        return workRepository.checkIDUser(iduser);
    }
}
