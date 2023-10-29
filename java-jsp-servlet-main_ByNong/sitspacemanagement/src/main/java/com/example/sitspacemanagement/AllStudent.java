package com.example.sitspacemanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllStudent {
    private Map<String, Student> allData;

    public AllStudent() {
        allData = new HashMap<>(20, 0.5f);
    }

    public boolean add(Student std) {
        Student stdInMap = allData.get(std.getId());
        if (stdInMap == null) {
            allData.put(std.getId(), std);
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(String id) {
        Student stdInMap = allData.get(id);
        if (stdInMap != null) {
            allData.remove(id);
            return true;
        } else {
            return false;
        }
    }

    public List<Student> getAllData() {
        return new ArrayList<>(allData.values());
    }
}
