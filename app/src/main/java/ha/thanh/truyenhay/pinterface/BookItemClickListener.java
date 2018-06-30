package ha.thanh.truyenhay.pinterface;
import android.widget.ImageView;
import android.widget.TextView;

import ha.thanh.truyenhay.model.Category;

/**
 * Created by msc10 on 19/02/2017.
 */

public interface BookItemClickListener {
    void onAnimalItemClick(int pos, Category animalItem, ImageView shareImageView, TextView textView);
}