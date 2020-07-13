package com.duke.yinyangli.base;

import android.content.Context;
import android.view.View;

import com.duke.yinyangli.bean.MainInfoModel;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }

}
