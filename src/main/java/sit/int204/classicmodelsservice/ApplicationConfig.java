package sit.int204.classicmodelsservice;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sit.int204.classicmodelsservice.service.ListMapper;

@Configuration
public class ApplicationConfig {
@Bean
    public ModelMapper modelMapper(){
    return  new ModelMapper();
}

    @Bean
    public ListMapper ListMapper(){
        return   ListMapper.getInstance();
    }
}
