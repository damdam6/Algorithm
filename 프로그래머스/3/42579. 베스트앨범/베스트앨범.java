import java.util.*;

public class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlayCount = new HashMap<>();
        List<Song> songs = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);
            songs.add(new Song(i, genres[i], plays[i]));
        }

        // 장르별 총 재생 횟수에 따라 정렬
        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((a, b) -> genrePlayCount.get(b).compareTo(genrePlayCount.get(a)));

        List<Integer> answerList = new ArrayList<>();
        for (String genre : sortedGenres) {
            // 해당 장르의 노래들을 재생 횟수와 고유 번호에 따라 정렬
            List<Song> filteredSongs = new ArrayList<>();
            for (Song song : songs) {
                if (song.genre.equals(genre)) {
                    filteredSongs.add(song);
                }
            }

            Collections.sort(filteredSongs, (a, b) -> {
                if (a.playCount == b.playCount) {
                    return a.id - b.id;
                }
                return b.playCount - a.playCount;
            });

            // 최대 두 개의 노래 선택
            for (int i = 0; i < Math.min(filteredSongs.size(), 2); i++) {
                answerList.add(filteredSongs.get(i).id);
            }
        }

        // 리스트를 배열로 변환하여 반환
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    class Song {
        int id;
        String genre;
        int playCount;

        public Song(int id, String genre, int playCount) {
            this.id = id;
            this.genre = genre;
            this.playCount = playCount;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(solution.solution(genres, plays)));
    }
}
