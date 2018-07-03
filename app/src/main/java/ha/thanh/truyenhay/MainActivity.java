package ha.thanh.truyenhay;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import ha.thanh.truyenhay.fragment.FragmentHome;

public class MainActivity extends AppCompatActivity {

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
    }
    private void initData() {

    }
    private void initView() {

    }

}
