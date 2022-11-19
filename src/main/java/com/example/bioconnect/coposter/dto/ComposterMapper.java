package com.example.bioconnect.coposter.dto;

import com.example.bioconnect.entities.Composter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", uses = ComposterMapper.class)
public interface ComposterMapper {


    @Mapping(source = "composterCoordinatesDto", target = "composterCoordinates")
    Composter mapFillComposterDtoToComposter(FillComposterDto fillComposterDto);

    default List<Double> mapPointDtoToDouble(List<PointDto> composterCoordinatesDto) {
        List<Double> doubleList = new ArrayList<>();
        if (composterCoordinatesDto.contains(null)) {
            throw new RuntimeException("The coordinate can not be null!");
        }
        composterCoordinatesDto.forEach(p -> {
            if (p.getX() == null || p.getY() == null) {
                throw new RuntimeException("The value of coordinate can not be null!");
            }
            doubleList.add(p.getX());
            doubleList.add(p.getY());
        });
        return doubleList;
    }

    @Mapping(source = "composterCoordinates", target = "composterCoordinatesDto")
    GetComposterDto mapComposterToGetComposterDto(Composter savedComposter);

    default List<PointDto> mapDoubleToPointDto(List<Double> composterCoordinates) {
        List<PointDto> pointDtos = new ArrayList<>();
        for (int i = 0; i < composterCoordinates.size(); i += 2) {
            pointDtos.add(new PointDto(composterCoordinates.get(i), composterCoordinates.get(i + 1)));
        }
        return pointDtos;
    }
}
