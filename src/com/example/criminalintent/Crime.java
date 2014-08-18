package com.example.criminalintent;

import java.util.Date;
import java.util.UUID;

public class Crime {
	private UUID mid;
	private String mTitle;
	private Date mDate;
	private boolean mSolved;
	
	public Crime() {
		//Genereate unique identifier
		mid = UUID.randomUUID();
		mDate = new Date();
	}

	public Date getDate() {
		return mDate;
	}

	public void setDate(Date date) {
		mDate = date;
	}

	public boolean isSolved() {
		return mSolved;
	}

	public void setSolved(boolean solved) {
		mSolved = solved;
	}

	public String getTitle() {
		return mTitle;
	}
	
	@Override
	public String toString() {
		return mTitle;
	}

	public void setTitle(String title) {
		mTitle = title;
	}

	public UUID getId() {
		return mid;
	}

}
