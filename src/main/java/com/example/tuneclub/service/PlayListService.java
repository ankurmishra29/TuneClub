package com.example.tuneclub.service;

import java.util.List;


import com.example.tuneclub.entity.PlayList;

public interface PlayListService {

   public void addPlayList(PlayList playList);

   public List<PlayList> fetchAllPlayList();

   

}
