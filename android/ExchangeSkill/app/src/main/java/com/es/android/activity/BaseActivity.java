package com.es.android.activity;

import net.simonvt.menudrawer.MenuDrawer;
import net.simonvt.menudrawer.Position;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.es.android.R;
import com.es.android.utils.ActivityUtility;

public class BaseActivity extends Activity {
	private static final String TAG = "BaseActivity";
	
	
	private View mSuperContentView;
	private ViewGroup mContentView;
	
	/* 导航栏 */
	private TextView mTitle;
	private Button mLeftButton;
	private Button mRightButton;
	private Button mExtendButton;
	private RelativeLayout mNavbarContainer;
	
	/* 抽屉菜单 */
	private static final String STATE_MENUDRAWER = "net.simonvt.menudrawer.samples.WindowSample.menuDrawer";
    private static final String STATE_ACTIVE_VIEW_ID = "net.simonvt.menudrawer.samples.WindowSample.activeViewId";
	private MenuDrawer mMenuDrawer;
    private int mActiveViewId;
    
    @SuppressLint("InflateParams")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		if (savedInstanceState != null) {
            mActiveViewId = savedInstanceState.getInt(STATE_ACTIVE_VIEW_ID);
        }
		mSuperContentView = getLayoutInflater().inflate(R.layout.base_activity, null);
	    super.setContentView(this.mSuperContentView);
	    findViews(this.mSuperContentView);
	    setListener();
	    initMenuDrawer();
	}
    
    public void setContentView(int layoutResid) {
    	mContentView.removeAllViews();
        ((LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(layoutResid, this.mContentView, true);
        onContentChanged();
    }
    
    public void setContentView(View view) {
    	mContentView.removeAllViews();
        mContentView.addView(view);
        onContentChanged();
    }
    
    public void setContentView(View view, ViewGroup.LayoutParams layoutPara)
    {
        mContentView.removeAllViews();
        mContentView.addView(view, layoutPara);
        onContentChanged();
    }
    
	private void findViews(View v) {
		mContentView = (ViewGroup) findViewById(R.id.base_content);
		mTitle = (TextView) findViewById(R.id.base_navigationbar_title);
		mLeftButton = (Button) findViewById(R.id.base_navigationbar_left_btn);
		mRightButton = (Button) findViewById(R.id.base_navigationbar_right_btn);
		mExtendButton = (Button) findViewById(R.id.base_navigationbar_extend_btn);
		mNavbarContainer = (RelativeLayout) findViewById(R.id.navigation_bar);
	}
	
	private void setListener() {
		
		mLeftButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mMenuDrawer.openMenu();
			}
		});
	}

	

	protected TextView getTitleView() {
		return mTitle;
	}
	
	protected void setTitleViewText(String s) {
		if (mTitle != null) {
			mTitle.setText(s);
		}
	}

	protected Button getLeftButton() {
		return mLeftButton;
	}
	
	protected void setLeftButtonBg(int resid) {
		if (mLeftButton != null) {
			mLeftButton.setBackgroundResource(resid);
		}
	}
	
	@SuppressWarnings("deprecation")
	protected void setLeftButtonBg(Drawable background) {
		if (mLeftButton != null) {
			mLeftButton.setBackgroundDrawable(background);
		}
	}
	
	protected void hideLeftButton() {
		if (mLeftButton != null) {
			mLeftButton.setVisibility(View.INVISIBLE);
		}
	}

	protected Button getRightButton() {
		return mRightButton;
	}
	
	protected void setRightButtonBg(int resid) {
		if (mRightButton != null) {
			mRightButton.setBackgroundResource(resid);
		}
	}
	
	@SuppressWarnings("deprecation")
	protected void setRightButtonBg(Drawable background) {
		if (mRightButton != null) {
			mRightButton.setBackgroundDrawable(background);
		}
	}
	
	protected void hideRightButton() {
		if (mRightButton != null) {
			mRightButton.setVisibility(View.INVISIBLE);
		}
	}

	protected Button getExtendButton() {
		return mExtendButton;
	}
	
	protected void setExtendButtonBg(int resid) {
		if (mExtendButton != null) {
			mExtendButton.setBackgroundResource(resid);
		}
	}
	
	@SuppressWarnings("deprecation")
	protected void setExtendButtonBg(Drawable background) {
		if (mExtendButton != null) {
			mExtendButton.setBackgroundDrawable(background);
		}
	}
	
	protected void hideExtendButton() {
		if (mExtendButton != null) {
			mExtendButton.setVisibility(View.INVISIBLE);
		}
	}
	
	protected void setNavbarBg(int resid) {
		if (mNavbarContainer != null) {
			mNavbarContainer.setBackgroundResource(resid);
		}
	}
	
	protected void setNavbarBgFromColor(int color) {
		if (mNavbarContainer != null) {
			mNavbarContainer.setBackgroundColor(color);;
		}
	}
	
	private OnClickListener mOnMenudrawerItemClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			int oldActivityViewId = mActiveViewId;
			mMenuDrawer.setActiveView(v);
	        mMenuDrawer.closeMenu();
	        mActiveViewId = v.getId();
	        
	        switch (mActiveViewId) {
	        case R.id.menu_drawer_top:
	        	mActiveViewId = oldActivityViewId;
				mMenuDrawer.setActiveView(BaseActivity.this.findViewById(mActiveViewId));
	        	return;
	        case R.id.menu_drawer_display_district:
	        	gotoDisplayDistrict();
	        	break;
	        case R.id.menu_drawer_exchange_district:
	        	gotoExchangeDisplayActivity();
	        	break;
	        case R.id.menu_drawer_achievement_district:
	        	gotoAchievementActivity();
	        	break;
	        case R.id.menu_drawer_system_configure_district:
	        	gotoSystemConfigure();
	        	break;
	        case R.id.menu_drawer_contactus_district:
	        	gotoContactActivity();
	        	break;
	        case R.id.menu_drawer_social_share_district:
	        	gotoSocialShareActivity();
	        	break;
	        case R.id.menu_drawer_personal_center:
	        	gotoPersonalCenterActivity();
	        	break;
	        }
	        BaseActivity.this.finish();
		}
	};
	
	private void gotoPersonalCenterActivity(){
		Intent intent = new Intent();
        intent.setClass(BaseActivity.this, PersonalCenterActivity.class); 
        startActivity(intent);
	}
	
	private void gotoSocialShareActivity(){
		Intent intent = new Intent();
        intent.setClass(BaseActivity.this, SocialShareActivity.class); 
        startActivity(intent);
	}
	
	private void gotoContactActivity(){
		Intent intent = new Intent();
        intent.setClass(BaseActivity.this, ContactEicActivity.class); 
        startActivity(intent);
	}
	
	protected void gotoDisplayDistrict() {
		Intent intent = new Intent();
        intent.setClass(BaseActivity.this, DisplayActivity.class); 
        startActivity(intent);
	}
	
	protected void gotoSystemConfigure() {
		Intent intent = new Intent();
        intent.setClass(BaseActivity.this, SystemConfigureActivity.class); 
        startActivity(intent);
	}
	
	protected void gotoExchangeDisplayActivity() {
		Intent intent = new Intent();
        intent.setClass(BaseActivity.this, ExchangeDisplayActivity.class); 
        startActivity(intent);
	}
	
	protected void gotoAchievementActivity() {
		Intent intent = new Intent();
        intent.setClass(BaseActivity.this, ExchangeAchievementActivity.class); 
        startActivity(intent);
	}
	
	
	
	@Override
    protected void onRestoreInstanceState(Bundle inState) {
        super.onRestoreInstanceState(inState);
        mMenuDrawer.restoreState(inState.getParcelable(STATE_MENUDRAWER));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(STATE_MENUDRAWER, mMenuDrawer.saveState());
        outState.putInt(STATE_ACTIVE_VIEW_ID, mActiveViewId);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mMenuDrawer.toggleMenu();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        final int drawerState = mMenuDrawer.getDrawerState();
        if (drawerState == MenuDrawer.STATE_OPEN || drawerState == MenuDrawer.STATE_OPENING) {
            mMenuDrawer.closeMenu();
            return;
        }

        super.onBackPressed();
    }
	
	private void initMenuDrawer() {
    	mMenuDrawer = MenuDrawer.attach(this, MenuDrawer.Type.BEHIND, Position.LEFT, MenuDrawer.MENU_DRAG_WINDOW);
        //mMenuDrawer.setContentView(R.layout.base_activity); 
        mMenuDrawer.setMenuView(R.layout.menu_scrollview);
        
        int screenWidth = ActivityUtility.getScreenSize(this).x;
        mMenuDrawer.setMenuSize((int)(screenWidth * 0.6));
        mMenuDrawer.setDropShadowEnabled(false);
        
        Log.d(TAG, "screen width: " + screenWidth);
       

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            //getActionBar().setDisplayHomeAsUpEnabled(true);
        }
        findViewById(R.id.menu_drawer_top).setOnClickListener(mOnMenudrawerItemClickListener);
        findViewById(R.id.menu_drawer_display_district).setOnClickListener(mOnMenudrawerItemClickListener);
        findViewById(R.id.menu_drawer_exchange_district).setOnClickListener(mOnMenudrawerItemClickListener);
        findViewById(R.id.menu_drawer_achievement_district).setOnClickListener(mOnMenudrawerItemClickListener);
        findViewById(R.id.menu_drawer_system_configure_district).setOnClickListener(mOnMenudrawerItemClickListener);
        findViewById(R.id.menu_drawer_contactus_district).setOnClickListener(mOnMenudrawerItemClickListener);
        findViewById(R.id.menu_drawer_social_share_district).setOnClickListener(mOnMenudrawerItemClickListener);
        findViewById(R.id.menu_drawer_personal_center).setOnClickListener(mOnMenudrawerItemClickListener);

        TextView activeView = (TextView) findViewById(mActiveViewId);
        if (activeView != null) {
            mMenuDrawer.setActiveView(activeView);
            //mContentTextView.setText("Active item: " + activeView.getText());
        }
    }
}