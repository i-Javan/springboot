package com.efunds.pms.riskmanage.model;

public class PmsRemindConf {
    private String sRemindId;

    private String sMenuFullId;

    private String sRemindTitle;

    private String sRemark;

    private String sRemindControl;

    private String sRemindTmplSms;

    private String sRemindTmplEmail;

    private String sRemindTmplSys;

    public String getsRemindId() {
        return sRemindId;
    }

    public PmsRemindConf withsRemindId(String sRemindId) {
        this.setsRemindId(sRemindId);
        return this;
    }

    public void setsRemindId(String sRemindId) {
        this.sRemindId = sRemindId == null ? null : sRemindId.trim();
    }

    public String getsMenuFullId() {
        return sMenuFullId;
    }

    public PmsRemindConf withsMenuFullId(String sMenuFullId) {
        this.setsMenuFullId(sMenuFullId);
        return this;
    }

    public void setsMenuFullId(String sMenuFullId) {
        this.sMenuFullId = sMenuFullId == null ? null : sMenuFullId.trim();
    }

    public String getsRemindTitle() {
        return sRemindTitle;
    }

    public PmsRemindConf withsRemindTitle(String sRemindTitle) {
        this.setsRemindTitle(sRemindTitle);
        return this;
    }

    public void setsRemindTitle(String sRemindTitle) {
        this.sRemindTitle = sRemindTitle == null ? null : sRemindTitle.trim();
    }

    public String getsRemark() {
        return sRemark;
    }

    public PmsRemindConf withsRemark(String sRemark) {
        this.setsRemark(sRemark);
        return this;
    }

    public void setsRemark(String sRemark) {
        this.sRemark = sRemark == null ? null : sRemark.trim();
    }

    public String getsRemindControl() {
        return sRemindControl;
    }

    public PmsRemindConf withsRemindControl(String sRemindControl) {
        this.setsRemindControl(sRemindControl);
        return this;
    }

    public void setsRemindControl(String sRemindControl) {
        this.sRemindControl = sRemindControl == null ? null : sRemindControl.trim();
    }

    public String getsRemindTmplSms() {
        return sRemindTmplSms;
    }

    public PmsRemindConf withsRemindTmplSms(String sRemindTmplSms) {
        this.setsRemindTmplSms(sRemindTmplSms);
        return this;
    }

    public void setsRemindTmplSms(String sRemindTmplSms) {
        this.sRemindTmplSms = sRemindTmplSms == null ? null : sRemindTmplSms.trim();
    }

    public String getsRemindTmplEmail() {
        return sRemindTmplEmail;
    }

    public PmsRemindConf withsRemindTmplEmail(String sRemindTmplEmail) {
        this.setsRemindTmplEmail(sRemindTmplEmail);
        return this;
    }

    public void setsRemindTmplEmail(String sRemindTmplEmail) {
        this.sRemindTmplEmail = sRemindTmplEmail == null ? null : sRemindTmplEmail.trim();
    }

    public String getsRemindTmplSys() {
        return sRemindTmplSys;
    }

    public PmsRemindConf withsRemindTmplSys(String sRemindTmplSys) {
        this.setsRemindTmplSys(sRemindTmplSys);
        return this;
    }

    public void setsRemindTmplSys(String sRemindTmplSys) {
        this.sRemindTmplSys = sRemindTmplSys == null ? null : sRemindTmplSys.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sRemindId=").append(sRemindId);
        sb.append(", sMenuFullId=").append(sMenuFullId);
        sb.append(", sRemindTitle=").append(sRemindTitle);
        sb.append(", sRemark=").append(sRemark);
        sb.append(", sRemindControl=").append(sRemindControl);
        sb.append(", sRemindTmplSms=").append(sRemindTmplSms);
        sb.append(", sRemindTmplEmail=").append(sRemindTmplEmail);
        sb.append(", sRemindTmplSys=").append(sRemindTmplSys);
        sb.append("]");
        return sb.toString();
    }
}