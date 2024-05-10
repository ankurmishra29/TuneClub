package com.example.tuneclub.service;

import java.util.List;


import com.example.tuneclub.entity.Song;

public interface SongService {

	public String addSong(Song song);

	public boolean songExists(String name);

	public List<Song> fetchAllSong();

	public void updateSong(Song s);
}
