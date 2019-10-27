package com.dhbw.jamsession.bl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dhbw.jamsession.exception.JamSessionException;
import com.dhbw.jamsession.pl.EnumEffectType;
import com.dhbw.jamsession.pl.EnumInstrumentType;
import com.dhbw.jamsession.pl.EnumPitchType;
import com.dhbw.jamsession.pl.SoundFileId;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
public class HttpRequestController {
	
	//returns all sound id's for a JamSession
	@ApiOperation(value = "returns all sound id's for a JamSession")
	@GetMapping("/jamSessionSoundsIds")
	public ResponseEntity<List<SoundFileId>> getSessionSoundIds(@RequestParam String jamSessionName, @RequestParam String player) {
		JamSession session = JamSession.getJamSessionByName(jamSessionName);
		if(session.hasPlayer(player)) {
			return new ResponseEntity<List<SoundFileId>>(session.getSoundIds(),HttpStatus.OK);
		} else {
			throw new JamSessionException("This player is not in this JamSession!");
		}
	}

	// returns all soundfiles for a JamSession
	@ApiOperation(value = "returns one soundfile by id")
	@GetMapping("/jamSessionSoundFiles")
	public ResponseEntity<InputStreamResource> getSessionSoundFile(@RequestParam EnumInstrumentType instrumentType,
			@RequestParam EnumPitchType pitchType, @RequestParam EnumEffectType effectType) {
		InputStreamResource resource = new InputStreamResource(JamSession.getSound(instrumentType,pitchType,effectType));
		return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("audio/wav"))
                .body(resource);
	}

	// adds sounds to a player in a JamSession
	@ApiOperation(value = "adds sounds to a player in a JamSession")
	@PostMapping("/jamSessionSounds")
	public void addSoundsToPlayer(@RequestParam String jamSessionName, @RequestParam String player,
			@RequestBody List<SoundFileId> sounds) {
		JamSession session = JamSession.getJamSessionByName(jamSessionName);
		if (session.hasPlayer(player)) {
			session.addSoundsToSessionPlayer(player, sounds);
		} else {
			throw new JamSessionException("This player is not in this JamSession!");
		}
	}

	// returns all active session names
	@ApiOperation(value = "returns all active session names")
	@GetMapping("/jamSessions")
	public List<String> getAllSessions() {
		List<String> list = new ArrayList<String>();
		for (JamSession session : JamSession.getJamSessions()) {
			list.add(session.getSessionName());
		}
		return list;
	}

	// returns all active session names
	@ApiOperation(value = "returns all available effects")
	@GetMapping("/effects")
	public EnumEffectType[] getAllEffects() {
		return EnumEffectType.values();
	}

	// returns all available instruments
	@ApiOperation(value = "returns all available instruments")
	@GetMapping("/instruments")
	public EnumInstrumentType[] getAllInstruments() {
		return EnumInstrumentType.values();
	}

	// returns all available pitches
	@ApiOperation(value = "returns all available pitches")
	@GetMapping("/pitches")
	public EnumPitchType[] getAllPitches() {
		return EnumPitchType.values();
	}

}
