package edu.ldcollege.domain;

public class TBClassUser {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_class_user.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_class_user.userName
     *
     * @mbg.generated
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_class_user.classId
     *
     * @mbg.generated
     */
    private Integer classid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_class_user.userType
     *
     * @mbg.generated
     */
    private Byte usertype;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_class_user.userStatus
     *
     * @mbg.generated
     */
    private Byte userstatus;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_class_user.id
     *
     * @return the value of tbl_class_user.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_class_user.id
     *
     * @param id the value for tbl_class_user.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_class_user.userName
     *
     * @return the value of tbl_class_user.userName
     *
     * @mbg.generated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_class_user.userName
     *
     * @param username the value for tbl_class_user.userName
     *
     * @mbg.generated
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_class_user.classId
     *
     * @return the value of tbl_class_user.classId
     *
     * @mbg.generated
     */
    public Integer getClassid() {
        return classid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_class_user.classId
     *
     * @param classid the value for tbl_class_user.classId
     *
     * @mbg.generated
     */
    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_class_user.userType
     *
     * @return the value of tbl_class_user.userType
     *
     * @mbg.generated
     */
    public Byte getUsertype() {
        return usertype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_class_user.userType
     *
     * @param usertype the value for tbl_class_user.userType
     *
     * @mbg.generated
     */
    public void setUsertype(Byte usertype) {
        this.usertype = usertype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_class_user.userStatus
     *
     * @return the value of tbl_class_user.userStatus
     *
     * @mbg.generated
     */
    public Byte getUserstatus() {
        return userstatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_class_user.userStatus
     *
     * @param userstatus the value for tbl_class_user.userStatus
     *
     * @mbg.generated
     */
    public void setUserstatus(Byte userstatus) {
        this.userstatus = userstatus;
    }
}