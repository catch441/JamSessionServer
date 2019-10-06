package com.dhbw.jamsession.pl;

public enum EnumEffectType {
	
	EIGHTZEROEIGHT(0),
	ACOUSTIC(1),
	NOISE(2),
	TAPE(3),
	ACOUSTIC01(4),
	ACOUSTIC02(5),
	ANALOG(6),
	DIGITAL(7),
	DIST01(8),
	DIST02(9),
	ELECTRO(10),
	PLAIN(11),
	RESO(12),
	RING(13),
	BIG(14),
	CLASSIC(15),
	CULTIVATOR(16),
	DEEP(17),
	DRY(18),
	ELECTRO01(19),
	ELECTRO02(20),
	FLOPPY(21),
	GRITTY(22),
	HEAVY(23),
	NEWWAVE(24),
	OLDSCHOOL(25),
	SLAPBACK(26),
	SOFTY(27),
	STOMB(28),
	TIGHT(29),
	TRON(30),
	VINYL01(31),
	VINYL02(32),
	ZAPPER(33),
	BLOCK(34),
	BRUTE(35),
	DIST03(36),
	LOFI01(37),
	LOFI02(38),
	MODULAR(39),
	PINCH(40),
	PUNCH(41),
	SMASHER(42),
	SUMO(43),
	CHIPTUNE(44),
	FM(45),
	LOFI(46),
	ROTOTOM(47),
	SHORT(48);
	

	int value;
	
	EnumEffectType(int value) {
		this.value = value;
	}
}
