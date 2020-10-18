package com.yangshu.elastic.entity;

import java.util.Date;
import javax.persistence.*;

public class Users {

    @Id
    @Column(name = "user_id")
    private String userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 手机号、登录账号
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 加密盐
     */
    private String salt;

    /**
     * 头像，如果没有，使用默认头像
     */
    @Column(name = "face_image")
    private String faceImage;

    /**
     * 用户性别：0男性，1女性
     */
    private Byte sex;

    /**
     * 用户年龄
     */
    private Integer age;

    /**
     * 粉丝数量
     */
    @Column(name = "fans_num")
    private Integer fansNum;

    /**
     * 关注的人数量
     */
    @Column(name = "follow_num")
    private Integer followNum;

    /**
     * 收到的赞数量
     */
    @Column(name = "like_num")
    private Integer likeNum;

    /**
     * 个人简介
     */
    private String description;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户状态：0、正常使用 1、用户注销 2、违规用户
     */
    private Byte status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取手机号、登录账号
     *
     * @return phone - 手机号、登录账号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号、登录账号
     *
     * @param phone 手机号、登录账号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取加密盐
     *
     * @return salt - 加密盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置加密盐
     *
     * @param salt 加密盐
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 获取头像，如果没有，使用默认头像
     *
     * @return face_image - 头像，如果没有，使用默认头像
     */
    public String getFaceImage() {
        return faceImage;
    }

    /**
     * 设置头像，如果没有，使用默认头像
     *
     * @param faceImage 头像，如果没有，使用默认头像
     */
    public void setFaceImage(String faceImage) {
        this.faceImage = faceImage;
    }

    /**
     * 获取用户性别：0男性，1女性
     *
     * @return sex - 用户性别：0男性，1女性
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * 设置用户性别：0男性，1女性
     *
     * @param sex 用户性别：0男性，1女性
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * 获取用户年龄
     *
     * @return age - 用户年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置用户年龄
     *
     * @param age 用户年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取粉丝数量
     *
     * @return fans_num - 粉丝数量
     */
    public Integer getFansNum() {
        return fansNum;
    }

    /**
     * 设置粉丝数量
     *
     * @param fansNum 粉丝数量
     */
    public void setFansNum(Integer fansNum) {
        this.fansNum = fansNum;
    }

    /**
     * 获取关注的人数量
     *
     * @return follow_num - 关注的人数量
     */
    public Integer getFollowNum() {
        return followNum;
    }

    /**
     * 设置关注的人数量
     *
     * @param followNum 关注的人数量
     */
    public void setFollowNum(Integer followNum) {
        this.followNum = followNum;
    }

    /**
     * 获取收到的赞数量
     *
     * @return like_num - 收到的赞数量
     */
    public Integer getLikeNum() {
        return likeNum;
    }

    /**
     * 设置收到的赞数量
     *
     * @param likeNum 收到的赞数量
     */
    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    /**
     * 获取个人简介
     *
     * @return description - 个人简介
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置个人简介
     *
     * @param description 个人简介
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取用户状态：0、正常使用 1、用户注销 2、违规用户
     *
     * @return status - 用户状态：0、正常使用 1、用户注销 2、违规用户
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置用户状态：0、正常使用 1、用户注销 2、违规用户
     *
     * @param status 用户状态：0、正常使用 1、用户注销 2、违规用户
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}