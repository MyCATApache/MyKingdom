package edu.ldcollege.domain;

public class TBCourse {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_course.cId
     *
     * @mbg.generated
     */
    private Integer cid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_course.classId
     *
     * @mbg.generated
     */
    private Integer classid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_course.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_course.description
     *
     * @mbg.generated
     */
    private String description;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_course.cId
     *
     * @return the value of tbl_course.cId
     *
     * @mbg.generated
     */
    public Integer getCid() {
        return cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_course.cId
     *
     * @param cid the value for tbl_course.cId
     *
     * @mbg.generated
     */
    public void setCid(Integer cid) {
        this.cid = cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_course.classId
     *
     * @return the value of tbl_course.classId
     *
     * @mbg.generated
     */
    public Integer getClassid() {
        return classid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_course.classId
     *
     * @param classid the value for tbl_course.classId
     *
     * @mbg.generated
     */
    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_course.name
     *
     * @return the value of tbl_course.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_course.name
     *
     * @param name the value for tbl_course.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_course.description
     *
     * @return the value of tbl_course.description
     *
     * @mbg.generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_course.description
     *
     * @param description the value for tbl_course.description
     *
     * @mbg.generated
     */
    public void setDescription(String description) {
        this.description = description;
    }
}