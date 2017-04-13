package cn.edu.hust.maoshiling.repository;


import cn.edu.hust.maoshiling.entity.Category;
import cn.edu.hust.maoshiling.entity.Function;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by 15352 on 2017/4/11.
 */
public interface FunctionRepository extends BaseRepository<Function,Integer> {

    /**
     * 查找给定ID对应的功能
     * @param id
     * @return
     */
    public Function findOne(Integer id);

    /**
     * 查找属于某一功能组的功能
     * @param categoty
     * @return
     */
    @Query("select function from #{#entityName} function where function.category = ?1")
    public List<Function> findByCategory(Category categoty);
}
