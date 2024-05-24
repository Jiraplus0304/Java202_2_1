package sit.int204.classicmodelsservice.service;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import sit.int204.classicmodelsservice.FileStorageProperties;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Getter
public class FileService {
    private final Path findStorageLoacation;

    @Autowired
    public FileService(FileStorageProperties fileStorageProperties) {
        this.findStorageLoacation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();
        try {
            if (!Files.exists(this.findStorageLoacation)) {
                Files.createDirectories(this.findStorageLoacation);
            }
        } catch (IOException ex) {
            throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public String store(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains("..")) {
                throw new RuntimeException("Sorry! Filename contains invalid path sequence" + fileName);
            }
            Path targetLocation = this.findStorageLoacation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException ex) {
            throw new RuntimeException("Could not store file " + fileName + ".Please try again", ex);
        }
    }

    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.findStorageLoacation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new RuntimeException("File not found" + fileName);
            }


        } catch (MalformedURLException e) {
            throw new RuntimeException("File operation error" + fileName, e);
        }
    }

    public void removeFile(String filename) {
        try {
            Path filePath = this.findStorageLoacation.resolve(filename).normalize();
            if (Files.exists(filePath)) {
                Files.delete(filePath);
            } else {
                throw new RuntimeException("File not found " + filename);
            }
        } catch (IOException e) {
            throw new RuntimeException("File operlation error: " + filename, e);
        }
    }

    public List<String> getAllFile() {
        try (Stream<Path> stream = Files.list(findStorageLoacation)) {
            return stream.filter(file -> !Files.isDirectory(file))
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toList());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
