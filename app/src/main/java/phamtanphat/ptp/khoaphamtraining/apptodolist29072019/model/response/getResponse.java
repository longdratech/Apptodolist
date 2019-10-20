package phamtanphat.ptp.khoaphamtraining.apptodolist29072019.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class getResponse {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("iduser")
    @Expose
    private int iduser;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}