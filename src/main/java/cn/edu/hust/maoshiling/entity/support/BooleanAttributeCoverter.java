package cn.edu.hust.maoshiling.entity.support;

import org.springframework.util.Assert;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


/**
 * Created by 15352 on 2017/4/12.
 */
@Converter(autoApply = true)
public class BooleanAttributeCoverter implements AttributeConverter<Boolean,String> {
    public static final String MALE = "男";
    public static final String FEMALE = "女";

    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        Assert.notNull(attribute,"attribute can not be null!");
        if (attribute==true){
            return MALE;
        }else {
            return FEMALE;
        }
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        Assert.notNull(dbData,"attribute can not be null!");
        if (MALE.equals(dbData)){
            return Boolean.TRUE;
        }else {
            return Boolean.FALSE;
        }
    }
}
