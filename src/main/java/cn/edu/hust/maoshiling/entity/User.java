package cn.edu.hust.maoshiling.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

/**
 * Created by 15352 on 2017/4/7.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
public class User extends BaseEntity{
    /**
     * 用户id
     */
    @Id
    @GeneratedValue
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 真实姓名
     */
    private String name;
    /**
     * 出生日期
     */
    private Instant birthday;
    /**
     * 性别
     */
    private boolean sex;
    /**
     * 所属院系
     */
    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;
    /**
     * 用户角色
     */
    @ManyToMany
    @JoinTable(name="USER_ROLE",
            joinColumns = {@JoinColumn(name="USER_ID",referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name="ROLE_CODE",referencedColumnName = "ROLE_CODE")})
    private Set<Role> roles;
}
