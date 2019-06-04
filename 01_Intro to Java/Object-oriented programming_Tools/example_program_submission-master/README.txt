project folder:
example_program_submission/


Brief description of submitted files:

src/example/MP3.java
    - One object of class MP3 stores a simplified version of a song's properties.

src/example/MyTunes.java
    - One object of class MyTunes parses a CSV file.
    - Each row is stored as an entry in an array of MP3 objects.
    - Includes main() for debugging.
    

src/example/MyPlaylist.java
    - The main application.
    - Allows the user to create a playlist of songs by searching or directly adding.
    - Includes main() for running the application.

resources/songs.csv
    - A CSV (Comma Separated Value) file.
    - First row contains the number of song entries and the number of properties for each song.
    - Lines 2 to EOF (end of file) contain properties for each song in the format:
      title,artist,genre,year

RUN.txt
    - console output of MyTunes.java and MyPlayList.java

README.txt
    - description of submitted files
