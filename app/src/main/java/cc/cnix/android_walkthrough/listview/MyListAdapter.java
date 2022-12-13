package cc.cnix.android_walkthrough.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import cc.cnix.android_walkthrough.R;

/**
 * @Author: wriprin
 * @Date: 2022/12/13 15:20
 * @Version 1.0
 */
public class MyListAdapter extends BaseAdapter {

    // 接收传入的 Context 对象（系统环境信息）
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public MyListAdapter(Context context) {
        this.mContext = context;
        /**
         * LayoutInflater.from() 是 Android 开发框架中的一个方法
         * 它用于创建一个新的 LayoutInflater 对象
         * LayoutInflater 是一个用于将布局文件（通常是 XML 格式的布局文件）转换成视图对象的类
         * 这个视图对象可以被添加到活动或者其他容器中，以便在应用程序的用户界面中显示
         */
        mLayoutInflater = LayoutInflater.from(context);
    }

    /**
     * 构建 Adapter 填充对象属性
     */
    static class ViewHolder {
        public ImageView ivHeadShot;
        public ImageView ivUserLevel;
        public TextView tvUserName;
        public TextView tvUserCondition;
        public TextView tvDescription;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            /**
             * mLayoutInflater.inflate() 是 Android 框架中的一个方法
             * 它可以用来将一个布局文件加载并创建为 View 对象
             * 该方法接收两个参数：布局文件的资源 ID 和一个父视图，然后返回一个新创建的 View 对象
             */
            // 拿到 layout_list_item 对象
            convertView = mLayoutInflater.inflate(R.layout.layout_list_item, null);

            // 实例化 ViewHolder，对应属性存储控件
            viewHolder = new ViewHolder();
            viewHolder.ivHeadShot = convertView.findViewById(R.id.iv_01);
            viewHolder.ivUserLevel = convertView.findViewById(R.id.iv_02);
            viewHolder.tvUserName = convertView.findViewById(R.id.tv_01);
            viewHolder.tvUserCondition = convertView.findViewById(R.id.tv_02);
            viewHolder.tvDescription = convertView.findViewById(R.id.tv_03);

            // 绑定
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // 控件属性赋值
        viewHolder.tvUserName.setText("@Wriprin");
        viewHolder.tvUserCondition.setText("Simple Life");
        viewHolder.tvDescription.setText("Wriprin's BLOG: https://blog.cnix.cc");

        return convertView;
    }
}
