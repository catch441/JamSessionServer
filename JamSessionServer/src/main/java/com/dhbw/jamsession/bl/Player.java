package com.dhbw.jamsession.bl;

import java.util.ArrayList;
import java.util.List;

import com.dhbw.jamsession.pl.SoundFileId;

public class Player {

	private List<SoundFileId> sounds;
	private String name;
	private boolean isLeader;
	
	public Player(String name,boolean isLeader) {
		sounds = new ArrayList<SoundFileId>();
		setName(name);
		setLeader(isLeader);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isLeader() {
		return isLeader;
	}

	public void setLeader(boolean isLeader) {
		this.isLeader = isLeader;
	}

	public List<SoundFileId> getSounds() {
		return sounds;
	}

	public void setSounds(List<SoundFileId> sounds) {
		this.sounds = sounds;
	}

}
