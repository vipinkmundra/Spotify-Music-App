import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class Main {
    public static List<Album> albums = new ArrayList<>();
    public static void main(String[] args) {
        Album album1 = new Album("Musa","Sidhu MussaWala");
        album1.addSongToAlbum("295",4.05);
        album1.addSongToAlbum("BlockBuster",10.01);
        album1.addSongToAlbum("Last Ride",3.05);

        Album album2 = new Album("Arigit's Song","Arigit singh");
        album2.addSongToAlbum("Keshriya",4.55);
        album2.addSongToAlbum("Jeena Jeena",6.01);
        album2.addSongToAlbum("Gerua",3.05);

        albums.add(album1);
        albums.add(album2);

        System.out.println(album2.findSong("Keshriya"));

        LinkedList<Song> myPlayList = new LinkedList<>();
        album1.addToPlayListFromAlbum(1,myPlayList);
        album1.addToPlayListFromAlbum("295",myPlayList);
    }
}