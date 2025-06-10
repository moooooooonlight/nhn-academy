package com.nhnacademy.exam.hotel.converter;

import com.nhnacademy.exam.hotel.domain.ViewType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.Objects;

@Converter(autoApply = true)
public class ViewTypeConverter implements AttributeConverter<ViewType, Integer> {

    @Override
    public Integer  convertToDatabaseColumn(ViewType viewType) {
        return viewType.getDbValue();
    }

    @Override
    public ViewType convertToEntityAttribute(Integer viewType) {
        return ViewType.fromDbValue(viewType);
    }
}
