package cn.edu.hust.maoshiling.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Created by 15352 on 2017/4/11.
 * 功能
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
public class Function extends BaseEntity{
    /**
     * 功能id
     */
    @Id
    @GeneratedValue
    private Integer id;
    /**
     * 功能名称
     */
    private String name;
    /**
     * 功能对应的url
     */
    private String url;
    /**
     * 所属功能组
     */
    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;
    /**
     * 具备该功能的角色
     */
    @ManyToMany(mappedBy = "functions")
    private List<Role> roles;
}
