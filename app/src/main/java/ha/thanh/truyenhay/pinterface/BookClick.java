package ha.thanh.truyenhay.pinterface;

import ha.thanh.truyenhay.adapter.BookInCategoryAdapter;

/**
 * Created by VCCORP on 6/29/2018.
 */

public interface BookClick {
    void onKittenClicked(BookInCategoryAdapter.ViewHolderBook holder, int position);
}
