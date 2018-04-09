package ck;

import java.util.HashMap;
import java.util.Map;

public class CKNumber {

    private String file;
    private String className;
    private String type;

    private int wmc;
    private int cbo;
    private int lcom;
    private int nom;

    private int loc;

    private Map<String, Integer> specific;
    private boolean error;

    public CKNumber(String file, String className, String type) {
        this.file = file;
        this.className = className;
        this.type = type;

        this.specific = new HashMap<String, Integer>();
    }

    public String getFile() {
        return file;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((file == null) ? 0 : file.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CKNumber other = (CKNumber) obj;
        if (file == null) {
            if (other.file != null)
                return false;
        } else if (!file.equals(other.file))
            return false;
        return true;
    }

    public String getClassName() {
//        String parts[] = className.split(".");
//        String nameOfClass = parts[parts.length];
        return className;
    }

    public void setWmc(int cc) {
        this.wmc = cc;
    }

    public int getWmc() {
        return wmc;
    }


    public int getCbo() {
        return cbo;
    }

    public void setCbo(int cbo) {
        this.cbo = cbo;
    }

    public void setLcom(int lcom) {
        this.lcom = lcom;
    }
    public int getLcom() {
        return lcom;
    }

    public void setNom(int nom) {
        this.nom = nom;
    }
    public int getNom() {
        return nom;
    }

    public int getLoc() {
        return loc;
    }

    public void setLoc(int loc) {
        this.loc = loc;
    }


    public boolean isError() {
        return error;
    }

    public void error() {
        this.error = true;
    }

    @Override
    public String toString() {
        return "CKNumber [file=" + file + ", className=" + className + ", type=" + type + ", " +
                "wmc=" + wmc + ", cbo=" + cbo + ", lcom=" + lcom + ", nom=" + nom + ", loc=" +
                loc + ", specific=" + specific + ", error=" + error + "]";
    }
}
