package com.brandappz.dhfl.event.fragments;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.brandappz.dhfl.event.ConferenceApp;
import com.brandappz.dhfl.event.R;
import com.brandappz.dhfl.event.adapter.SponsorsListAdapter;
import com.brandappz.dhfl.event.model.Sponsor;
import com.brandappz.dhfl.event.utils.Utils;

public class SponsorsFragment extends Fragment {

	private ConferenceApp app;
	private ListView list;
	private List<Sponsor> data;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.list, container, false);
		app = (ConferenceApp) getActivity().getApplication();

		list = (ListView) rootView.findViewById(R.id.list);
		data = app.getDbManager().getAllSponsors();
		list.setAdapter(new SponsorsListAdapter(getActivity(), data));
		list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Utils.openUrl(getActivity(), data.get(position).getWebsiteUrl());
			}
		});

		return rootView;
	}

}
