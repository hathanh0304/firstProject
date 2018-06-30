package ha.thanh.truyenhay.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import ha.thanh.truyenhay.R;
import ha.thanh.truyenhay.activity.ReadBookActivity;
import ha.thanh.truyenhay.adapter.BookRecentGalleryAdapter;
import ha.thanh.truyenhay.db.DatabaseOpenHelper;
import ha.thanh.truyenhay.model.Category;
import ha.thanh.truyenhay.adapter.BookGalleryAdapter;
import ha.thanh.truyenhay.pinterface.BookItemClickListener;
import ha.thanh.truyenhay.pinterface.BookRecentItemClickListener;

/**
 * Created by VCCORP on 6/29/2018.
 */

public class FragmentHome extends Fragment implements View.OnClickListener, BookItemClickListener , BookRecentItemClickListener {
    public static final String TAG = FragmentHome.class.getSimpleName();
    private TextView tvTeenBook;
    private TextView tvSweetBook;
    private RecyclerView rclBookInCategory;
    private RecyclerView rclRecentBook;
    private NestedScrollView scrollView;
    private DatabaseOpenHelper databaseAccess;
    private Context context;
    private BookGalleryAdapter animalGalleryAdapter;
    private BookRecentGalleryAdapter bookRecentGalleryAdapter;

    public FragmentHome() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        initDataView();
        initData();
        return view;
    }

    private void initData() {
        databaseAccess = new DatabaseOpenHelper(context);
        databaseAccess.openDataBase();
        List<Category> categories = databaseAccess.getAllBook();
        animalGalleryAdapter = new BookGalleryAdapter(categories, this);
        bookRecentGalleryAdapter = new BookRecentGalleryAdapter(categories, this);
        rclBookInCategory.setAdapter(animalGalleryAdapter);
        rclRecentBook.setAdapter(bookRecentGalleryAdapter);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    private void initDataView() {
        GridLayoutManager layoutManager = new GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false);
        rclBookInCategory.setLayoutManager(layoutManager);
        rclBookInCategory.setNestedScrollingEnabled(false);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(context);
        layoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        rclRecentBook.setLayoutManager(layoutManager1);
        rclRecentBook.setNestedScrollingEnabled(false);
        scrollView.setNestedScrollingEnabled(false);
        tvTeenBook.setOnClickListener(this);
        tvSweetBook.setOnClickListener(this);
    }

    private void initView(View view) {
        rclBookInCategory = (RecyclerView) view.findViewById(R.id.rclBookInCategory);
        rclRecentBook = (RecyclerView) view.findViewById(R.id.rclRecentBook);
        scrollView = (NestedScrollView) view.findViewById(R.id.scrollView);
        tvTeenBook = (TextView) view.findViewById(R.id.tvTeenBook);
        tvSweetBook = (TextView) view.findViewById(R.id.tvSweetBook);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvTeenBook:
                tvSweetBook.setBackgroundColor(getResources().getColor(R.color.sweet));
                tvTeenBook.setBackgroundColor(getResources().getColor(R.color.white));
                break;
            case R.id.tvSweetBook:
                tvTeenBook.setBackgroundColor(getResources().getColor(R.color.sweet));
                tvSweetBook.setBackgroundColor(getResources().getColor(R.color.white));
                break;
        }
    }

    @Override
    public void onAnimalItemClick(int pos, Category animalItem, ImageView sharedImageView, TextView textView) {
        Fragment introBookFragment = IntroBookFragment.newInstance(ViewCompat.getTransitionName(sharedImageView), ViewCompat.getTransitionName(textView));
        getFragmentManager()
                .beginTransaction()
                .addSharedElement(sharedImageView, ViewCompat.getTransitionName(sharedImageView))
                .addSharedElement(textView, ViewCompat.getTransitionName(textView))
                .addToBackStack(TAG)
                .replace(R.id.container, introBookFragment)
                .commit();
    }

    @Override
    public void onAnimalRecentItemClick(int pos, Category animalItem, ImageView shareImageView, TextView textView) {
//        Fragment introBookFragment = ReadBookFragment.newInstance();
//        getFragmentManager()
//                .beginTransaction()
//                .addToBackStack(TAG)
//                .add(R.id.container, introBookFragment)
//                .commit();
        startActivity(new Intent(context, ReadBookActivity.class));
    }
}
