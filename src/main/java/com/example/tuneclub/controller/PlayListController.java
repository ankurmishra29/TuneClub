package com.example.tuneclub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.tuneclub.entity.PlayList;
import com.example.tuneclub.entity.Song;
import com.example.tuneclub.service.PlayListService;
import com.example.tuneclub.service.SongService;

@Controller
public class PlayListController {

	@Autowired
	SongService songService;
	
	@Autowired
	PlayListService playListService;
	
	@GetMapping("/createPlayList")
	public String createPlayList(Model model) {
		List<Song> songList=songService.fetchAllSong();
		model.addAttribute("songs",songList);
		return "createplaylist";
	}
	
	@PostMapping("/addPlayList")
	public String addPlayList(@ModelAttribute PlayList playList) {
		//updating playlist table
		playListService.addPlayList(playList);
		
		//updating the song table
		List<Song> songList=playList.getSongs();
		for(Song s: songList) {
			s.getPlaylists().add(playList);
			songService.updateSong(s);
		}
		System.out.println("playlist added successfull");
		return "adminhome";
	}
	
	@GetMapping("/viewPlayList")
	public String viewPlayList(Model model)
	{
		List<PlayList> playList=playListService.fetchAllPlayList();
		System.out.println(playList);
		model.addAttribute("playlists", playList);
		return "displayplaylist";
	}
}
