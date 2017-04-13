package cn.edu.hust.maoshiling.repository;


import cn.edu.hust.maoshiling.entity.Role;

/**
 * Created by 15352 on 2017/4/11.
 */
public interface RoleRepository extends BaseRepository<Role,String> {

    /**
     * 删除给定角色
     * @param Role
     * @return
     */
    public Role delete(Role Role);

    /**
     * 根据角色名查找角色
     * @param roleCode
     * @return
     */
    public Role findByRoleCode(String roleCode);
}
