package ha.thanh.truyenhay.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ha.thanh.truyenhay.R;
import ha.thanh.truyenhay.model.Category;
import ha.thanh.truyenhay.pinterface.BookClick;

/**
 * Created by VCCORP on 6/28/2018.
 */


public class BookInCategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private int TYPE_ITEM = 0;
    private LayoutInflater layoutInflater;
    private Context context;
    private int recent = 0;
    private List<Category> categories = new ArrayList<>();
    private  BookClick mListener;


    public BookInCategoryAdapter(Context context, List<Category> categories, int recent, BookClick mListener ) {
        this.context = context;
        this.categories = categories;
        this.recent = recent;
        layoutInflater = LayoutInflater.from(context);
        this.mListener = mListener;
    }


    @Override
    public int getItemViewType(int position) {
        return TYPE_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            View view;
            if(recent == 0) {
                view = layoutInflater.inflate(R.layout.item_recnet_book, null);
            }else {
                view = layoutInflater.inflate(R.layout.item_book, null);
            }
            return new ViewHolderBook(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            Category category = categories.get(position);
            if (holder instanceof ViewHolderBook) {
                ViewCompat.setTransitionName(((ViewHolderBook) holder).imgAvatar, String.valueOf(position) + "_image");
                ((ViewHolderBook) holder).setData(category, position);

            }


    }

    @Override
    public int getItemCount() {
        if(categories == null){
            return 0;
        }else {
            return categories.size();
        }
    }


    public class ViewHolderBook extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvTitle;
        public ImageView imgAvatar;
        private TypedArray testArrayIcon;
        private ViewHolderBook(View view) {
            super(view);
            tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            imgAvatar = (ImageView) view.findViewById(R.id.imgAvatar);
            testArrayIcon = context.getResources().obtainTypedArray(R.array.image);

        }

        private void setData(Category data, final int position) {
            tvTitle.setText(data.getCatName());
            imgAvatar.setBackgroundResource(testArrayIcon.getResourceId(0, -1));
            imgAvatar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mListener.onKittenClicked(ViewHolderBook.this, position);
                }
            });
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
            }
        }
    }
}
