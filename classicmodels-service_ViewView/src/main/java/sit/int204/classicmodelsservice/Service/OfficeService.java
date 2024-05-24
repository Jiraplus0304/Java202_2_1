package sit.int204.classicmodelsservice.Service;

import jakarta.transaction.Transactional;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import sit.int204.classicmodelsservice.Entities.Office;
import sit.int204.classicmodelsservice.Repositories.OfficeRepository;
import sit.int204.classicmodelsservice.dtos.NewOfficeDto;
import sit.int204.classicmodelsservice.exception.ItemNotFoundException;

import java.util.List;

@Service

public class OfficeService {
    @Autowired
    private OfficeRepository repository;

    @Autowired
    ModelMapper mapper;
    @Autowired
    ListMapper listMapper;

    public List<Office> getAllOffice() {
        return repository.findAll();
    }

    public List<NewOfficeDto> getAllOffice2() {
        return listMapper.mapList(repository.findAll(), NewOfficeDto.class,mapper);
    }

    public Office getOffice(String officeCode) {
        return repository.findById(officeCode).orElseThrow(
                () -> new HttpClientErrorException(HttpStatus.NOT_FOUND,
                        "Office Id " + officeCode + " DOES NOT EXIST !!!") {
                }
        );
    }

    @Transactional
    public Office createNewOffice(Office office) {
        return repository.save(office);
    }
    @Transactional
    public void removeOffice(String officeCode) {
        Office office = repository.findById(officeCode).orElseThrow(
                () -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Office Id " + officeCode + " DOES NOT EXIST !!!")
        );
        repository.delete(office);
    }

    @Transactional
    public Office updateOffice(String officeCode, Office office) {
        if(office.getOfficeCode()!=null && !office.getOfficeCode().trim().isEmpty()) {
            if (!office.getOfficeCode().equals(officeCode)) {
                throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                        "Conflict Office code  !!! (" + officeCode +
                                " vs " + office.getOfficeCode() + ")");
            }
        }
        Office existingOffice = repository.findById(officeCode).orElseThrow(
                () -> new HttpClientErrorException(HttpStatus.NOT_FOUND,
                        "Office Id " + officeCode + " DOES NOT EXIST !!!"));
        return repository.save(office);
    }
}
