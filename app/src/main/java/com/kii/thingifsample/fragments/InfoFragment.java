package com.kii.thingifsample.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.kii.thingif.ThingIFAPI;
import com.kii.thingifsample.MainActivity;
import com.kii.thingifsample.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment {

    private ThingIFAPI api;

    public InfoFragment() {
        // Required empty public constructor
    }
    public static InfoFragment newFragment(ThingIFAPI api) {
        InfoFragment fragment = new InfoFragment();
        Bundle arguments = new Bundle();
        arguments.putParcelable("ThingIFAPI", api);
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("ThingIFAPI", this.api);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            this.api = savedInstanceState.getParcelable("ThingIFAPI");
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.api = arguments.getParcelable("ThingIFAPI");
        }
        View view = inflater.inflate(R.layout.info_view, null);
        Button logoutButton = (Button)view.findViewById(R.id.logout_button);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThingIFAPI.removeAllStoredInstances();
                Intent i = new Intent();
                i.setClass(getContext().getApplicationContext(), MainActivity.class);
                startActivityForResult(i, 0);
            }
        });
        TextView textOwner = (TextView)view.findViewById(R.id.textOwner);
        if (this.api.getOwner() != null) {
            textOwner.setText(this.api.getOwner().getTypedID().getID());
        }
        TextView textTarget = (TextView)view.findViewById(R.id.textTarget);
        if (this.api.getTarget() != null) {
            textTarget.setText(this.api.getTarget().getTypedID().getID());
        }
        TextView textInstallationID = (TextView)view.findViewById(R.id.textInstallationID);
        if (this.api.getInstallationID() != null) {
            textInstallationID.setText(this.api.getInstallationID());
        }
        return view;
    }
}
