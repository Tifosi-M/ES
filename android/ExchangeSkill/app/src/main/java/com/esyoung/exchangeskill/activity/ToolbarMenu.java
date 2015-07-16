package com.esyoung.exchangeskill.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.esyoung.exchangeskill.R;
import com.esyoung.exchangeskill.fragment.AchievementWallFragment;
import com.esyoung.exchangeskill.fragment.DisplayWallFragment;
import com.esyoung.exchangeskill.fragment.ExchangeWallFragment;
import com.esyoung.exchangeskill.fragment.PersonalCenterFragment;
import com.esyoung.exchangeskill.materialmenu.MaterialMenuDrawable;
import com.esyoung.exchangeskill.materialmenu.extras.toolbar.MaterialMenuIconToolbar;

/**
 * Created by Administrator on 2015/3/1.
 */
public class ToolbarMenu {

    private View mView;
    private TextView txt_user_name,txt_display_wall,txt_exchange_wall,txt_achievement_wall,txt_share,txt_setting,txt_system_setting,txt_person_center,txt_constract_us;
    private Context mContext;
    private RelativeLayout rl_display_wall,rl_exchange_wall,rl_achievement_wall,rl_person_center,relativeLayout;
    private ImageView img_display_wall,img_exchange_wall,img_achievement_wall,img_person_center;
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ToolbarActivity mToolbarActivity;
    public static final int DISPLAYWALL = 1;
    public static final int EXCHANGEWALL = 2;
    public static final int ACHIEVEMENTWALL = 3;
    public static final int PERSONALCENTER = 4;
    public static int SELECTFLAG = 0;
    private MaterialMenuIconToolbar mMaterialMenu;
    private DisplayWallFragment mDisplayWallFragment;
    private AchievementWallFragment mAchievementWallFragment;
    private ExchangeWallFragment mExchangeWallFragment;
    private PersonalCenterFragment mPersonalCenterFragment;

    public ToolbarMenu(View view,Context context,Toolbar toolbar,DrawerLayout drawerLayout, MaterialMenuIconToolbar materialMenu,ToolbarActivity toolbarActivity) {
        mView = view;
        mContext = context;
        mToolbar = toolbar;
        mDrawerLayout = drawerLayout;
        mMaterialMenu = materialMenu;
        mToolbarActivity = toolbarActivity;
        init();
    }

    public void init(){
        Typeface fontFace = Typeface.createFromAsset(mContext.getAssets(),"fonts/HYQiHei-45S.ttf");
        txt_user_name= (TextView) mView.findViewById(R.id.txt_user_name);
        txt_user_name.setTypeface(fontFace);
        txt_display_wall= (TextView) mView.findViewById(R.id.txt_display_wall);
        txt_display_wall.setTypeface(fontFace);
        txt_exchange_wall= (TextView) mView.findViewById(R.id.txt_exchange_wall);
        txt_exchange_wall.setTypeface(fontFace);
        txt_achievement_wall= (TextView) mView.findViewById(R.id.txt_achievement_wall);
        txt_achievement_wall.setTypeface(fontFace);
        txt_share= (TextView) mView.findViewById(R.id.txt_share);
        txt_share.setTypeface(fontFace);
        txt_system_setting= (TextView) mView.findViewById(R.id.txt_system_setting);
        txt_system_setting.setTypeface(fontFace);
        txt_constract_us= (TextView) mView.findViewById(R.id.txt_constract_us);
        txt_constract_us.setTypeface(fontFace);
        txt_person_center= (TextView) mView.findViewById(R.id.txt_person_center);
        txt_person_center.setTypeface(fontFace);
        txt_setting= (TextView) mView.findViewById(R.id.txt_setting);
        txt_setting.setTypeface(fontFace);
        relativeLayout = (RelativeLayout) mView.findViewById(R.id.relativeLayout);
        rl_display_wall = (RelativeLayout) mView.findViewById(R.id.rl_display_wall);
        rl_exchange_wall = (RelativeLayout) mView.findViewById(R.id.rl_exchange_wall);
        rl_achievement_wall = (RelativeLayout) mView.findViewById(R.id.rl_achievement_wall);
        rl_person_center = (RelativeLayout) mView.findViewById(R.id.rl_person_center);
        img_display_wall = (ImageView) mView.findViewById(R.id.img_display_wall);
        img_exchange_wall = (ImageView) mView.findViewById(R.id.img_exchange_wall);
        img_achievement_wall = (ImageView) mView.findViewById(R.id.img_achievement_wall);
        img_person_center = (ImageView) mView.findViewById(R.id.img_person_center);
        rl_display_wall.setOnClickListener(toolbarMenuListener);
        rl_exchange_wall.setOnClickListener(toolbarMenuListener);
        rl_achievement_wall.setOnClickListener(toolbarMenuListener);
        rl_person_center.setOnClickListener(toolbarMenuListener);
    }



    View.OnClickListener toolbarMenuListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentManager fm = mToolbarActivity.getFragmentManager();
            // 开启Fragment事务
            FragmentTransaction transaction = fm.beginTransaction();
            switch (v.getId()){
                case R.id.rl_display_wall:
                    selectDisplayWall();
                    if (mDisplayWallFragment == null) {
                        mDisplayWallFragment = new DisplayWallFragment();
                    }
                    transaction.replace(R.id.main_frame, mDisplayWallFragment);
                    break;
                case R.id.rl_exchange_wall:
                    selectExchangeWall();
                    if (mExchangeWallFragment == null) {
                        mExchangeWallFragment = new ExchangeWallFragment();
                    }
                    transaction.replace(R.id.main_frame, mExchangeWallFragment);
                    break;
                case R.id.rl_achievement_wall:
                    selectAchievementWall();
                    if (mAchievementWallFragment == null) {
                        mAchievementWallFragment = new AchievementWallFragment();
                    }
                    transaction.replace(R.id.main_frame, mAchievementWallFragment);
                    break;
                case R.id.rl_person_center:
                    selectPersonCenter();
                    if (mPersonalCenterFragment == null) {
                        mPersonalCenterFragment = new PersonalCenterFragment();
                    }
                    transaction.replace(R.id.main_frame, mPersonalCenterFragment);
                    break;
            }
            // 事务提交
            transaction.commit();
            if (mMaterialMenu.getState() == MaterialMenuDrawable.IconState.BURGER) {
                mDrawerLayout.openDrawer(Gravity.START);
            } else {
                mDrawerLayout.closeDrawer(Gravity.START);
            }
        }
    };

    private void selectDisplayWall() {
        rl_display_wall.setBackgroundColor(mContext.getResources().getColor(R.color.lightgray));
        txt_display_wall.setTextColor(mContext.getResources().getColor(R.color.blueviolet));
        img_display_wall.setImageResource(R.drawable.iconfont_display_select);
        rl_exchange_wall.setBackgroundColor(mContext.getResources().getColor(R.color.white));
        txt_exchange_wall.setTextColor(mContext.getResources().getColor(R.color.grey));
        img_exchange_wall.setImageResource(R.drawable.iconfont_exchange);
        rl_achievement_wall.setBackgroundColor(mContext.getResources().getColor(R.color.white));
        txt_achievement_wall.setTextColor(mContext.getResources().getColor(R.color.grey));
        img_achievement_wall.setImageResource(R.drawable.iconfont_achievement);
        rl_person_center.setBackgroundColor(mContext.getResources().getColor(R.color.white));
        txt_person_center.setTextColor(mContext.getResources().getColor(R.color.grey));
        img_person_center.setImageResource(R.drawable.iconfont_my);
        relativeLayout.setBackgroundColor(mContext.getResources().getColor(R.color.blueviolet));
        mToolbar.setBackgroundColor(mContext.getResources().getColor(R.color.blueviolet));

        SELECTFLAG = DISPLAYWALL;
    }

    private void selectExchangeWall() {
        rl_display_wall.setBackgroundColor(mContext.getResources().getColor(R.color.white));
        txt_display_wall.setTextColor(mContext.getResources().getColor(R.color.grey));
        img_display_wall.setImageResource(R.drawable.iconfont_display);
        rl_exchange_wall.setBackgroundColor(mContext.getResources().getColor(R.color.lightgray));
        txt_exchange_wall.setTextColor(mContext.getResources().getColor(R.color.titlegreen));
        img_exchange_wall.setImageResource(R.drawable.iconfont_exchange_select);
        rl_achievement_wall.setBackgroundColor(mContext.getResources().getColor(R.color.white));
        txt_achievement_wall.setTextColor(mContext.getResources().getColor(R.color.grey));
        img_achievement_wall.setImageResource(R.drawable.iconfont_achievement);
        rl_person_center.setBackgroundColor(mContext.getResources().getColor(R.color.white));
        txt_person_center.setTextColor(mContext.getResources().getColor(R.color.grey));
        img_person_center.setImageResource(R.drawable.iconfont_my);
        relativeLayout.setBackgroundColor(mContext.getResources().getColor(R.color.titlegreen));
        mToolbar.setBackgroundColor(mContext.getResources().getColor(R.color.titlegreen));
        SELECTFLAG = EXCHANGEWALL;
    }

    private void selectAchievementWall() {
        rl_display_wall.setBackgroundColor(mContext.getResources().getColor(R.color.white));
        txt_display_wall.setTextColor(mContext.getResources().getColor(R.color.grey));
        img_display_wall.setImageResource(R.drawable.iconfont_display);
        rl_exchange_wall.setBackgroundColor(mContext.getResources().getColor(R.color.white));
        txt_exchange_wall.setTextColor(mContext.getResources().getColor(R.color.grey));
        img_exchange_wall.setImageResource(R.drawable.iconfont_exchange);
        rl_achievement_wall.setBackgroundColor(mContext.getResources().getColor(R.color.lightgray));
        txt_achievement_wall.setTextColor(mContext.getResources().getColor(R.color.yellow));
        img_achievement_wall.setImageResource(R.drawable.iconfont_achievement_select);
        rl_person_center.setBackgroundColor(mContext.getResources().getColor(R.color.white));
        txt_person_center.setTextColor(mContext.getResources().getColor(R.color.grey));
        img_person_center.setImageResource(R.drawable.iconfont_my);
        relativeLayout.setBackgroundColor(mContext.getResources().getColor(R.color.gold));
        mToolbar.setBackgroundColor(mContext.getResources().getColor(R.color.gold));
        SELECTFLAG = ACHIEVEMENTWALL;
    }

    private void selectPersonCenter() {
        rl_display_wall.setBackgroundColor(mContext.getResources().getColor(R.color.white));
        txt_display_wall.setTextColor(mContext.getResources().getColor(R.color.grey));
        img_display_wall.setImageResource(R.drawable.iconfont_display);
        rl_exchange_wall.setBackgroundColor(mContext.getResources().getColor(R.color.white));
        txt_exchange_wall.setTextColor(mContext.getResources().getColor(R.color.grey));
        img_exchange_wall.setImageResource(R.drawable.iconfont_exchange);
        rl_achievement_wall.setBackgroundColor(mContext.getResources().getColor(R.color.white));
        txt_achievement_wall.setTextColor(mContext.getResources().getColor(R.color.grey));
        img_achievement_wall.setImageResource(R.drawable.iconfont_achievement);
        rl_person_center.setBackgroundColor(mContext.getResources().getColor(R.color.lightgray));
        txt_person_center.setTextColor(mContext.getResources().getColor(R.color.titleblue));
        img_person_center.setImageResource(R.drawable.iconfont_my_select);
        relativeLayout.setBackgroundColor(mContext.getResources().getColor(R.color.titleblue));
        mToolbar.setBackgroundColor(mContext.getResources().getColor(R.color.titleblue));
        SELECTFLAG = PERSONALCENTER;
    }
}
