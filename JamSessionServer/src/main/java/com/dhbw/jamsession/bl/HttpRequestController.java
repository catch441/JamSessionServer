package com.dhbw.jamsession.bl;

import java.io.File;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dhbw.jamsession.exception.JamSessionException;
import com.dhbw.jamsession.pl.SoundFileId;

@CrossOrigin
@RestController
public class HttpRequestController {

	//returns all soundfiles for a JamSession
	@GetMapping("/jamSessionSounds")
	public List<File> getSessionSoundFiles(@RequestParam String jamSessionName, @RequestParam String player) {
		JamSession session = JamSession.getJamSessionByName(jamSessionName);
		if(session.hasPlayer(player)) {
			return session.getSoundFilesForClient();
		} else {
			throw new JamSessionException("This player is not in this JamSession!");
		}
	}
	
	//adds sounds to a player in a JamSession
	@PostMapping("/jamSessionSounds\"")
	public void addSoundsToPlayer(@RequestParam String jamSessionName, @RequestParam String player,@RequestBody List<SoundFileId> sounds) {
		JamSession session = JamSession.getJamSessionByName(jamSessionName);
		if(session.hasPlayer(player)) {
			session.addSoundsToSessionPlayer(player, sounds);
		} else {
			throw new JamSessionException("This player is not in this JamSession!");
		}
	}
	
	//get all sessions
	
	//get all effects
	
	//get all instruments
	
	//get all tunes
	
}