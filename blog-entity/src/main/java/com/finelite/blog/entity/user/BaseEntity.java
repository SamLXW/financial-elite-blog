package com.finelite.blog.entity.user;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BaseEntity {

    private Long createdBy;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新人
     */
    private Long updatedBy;
    /**
     * 更新时间
     */
    private Date updatedTime;

    public Long getCreatedBy() {
        return createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}
