package ha.thanh.truyenhay.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import ha.thanh.truyenhay.R;

/**
 * Created by VCCORP on 6/29/2018.
 */

public class IntroBookFragment extends Fragment {
    private Context context;
    public static IntroBookFragment instance;

    public static IntroBookFragment getInstance (){
        if(instance == null){
            instance = new IntroBookFragment();
        }
        return instance;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_intro_book, container, false);
        initView(view);
        initData();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView image = (ImageView) view.findViewById(R.id.image);
        image.setImageResource(R.drawable.test);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (getActivity()).onBackPressed();
            }
        });
    }
    private void initData() {

    }
    private void initView(View view) {

    }


}
