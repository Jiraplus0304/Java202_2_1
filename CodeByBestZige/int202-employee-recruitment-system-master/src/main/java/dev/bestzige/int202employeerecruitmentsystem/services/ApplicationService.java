package dev.bestzige.int202employeerecruitmentsystem.services;

import dev.bestzige.int202employeerecruitmentsystem.models.Application;
import dev.bestzige.int202employeerecruitmentsystem.utils.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class ApplicationService {
    private List<Application> applications = new ArrayList<>();

    public void loadData() {
        applications = FileUtil.loadDataApplications();
    }

    public void saveData() {
        FileUtil.saveDataApplications(applications);
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void addApplication(Application application) {
        applications.add(application);
    }

    public void removeApplication(int id) {
        applications.removeIf(application -> application.getId() == id);
    }
}
