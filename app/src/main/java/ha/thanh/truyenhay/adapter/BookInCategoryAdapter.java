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
import ha.thanh.truyenhay.viewholder.ViewHolderBook;

/**
 * Created by VCCORP on 6/28/2018.
 */


public class BookInCategoryAdapter extends RecyclerView.Adapter<ViewHolderBook> {
    private int TYPE_ITEM = 0;
    private LayoutInflater layoutInflater;
    private Context context;
    private int recent = 0;
    private List<Category> categories = new ArrayList<>();
    private BookClick mListener;


    public BookInCategoryAdapter(Context context, List<Category> categories, int recent, BookClick mListener) {
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
    public ViewHolderBook onCreateViewHolder(ViewGroup container, int position) {
        View view;
        if (recent == 0) {
            view = layoutInflater.inflate(R.layout.item_recnet_book, null);
        } else {
            view = layoutInflater.inflate(R.layout.item_book, null);
        }
        return new ViewHolderBook(view);
    }


    @Override
    public void onBindViewHolder(final ViewHolderBook holder, final int position) {
        Category category = categories.get(position);
        holder.testArrayIcon = context.getResources().obtainTypedArray(R.array.image);
        holder.tvTitle.setText(category.getCatName());
        holder.imgAvatar.setBackgroundResource(holder.testArrayIcon.getResourceId(0, -1));
        ViewCompat.setTransitionName(holder.imgAvatar, "simple_fragment_transition");
        holder.imgAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onKittenClicked(holder, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (categories == null) {
            return 0;
        } else {
            return 11;
        }
    }
}
