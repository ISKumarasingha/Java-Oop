// Create Performance Class
public class Performance {
    private String mainArtist;
    private String performanceName;
    private String venue;
    private int year;

    public Performance(String performanceName, String mainArtist, int year, String venue) {
        this.mainArtist = mainArtist;
        this.performanceName = performanceName;
        this.venue = venue;
        this.year = year;
    }
    
    public String getMainArtist() {
        return mainArtist;
    }

    public String getPerformanceName() {
        return performanceName;
    }

    public String getVenue() {
        return venue;
    }

    public int getYear() {
        return year;
    }
}

// Performance Classes.
// 1) Live_Performance Class including Performance Class.
class LivePerformance extends Performance {
    public LivePerformance(String performanceName, String mainArtist, int year, String venue) {
        super(performanceName, mainArtist, year, venue);
        System.out.println("Welcome to the Performance " + performanceName + " by " + mainArtist + "!\n");
    }

    public void interectAudience() {
        System.out.println("They can interact with audience.");
    }
}

// 2) Studio_Performance Class including Performance Class.
class StudioPerformance extends Performance {
    public StudioPerformance(String performanceName, String mainArtist, int year, String venue) {
        super(performanceName, mainArtist, year, venue);
        System.out.println("Welcome to the Performance " + performanceName + " by " + mainArtist + "!");
    }

    public void audioProcessing() {
        System.out.println("They can interact with audience.");
    }
}
