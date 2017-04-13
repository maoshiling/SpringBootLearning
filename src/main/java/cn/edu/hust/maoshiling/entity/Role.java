package cn.edu.hust.maoshiling.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by 15352 on 2017/4/11.
 * 角色
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
public class Role extends BaseEntity{
    /**
     * 角色代码
     */
    @Id
    @Column(name = "ROLE_CODE")
    private String roleCode;
    /**
     * 角色名称
     */
    @Column(name = "ROLE_NAME")
    private String roleName;
    /**
     * 角色具备的权限
     */
    @ManyToMany
    @JoinTable(name="ROLE_FUNCTION",
            joinColumns = {@JoinColumn(name = "ROLE_CODE",referencedColumnName = "ROLE_CODE")},
            inverseJoinColumns = {@JoinColumn(name = "FUNCTION_ID",referencedColumnName = "ID")})
    private List<Function> functions;
}
