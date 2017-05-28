package com.example.vihaan.whatsappclone.ui.chatscreen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;

import com.example.vihaan.whatsappclone.R;

/**
 * Created by vihaan on 22/05/17.
 */

public class ChatFragment extends Fragment {

    public static ChatFragment newInstance() {

        Bundle args = new Bundle();

        ChatFragment fragment = new ChatFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    private void initViews()
    {
        initMessageBar();
    }


    FloatingActionButton mFabButton;

    private void initMessageBar()
    {
        EditText editText = (EditText) getView().findViewById(R.id.editText);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("edit text", "before changed");
                Log.d("s ", s.toString());
                Log.d("count", count+"");
                Log.d("after", after+"");

                if(s.length() == 0)
                {
                        showSendButton();
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                Log.d("edit text", "on text changed");
            }

            @Override
            public void afterTextChanged(Editable s) {

                if(s.length() == 0)
                {
                    showAudioButton();
                }
                Log.d("edit text", "after text changed");
            }
        });


        mFabButton = (FloatingActionButton) getView().findViewById(R.id.floatingButton);
        mFabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tag = (String) mFabButton.getTag();
                Log.d("fab tag" , tag);

            }
        });
    }

    private static final String SEND_IMAGE = "send_image";
    private void showSendButton()
    {
        mFabButton.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.input_send));
        mFabButton.setTag(SEND_IMAGE);
    }

    private static final String MIC_IMAGE= "mic_image";
    private void showAudioButton()
    {
        mFabButton.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.input_mic_white));
        mFabButton.setTag(MIC_IMAGE);
    }
}
