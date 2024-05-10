package com.example.tuneclub.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.tuneclub.entity.Song;
import com.example.tuneclub.service.SongService;

@Controller
public class SongController {

	@Autowired
	SongService songService;

	@PostMapping("/addSong")
	public String addSong(@ModelAttribute Song song) {
		boolean songStatus=songService.songExists(song.getName());
		if(songStatus==false) {
			songService.addSong(song);
			System.out.println("song added successfully");
		}
		else {
			System.out.println("Song is already exist");
		}
		return "adminhome";
	}

	@GetMapping("/viewSong")
	public String viewSong(Model model)
	{
		List<Song> songList=songService.fetchAllSong();
		System.out.println(songList);
		model.addAttribute("songs", songList);
		return "displaysong";
	}

	@GetMapping("/playSong")
	public String playSong(Model model)
	{
		boolean premium=false;
		if(premium) {
			List<Song> songList=songService.fetchAllSong();
			System.out.println(songList);
			model.addAttribute("songs", songList);
			return "displaysong";
		}
		else {
			return "subscriptionForm";
		}
	}
}