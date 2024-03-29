package cc.cnix.android_walkthrough.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import cc.cnix.android_walkthrough.R;

/**
 * @Author: wriprin
 * @Date: 2022/12/14 17:24
 * @Version 1.0
 */
public class MyHoriAdapter extends RecyclerView.Adapter<MyHoriAdapter.LinearViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;

    public MyHoriAdapter(Context context, OnItemClickListener listener) {
        this.mContext = context;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public MyHoriAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_hori_item, null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHoriAdapter.LinearViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.mTvUserName.setText("@Wriprin");

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

    class LinearViewHolder extends RecyclerView.ViewHolder {

        private TextView mTvUserName;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);

            mTvUserName = itemView.findViewById(R.id.tv_01);
        }
    }

    public interface OnItemClickListener {
        void onClick(int pos);
    }
}