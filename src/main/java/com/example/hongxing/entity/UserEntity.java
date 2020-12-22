package com.example.hongxing.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("USERS")
@Data
public class UserEntity {

    @TableField(value = "USID")
    private Integer usId;

    @TableField(value = "USACCOUNTS")
    private String usAccounts;

    @TableField(value = "USNAME")
    private String usName;

    @TableField(value = "OGINDEX")
    private Integer ogindex;

    @TableField(value = "CREATEUSER")
    private String createUser;

    @TableField(value = "RAWPASSWORD")
    private String rawPassword;

    public Integer getUsId() {
        return usId;
    }

    public void setUsId(Integer usId) {
        this.usId = usId;
    }

    public String getUsAccounts() {
        return usAccounts;
    }

    public void setUsAccounts(String usAccounts) {
        this.usAccounts = usAccounts;
    }

    public String getUsName() {
        return usName;
    }

    public void setUsName(String usName) {
        this.usName = usName;
    }

    public Integer getOgindex() {
        return ogindex;
    }

    public void setOgindex(Integer ogindex) {
        this.ogindex = ogindex;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getRawPassword() {
        return rawPassword;
    }

    public void setRawPassword(String rawPassword) {
        this.rawPassword = rawPassword;
    }
}
