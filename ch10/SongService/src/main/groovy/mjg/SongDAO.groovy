package mjg;

import groovy.lang.Singleton;

@Singleton
public class SongDAO {
	def songs = [:]

    def addSong(Song s) { songs[s.id] = s }
	
	def updateSong(Song s) { songs[s.id] = s }

	def getSong(String id) { songs[id] }

	def getAllSongs() { songs.values() }

	def deleteSong(String id) { songs.remove id }

	boolean exists(String id) { songs[id] }
}
