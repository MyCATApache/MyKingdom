package io.imking.biz.domain;

import java.util.Date;

public class CustRecord {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tc_cust_record.id
     *
     * @mbg.generated Wed Jan 17 21:46:14 CST 2018
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tc_cust_record.cust_id
     *
     * @mbg.generated Wed Jan 17 21:46:14 CST 2018
     */
    private Long custId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tc_cust_record.user_id
     *
     * @mbg.generated Wed Jan 17 21:46:14 CST 2018
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tc_cust_record.remarks
     *
     * @mbg.generated Wed Jan 17 21:46:14 CST 2018
     */
    private String remarks;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tc_cust_record.create_time
     *
     * @mbg.generated Wed Jan 17 21:46:14 CST 2018
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tc_cust_record.id
     *
     * @return the value of tc_cust_record.id
     *
     * @mbg.generated Wed Jan 17 21:46:14 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tc_cust_record.id
     *
     * @param id the value for tc_cust_record.id
     *
     * @mbg.generated Wed Jan 17 21:46:14 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tc_cust_record.cust_id
     *
     * @return the value of tc_cust_record.cust_id
     *
     * @mbg.generated Wed Jan 17 21:46:14 CST 2018
     */
    public Long getCustId() {
        return custId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tc_cust_record.cust_id
     *
     * @param custId the value for tc_cust_record.cust_id
     *
     * @mbg.generated Wed Jan 17 21:46:14 CST 2018
     */
    public void setCustId(Long custId) {
        this.custId = custId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tc_cust_record.user_id
     *
     * @return the value of tc_cust_record.user_id
     *
     * @mbg.generated Wed Jan 17 21:46:14 CST 2018
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tc_cust_record.user_id
     *
     * @param userId the value for tc_cust_record.user_id
     *
     * @mbg.generated Wed Jan 17 21:46:14 CST 2018
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tc_cust_record.remarks
     *
     * @return the value of tc_cust_record.remarks
     *
     * @mbg.generated Wed Jan 17 21:46:14 CST 2018
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tc_cust_record.remarks
     *
     * @param remarks the value for tc_cust_record.remarks
     *
     * @mbg.generated Wed Jan 17 21:46:14 CST 2018
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tc_cust_record.create_time
     *
     * @return the value of tc_cust_record.create_time
     *
     * @mbg.generated Wed Jan 17 21:46:14 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tc_cust_record.create_time
     *
     * @param createTime the value for tc_cust_record.create_time
     *
     * @mbg.generated Wed Jan 17 21:46:14 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}