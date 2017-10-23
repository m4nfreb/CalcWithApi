package pl.moozo.apicalc.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostSum {
    @SerializedName("num1")
    @Expose
    private Float num1;

    @SerializedName("num2")
    @Expose
    private Float num2;

    public Float getNum1() {
        return num1;
    }

    public void setNum1(Float num1) {
        this.num1 = num1;
    }

    public Float getNum2() {
        return num2;
    }

    public void setNum2(Float num2) {
        this.num2 = num2;
    }

    @Override
    public String toString() {
        return "PostSum{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                '}';
    }
}
