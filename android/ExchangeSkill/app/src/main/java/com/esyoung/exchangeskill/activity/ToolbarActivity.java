package com.esyoung.exchangeskill.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;

import com.esyoung.exchangeskill.R;
import com.esyoung.exchangeskill.fragment.DisplayWallFragment;
import com.esyoung.exchangeskill.materialmenu.MaterialMenuDrawable;
import com.esyoung.exchangeskill.materialmenu.extras.toolbar.MaterialMenuIconToolbar;

import static com.esyoung.exchangeskill.materialmenu.MaterialMenuDrawable.Stroke;


public class ToolbarActivity extends ActionBarActivity {

    private MaterialMenuIconToolbar materialMenu;
    private DrawerLayout drawerLayout;
    protected BaseActivityHelper helper;
    private Toolbar toolbar;
    private RelativeLayout drawer;
    private DisplayWallFragment mDisplayWallFragment;
    private ToolbarActivity mToolbarActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar);
        initView();
    }

    private void initView() {
        mToolbarActivity = this;
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.common_drawer_exchange_district);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        setDefaultFragment();
        drawer = (RelativeLayout) findViewById(R.id.drawer);
        drawerLayout = ((DrawerLayout) findViewById(R.id.drawer_layout));
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (materialMenu.getState() == MaterialMenuDrawable.IconState.BURGER) {
                    drawerLayout.openDrawer(Gravity.START);
                } else {
                    drawerLayout.closeDrawer(Gravity.START);
                }
            }
        });
        materialMenu = new MaterialMenuIconToolbar(this, Color.WHITE, Stroke.THIN) {
            @Override
            public int getToolbarViewId() {
                return R.id.toolbar;
            }
        };
        materialMenu.setNeverDrawTouch(true);
        helper = new BaseActivityHelper();
        helper.init(getWindow().getDecorView(), materialMenu);
        new ToolbarMenu(drawerLayout,this,toolbar,drawerLayout,materialMenu,mToolbarActivity);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        helper.refreshDrawerState();
        materialMenu.syncState(savedInstanceState);
    }

    @Override protected void onSaveInstanceState(Bundle outState) {
        materialMenu.onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    private void setDefaultFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mDisplayWallFragment = new DisplayWallFragment();
        transaction.replace(R.id.main_frame, mDisplayWallFragment);
        transaction.commit();
    }
}
