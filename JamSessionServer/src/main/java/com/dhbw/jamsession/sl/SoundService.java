package com.dhbw.jamsession.sl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhbw.jamsession.exception.NonResultException;
import com.dhbw.jamsession.pl.EnumEffectType;
import com.dhbw.jamsession.pl.EnumInstrumentType;
import com.dhbw.jamsession.pl.EnumPitchType;
import com.dhbw.jamsession.pl.SoundFile;
import com.dhbw.jamsession.pl.SoundFileId;
import com.dhbw.jamsession.pl.SoundFileRepo;

@Service
public class SoundService {

	@Autowired
	SoundFileRepo repo;
	
	public SoundFile getSoundById(EnumInstrumentType instrumentType,EnumPitchType tuneType,EnumEffectType effectType) {
		SoundFileId id = new SoundFileId(effectType, tuneType, instrumentType);
		Optional<SoundFile> output = repo.findById(id);
		if(output.isPresent()) {
			return output.get();
		} else {
			throw new NonResultException("No soundfile found!");
		}
	}
}
