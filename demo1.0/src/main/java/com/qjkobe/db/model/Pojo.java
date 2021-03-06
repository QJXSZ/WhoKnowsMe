package com.qjkobe.db.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/8/22.
 */
public class Pojo implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -4174949718721742251L;

    private Date createtime;

    private Date updatetime;

    private String updateuser;

    private Integer isdelete;

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getUpdateUser() {
        return updateuser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateuser = updateUser;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
}
