package com.dhbw.jamsession.pl;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class SoundFileId implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "effect")
	@Enumerated(EnumType.STRING)
	private EnumEffectType effect;
	
	@Column(name = "tune")
	@Enumerated(EnumType.STRING)
	private EnumPitchType pitchType;
	
	@Column(name = "instrumental_type")
	@Enumerated(EnumType.STRING)
	private EnumInstrumentType instrumentType;
	
	public SoundFileId() {
		
	}
	
	public SoundFileId(EnumEffectType effect,EnumPitchType pitchType, EnumInstrumentType instrumentType) {
		setEffect(effect);
		setInstrumentType(instrumentType);
		setPitchType(pitchType);
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
}
