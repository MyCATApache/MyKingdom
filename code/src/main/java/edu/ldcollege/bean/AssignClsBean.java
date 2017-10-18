package edu.ldcollege.bean;

public class AssignClsBean {
private Integer classId;
private Integer studentId;
private Integer season;
private String reason;
private String note;
public Integer getClassId() {
	return classId;
}
public void setClassId(Integer classId) {
	this.classId = classId;
}
public Integer getStudentId() {
	return studentId;
}
public void setStudentId(Integer studentId) {
	this.studentId = studentId;
}
public String getReason() {
	return reason;
}
public void setReason(String reason) {
	this.reason = reason;
}
public String getNote() {
	return note;
}
public void setNote(String note) {
	this.note = note;
}
public Integer getSeason() {
	return season;
}
public void setSeason(Integer season) {
	this.season = season;
}
@Override
public String toString() {
	return "AssignClsBean [classId=" + classId + ", studentId=" + studentId + ", season=" + season + ", reason="
			+ reason + ", note=" + note + "]";
}

}
