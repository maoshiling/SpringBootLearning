package cn.edu.hust.maoshiling.repository;


import cn.edu.hust.maoshiling.entity.User;

/**
 * Created by 15352 on 2017/4/11.
 */
public interface UserRepository extends BaseRepository<User,Integer> {
    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    public User findOne(Integer id);

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public User findByUsername(String username);

    /**
     * 根据真实姓名查找用户
     * @param name
     * @return
     */
    public User findByName(String name);
}
