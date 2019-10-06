package com.dhbw.jamsession.pl;

import java.io.File;

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
	private File file;

	public SoundFileId getId() {
		return id;
	}

	public void setId(SoundFileId id) {
		this.id = id;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
}
