package ha.thanh.truyenhay.fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import ha.thanh.truyenhay.R;

/**
 * Created by VCCORP on 6/29/2018.
 */

public class IntroBookFragment extends Fragment {
    private Context context;
    private static final String EXTRA_TRANSITION_NAME = "transition_name";
    private static final String EXTRA_TRANSITION_NAME1 = "transition_name1";


    public IntroBookFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        postponeEnterTransition();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setSharedElementEnterTransition(TransitionInflater.from(getContext()).inflateTransition(android.R.transition.move));
        }
    }

    public static IntroBookFragment newInstance( String transitionName, String transitionName1 ) {
        IntroBookFragment animalDetailFragment = new IntroBookFragment();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_TRANSITION_NAME, transitionName);
        bundle.putString(EXTRA_TRANSITION_NAME1, transitionName1);
        animalDetailFragment.setArguments(bundle);
        return animalDetailFragment;
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
        TextView text = (TextView) view.findViewById(R.id.text);
        image.setImageResource(R.drawable.test);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (getActivity()).onBackPressed();
            }
        });
        String transitionName = getArguments().getString(EXTRA_TRANSITION_NAME);
        String transitionName1 = getArguments().getString(EXTRA_TRANSITION_NAME1);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            image.setTransitionName(transitionName);
            text.setTransitionName(transitionName1);
        }
        Picasso.with(getContext())
                .load(R.drawable.test)
                .noFade()
                .into(image, new Callback() {
                    @Override
                    public void onSuccess() {
                        startPostponedEnterTransition();
                    }

                    @Override
                    public void onError() {
                        startPostponedEnterTransition();
                    }
                });
        text.setText(transitionName1);
    }
    private void initData() {

    }
    private void initView(View view) {

    }


}
