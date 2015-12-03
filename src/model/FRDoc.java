package model;

/**
 * Created by thomassinclair on 29/11/15.
 */
public class FRDoc implements Doc {

    String entireDoc,
           docNo,
           parent,
           text,
           usdept,
           usbureau,
           cfrno,
           rindock,
           agency,
           action,
           summary,
           date,
           further,
           supplem,
           signer,
           signjob,
           frfiling,
           billing,
           footcite,
           footnote,
           footname,
           table,
           theImport,
           address,
           docTitle;

    public FRDoc() {

        this.entireDoc = "";

        this.docNo = "";
        this.parent = "";
        this.text = "";
        this.usdept = "";
        this.usbureau = "";
        this.cfrno = "";
        this.rindock = "";
        this.agency = "";
        this.action = "";
        this.summary = "";
        this.date = "";
        this.further = "";
        this.supplem = "";
        this.signer = "";
        this.signjob = "";
        this.frfiling = "";
        this.billing = "";
        this.footcite = "";
        this.footnote = "";
        this.footname = "";
        this.table = "";
        this.theImport = "";
        this.address = "";
        this.docTitle = "";

    }

    public String getEntireDoc() {
        return entireDoc;
    }

    public String getCategory(String category) {

        switch (category) {
            case "docno" :
                return docNo;
            case "parent" :
                return parent;
            case "text" :
                return text;
            case "usdept" :
                return usdept;
            case "usbureau" :
                return usbureau;
            case "cfrno" :
                return cfrno;
            case "rindock" :
                return rindock;
            case "agency" :
                return agency;
            case "action":
                return action;
            case "summary" :
                return summary;
            case "date" :
                return date;
            case "further" :
                return further;
            case "supplem" :
                return supplem;
            case "signer" :
                return signer;
            case "signjob" :
                return signjob;
            case "frfiling" :
                return frfiling;
            case "billing" :
                return billing;
            case "footcite" :
                return footcite;
            case "footnote" :
                return footnote;
            case "footname" :
                return footname;
            case "table" :
                return table;
            case "import":
                return theImport;
            case "address":
                return address;
            case "doctitle" :
                return docTitle;
            default:
                return "";
        }

    }

    public void setEntireDoc() {

    }

    public void setDocNo(String value) {
        this.docNo = value;
    }

    public void setParent(String value) {
        this.parent = value;
    }

    public void setText(String value) {
        this.text = value;
    }

    public void setUSDept(String value) {
        this.usdept = value;
    }

    public void setUSBureau(String value) {
        this.usbureau = value;
    }

    public void setCfrno(String value) {
        this.cfrno = value;
    }

    public void setRindock(String value) {
        this.rindock = value;
    }

    public void setAgency(String value) {
        this.agency = value;
    }

    public void setAction(String value) {
        this.action = value;
    }

    public void setSummary(String value) {
        this.summary = value;
    }

    public void setDate(String value) {
        this.date = value;
    }

    public void setFurther(String value) {
        this.further = value;
    }

    public void setSupplem(String value) {
        this.supplem = value;
    }

    public void setSigner(String value) {
        this.signer = value;
    }

    public void setSignjob(String value) {
        this.signjob = value;
    }

    public void setFrfiling(String value) {
        this.frfiling = value;
    }

    public void setBilling(String value) {
        this.billing = value;
    }

    public void setFootcite(String value) {
        this.footcite = value;
    }

    public void setFootnote(String value) {
        this.footnote = value;
    }

    public void setFootname(String value) {
        this.footname = value;
    }

    public void setTable(String value) {
        this.table = value;
    }

    public void setImport(String value) {
        this.theImport = value;
    }

    public void setAddress(String value) {
        this.address = value;
    }

    public void setDocTitle(String value) {
        this.docTitle = value;
    }
}
