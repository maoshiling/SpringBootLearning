package cn.edu.hust.maoshiling.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by 15352 on 2017/4/11.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
public class Category extends BaseEntity{
    /**
     * 功能组id
     */
    @Id
    @GeneratedValue
    private Integer id;
    /**
     * 功能组名称
     */
    private String name;
    /**
     * 功能组包含的功能
     */
    @OneToMany(mappedBy = "category")
    private List<Function> functions;

}
