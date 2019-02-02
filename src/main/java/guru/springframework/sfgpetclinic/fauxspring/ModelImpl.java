package guru.springframework.sfgpetclinic.fauxspring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModelImpl implements Model {

    private Map<String, Object> modelMaps = new HashMap<>();
    private List<Object> modelsList = new ArrayList<>();

    @Override
    public void addAttribute(String key, Object o) {
        this.modelMaps.put(key, o);
    }

    @Override
    public void addAttribute(Object o) {
        this.modelsList.add(o);
    }

    public Map<String, Object> getModelMaps() {
        return modelMaps;
    }

    public void setModelMaps(Map<String, Object> modelMaps) {
        this.modelMaps = modelMaps;
    }

    public List<Object> getModelsList() {
        return modelsList;
    }

    public void setModelsList(List<Object> modelsList) {
        this.modelsList = modelsList;
    }
}
