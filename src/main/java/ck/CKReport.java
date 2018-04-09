package ck;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CKReport {

    private Map<String, CKNumber> results;

    public CKReport() {
        this.results = new HashMap<String, CKNumber>();
    }

    public void add(CKNumber ck) {
        results.put(ck.getFile(), ck);
    }

    public Collection<CKNumber> all() {
        return results.values();
    }
}
