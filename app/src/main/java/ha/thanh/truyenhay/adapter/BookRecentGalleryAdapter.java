package ha.thanh.truyenhay.adapter;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ha.thanh.truyenhay.R;
import ha.thanh.truyenhay.model.Category;
import ha.thanh.truyenhay.pinterface.BookItemClickListener;
import ha.thanh.truyenhay.pinterface.BookRecentItemClickListener;

/**
 * Created by msc10 on 16/02/2017.
 */

public class BookRecentGalleryAdapter extends RecyclerView.Adapter<BookRecentGalleryAdapter.ImageViewHolder> {

    private final BookRecentItemClickListener bookItemClick;
    private List<Category> categories;

    public BookRecentGalleryAdapter(List<Category> animalItems, BookRecentItemClickListener bookItemClick) {
        this.categories = animalItems;
        this.bookItemClick = bookItemClick;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recnet_book, parent, false));
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public void onBindViewHolder(final ImageViewHolder holder, int position) {
        final Category category = categories.get(position);

        Picasso.with(holder.itemView.getContext())
                .load(R.drawable.test)
                .into(holder.imgAvatar);
        holder.tvTitle.setText(category.getCatName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookItemClick.onAnimalRecentItemClick(holder.getAdapterPosition(), category, holder.imgAvatar, holder.tvTitle);
            }
        });
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgAvatar;
        private TextView tvTitle;

        public ImageViewHolder(View itemView) {
            super(itemView);
            imgAvatar = (ImageView) itemView.findViewById(R.id.imgAvatar);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        }
    }
}
