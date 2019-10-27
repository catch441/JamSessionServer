package com.dhbw.jamsession.pl;

public enum EnumInstrumentType {

	DRUM(1),
	BANJO(2),
	BASSATTACK(3),
	BD(4),
	BELL(5),
	BIT(6),
	COWBELL(7),
	DIDGERIDOO(8),
	FLUTE(9),
	HARP(10),
	ICECHIME(11),
	IRON_XYLOTHON(12),
	XYLOPHON(13);
	
	int value;
	
	EnumInstrumentType(int value) {
		this.value = value;
	}
}
