package co.practice.roth.springjwtpractice01.repository;

import co.practice.roth.springjwtpractice01.model.AppUser;
import co.practice.roth.springjwtpractice01.service.AppUserService;
import org.apache.ibatis.annotations.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface AppUserRepository {

    @Results(id = "userMapper", value = {
            @Result(property = "userId", column = "user_id"),
            @Result(property = "fullName", column = "full_name"),
            @Result(property = "roles", column = "user_id",
                    many = @Many(select = "getAllRolesByUserId"))
    })
    @Select("""
                SELECT * FROM app_users
                WHERE email = #{email}
            """)
    AppUser findUserByEmail(String email);

    @Select("""
                    SELECT role_name FROM roles r 
                    INNER JOIN user_role ur 
                    ON r.role_id = ur.role_id
                    WHERE user_id = #{userId}
            """)
    List<String> getAllRolesByUserId(Integer userId);


}
