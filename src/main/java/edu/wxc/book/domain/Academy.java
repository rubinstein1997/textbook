package edu.wxc.book.domain;

public class Academy {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column academy.academy_id
     *
     * @mbg.generated Thu Jul 05 16:25:32 CST 2018
     */
    private Integer academyId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column academy.academy_name
     *
     * @mbg.generated Thu Jul 05 16:25:32 CST 2018
     */
    private String academyName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column academy.academy_id
     *
     * @return the value of academy.academy_id
     *
     * @mbg.generated Thu Jul 05 16:25:32 CST 2018
     */
    public Integer getAcademyId() {
        return academyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column academy.academy_id
     *
     * @param academyId the value for academy.academy_id
     *
     * @mbg.generated Thu Jul 05 16:25:32 CST 2018
     */
    public void setAcademyId(Integer academyId) {
        this.academyId = academyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column academy.academy_name
     *
     * @return the value of academy.academy_name
     *
     * @mbg.generated Thu Jul 05 16:25:32 CST 2018
     */
    public String getAcademyName() {
        return academyName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column academy.academy_name
     *
     * @param academyName the value for academy.academy_name
     *
     * @mbg.generated Thu Jul 05 16:25:32 CST 2018
     */
    public void setAcademyName(String academyName) {
        this.academyName = academyName == null ? null : academyName.trim();
    }
}