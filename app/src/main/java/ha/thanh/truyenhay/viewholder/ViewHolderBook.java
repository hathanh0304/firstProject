package ha.thanh.truyenhay.viewholder;

import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import ha.thanh.truyenhay.R;

/**
 * Created by NDT on 6/29/2018.
 */

public class ViewHolderBook extends RecyclerView.ViewHolder {
    public TextView tvTitle;
    public ImageView imgAvatar;
    public TypedArray testArrayIcon;
    public ViewHolderBook(View view) {
        super(view);
        tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        imgAvatar = (ImageView) view.findViewById(R.id.imgAvatar);
    }
}
