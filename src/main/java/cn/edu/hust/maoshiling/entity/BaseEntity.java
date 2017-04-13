package cn.edu.hust.maoshiling.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.time.ZonedDateTime;

/**
 * Created by 15352 on 2017/4/13.
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    /**
     * 创建者
     */
    @CreatedBy
    private String createdBy;
    /**
     * 创建时间
     */
    @CreatedDate
    private ZonedDateTime createdAt;
    /**
     * 修改者
     */
    @LastModifiedBy
    private String modifiedBy;
    /**
     * 修改时间
     */
    @LastModifiedDate
    private ZonedDateTime modifiedAt;
    /**
     * 版本号
     */
    @Version
    private int version;
}
