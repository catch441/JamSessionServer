package com.dhbw.jamsession.bl;

import com.dhbw.jamsession.pl.EnumEffectType;
import com.dhbw.jamsession.pl.EnumInstrumentType;
import com.dhbw.jamsession.pl.EnumTuneType;

public class SoundMessage {

	private EnumInstrumentType instrument;
	private EnumTuneType tune;
	private EnumEffectType effect;
	private EnumMessageType type;
	private boolean play;
	private int id;
	
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

	public EnumEffectType getEffect() {
		return effect;
	}

	public void setEffect(EnumEffectType effect) {
		this.effect = effect;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
