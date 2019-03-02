package com.example.lishuaizhe32.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.lishuaizhe32.R;
import com.example.lishuaizhe32.activity.XiangQingActivity;
import com.example.lishuaizhe32.callback.cartCallback;
import com.example.lishuaizhe32.entiey.OneBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class OneAdapter extends RecyclerView.Adapter<OneAdapter.ViewHolder> {

    private Context context;

    private List<OneBean.ResultBean> list;

    private OnItemClickListener onItemClickListener;

    private     cartCallback cartCallback;


    public OneAdapter(Context context, List<OneBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =LayoutInflater.from(context).inflate(R.layout.onesize1,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final OneBean.ResultBean resultBean = list.get(i);
        viewHolder.name.setText(resultBean.commodityName);
        viewHolder.image.setImageURI(resultBean.pic);
        viewHolder.jiage.setText(resultBean.price+"");
        viewHolder.text1.setText(resultBean.count+"");
        viewHolder.xuanze.setChecked(resultBean.isChecked);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,XiangQingActivity.class);
                intent.putExtra("zzz",resultBean.commodityId+"");
                context.startActivity(intent);
            }
        });

        viewHolder.jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        viewHolder.jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView text1;
        private final TextView jiage;
        private final TextView jian;
        private final TextView jia;
        private final SimpleDraweeView image;
        private final CheckBox xuanze;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            xuanze = itemView.findViewById(R.id.xuanze);
            image = itemView.findViewById(R.id.image);
            jiage = itemView.findViewById(R.id.jiage);
            jian = itemView.findViewById(R.id.jian);
            text1 = itemView.findViewById(R.id.text1);
            jia = itemView.findViewById(R.id.jia);

        }
    }

    public static interface OnItemClickListener {
        void onItemClick(View view);
        void onItemLongClick(View view);
    }

}
