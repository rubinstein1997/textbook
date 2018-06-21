package edu.wxc.book.domain;

public class ApplyItem {
    private Integer applyId;

    private String bookName;

    private String press;

    private String major;

    private Integer bookNumber;

    private Integer studentNumber;

    private String message;

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(Integer bookNumber) {
        this.bookNumber = bookNumber;
    }

    public Integer getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ApplyItem{" +
                "applyId=" + applyId +
                ", bookName='" + bookName + '\'' +
                ", press='" + press + '\'' +
                ", major='" + major + '\'' +
                ", bookNumber=" + bookNumber +
                ", studentNumber=" + studentNumber +
                ", message='" + message + '\'' +
                '}';
    }

}
