package com.dhbw.jamsession.bl;

import java.util.ArrayList;
import java.util.List;

import com.dhbw.jamsession.pl.SoundFileId;

public class Player {

	private List<SoundFileId> sounds;
	private String name;
	
	public Player(String name) {
		sounds = new ArrayList<SoundFileId>();
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SoundFileId> getSounds() {
		return sounds;
	}

	public void setSounds(List<SoundFileId> sounds) {
		this.sounds = sounds;
	}

}
