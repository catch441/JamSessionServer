package com.dhbw.jamsession.bl;

import com.dhbw.jamsession.pl.SoundFileId;

public class SoundHttpEntity {

	private SoundFileId id;
	private byte[] data;
	
	public SoundHttpEntity(SoundFileId id,byte[] data) {
		this.setId(id);
		this.setData(data);
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public SoundFileId getId() {
		return id;
	}

	public void setId(SoundFileId id) {
		this.id = id;
	}
}
