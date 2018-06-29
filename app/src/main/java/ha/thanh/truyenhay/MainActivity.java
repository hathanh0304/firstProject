package ha.thanh.truyenhay;

import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import ha.thanh.truyenhay.adapter.BookInCategoryAdapter;
import ha.thanh.truyenhay.db.DatabaseOpenHelper;
import ha.thanh.truyenhay.fragment.FragmentHome;
import ha.thanh.truyenhay.model.Category;

public class MainActivity extends AppCompatActivity /*implements View.OnClickListener*/{
//    private TextView tvTeenBook;
//    private TextView tvSweetBook;
//    private RecyclerView rclBookInCategory;
//    private RecyclerView rclRecentBook;
//    private BookInCategoryAdapter recentBookAdapter;
//    private BookInCategoryAdapter bookInCategoryAdapter;
//    private NestedScrollView scrollView;
//    private DatabaseOpenHelper databaseAccess;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new FragmentHome())
                    .commit();
        }


//        databaseAccess = new DatabaseOpenHelper(this);
//        databaseAccess.openDataBase();
//
//        List<Category> categories = databaseAccess.getAllBook();
//        recentBookAdapter = new BookInCategoryAdapter(this, categories, 0);
//        bookInCategoryAdapter = new BookInCategoryAdapter(this, categories, 1);
//        rclBookInCategory.setAdapter(bookInCategoryAdapter);
//        rclRecentBook.setAdapter(recentBookAdapter);
    }

    private void initData() {
//        GridLayoutManager layoutManager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
//        rclBookInCategory.setLayoutManager(layoutManager);
//        rclBookInCategory.setNestedScrollingEnabled(false);
//        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this);
//        layoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
//        rclRecentBook.setLayoutManager(layoutManager1);
//        rclRecentBook.setNestedScrollingEnabled(false);
//        scrollView.setNestedScrollingEnabled(false);
//        tvTeenBook.setOnClickListener(this);
//        tvSweetBook.setOnClickListener(this);

    }

    private void initView() {
//        rclBookInCategory = (RecyclerView) findViewById(R.id.rclBookInCategory);
//        rclRecentBook = (RecyclerView) findViewById(R.id.rclRecentBook);
//        scrollView = (NestedScrollView) findViewById(R.id.scrollView);
//        tvTeenBook = (TextView) findViewById(R.id.tvTeenBook);
//        tvSweetBook = (TextView) findViewById(R.id.tvSweetBook);
    }



//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.tvTeenBook:
//                tvSweetBook.setBackgroundColor(getResources().getColor(R.color.sweet));
//                tvTeenBook.setBackgroundColor(getResources().getColor(R.color.white));
//                break;
//            case R.id.tvSweetBook:
//                tvTeenBook.setBackgroundColor(getResources().getColor(R.color.sweet));
//                tvSweetBook.setBackgroundColor(getResources().getColor(R.color.white));
//                break;
//        }
//    }
}
