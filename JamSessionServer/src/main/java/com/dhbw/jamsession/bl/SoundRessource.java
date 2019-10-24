package com.dhbw.jamsession.bl;

import com.dhbw.jamsession.pl.EnumEffectType;
import com.dhbw.jamsession.pl.EnumInstrumentType;
import com.dhbw.jamsession.pl.EnumPitchType;

public class SoundRessource {

	private EnumEffectType effect;
	private EnumPitchType pitchType;
	private EnumInstrumentType instrumentType;
	private byte[] data;
	
	public SoundRessource(EnumEffectType effect,EnumPitchType pitchType,EnumInstrumentType instrumentType,byte[] data) {
		setEffect(effect);
		setInstrumentType(instrumentType);
		setPitchType(pitchType);
		setData(data);
	}

	public EnumEffectType getEffect() {
		return effect;
	}

	public void setEffect(EnumEffectType effect) {
		this.effect = effect;
	}

	public EnumPitchType getPitchType() {
		return pitchType;
	}

	public void setPitchType(EnumPitchType pitchType) {
		this.pitchType = pitchType;
	}

	public EnumInstrumentType getInstrumentType() {
		return instrumentType;
	}

	public void setInstrumentType(EnumInstrumentType instrumentType) {
		this.instrumentType = instrumentType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
}
