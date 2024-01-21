package playlist;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public boolean addSong(String title, double duration) {
        if(findSong(title) == null) {
            songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    public boolean addToPlayList(int trackNumber, List<Song> playlist) {
        Song addedSong = (trackNumber > 0 && trackNumber <= songs.size()) ? songs.get(trackNumber - 1) : null;
        if(addedSong != null) {
            playlist.add(addedSong);
            return true;
        }
        return false;
    }

    public boolean addToPlayList(String title, List<Song> playlist) {
        Song addedSong = findSong(title);
        if(addedSong != null) {
            playlist.add(addedSong);
            return true;
        }
        return false;
    }

    private Song findSong(String title) {
        for(Song s : songs) {
            if(s.getTitle().equals(title))
                return s;
        }
        return null;
    }
}
