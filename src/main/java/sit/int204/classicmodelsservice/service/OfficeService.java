package sit.int204.classicmodelsservice.service;

import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import sit.int204.classicmodelsservice.entities.Employee;
import sit.int204.classicmodelsservice.entities.Office;
import sit.int204.classicmodelsservice.exceptions.ItemNotFoundException;
import sit.int204.classicmodelsservice.model.Count;
import sit.int204.classicmodelsservice.repository.OfficeRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service


public class OfficeService {
    @Autowired
    private OfficeRepository repository;

    public List<Office> getAllOffice(String[] param) {
        if (param == null)
            return repository.findAll();
        else {
            return repository.findAllById(List.of(param));
        }
    }

    public Office getOffice(String officeCode) {
        return repository.findById(officeCode).orElseThrow(
                () -> new ItemNotFoundException("404 Office Id " + officeCode + " DOES NOT EXIST !!!") {
                });
    }

    @Transactional
    public Office createNewOffice(Office office) {
        return repository.save(office);
    }

    @Transactional
    public void removeOffice(String officeCode) {
        Office office = repository.findById(officeCode).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Office Id " + officeCode + " DOES NOT EXIST !!!"));
        repository.delete(office);
    }

    @Transactional
    public Office updateOffice(String officeCode, Office office) {
        if (office.getOfficeCode() != null && !office.getOfficeCode().trim().isEmpty()) {
            if (!office.getOfficeCode().equals(officeCode)) {
                throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Conflict Office code  !!! (" + officeCode + " vs " + office.getOfficeCode() + ") ");
            }
        }
        Office existingOffice = repository.findById(officeCode).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, " Office Id" + officeCode + " DOES NOT EXIST !!!"));
        return repository.save(office);
    }

    public Count getOfficeCount() {
        return new Count(repository.count());
    }

}