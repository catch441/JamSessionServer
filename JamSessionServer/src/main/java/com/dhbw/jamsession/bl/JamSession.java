package com.dhbw.jamsession.bl;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dhbw.jamsession.exception.JamSessionException;
import com.dhbw.jamsession.pl.EnumEffectType;
import com.dhbw.jamsession.pl.EnumInstrumentType;
import com.dhbw.jamsession.pl.EnumPitchType;
import com.dhbw.jamsession.pl.SoundFile;
import com.dhbw.jamsession.pl.SoundFileId;
import com.dhbw.jamsession.sl.ServiceManager;
import com.dhbw.jamsession.sl.SoundService;

public class JamSession implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static List<JamSession> jamSessions = new ArrayList<JamSession>();

	public static void createNewJamSession(String name, String passwordhash, String leader) {
		for (JamSession session : jamSessions) {
			if (session.getSessionName().equals(name)) {
				throw new JamSessionException("This session name already exists!");
			}
		}
		JamSession session = new JamSession(name, passwordhash, leader);
		jamSessions.add(session);
	}

	public static void deleteJamSession(JamSession session) {
		jamSessions.remove(session);
	}

	public static boolean sessionExists(String name) {
		for (JamSession session : jamSessions) {
			if (session.getSessionName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	public static JamSession getJamSessionByName(String name) {
		for (JamSession session : jamSessions) {
			if (session.getSessionName().equals(name)) {
				return session;
			}
		}
		throw new JamSessionException("No JamSession found!");
	}

	public static List<JamSession> getJamSessions() {
		return jamSessions;
	}
	
	public static InputStream getSound(EnumInstrumentType instrumentType,
			EnumPitchType pitchType, EnumEffectType effectType) {
		try {
			return ServiceManager.getService(SoundService.class).getSoundById(instrumentType,
					pitchType, effectType).getFile().getBinaryStream();
		} catch (SQLException e) {
			throw new JamSessionException(e.getMessage());
		}
	}
	
	public static ArrayList<String> getAllEffectsByInstrument(EnumInstrumentType instrumentType) {
		return ServiceManager.getService(SoundService.class).getAllEffectsByInstrument(instrumentType);
	}
	
	public static ArrayList<String> getAllEffectsForDrumByInstrumentAndPitch(EnumPitchType pitchType) {
		return ServiceManager.getService(SoundService.class).getAllEffectsForDrumByInstrumentAndPitch(pitchType);
	}

	private String sessionName;
	private String passwordhash;
	private List<Player> players;
	private List<SoundFile> soundFiles;

	public JamSession(String sessionName, String passwordhash, String leader) {
		players = new ArrayList<>();
		soundFiles = new ArrayList<>();
		setSessionName(sessionName);
		setPasswordhash(passwordhash);
		players.add(new Player(leader));
	}

	public String getSessionName() {
		return sessionName;
	}

	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}

	public int getSessionPlayerSize() {
		return players.size();
	}

	public boolean hasPlayer(String name) {
		for (Player player : players) {
			if (player.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	public void addPlayer(String name) {
		for (Player player : players) {
			if (player.getName().equals(name)) {
				throw new JamSessionException("This player is already in this session!");
			}
		}
		players.add(new Player(name));
	}

	public Player getPlayer(String name) {
		for (Player player : players) {
			if (player.getName().equals(name)) {
				return player;
			}
		}
		throw new JamSessionException("No player found!");
	}

	public void removePlayer(String name) {
		Player player = null;
		for (Player p : players) {
			if (p.getName().equals(name)) {
				player = p;
			}
		}
		if (player != null) {
			players.remove(player);
		} else {
			throw new JamSessionException("This player is not in this session!");
		}
	}

	public void addSoundsToSessionPlayer(String name, List<SoundFileId> sounds) {
		for (SoundFileId id : sounds) {
			boolean exists = false;
			for (SoundFile soundFile : soundFiles) {
				if (!exists && soundFile.getId().equals(id)) {
					exists = true;
				}
			}
			Player player = getPlayer(name);
			if (player.getSounds().contains(id)) {
				throw new JamSessionException("This player has already this sound!");
			} else {
				if (!exists) {
					soundFiles.add(ServiceManager.getService(SoundService.class).getSoundById(id.getInstrumentType(),
							id.getPitchType(), id.getEffect()));
					player.getSounds().add(id);
				} else {
					throw new JamSessionException("This sound is already used!");
				}

			}
		}
	}

	public void removeSoundsFromSessionPlayer(String name, List<SoundFileId> sounds) {
		for (SoundFileId id : sounds) {
			boolean exists = false;
			for (SoundFile soundFile : soundFiles) {
				if (!exists && soundFile.getId().equals(id)) {
					exists = true;
				}
			}
			Player player = getPlayer(name);
			if (exists && !player.getSounds().contains(id)) {
				throw new JamSessionException("This player doesn't have this sound!");
			} else if (exists) {
				player.getSounds().remove(id);
			} else {
				throw new JamSessionException("This session doesn't have this sound!");
			}
		}
	}

	public String getPasswordhash() {
		return passwordhash;
	}

	public void setPasswordhash(String passwordhash) {
		this.passwordhash = passwordhash;
	}
	
	public List<SoundFileId> getSoundIds() {
		List<SoundFileId> list = new ArrayList<>();
		for (SoundFile sound : soundFiles) {
			list.add(sound.getId());
		}
		return list;
	}
}
