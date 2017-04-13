package cn.edu.hust.maoshiling.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Created by 15352 on 2017/4/7.
 * 院系信息
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
public class Department extends BaseEntity{
    /**
     * 学院id
     */
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    /**
     * 学院名称
     */
    private String name;
    /**
     * 属于学院的用户
     */
    @OneToMany(mappedBy = "department")
    private List<User> users;
}
