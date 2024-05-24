package sit.int204.classicmodelsservice.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import sit.int204.classicmodelsservice.dtos.PageDTO;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ListMapper {
    private static ModelMapper modelMapper = new ModelMapper();
    private static final ListMapper listMapper = new ListMapper();

    private ListMapper(){

    }
    public <S,T> List <T> mapList(List<S> source, Class<T> targetClass, ModelMapper modelMapper){
        return source.stream().map(entity -> modelMapper.map(entity, targetClass)).collect(Collectors.toList());
    }
    public <S,T> List <T> mapList(List<S> source, Class<T> targetClass){
        return mapList(source,targetClass,modelMapper);
    }

    public static ListMapper getInstance(){
        return listMapper;
    }

    public <S,T> PageDTO<T> toPageDTO(Page<S> source, Class<T> targetClass, ModelMapper modelMapper){
        PageDTO<T> page = modelMapper.map(source,PageDTO.class);
        page.setContenct(mapList(source.getContent(),targetClass,modelMapper));
        return page;
    }
    public <S,T> PageDTO<T> toPageDTO(Page<S> source, Class<T> targetClass){
        return toPageDTO(source,targetClass,modelMapper);
    }
}
