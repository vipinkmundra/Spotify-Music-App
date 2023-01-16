import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private List<Song> songs;
    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
    public boolean findSong(String title){
        for(Song song : songs){
            if(song.getTitle().equals(title)){
                return true;
            }
        }
        return false;
    }
    void addSongToAlbum(String title,double duration){
        Song s = new Song(title,duration);
        if(findSong(s.getTitle()) == true){
            System.out.println("Song already present in album.");
        }else{
            songs.add(s);
            System.out.println("New Song has been added");
        }
        return;
    }

    public void addToPlayListFromAlbum(String title,LinkedList<Song> playList){
        if(findSong(title) == true){
            for(Song song : songs){
                if(song.getTitle() == title){
                    playList.add(song);
                    System.out.println("Song is added into playList");
                    break;
                }
            }
        }else{
            System.out.println("Song is not their in Album");
        }
        return;
    }
    public void addToPlayListFromAlbum(int track, LinkedList<Song> playList){
        int index = track-1;
        if(index>=0 && index<songs.size()){
            playList.add(songs.get(index));
            System.out.println("Song is added into playList");
        }else{
            System.out.println("Invalid Track Number");
        }
        return;
    }
}
