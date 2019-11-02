package com.dhbw.jamsession.pl;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SoundFileRepo extends JpaRepository<SoundFile, SoundFileId>{

	@Query("SELECT DISTINCT s.id.effect FROM SoundFile s WHERE s.id.instrumentType =:instrument")
	public ArrayList<String> getAllEffectsByInstrument(@Param("instrument") EnumInstrumentType instrument);
	
	@Query("SELECT DISTINCT s.id.effect FROM SoundFile s WHERE s.id.instrumentType =:instrument AND s.id.pitchType =:pitch")
	public ArrayList<String> getAllEffectsByInstrumentAndPitch(@Param("instrument") EnumInstrumentType instrument,
																@Param("pitch") EnumPitchType pitchType);
}
