package com.dhbw.jamsession.pl;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="SoundFile.findAll", query="SELECT f FROM SoundFile f")
public class SoundFile {
	
	@EmbeddedId
	private SoundFileId id;

	@Column(name = "file")
	private Blob file;
	
	public SoundFile(SoundFileId id,Blob file) {
		setId(id);
		setFile(file);
	}

	public SoundFileId getId() {
		return id;
	}

	public void setId(SoundFileId id) {
		this.id = id;
	}

	public Blob getFile() {
		return file;
	}

	public void setFile(Blob file) {
		this.file = file;
	}
	
}
