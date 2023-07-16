public class Assesmnet {
    public static void main(String[] args) throws Exception {

        LivePerformance L1 = new LivePerformance("Eras Tour", "Taylor Swift",2023, "Glendale");
        L1.interectAudience();

        System.out.println(L1.getYear() + " is the Year ");
        System.out.println(L1.getVenue() + " is the place ");

        // Create Music tracks
        MusicTrack T1 = new MusicTrack("Lavender Haze", 55);
        MusicTrack T2 = new MusicTrack("All Too Well", 65);
        MusicTrack T3 = new MusicTrack("the lakes", 75);
        MusicTrack T4 = new MusicTrack("The Man", 85);
        MusicTrack T5 = new MusicTrack("Love Story", 45);

        BackupSinger backup_singer1 = new BackupSinger("Jeslyn");
        BackupSinger backup_singer2 = new BackupSinger("Melanie");
        backup_singer1.backup();
        backup_singer1.sing();
        backup_singer2.backup();
        backup_singer2.sing();

        BackupDancer backup_dancer1 = new BackupDancer("Stephanie");
        BackupDancer backup_dancer2 = new BackupDancer("Jake");
        backup_dancer1.backup();
        backup_dancer1.dance();
        backup_dancer2.backup();
        backup_dancer2.dance();
    }
}