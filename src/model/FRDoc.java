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
    
    private void addToEntireDoc(String value) {
    	this.entireDoc = entireDoc + "\n\n" + value;
    	this.entireDoc.trim();
    }

    public void setDocNo(String value) {
        this.docNo = value;
        addToEntireDoc(value);
    }

    public void setParent(String value) {
        this.parent = value;
        addToEntireDoc(value);
    }

    public void setText(String value) {
        this.text = value;
        addToEntireDoc(value);
    }

    public void setUSDept(String value) {
        this.usdept = value;
        addToEntireDoc(value);
    }

    public void setUSBureau(String value) {
        this.usbureau = value;
        addToEntireDoc(value);
    }

    public void setCfrno(String value) {
        this.cfrno = value;
        addToEntireDoc(value);
    }

    public void setRindock(String value) {
        this.rindock = value;
        addToEntireDoc(value);
    }

    public void setAgency(String value) {
        this.agency = value;
        addToEntireDoc(value);
    }

    public void setAction(String value) {
        this.action = value;
        addToEntireDoc(value);
    }

    public void setSummary(String value) {
        this.summary = value;
        addToEntireDoc(value);
    }

    public void setDate(String value) {
        this.date = value;
        addToEntireDoc(value);
    }

    public void setFurther(String value) {
        this.further = value;
        addToEntireDoc(value);
    }

    public void setSupplem(String value) {
        this.supplem = value;
        addToEntireDoc(value);
    }

    public void setSigner(String value) {
        this.signer = value;
        addToEntireDoc(value);
    }

    public void setSignjob(String value) {
        this.signjob = value;
        addToEntireDoc(value);
    }

    public void setFrfiling(String value) {
        this.frfiling = value;
        addToEntireDoc(value);
    }

    public void setBilling(String value) {
        this.billing = value;
        addToEntireDoc(value);
    }

    public void setFootcite(String value) {
        this.footcite = value;
        addToEntireDoc(value);
    }

    public void setFootnote(String value) {
        this.footnote = value;
        addToEntireDoc(value);
    }

    public void setFootname(String value) {
        this.footname = value;
        addToEntireDoc(value);
    }

    public void setTable(String value) {
        this.table = value;
        addToEntireDoc(value);
    }

    public void setImport(String value) {
        this.theImport = value;
        addToEntireDoc(value);
    }

    public void setAddress(String value) {
        this.address = value;
        addToEntireDoc(value);
    }

    public void setDocTitle(String value) {
        this.docTitle = value;
        addToEntireDoc(value);
    }
}
