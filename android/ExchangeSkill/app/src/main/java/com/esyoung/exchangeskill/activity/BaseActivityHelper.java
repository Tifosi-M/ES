package com.esyoung.exchangeskill.activity;

import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;

import com.esyoung.exchangeskill.R;
import com.esyoung.exchangeskill.materialmenu.MaterialMenu;
import com.esyoung.exchangeskill.materialmenu.MaterialMenuDrawable;

import java.util.Random;
import static com.esyoung.exchangeskill.materialmenu.MaterialMenuDrawable.IconState;

public class BaseActivityHelper {

	private MaterialMenu materialIcon;
	private DrawerLayout drawerLayout;
	private boolean direction;
    private Toolbar toolbar;
	public void init(View parent, MaterialMenu actionBarIcon) {

		materialIcon = actionBarIcon;
        toolbar = (Toolbar) parent.findViewById(R.id.toolbar);
		drawerLayout = ((DrawerLayout) parent.findViewById(R.id.drawer_layout));
		drawerLayout.setScrimColor(Color.parseColor("#66000000"));
		drawerLayout.setDrawerListener(new DrawerLayout.SimpleDrawerListener() {

			@Override
			public void onDrawerSlide(View drawerView, float slideOffset) {
				materialIcon.setTransformationOffset(
						MaterialMenuDrawable.AnimationState.BURGER_ARROW,
						direction ? 2 - slideOffset : slideOffset);
			}

			@Override
			public void onDrawerOpened(View drawerView) {
                toolbar.setTitle(R.string.common_drawer_title_district);
                direction = true;
			}

			@Override
			public void onDrawerClosed(View drawerView) {
                switch (ToolbarMenu.SELECTFLAG) {
                    case ToolbarMenu.DISPLAYWALL:
                        toolbar.setTitle(R.string.common_drawer_display_district);
                        break;
                    case ToolbarMenu.EXCHANGEWALL:
                        toolbar.setTitle(R.string.common_drawer_exchange_district);
                        break;
                    case ToolbarMenu.ACHIEVEMENTWALL:
                        toolbar.setTitle(R.string.common_drawer_achievement_district);
                        break;
                    case ToolbarMenu.PERSONALCENTER:
                        toolbar.setTitle(R.string.common_drawer_personalcenter_district);
                        break;
                    default:
                        break;
                }
				direction = false;
			}
		});

	}

	public void refreshDrawerState() {
		this.direction = drawerLayout.isDrawerOpen(Gravity.START);
	}
}
