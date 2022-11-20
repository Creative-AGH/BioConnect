package com.example.bioconnect;

import com.example.bioconnect.entities.CategoryOfWaste;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class CategoryOfWasteConverter implements AttributeConverter<CategoryOfWaste, String> {

    @Override
    public String convertToDatabaseColumn(CategoryOfWaste role) {
        if (role == null) {
            return null;
        }
        return role.getCode();
    }

    @Override
    public CategoryOfWaste convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(CategoryOfWaste.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
