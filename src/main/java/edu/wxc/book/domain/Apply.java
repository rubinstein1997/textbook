package edu.wxc.book.domain;

import java.util.Date;

public class Apply {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column apply.apply_id
     *
     * @mbg.generated Mon Jun 25 19:46:01 CST 2018
     */
    private Integer applyId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column apply.user_id
     *
     * @mbg.generated Mon Jun 25 19:46:01 CST 2018
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column apply.status
     *
     * @mbg.generated Mon Jun 25 19:46:01 CST 2018
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column apply.message
     *
     * @mbg.generated Mon Jun 25 19:46:01 CST 2018
     */
    private String message;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column apply.time
     *
     * @mbg.generated Mon Jun 25 19:46:01 CST 2018
     */
    private Date time;

    public Apply(Integer applyId, Integer userId, Integer status, String message, Date time) {
        this.applyId = applyId;
        this.userId = userId;
        this.status = status;
        this.message = message;
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column apply.apply_id
     *
     * @return the value of apply.apply_id
     *
     * @mbg.generated Mon Jun 25 19:46:01 CST 2018
     */
    public Integer getApplyId() {
        return applyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column apply.apply_id
     *
     * @param applyId the value for apply.apply_id
     *
     * @mbg.generated Mon Jun 25 19:46:01 CST 2018
     */
    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column apply.user_id
     *
     * @return the value of apply.user_id
     *
     * @mbg.generated Mon Jun 25 19:46:01 CST 2018
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column apply.user_id
     *
     * @param userId the value for apply.user_id
     *
     * @mbg.generated Mon Jun 25 19:46:01 CST 2018
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column apply.status
     *
     * @return the value of apply.status
     *
     * @mbg.generated Mon Jun 25 19:46:01 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column apply.status
     *
     * @param status the value for apply.status
     *
     * @mbg.generated Mon Jun 25 19:46:01 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column apply.message
     *
     * @return the value of apply.message
     *
     * @mbg.generated Mon Jun 25 19:46:01 CST 2018
     */
    public String getMessage() {
        return message;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column apply.message
     *
     * @param message the value for apply.message
     *
     * @mbg.generated Mon Jun 25 19:46:01 CST 2018
     */
    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column apply.time
     *
     * @return the value of apply.time
     *
     * @mbg.generated Mon Jun 25 19:46:01 CST 2018
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column apply.time
     *
     * @param time the value for apply.time
     *
     * @mbg.generated Mon Jun 25 19:46:01 CST 2018
     */
    public void setTime(Date time) {
        this.time = time;
    }
}