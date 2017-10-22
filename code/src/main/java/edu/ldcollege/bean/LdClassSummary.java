package edu.ldcollege.bean;

public class LdClassSummary {
private int classId;
private String className;
private String createDay;
private String endDay;
//班长的用户ID
private int monitorId; 
private String monitorName;
private String monitorQQ;
//学习委员的用户ID
private int commissaryId;
private String commissaryName;
private String commissaryQQ;
//当前正常的学员数
private long curNormalStudents;
//欠费的的学员数
private long curArrearagedStudents;
//退学的学员数
private long dropedStudents;
public int getClassId() {
	return classId;
}
public void setClassId(int classId) {
	this.classId = classId;
}
public String getClassName() {
	return className;
}
public void setClassName(String className) {
	this.className = className;
}
public String getCreateDay() {
	return createDay;
}
public void setCreateDay(String createDay) {
	this.createDay = createDay;
}
public String getEndDay() {
	return endDay;
}
public void setEndDay(String endDay) {
	this.endDay = endDay;
}
public int getMonitorId() {
	return monitorId;
}
public void setMonitorId(int monitorId) {
	this.monitorId = monitorId;
}
public String getMonitorName() {
	return monitorName;
}
public void setMonitorName(String monitorName) {
	this.monitorName = monitorName;
}
public String getMonitorQQ() {
	return monitorQQ;
}
public void setMonitorQQ(String monitorQQ) {
	this.monitorQQ = monitorQQ;
}
public int getCommissaryId() {
	return commissaryId;
}
public void setCommissaryId(int commissaryId) {
	this.commissaryId = commissaryId;
}
public String getCommissaryName() {
	return commissaryName;
}
public void setCommissaryName(String commissaryName) {
	this.commissaryName = commissaryName;
}
public String getCommissaryQQ() {
	return commissaryQQ;
}
public void setCommissaryQQ(String commissaryQQ) {
	this.commissaryQQ = commissaryQQ;
}


public long getCurNormalStudents() {
	return curNormalStudents;
}
public void setCurNormalStudents(long curNormalStudents) {
	this.curNormalStudents = curNormalStudents;
}
public long getCurArrearagedStudents() {
	return curArrearagedStudents;
}
public void setCurArrearagedStudents(long curArrearagedStudents) {
	this.curArrearagedStudents = curArrearagedStudents;
}
public long getDropedStudents() {
	return dropedStudents;
}
public void setDropedStudents(long dropedStudents) {
	this.dropedStudents = dropedStudents;
}
public void setDropedStudents(int dropedStudents) {
	this.dropedStudents = dropedStudents;
}


}
