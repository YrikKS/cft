package nsu.kurgin.lab1.Registration;

public class UpdateField {
    private String msg;
    private String typeChange;

    public String getTypeChange() {
        return typeChange;
    }

    public void setTypeChange(String typeChange) {
        this.typeChange = typeChange;
    }

    public UpdateField(String fieldUpdate, String msg) {
        this.msg = msg;
        setTypeChange(fieldUpdate);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
