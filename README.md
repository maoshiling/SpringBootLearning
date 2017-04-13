# SpringBottomLearning

## 出现的问题
- 实体中的集合用List、Set、Map，不要用具体的类型
- 实体上加@Entity
- 主键的@Id注解要注意是java.persistence.Id
- ManyToMany的使用
```
@ManyToMany
@JoinTable(name="ROLE_FUNCTION",
        joinColumns = {@JoinColumn(name = "ROLE_CODE",referencedColumnName = "ROLE_CODE")},
        inverseJoinColumns = {@JoinColumn(name = "FUNCTION_ID",referencedColumnName = "ID")})
private List<Function> functions;
```

## 快捷键记录
- 大小写转换：ctrl+shift+U

