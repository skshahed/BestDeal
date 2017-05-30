package com.example.forever.bestdeal.PostProduct;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.forever.bestdeal.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductPostFragment extends Fragment {


    public ProductPostFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_post, container, false);
    }

}
