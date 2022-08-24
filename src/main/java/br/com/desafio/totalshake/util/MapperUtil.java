package br.com.desafio.totalshake.util;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component("mapperUtil")
public final class MapperUtil {

    protected ModelMapper modelMapper;

    public MapperUtil() {
        this.modelMapper = new ModelMapper();
    }

    public <S, D> D mapTo(S source, Class<D> destinyClass) {
        return this.modelMapper.map(source,destinyClass);
    }

    public <S, D> List<D> toList(List<S> source, Type destinyClass) {
        return this.modelMapper.map(source, destinyClass);
    }
}
