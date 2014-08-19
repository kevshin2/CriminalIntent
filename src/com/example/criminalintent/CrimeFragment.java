package com.example.criminalintent;

import java.util.UUID;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

public class CrimeFragment extends Fragment {
	private Crime mCrime;
	private EditText mTitleField;
	private Button mDateButton;
	private CheckBox mSolvedCheckBox;
	public static final String EXTRA_CRIME_ID = "com.bignerdranch.android.criminalintent.crime_id";
	private static final String TAG = "Criminalintent";
	
	public static CrimeFragment newInstance(UUID crimeId) {
		Bundle args = new Bundle();
		args.putSerializable(EXTRA_CRIME_ID, crimeId);
		//Log.d(TAG, "before new CrimeFragment");
		CrimeFragment fragment = new CrimeFragment();
		//Log.d(TAG, "after new CrimeFragment");
		fragment.setArguments(args);
		//Log.d(TAG, "args set");
		return fragment;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Log.d(TAG, "getting ID");
		UUID crimeId = (UUID)getArguments().getSerializable(EXTRA_CRIME_ID);
		//Log.d(TAG, "args rechieved");
		mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);
	}
	
	
	@Override 
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_crime, parent, false);
		//Log.d(TAG, "oncreateview");
		mTitleField = (EditText)v.findViewById(R.id.crime_title);
		mTitleField.setText(mCrime.getTitle());
		mTitleField.addTextChangedListener(new TextWatcher() {

			@Override
			public void afterTextChanged(Editable c) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void beforeTextChanged(CharSequence c, int start,
					int count, int after) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTextChanged(CharSequence c, int start, int before,
					int count) {
				mCrime.setTitle(c.toString());
				
			}
			
		});
		
		mDateButton = (Button)v.findViewById(R.id.crime_date);
		String d = DateFormat.format("E, MMMM dd, yyyy", mCrime.getDate()).toString();
		mDateButton.setText(d);
		mDateButton.setEnabled(false);
		
		mSolvedCheckBox = (CheckBox)v.findViewById(R.id.crime_solved);
		mSolvedCheckBox.setChecked(mCrime.isSolved());
		mSolvedCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mCrime.setSolved(isChecked);
			}
		});
		
		return v;
	}
}
