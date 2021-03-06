package com.brandappz.alpcord.events.fragments;


import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.brandappz.alpcord.events.R;


public class LocationsFragmentOld extends Fragment {
    public WebView mWebView;

    public LocationsFragmentOld() {
        // Required empty public constructor
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @SuppressWarnings("deprecation")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_quiz_leader_board, container, false);
        mWebView = (WebView) v.findViewById(R.id.webvu2);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.setInitialScale((int) (100 * mWebView.getScale()));

        final ProgressDialog dialog = ProgressDialog.show(getActivity(), "", "Please wait, Loading Page...", true);


        mWebView.setInitialScale(1);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setSupportZoom(true);
        mWebView.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);

        mWebView.getSettings().setUseWideViewPort(true);
        mWebView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        mWebView.setScrollbarFadingEnabled(false);

        mWebView.loadUrl("http://socialcampaign.co.in/apps/event_management/dhfl/quiz/dhfllocation.html");
        mWebView.setWebViewClient(new WebViewClient() {

            @SuppressWarnings("deprecation")
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                dialog.show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                dialog.dismiss();
                String webUrl = mWebView.getUrl();
            }


        });


        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);


        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
/*import android.app.Fragment;
import android.location.Location;
import android.os.Bundle;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.brandappz.dhfl.event.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;

public  class LocationsFragmentOld extends Fragment
		implements
		GooglePlayServicesClient.ConnectionCallbacks,
		GooglePlayServicesClient.OnConnectionFailedListener,
		LocationListener {
	GoogleMap map;
	LatLng latlng;
	private LocationRequest lr;
	private LocationClient lc;
	MapFragment mapFragment;
	ImageView iv;
	private static View view;

	public LocationsFragmentOld() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {

		if (view != null) {
			ViewGroup parent = (ViewGroup) view.getParent();
			if (parent != null)
				parent.removeView(view);
		}

		try {
			view = inflater.inflate(R.layout.fragment_locations, container,
					false);

			mapFragment = ((MapFragment) this.getActivity()
					.getFragmentManager().findFragmentById(R.id.map_layout));
			iv = (ImageView) view.findViewById(R.id.iv);

			map = mapFragment.getMap();
			map.getUiSettings().setAllGesturesEnabled(false);
			map.getUiSettings().setMyLocationButtonEnabled(false);
			//map.setMyLocationEnabled(true);
			map.getUiSettings().setZoomControlsEnabled(false);

			MapsInitializer.initialize(this.getActivity());
		} catch (GooglePlayServicesNotAvailableException e) {
			Toast.makeText(getActivity(), "Google Play Services missing !",
					Toast.LENGTH_LONG).show();
		} catch (InflateException e) {
			Toast.makeText(getActivity(), "Problems inflating the view !",
					Toast.LENGTH_LONG).show();
		} catch (NullPointerException e) {
			Toast.makeText(getActivity(), "Google Play Services missing !",
					Toast.LENGTH_LONG).show();
		}

		return view;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		lr = LocationRequest.create();
		lr.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
		lc = new LocationClient(this.getActivity().getApplicationContext(),
				this, this);
		lc.connect();
	}

	@Override
	public void onLocationChanged(Location l2) {
		CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(
				new LatLng(l2.getLatitude(), l2.getLongitude()), 15);
		map.animateCamera(cameraUpdate);
	}

	@Override
	public void onConnectionFailed(ConnectionResult arg0) {

	}

	@Override
	public void onConnected(Bundle connectionHint) {
		lc.requestLocationUpdates(lr, this);

	}

	@Override
	public void onDisconnected() {

	}
}*/
