package com.example.tuneclub.serviceimpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tuneclub.entity.PlayList;
import com.example.tuneclub.repository.PlayListRepository;
import com.example.tuneclub.service.PlayListService;

@Service
public class PlayListServiceImpl implements PlayListService {
    
	@Autowired
	PlayListRepository playListRepository;
	
	@Override
	public void addPlayList(PlayList playList) {
		playListRepository.save(playList);
	}
	
	@Override
	public List<PlayList> fetchAllPlayList(){
		return playListRepository.findAll();
	}
	
}
