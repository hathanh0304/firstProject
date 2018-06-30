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

/**
 * Created by msc10 on 16/02/2017.
 */

public class BookGalleryAdapter extends RecyclerView.Adapter<BookGalleryAdapter.ImageViewHolder> {

    private final BookItemClickListener bookItemClick;
    private List<Category> categories;

    public BookGalleryAdapter(List<Category> animalItems, BookItemClickListener bookItemClick) {
        this.categories = animalItems;
        this.bookItemClick = bookItemClick;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_book, parent, false));
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
        ViewCompat.setTransitionName(holder.imgAvatar, category.getCatId());
        ViewCompat.setTransitionName(holder.tvTitle, category.getCatName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookItemClick.onAnimalItemClick(holder.getAdapterPosition(), category, holder.imgAvatar, holder.tvTitle);
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
