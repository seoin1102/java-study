package chapter3;

public class SongApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Song song = new Song();
		song.setTitle("좋은 날");
		song.setArtist("아이유");
		song.setComposer("이민수");
		song.setAlbum("Real");
		song.setYear(2010);
		song.setTrack(3);
		
		song.show();
		
	}

}
