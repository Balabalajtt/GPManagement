package com.ylxt.gpmanagement.work.data.gson;

import java.io.Serializable;

/**
 * Created by 江婷婷 on 2018/5/21.
 */

public class SubjectData implements Serializable {
    public int id;
    public String studentName;
    public String number;
    public String subjectName;
    public String topicSource;
    public String subjectType;
    public String topicType;
    public String topicPaper;
    public String ability;
    public String target;
    public String guideTeacher;
    public int source;
    public String attachment;
    public int status;

    public SubjectData(int id, String studentName, String number, String subjectName, String topicSource, String subjectType, String topicType, String topicPaper, String ability, String target, String guideTeacher, int source, String attachment, int status) {
        this.id = id;
        this.studentName = studentName;
        this.number = number;
        this.subjectName = subjectName;
        this.topicSource = topicSource;
        this.subjectType = subjectType;
        this.topicType = topicType;
        this.topicPaper = topicPaper;
        this.ability = ability;
        this.target = target;
        this.guideTeacher = guideTeacher;
        this.source = source;
        this.attachment = attachment;
        this.status = status;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getTopicSource() {
        return topicSource;
    }

    public void setTopicSource(String topicSource) {
        this.topicSource = topicSource;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public String getTopicType() {
        return topicType;
    }

    public void setTopicType(String topicType) {
        this.topicType = topicType;
    }

    public String getTopicPaper() {
        return topicPaper;
    }

    public void setTopicPaper(String topicPaper) {
        this.topicPaper = topicPaper;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getGuideTeacher() {
        return guideTeacher;
    }

    public void setGuideTeacher(String guideTeacher) {
        this.guideTeacher = guideTeacher;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
