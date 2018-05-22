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
    public static final String KAITIFUJIAN = "";
    public static final String KAITI = "";
    public static final String CHANGEPWD = "user/reset_password.do";
    public static final String LOGOUT = "user/logout.do";
    public static final String CHANGEINFO = "user/update_information.do";
    public static final String SHENGBAO = "subject/declare_subject.do";
    public static final String CHECK_SHENGBAO = "subject/get_declare_subject.do";


    public static Context context = null;


    public static List<String> locations = new ArrayList<>();

}
