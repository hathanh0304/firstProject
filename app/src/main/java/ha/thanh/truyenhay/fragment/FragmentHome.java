package ha.thanh.truyenhay.fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ha.thanh.truyenhay.DetailsTransition;
import ha.thanh.truyenhay.R;
import ha.thanh.truyenhay.adapter.BookInCategoryAdapter;
import ha.thanh.truyenhay.db.DatabaseOpenHelper;
import ha.thanh.truyenhay.model.Category;
import ha.thanh.truyenhay.pinterface.BookClick;
import ha.thanh.truyenhay.simple_fragment_to_fragment.SimpleFragmentA;
import ha.thanh.truyenhay.simple_fragment_to_fragment.SimpleFragmentB;
import ha.thanh.truyenhay.viewholder.ViewHolderBook;

/**
 * Created by VCCORP on 6/29/2018.
 */

public class FragmentHome extends Fragment implements BookClick, View.OnClickListener{
    public static final String TAG = SimpleFragmentA.class.getSimpleName();
    private TextView tvTeenBook;
    private TextView tvSweetBook;
    private RecyclerView rclBookInCategory;
    private RecyclerView rclRecentBook;
    private BookInCategoryAdapter recentBookAdapter;
    private BookInCategoryAdapter bookInCategoryAdapter;
    private NestedScrollView scrollView;
    private DatabaseOpenHelper databaseAccess;
    private Context context;

    private ImageView imgTest;


    public FragmentHome (){

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
        initData();

        databaseAccess = new DatabaseOpenHelper(context);
        databaseAccess.openDataBase();

        List<Category> categories = databaseAccess.getAllBook();
        recentBookAdapter = new BookInCategoryAdapter(context, categories, 0, this);
        bookInCategoryAdapter = new BookInCategoryAdapter(context, categories, 1, this);
        rclBookInCategory.setAdapter(bookInCategoryAdapter);
        rclRecentBook.setAdapter(recentBookAdapter);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    private void initData() {
        GridLayoutManager layoutManager = new GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false);
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
//        ViewCompat.setTransitionName(imgTest,  "1_image");
    }


    @Override
    public void onKittenClicked(ViewHolderBook holder, int position) {
//        int kittenNumber = (position % 6) + 1;
//        IntroBookFragment kittenDetails = IntroBookFragment.newInstance(kittenNumber);
//        // Note that we need the API version check here because the actual transition classes (e.g. Fade)
//        // are not in the support library and are only available in API 21+. The methods we are calling on the Fragment
//        // ARE available in the support library (though they don't do anything on API < 21)
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            kittenDetails.setSharedElementEnterTransition(new DetailsTransition());
//            kittenDetails.setEnterTransition(new Fade());
//            setExitTransition(new Fade());
//            kittenDetails.setSharedElementReturnTransition(new DetailsTransition());
//        }
//        getActivity().getSupportFragmentManager()
//                .beginTransaction()
//                .addSharedElement(holder.imgAvatar,  "kittenImage")
//                .replace(R.id.container, kittenDetails)
//                .addToBackStack(null)
//                .commit();


        SimpleFragmentB simpleFragmentB = SimpleFragmentB.newInstance();
        getFragmentManager()
                .beginTransaction()
                .addSharedElement(holder.imgAvatar, ViewCompat.getTransitionName(holder.imgAvatar))
                .addToBackStack(TAG)
                .replace(R.id.container, simpleFragmentB)
                .commit();
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvTeenBook:
                tvSweetBook.setBackgroundColor(getResources().getColor(R.color.sweet));
                tvTeenBook.setBackgroundColor(getResources().getColor(R.color.white));
                break;
            case R.id.tvSweetBook:
                tvTeenBook.setBackgroundColor(getResources().getColor(R.color.sweet));
                tvSweetBook.setBackgroundColor(getResources().getColor(R.color.white));
                break;

//            case R.id.imgTest:
//
//                break;
        }
    }
}
