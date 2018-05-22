package com.ylxt.gpmanagement.work.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ylxt.gpmanagement.R;
import com.ylxt.gpmanagement.base.ui.fragment.BaseFragment;
import com.ylxt.gpmanagement.work.data.NoticeBean;
import com.ylxt.gpmanagement.work.ui.activity.GongGaoActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 江婷婷 on 2018/5/10.
 */

public class FirstFragment extends BaseFragment {

    private List<NoticeBean> mNoticeBeans;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        initData();
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        LinearLayout llone = view.findViewById(R.id.ll_yuannei_one);
        LinearLayout lltwo = view.findViewById(R.id.ll_yuannei_two);
        LinearLayout llthree = view.findViewById(R.id.ll_yuannei_three);
        LinearLayout llxiaoone = view.findViewById(R.id.ll_xiaonei_one);
        llxiaoone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GongGaoActivity.class);
                intent.putExtra("title", "西安邮电大学校内公告");
                intent.putExtra("time", "发布时间：（2012-11-15）");
                intent.putExtra("content", "西安邮电大学校内公告西安邮电大学校内公告西安邮电大学校内公告西安邮电大学校内公告 ");
                startActivity(intent);
            }
        });

        llone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GongGaoActivity.class);
                intent.putExtra("title", "关于论文检测注意事项的通知");
                intent.putExtra("time", "发布时间：（2016-05-26）");
                intent.putExtra("content", "各位老师、同学：\n" +
                        "\n" +
                        "        您好！关于2016届本科毕设论文检测需注意的事项通知如下：\n" +
                        "\n" +
                        "1、第一次论文检测必须于2016年5月30日24点前在系统中上传结束，过时将不能上传，请学生注意时间结点，千万不能错过。截止时间过后系统会自动开始检测，并记录检测次数，生成检测结果。学生和指导教师可在次日登录系统查看检测结果。\n" +
                        "\n" +
                        "2、检测标准为：文字复制比在30％以内（含30%）的论文视为合格，超过30％的论文视为不合格。所有学生全部进行检测，每人限两次检测机会。首次检测合格的，不再进行二次检测。\n" +
                        "\n" +
                        "3、 论文检测系统的网址为http://xiyou.check.cnki.net/，学生的用户名和初始密码均为学号，指导教师的用户名和初始密码均是正方教务系统的账号。请学生和老师尽快登录系统更改密码，防止他人盗用账号进行论文查重。\n" +
                        "\n" +
                        "4、学生必须按照“论文题目-论文作者-指导教师-专业”的命名规则准备好word 格式的电子论文。\n" +
                        "\n" +
                        "5、论文检测范围：论文正文部分即只检测章节部分\n");
                startActivity(intent);
            }
        });
        lltwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GongGaoActivity.class);
                intent.putExtra("title", "2016届本科毕业设计（论文）检测工作安排");
                intent.putExtra("time", "发布时间：（2016-05-24）");
                intent.putExtra("content", "各位老师：\n" +
                        "        您好！接学校教务处通知，本科论文检测系统现已开通，现将2016届毕业设计（论文）检测相关事项通知如下：\n" +
                        "\n" +
                        " 一、检测标准\n" +
                        "\n" +
                        "１.我校本科毕业设计（论文）的检测标准为：文字复制比在30％以内（含30%）的论文视为合格，超过30％的论文视为不合格。\n" +
                        "\n" +
                        "２. 2016届本科毕业设计（论文）需全部进行检测，每人限两次检测机会。首次检测合格的，不再进行二次检测。\n" +
                        "\n" +
                        "二、检测流程\n" +
                        "\n" +
                        "１.论文检测系统的网址为http://xiyou.check.cnki.net/，学生的用户名和初始密码均为学号，指导教师的用户名和初始密码和正方\n" +
                        "          教务系统的账号相同。学生和指导教师应在5月27日前登陆系统进行测试和修改密码。\n" +
                        "\n" +
                        "２.学生按照“论文题目-论文作者-指导教师-专业”的命名规则准备好word 格式的电子论文。\n" +
                        "\n" +
                        "３.学生应在5月30日24时前提交论文进行第一次检测。第一次检测未通过者修改论文后可在６月5日24时之前提交论文进行二次检测。\n" +
                        "\n" +
                        "４.截止时间过后系统会自动开始检测，并记录检测次数，生成检测结果。\n" +
                        "\n" +
                        "５.学生和指导教师可在次日登录系统查看检测结果。\n" +
                        "\n" +
                        "三、检测要求\n" +
                        "\n" +
                        "1.学生应主动配合检测工作，按时提交论文，确保检测的论文为最终版本，论文可以多次提交，以最后一次为准。\n" +
                        "\n" +
                        "２.学生不得以别人账号登陆和检测论文。\n" +
                        "\n" +
                        "３.学生不得通过篡改文字、将引用文字转化成图片格式等不当方式检测过关。\n" +
                        "\n" +
                        "4.对学生在论文检测中出现的违规行为，经学院认定，可取消毕业设计（论文）成绩。\n" +
                        "\n" +
                        "5.指导教师应认真履行职责，及时查验毕业设计（论文）打印版本与检测版本的一致性，反馈论文检测结果，指导和督促学生修改\n" +
                        "            完善论文。\n" +
                        "\n" +
                        "祝好！\n" +
                        "                                                                                                                                                           通院教办\n" +
                        "                                                                                                                                                           2016-5-24");
                startActivity(intent);
            }
        });
        llthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GongGaoActivity.class);
                intent.putExtra("title", "关于2016届毕业设计（论文）中期检查的通知");
                intent.putExtra("time", "发布时间：（2016-05-10）");
                intent.putExtra("content", "         关于2016届毕业设计（论文）中期检查的通知\n" +
                        "各位老师：\n" +
                        "    您好！接学校教务处实践科通知，为及时了解和掌握学生毕业设计（论文）的进展情况，保证学生顺利完成毕业设计（论文）任务，学校决定对2016届毕业设计（论文）工作进行中期检查，现将检查具体事宜安排如下：\n" +
                        "一、 中期检查分为两个部分：1.学院自查；2.学校抽查。\n" +
                        "二、 检查时间为： 学院自查: 5月13日前完成\n" +
                        "                  学校抽查: 5月20日前完成\n" +
                        "三、学院自查方式：各毕设小组组织检查，深入设计现场，组织对本组所有学生毕业 杓疲\uE7CA畚模┲衅诠ぷ鹘\uE263屑觳椋 检查时填写《西安邮电大学毕业设计（论文）中期检查表》（见附件）。\n" +
                        "四、 检查内容：检查学生毕业设计（论文）工作进展情况，学生出勤率、学生提交的中期总结报告、了解学生对毕业设计（论文）工作意见，同时检查指导教师工作状况。\n" +
                        "五、 1、检查结束后，由各毕设小组秘书统一将本小组所有学生的《中期检查表》（电子版+纸质版）电子版发到教办邮箱（txjb@xupt.edu.cn）,纸质版统一交到教办，并根据检查情况写出书面总结报告（电子版+纸质版）并提交教办，报告中应含有本检查小组检查过程、结果及检查小组人员名单。以上资料由教办进行汇总存档，以备学校检查。\n" +
                        "    2、相关文档的填写及提交\n" +
                        "   （1）《毕业设计（论文）中期汇报表》\n" +
                        "        《毕业设计（论文）中期汇报表》由学生本人直接在毕设系统（222.24.63.105）中填写，要求工作小结详细具体（字数不能少于600字），填写完成后直接点击提交即可（注：提交时请认真检查，提交后无法修改）。 另：《中期汇报表》中设计地点一栏的填写，根据指导教师所在部门填写设计地点。\n" +
                        "    (2)《毕业设计（论文）中期检查表》\n" +
                        "       《毕业设计（论文）中期检查表》由各检查小组成员填写，并由各小组秘书统一将本小组所有学生的《中期检查表》（电子版+纸质版）电子版发到教办邮箱（txjb@xupt.edu.cn）,纸质版统一交到教办。《检查表》中检查时间各小组根据实际情况填写，但必须填写到5月13日前。\n" +
                        " 即：学生系统在线填写《中期汇报表》并提交，此项工作必须在5月12日（本周四）之前完成\n" +
                        "       检查小组成员或指导教师填写《中期检查表》，统一由各小组秘书提交教办，此项工作必须在5月13日（本周五）之前完成。\n" +
                        "\n" +
                        "六、   学校检查方式：在学院中期检查结束后，学校检查组将深入到学院及毕业设计现场对学院的自查情况进行检查，对部分学生的毕业设计（论文）进展情况进行抽查。\n" +
                        "\n" +
                        "七、    学校检查时，要求主管毕业设计（论文）工作副院长在现场配合检查。\n" +
                        "\n" +
                        "\n" +
                        "附件：西安邮电大学毕业设计（论文）中期检查表\n" +
                        "\n" +
                        "毕业设计（论文）中期汇报表\n" +
                        "\n" +
                        "祝好！\n" +
                        " \n" +
                        "\n" +
                        "                                        通院教办\n" +
                        "                                        2016-5-10\n");
                startActivity(intent);
            }
        });


        return view;
    }

    private void initData() {
        mNoticeBeans = new ArrayList<>();
        mNoticeBeans.add(new NoticeBean("aaaaaaaaaaaaaaaaaaaaaaaaaaaa", "2018-5-11"));
        mNoticeBeans.add(new NoticeBean("aaaaaaaaaaaaaaaaaaaaaaaaaaaa", "2018-5-11"));
        mNoticeBeans.add(new NoticeBean("aaaaaaaaaaaaaaaaaaaaaaaaaaaa", "2018-5-11"));
    }


}
