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

    public static final String KAITI = "";

    //信
    public static final String SHOUXIN = "message/get_in_mails.do";
    public static final String SENDMESSAGE = "message/send.do";
    public static final String FAXIN = "message/get_send_mails.do";
    public static final String RIZHI = "log/get_guide_logs.do";

    //老师端
    public static final String TESHENBAO = "subject/refresh_audit_list.do";
    public static final String DEALSHENBAO = "subject/confirm_subject.do";
    public static final String PUBLISH = "subject/publish_subject.do";


    //全局
    public static Context context = null;

}
