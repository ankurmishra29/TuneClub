package com.example.tuneclub.serviceimpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tuneclub.entity.Song;
import com.example.tuneclub.repository.SongRepository;
import com.example.tuneclub.service.SongService;

@Service
public class SongServiceImpl implements SongService {

	@Autowired
	SongRepository songRepository;
	
	@Override
	public String addSong(Song song) {
		songRepository.save(song);
		return "song added successfully";
	}
	
	@Override
	public boolean songExists(String name) {
		Song song=songRepository.findByName(name);
		if(song==null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	@Override
	public List<Song> fetchAllSong(){
		return songRepository.findAll(); 
	}
	
	@Override
	public void updateSong(Song s) {
		songRepository.save(s);
	}
}
