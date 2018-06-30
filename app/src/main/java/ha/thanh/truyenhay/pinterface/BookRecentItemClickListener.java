package ha.thanh.truyenhay.pinterface;
import android.widget.ImageView;
import android.widget.TextView;

import ha.thanh.truyenhay.model.Category;

/**
 * Created by msc10 on 19/02/2017.
 */

public interface BookRecentItemClickListener {
    void onAnimalRecentItemClick(int pos, Category animalItem, ImageView shareImageView, TextView textView);
}