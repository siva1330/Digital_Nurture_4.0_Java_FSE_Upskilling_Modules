interface Playable {
    void play();
}

class Guitar implements Playable {
    public void play() {
        System.out.println("Strumming the guitar...");
    }
}

class Piano implements Playable {
    public void play() {
        System.out.println("Playing the piano...");
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        Playable g = new Guitar();
        Playable p = new Piano();

        g.play();
        p.play();
    }
}
