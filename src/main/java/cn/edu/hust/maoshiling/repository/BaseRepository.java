package cn.edu.hust.maoshiling.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 15352 on 2017/4/13.
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends Repository<T,ID>{
    /**
     * 保存
     * @param t
     * @return
     */
    public T save(T t);

    /**
     * 删除
     * @param t
     * @return
     */
    public T delete(T t);

    /**
     * 查找所有
     * @return
     */
    public List<T> findAll();
}
