package model;
import mapping.Mapping;
import java.util.HashMap;
import java.lang.reflect.Method;

public class ModelView {
    private String view;

    public String getview() {
        return this.view;
    }

    public void setview(String view) {
        this.view = view;
    }

    public void FindAll(String url, HashMap<String, Mapping> mapping_urls) {
        if (mapping_urls.containsKey(url)) {
            Mapping mapping = mapping_urls.get(url);
            Object invoker = mapping.getInstance();
            Method method = mapping.getMethod();
            String valeurRetour;
            try {
                valeurRetour = (String) method.invoke(invoker);
                if (valeurRetour.equals("emplist.jsp")) {
                    setview(valeurRetour);
                    dispatch();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void dispatch() {
        // Code pour dispatcher la vue
    }
}
