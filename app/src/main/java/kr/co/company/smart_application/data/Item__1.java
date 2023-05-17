package kr.co.company.smart_application.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item__1 {
    @SerializedName("PRDLST_NM")
    @Expose
    private String prdlstNm;
    @SerializedName("PRMS_DT")
    @Expose
    private String prmsDt;
    @SerializedName("DISPOS")
    @Expose
    private String dispos;
    @SerializedName("NTK_MTHD")
    @Expose
    private String ntkMthd;
    @SerializedName("CSTDY_MTHD")
    @Expose
    private String cstdyMthd;
    @SerializedName("IFTKN_ATNT_MATR_CN")
    @Expose
    private String iftknAtntMatrCn;
    @SerializedName("PRIMARY_FNCLTY")
    @Expose
    private String primaryFnclty;
    @SerializedName("STDR_STND")
    @Expose
    private Object stdrStnd;
    @SerializedName("BSSH_NM")
    @Expose
    private String bsshNm;
    @SerializedName("GU_PRDLST_MNF_MANAGE_NO")
    @Expose
    private String guPrdlstMnfManageNo;

    public String getPrdlstNm() {
        return prdlstNm;
    }

    public void setPrdlstNm(String prdlstNm) {
        this.prdlstNm = prdlstNm;
    }

    public String getPrmsDt() {
        return prmsDt;
    }

    public void setPrmsDt(String prmsDt) {
        this.prmsDt = prmsDt;
    }

    public String getDispos() {
        return dispos;
    }

    public void setDispos(String dispos) {
        this.dispos = dispos;
    }

    public String getNtkMthd() {
        return ntkMthd;
    }

    public void setNtkMthd(String ntkMthd) {
        this.ntkMthd = ntkMthd;
    }

    public String getCstdyMthd() {
        return cstdyMthd;
    }

    public void setCstdyMthd(String cstdyMthd) {
        this.cstdyMthd = cstdyMthd;
    }

    public String getIftknAtntMatrCn() {
        return iftknAtntMatrCn;
    }

    public void setIftknAtntMatrCn(String iftknAtntMatrCn) {
        this.iftknAtntMatrCn = iftknAtntMatrCn;
    }

    public String getPrimaryFnclty() {
        return primaryFnclty;
    }

    public void setPrimaryFnclty(String primaryFnclty) {
        this.primaryFnclty = primaryFnclty;
    }

    public Object getStdrStnd() {
        return stdrStnd;
    }

    public void setStdrStnd(Object stdrStnd) {
        this.stdrStnd = stdrStnd;
    }

    public String getBsshNm() {
        return bsshNm;
    }

    public void setBsshNm(String bsshNm) {
        this.bsshNm = bsshNm;
    }

    public String getGuPrdlstMnfManageNo() {
        return guPrdlstMnfManageNo;
    }

    public void setGuPrdlstMnfManageNo(String guPrdlstMnfManageNo) {
        this.guPrdlstMnfManageNo = guPrdlstMnfManageNo;
    }
}
