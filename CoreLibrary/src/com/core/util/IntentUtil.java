package com.core.util;

import com.core.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * @author miaoxin.ye
 * @createdate 2013-12-15 下午1:03:18
 * @Description: Intent工具类
 */
public class IntentUtil {
	
	public static void intentForward(Context context,Class<?> cls){
		context.startActivity(new Intent(context, cls));
	}

	public static void intentForward(Context context,Intent intent){
		context.startActivity(intent);
	}

	public static void intentFowardResult(Fragment fragment,Intent intent,int requestCode){
		fragment.startActivityForResult(intent, requestCode);
	}
	
	public static void intentForward(Context context,Class<?> cls,Intent intent){
		context.startActivity(intent.setClass(context, cls));
	}
	
	public static void intentFowardResult(Activity activity,Intent intent,int requestCode){
		activity.startActivityForResult(intent, requestCode);
	}
	
	/**
	 * @Description: 跳转前判断网络
	 * @param context
	 * @param intent
	 */
	public static void intentForwardNetWork(Context context,Class<?> cls){
		if(!NetWorkUtil.NETWORK){
			ToastUtil.showToastMessage(context,context.getString(R.string.not_network));
			return;
		}
		intentForward(context, cls);
	}
	
	/**
	 * @Description: 跳转前判断网络
	 * @param context
	 * @param intent
	 */
	public static void intentForwardNetWork(Context context,Intent intent){
		if(!NetWorkUtil.NETWORK){
			ToastUtil.showToastMessage(context,context.getString(R.string.not_network));
			return;
		}
		intentForward(context, intent);
	}
	
	/**
	 * @Description: 跳转前判断网络
	 * @param context
	 * @param intent
	 */
	public static void intentForwardNetWork(Context context,Class<?> cls,Intent intent){
		if(!NetWorkUtil.NETWORK){
			ToastUtil.showToastMessage(context,context.getString(R.string.not_network));
			return;
		}
		intentForward(context, cls, intent);
	}
	
	/**
	 * @Description: 跳转前判断网络,有返回值
	 * @param activity
	 * @param intent
	 * @param requestCode
	 */
	public static void intentFowardResultNetWork(Activity activity,Intent intent,int requestCode){
		if(!NetWorkUtil.NETWORK){
			ToastUtil.showToastMessage(activity,activity.getString(R.string.not_network));
			return;
		}
		intentFowardResult(activity, intent, requestCode);
	}
	
	/**
	 * @Description: 返回主页
	 * @param activity
	 * @param cls
	 */
	public static void goHome(Activity activity,Class<?> cls){
		Intent intent=new Intent();
		intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		intentForward(activity, cls, intent);
		activity.finish();
	}
	
}
