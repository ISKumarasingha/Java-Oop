// Create interface called IBackup
interface IBackup {
    void backup();
}

// Create Super Class.
// Then Create Main_Artist, Backup_Singer, Backup_Dancer Classes.
public class Artist {
    protected String name;

    public Artist(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Create Singer Class to extend the both Main_Artist & Backup_Singer Classes.
// Because both Main_Artist & Backup_Singer can sing.
class Singer extends Artist {
    public Singer(String name) {
        super(name);
    }

    public void sing() {
        System.out.println(this.name + " is singing.");
    }

    public void singBackup() {
    }
}

class Main_Artist extends Singer {
    public Main_Artist(String name) {
        super(name);
    }

    public void sing() {
        System.out.println(this.name + " is singing.");
    }
}

class BackupSinger extends Singer implements IBackup {
    public BackupSinger(String name) {
        super(name);
    }

    public void backup() {
        System.out.println(this.name + " is backing up the main artist by singing.");
    }

    public void sing() {
        System.out.println("Backup dancers back up the artist by singing.\n");
    }
}

class BackupDancer extends Artist implements IBackup {
    public BackupDancer(String name) {
        super(name);
        System.out.println(name + "backs up by dancing");
    }

    public void backup() {
        System.out.println(this.name + " is backing up the main artist by dancing.");
    }

    public void dance() {
        System.out.println(this.name + " is Dancing.");
    }
}