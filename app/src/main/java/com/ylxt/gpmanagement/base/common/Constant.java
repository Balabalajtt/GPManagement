package com.ylxt.gpmanagement.base.common;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 江婷婷 on 2018/5/14.
 */

public class Constant {
    public static final String SERVER_ADDRESS = "http://120.79.196.225:8080/GPManagement/";

    public static final String LOGIN = "user/login.do";
    public static final String LOGOUT = "user/logout.do";

    //修改信息
    public static final String CHANGEPWD = "user/reset_password.do";
    public static final String CHANGEINFO = "user/update_information.do";

    public static final String TEACHERINFO = "user/get_guide_teacher.do";

    //各种文件
    public static final String FUJIAN = "file/upload.do";

    //申报课题
    public static final String CHECK_SHENGBAO = "subject/get_declared_subject.do";
    public static final String SHENGBAO = "subject/declare_subject.do";

    //选题
    public static final String CHECK_XUANTI = "subject/get_selected_subject.do";
    public static final String XUANTI = "subject/select_subject.do";
    public static final String NENGXUANDETI = "subject/get_unselected_subjects.do";

    //开题
    public static final String KAITI = "report/submit_start_report.do";
    public static final String CHECK_KAITI = "report/check_start_report_valid.do";

    //中期
    public static final String ZHONGQI = "report/submit_middle_report.do";
    public static final String CHECK_ZHONGQI = "report/check_middle_report_valid.do";

    //定稿
    public static final String DINGGAO = "file/upload.do";
    public static final String CHECK_DINGGAO = "paper/check_paper_valid.do";

    public static final String CHECK_DABIAN = "paper/check_result_valid.do";

    //信
    public static final String SHOUXIN = "message/get_in_mails.do";
    public static final String SENDMESSAGE = "message/send.do";
    public static final String FAXIN = "message/get_send_mails.do";
    public static final String RIZHI = "log/get_guide_logs.do";

    //老师端
    public static final String TESHENBAO = "subject/refresh_audit_list.do";
    public static final String DEALSHENBAO = "subject/confirm_subject.do";
    public static final String PUBLISH = "subject/publish_subject.do";
    public static final String TEKAITI = "report/refresh_start_report_audit_list.do";
    public static final String DEALKAITI = "report/confirm_start_report.do";
    public static final String TEZHONGQI = "report/refresh_middle_report_audit_list.do";
    public static final String DEALZHONGQI = "report/confirm_middle_report.do";
    public static final String TEDINGGAO = "paper/refresh_paper_audit_list.do";
    public static final String DEALDINGGAO = "paper/confirm_paper.do";


    //全局
    public static Context context = null;

}
