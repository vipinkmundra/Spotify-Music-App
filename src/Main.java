import java.util.*;

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
        album1.addToPlayListFromAlbum("BlockBuster",myPlayList);
        album1.addToPlayListFromAlbum("295",myPlayList);
        album2.addToPlayListFromAlbum("Keshriya",myPlayList);
        album2.addToPlayListFromAlbum("Gerua",myPlayList);

        play(myPlayList);
    }

    public static void play(LinkedList<Song> playList){
        ListIterator<Song> itr = playList.listIterator();
        Scanner sc = new Scanner(System.in);

        boolean isForward = false;

        if(playList.size()>0){
            System.out.println("Currently Playing.");
            System.out.println(itr.next());
            isForward = true;
        }else{
            System.out.println("PlayList is empty.");
            return;
        }
        System.out.println("Enter your choice");
        printMenu();

        boolean quit = false;
        while(!quit){
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    if(isForward == false){
                        itr.next();
                        isForward = true;
                    }
                    if(itr.hasNext()){
                        System.out.println(itr.next());
                    }else{
                        System.out.println("You are at the end of playList.");
                        isForward = false;
                    }
                    break;
                case 2:
                    if(isForward == true){
                        itr.previous();
                        isForward = false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println(itr.previous());
                    }else{
                        System.out.println("You are at the start of playList.");
                        isForward = true;
                    }
                    break;
                case 3:
                    if(isForward == true){
                        if(itr.hasPrevious()){
                            System.out.println(itr.previous());
                            isForward = false;
                        }
                    }else{
                        if(itr.hasNext()){
                            System.out.println(itr.next());
                            isForward = true;
                        }
                    }
                    break;
                case 4:
                    printMenu();
                    break;
                case 5:
                    break;
                case 6:
                    printSongs(playList);
                    break;
                case 7:
                    quit = true;
                    break;
            }
        }

    }
    public static void printMenu(){
        System.out.println("1 - Play next song");
        System.out.println("2 - Play previous song");
        System.out.println("3 - Repeat the current song");
        System.out.println("4 - Show menu again");
        System.out.println("5 - Delete the current song");
        System.out.println("6 - Print all the songs in playlist");
        System.out.println("7 - Exit");

        return;
    }

    public static void printSongs(LinkedList<Song> playList){
        for(Song song : playList){
            System.out.println(song);
        }
        return;
    }
}