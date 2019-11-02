package com.dhbw.jamsession.pl;

public enum EnumPitchType {
	
	C_1(1),
	CIS_DES_1(2),
	D_1(3),
	DIS_ES_1(4),
	E_1(5),
	F_1(6),
	FIS_GES_1(7),
	G_1(8),
	GIS_AS_1(9),
	A_1(10),
	AIS_B_1(11),
	H_1(12),
	C_2(13),
	CIS_DES_2(14),
	D_2(15),
	DIS_ES_2(16),
	E_2(17),
	F_2(18),
	FIS_GES_2(19),
	G_2(20),
	GIS_AS_2(21),
	A_2(22),
	AIS_B_2(23),
	H_2(24),
	C_3(25),
	CIS_DES_3(26),
	D_3(27),
	DIS_ES_3(28),
	E_3(29),
	F_3(30),
	FIS_GES_3(31),
	G_3(32),
	GIS_AS_3(33),
	A_3(34),
	AIS_B_3(35),
	H_3(36),
	C_4(37),
	CIS_DES_4(38),
	D_4(39),
	DIS_ES_4(40),
	E_4(41),
	F_4(42),
	FIS_GES_4(43),
	G_4(44),
	GIS_AS_4(45),
	A_4(46),
	AIS_B_4(47),
	H_4(48),
	C_5(49),
	CIS_DES_5(50),
	D_5(51),
	DIS_ES_5(52),
	E_5(53),
	F_5(54),
	FIS_GES_5(55),
	G_5(56),
	GIS_AS_5(57),
	A_5(58),
	AIS_B_5(59),
	H_5(60),
	
	CRASH(61),
	HITHAT(62),
	KICK(63),
	SNARE(64),
	TOM(65);
	
	int value;
	
	EnumPitchType(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public static EnumPitchType fromValue(int value) {
		for(EnumPitchType pitchType:EnumPitchType.values()) {
			if(pitchType.getValue() == value) {
				return pitchType;
			}
		}
		return null;
	}
}
