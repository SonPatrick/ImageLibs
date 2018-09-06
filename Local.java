package ufopa.edu.br.imagelibs;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public class Local extends Fragment {
    private int URL = R.drawable.thor;
    private ImageView glideImage;
    private ImageView picassoImage;
    private Button loadButton;
    private View view;

    @SuppressLint("NewApi")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.root_layout, container, false);

        glideImage = view.findViewById(R.id.glide_imageView);
        picassoImage = view.findViewById(R.id.picasso_imageView);
        loadButton = view.findViewById(R.id.button_load);

        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadImages();
            }
        });

        return view;
    }

    public void loadImages(){

        Glide.with(getActivity())
                .load(URL)
                .error(R.color.colorErrorGlide)
                .into(glideImage);

        Picasso.with(getActivity())
                .load(URL)
                .error(R.color.colorErrorPicasso)
                .into(picassoImage);
    }
}