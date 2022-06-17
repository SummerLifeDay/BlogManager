package com.work.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "staff")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff {

    /**
     * 账号
     * 密码
     * 角色
     * 昵称
     * */
    private Integer staffId;
    private String userName;
    private String password;
    private Integer role;
    private String nickName;
}
