package cc.cnix.android_walkthrough.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import cc.cnix.android_walkthrough.R;

/**
 * @Author: wriprin
 * @Date: 2022/12/14 17:24
 * @Version 1.0
 */
public class MyStaggerAdapter extends RecyclerView.Adapter<MyStaggerAdapter.LinearViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;

    public MyStaggerAdapter(Context context, OnItemClickListener listener) {
        this.mContext = context;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public MyStaggerAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_stagger_item, null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyStaggerAdapter.LinearViewHolder holder, @SuppressLint("RecyclerView") int position) {
        if (position % 2 != 0) {
            holder.mIvShow.setImageResource(R.drawable.bg_01);
        } else {
            holder.mIvShow.setImageResource(R.drawable.bg_02);
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
        return 16;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder {

        private ImageView mIvShow;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);

            mIvShow = itemView.findViewById(R.id.iv_01);
        }
    }

    public interface OnItemClickListener {
        void onClick(int pos);
    }
}