package cc.cnix.android_walkthrough.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import cc.cnix.android_walkthrough.R;

/**
 * @Author: wriprin
 * @Date: 2022/12/14 14:12
 * @Version 1.0
 */
public class MyLinearAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;

    public MyLinearAdapter(Context context, OnItemClickListener listener) {
        this.mContext = context;
        this.mListener = listener;
    }


    @Override
    public int getItemViewType(int position) {
        if (position % 2 != 0) {
            return 0;
        } else {
            return 1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item, parent, false);
            return new LinearViewHolder(view);
        } else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.layout_linear_alter_item, parent, false);
            return new LinearViewHolderAlter(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        if (holder instanceof LinearViewHolder) {
            LinearViewHolder linearViewHolder = (LinearViewHolder) holder;
            linearViewHolder.mTvUserName.setText("@Wriprin");
            linearViewHolder.mTvUserDesc.setText("Wriprin's BLOG: https://blog.cnix.cc/");
        } else if (holder instanceof LinearViewHolderAlter) {
            LinearViewHolderAlter linearViewHolderAlter = (LinearViewHolderAlter) holder;
            linearViewHolderAlter.mTvDesc.setText("这是第二段样式");
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    /**
     * ViewHolder 0 - 个人介绍样式
     */
    class LinearViewHolder extends RecyclerView.ViewHolder {

        private TextView mTvUserName;
        private TextView mTvUserDesc;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);

            mTvUserName = itemView.findViewById(R.id.tv_01);
            mTvUserDesc = itemView.findViewById(R.id.tv_02);
        }
    }

    /**
     * ViewHolder 1 - 单段文字样式
     */
    class LinearViewHolderAlter extends RecyclerView.ViewHolder {

        private TextView mTvDesc;

        public LinearViewHolderAlter(@NonNull View itemView) {
            super(itemView);
            mTvDesc = itemView.findViewById(R.id.tv_01);
        }
    }

    public interface OnItemClickListener {
        void onClick(int pos);
    }
}