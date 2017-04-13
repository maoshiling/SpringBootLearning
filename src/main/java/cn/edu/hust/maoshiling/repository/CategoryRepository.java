package cn.edu.hust.maoshiling.repository;

import cn.edu.hust.maoshiling.entity.Category;

/**
 * Created by 15352 on 2017/4/12.
 */
public interface CategoryRepository extends BaseRepository<Category,Integer> {
    /**
     * 查找给定ID的功能组
     * @param id
     * @return
     */
    public Category findOne(Integer id);
}
