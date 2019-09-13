package com.dhbw.jamsession.music;

public class SoundMessage {

	private EnumInstrumentType instrument;
	private EnumTuneType tune;
	private EnumMessageType type;
	private boolean play;
	private String sender;
	
	public SoundMessage() {
		
	}

	public EnumInstrumentType getInstrument() {
		return instrument;
	}

	public void setInstrument(EnumInstrumentType instrument) {
		this.instrument = instrument;
	}

	public EnumTuneType getTune() {
		return tune;
	}

	public void setTune(EnumTuneType tune) {
		this.tune = tune;
	}

	public EnumMessageType getType() {
		return type;
	}

	public void setType(EnumMessageType type) {
		this.type = type;
	}

	public boolean isPlay() {
		return play;
	}

	public void setPlay(boolean play) {
		this.play = play;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}
}
