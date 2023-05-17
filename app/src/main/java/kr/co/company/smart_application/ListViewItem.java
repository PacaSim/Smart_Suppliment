package kr.co.company.smart_application;

import android.graphics.drawable.Drawable;

public class ListViewItem {
    private Drawable iconDrawable;
    private String titleStr;
    private String fnStr;
    private String intakeStr;

    public Drawable getIconDrawable() {
        return iconDrawable;
    }

    public void setIconDrawable(Drawable iconDrawable) {
        this.iconDrawable = iconDrawable;
    }

    public String getTitleStr() {
        return titleStr;
    }

    public void setTitleStr(String titleStr) {
        this.titleStr = titleStr;
    }

    public String getFnStr() {
        return fnStr;
    }

    public void setFnStr(String fnStr) {
        this.fnStr = fnStr;
    }

    public String getIntakeStr() {
        return intakeStr;
    }

    public void setIntakeStr(String intakeStr) {
        this.intakeStr = intakeStr;
    }


}
