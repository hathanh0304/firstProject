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
import ha.thanh.truyenhay.model.Story;
import ha.thanh.truyenhay.pinterface.BookItemClickListener;

/**
 * Created by msc10 on 16/02/2017.
 */

public class PreviewBookAdapter extends RecyclerView.Adapter<PreviewBookAdapter.ImageViewHolder> {

    private List<Story> stories;

    public PreviewBookAdapter(List<Story> stories) {
        this.stories = stories;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_preview_book, parent, false));
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public void onBindViewHolder(final ImageViewHolder holder, int position) {
        final Story story = stories.get(position);
        holder.tvTitle.setText(story.getTitle().split(":")[0]);
        holder.tvPreview.setText(story.getTitle().split(":")[1]);
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private TextView tvPreview;
        public ImageViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvPreview = (TextView) itemView.findViewById(R.id.tvPreview);
        }
    }
}
