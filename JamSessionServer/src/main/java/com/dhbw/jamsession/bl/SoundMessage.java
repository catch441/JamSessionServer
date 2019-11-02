package com.dhbw.jamsession.bl;

import com.dhbw.jamsession.pl.EnumEffectType;
import com.dhbw.jamsession.pl.EnumInstrumentType;
import com.dhbw.jamsession.pl.EnumPitchType;

public class SoundMessage {

	private EnumInstrumentType instrument;
	private EnumPitchType tune;
	private EnumEffectType effect;
	private EnumMessageType type;
	
	public SoundMessage() {
		
	}

	public EnumInstrumentType getInstrument() {
		return instrument;
	}

	public void setInstrument(EnumInstrumentType instrument) {
		this.instrument = instrument;
	}

	public EnumPitchType getTune() {
		return tune;
	}

	public void setTune(EnumPitchType tune) {
		this.tune = tune;
	}

	public EnumMessageType getType() {
		return type;
	}

	public void setType(EnumMessageType type) {
		this.type = type;
	}

	public EnumEffectType getEffect() {
		return effect;
	}

	public void setEffect(EnumEffectType effect) {
		this.effect = effect;
	}
}
