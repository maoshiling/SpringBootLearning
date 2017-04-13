package cn.edu.hust.maoshiling.repository;

import cn.edu.hust.maoshiling.entity.Department;

/**
 * Created by 15352 on 2017/4/12.
 */
public interface DepartmentRepository extends BaseRepository<Department,Integer> {
    /**
     * 查找给定ID的院系
     * @param id
     * @return
     */
    public Department findOne(Integer id);

    /**
     * 根据院系名称查找院系
     * @param name
     * @return
     */
    public Department findByName(String name);
}
