package sit.int204.classicmodelsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sit.int204.classicmodelsservice.FileStorageProperties;
import sit.int204.classicmodelsservice.service.FileService;

@RestController
@RequestMapping("/files")
public class FileController {

//    @Autowired
//    FileStorageProperties fileStorageProperties;

    @Autowired
    FileService fileService;


    @GetMapping("/test")
    public ResponseEntity<Object> testPropertiesMapping() {
//        return ResponseEntity.ok("Upload Floader (Directory) is \"" + fileStorageProperties.getUploadDir() + "\"");
        return  ResponseEntity.ok(fileService.getFindStorageLoacation()+ "has been created !!!");
    }

    @PostMapping("")
    public  ResponseEntity<Object> fileUpload(@RequestParam("file")MultipartFile file){
        fileService.store(file);
        return  ResponseEntity.ok("You seccessfully uploaded" + file.getOriginalFilename());
    }

    @GetMapping("/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename){
        Resource file = fileService.loadFileAsResource(filename);
        String fileName = file.getFilename();
        String extension = fileName.substring(fileName.length()-3);
        if(extension.equalsIgnoreCase("pdf"))
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(file);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(file);
    }

    @DeleteMapping("/{filename:.+}")
    public ResponseEntity<String> removeFile(@PathVariable String filename){
        fileService.removeFile(filename);
       return ResponseEntity.ok(filename + " has been reomved !!!");
    }

    @GetMapping
    public  ResponseEntity<Object> getAllFile(){
        return ResponseEntity.ok(fileService.getAllFile());
    }
}
