package cc.cnix.android_walkthrough.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import cc.cnix.android_walkthrough.R;

/**
 * @Author: wriprin
 * @Date: 2022/12/13 17:27
 * @Version 1.0
 */
public class MyGridAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public MyGridAdapter(Context context) {
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    static class ViewHolder {
        public ImageView mIvHeadShot;
        public ImageView mIvUserLevel;
        public TextView mTvUserName;
    }

    @Override
    public int getCount() {
        return 9;
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
            convertView = mLayoutInflater.inflate(R.layout.layout_grid_item, null);

            viewHolder = new ViewHolder();
            viewHolder.mIvHeadShot = convertView.findViewById(R.id.iv_01);
            viewHolder.mIvUserLevel = convertView.findViewById(R.id.iv_02);
            viewHolder.mTvUserName = convertView.findViewById(R.id.tv_01);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.mTvUserName.setText("@Wriprin");

        return convertView;
    }
}
