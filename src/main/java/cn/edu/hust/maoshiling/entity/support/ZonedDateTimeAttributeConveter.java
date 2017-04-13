package cn.edu.hust.maoshiling.entity.support;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Created by 15352 on 2017/4/13.
 */
@Converter(autoApply = true)
public class ZonedDateTimeAttributeConveter implements AttributeConverter<ZonedDateTime,Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(ZonedDateTime attribute) {
        if (attribute==null){
            return null;
        }
        return Timestamp.from(attribute.toInstant());
    }

    @Override
    public ZonedDateTime convertToEntityAttribute(Timestamp dbData) {
        if (dbData==null){
            return null;
        }
        LocalDateTime localDateTime = dbData.toLocalDateTime();
        return localDateTime.atZone(ZoneId.systemDefault());
    }
}
