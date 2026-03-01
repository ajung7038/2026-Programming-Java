import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Genre> mp = new HashMap<>();
        
        for (int i=0; i<genres.length; i++) {
            Genre genre;
            if (!mp.containsKey(genres[i])) {
                genre = new Genre(genres[i]);
                mp.put(genres[i], genre);
            } else {
                genre = mp.get(genres[i]);
            }
            genre.playTotal += plays[i];
            genre.vsPlaysOrAdd(plays[i], i);
        }
        
        List<Genre> mapKeySet = new ArrayList<>(mp.values());
        mapKeySet.sort((o1, o2) -> {
            return o2.playTotal - o1.playTotal;
        });
        
        // 결과 출력
        List<Integer> result = new ArrayList<>();
        for (Genre genre : mapKeySet) {
            result.add(genre.musicList.getFirst().index);
            if (genre.musicList.size() > 1) {
                result.add(genre.musicList.getLast().index);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public static class Genre {
        String name;
        int playTotal=0;
        Deque<Music> musicList = new LinkedList<>();
        
        public Genre(String name) {
            this.name = name;
        }
        
        public void vsPlaysOrAdd(int play, int index) {
            // 길이가 0
                // 맨앞에 추가
            // 길이가 1 이상 && plays[0]보다 크면
                // 맨 앞에 추가
                // 0 -> 1 미루기
            // 길이가 2 이상 && (plays[1]보다 크거나 plays[0]과 같으면)
                // plays[1] = play
            if (musicList.size() == 0) {
                musicList.addFirst(new Music(play, index));
            } else if (musicList.size() == 1) {
                if (musicList.getFirst().play < play) {
                    musicList.addFirst(new Music(play, index));
                } else musicList.addLast(new Music(play, index));
            } else if (musicList.size() == 2) {
                int beforePlay1 = musicList.getFirst().play;
                int beforePlay2 = musicList.getLast().play;
                if (beforePlay1 < play) {
                    musicList.addFirst(new Music(play, index));
                    musicList.removeLast();
                } else if (beforePlay2 < play) {
                    musicList.removeLast();
                    musicList.addLast(new Music(play, index));
                }
            }
        }
    }
    
    public static class Music {
        int play;
        int index;
        
        public Music(int play, int index) {
            this.play = play;
            this.index = index;
        }
    }
}